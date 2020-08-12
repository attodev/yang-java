/*
 * Copyright 2017-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.airlenet.yang.runtime.impl;

import com.airlenet.yang.compiler.datamodel.YangLeaf;
import com.airlenet.yang.compiler.datamodel.YangLeafList;
import com.airlenet.yang.compiler.datamodel.YangRpc;
import com.airlenet.yang.compiler.datamodel.YangSchemaNode;
import com.airlenet.yang.model.DataNode;
import com.airlenet.yang.model.DefaultModelObjectData;
import com.airlenet.yang.model.LeafListKey;
import com.airlenet.yang.model.ListKey;
import com.airlenet.yang.model.ModelObject;
import com.airlenet.yang.model.ModelObjectData;
import com.airlenet.yang.model.ModelObjectId;
import com.airlenet.yang.model.NodeKey;
import com.airlenet.yang.model.ResourceData;
import com.airlenet.yang.model.ResourceId;
import com.airlenet.yang.model.SchemaId;

import java.util.Iterator;
import java.util.List;

import static com.airlenet.yang.compiler.datamodel.utils.DataModelUtils.nonEmpty;
import static com.airlenet.yang.runtime.DefaultDataNodeWalker.walk;
import static com.airlenet.yang.runtime.SerializerHelper.getChildSchemaContext;

/**
 * Represents implementation to build and obtain YANG objects from data node.
 */
public class DefaultYobBuilder {
    private final DefaultYangModelRegistry registry;
    private YangSchemaNode lastIndexNode;

    /**
     * Creates an instance of YOB builder.
     *
     * @param reg YANG model registry
     */
    public DefaultYobBuilder(DefaultYangModelRegistry reg) {
        registry = reg;
    }

    /**
     * Returns the YANG object.
     *
     * @param data resource data
     * @return model object identifier and YANG object
     */
    public ModelObjectData getYangObject(ResourceData data) {
        DefaultModelObjectData.Builder builder = DefaultModelObjectData.builder();
        ModelObjectId id = null;
        if (data.resourceId() != null) {
            id = convertRscIdToMoId(data.resourceId());
        }

        List<DataNode> dataNodes = data.dataNodes();
        if (nonEmpty(dataNodes)) {
            for (DataNode dataNode : dataNodes) {
                YobListener listener = new YobListener(lastIndexNode, registry);
                walk(listener, dataNode);
                List<ModelObject> objList = listener.modelObjectList();
                if (objList != null) {
                    for (ModelObject obj : objList) {
                        builder.addModelObject(obj);
                    }
                }
            }
        }
        return builder.identifier(id).build();
    }

    /**
     * Converts resource identifier to model object identifier.
     *
     * @param id resource identifier
     * @return model object identifier
     */
    private ModelObjectId convertRscIdToMoId(ResourceId id) {
        ModelObjectId.Builder midb = ModelObjectId.builder();

        if (id != null) {
            List<NodeKey> nodeKeys = id.nodeKeys();
            NodeKey key;
            SchemaId sId;
            if (nonEmpty(nodeKeys)) {
                Iterator<NodeKey> it = nodeKeys.iterator();
                while (it.hasNext()) {
                    key = it.next();
                    sId = key.schemaId();
                    if (sId.name().equals(YobUtils.FORWARD_SLASH)) {
                        continue;
                    }

                    YangSchemaNode schemaNode;
                    if (lastIndexNode == null) {
                        schemaNode = ((YangSchemaNode) registry.getChildContext(sId));
                    } else {
                        schemaNode = ((YangSchemaNode)
                                getChildSchemaContext(lastIndexNode, sId.name(),
                                                      sId.namespace()));
                    }

                    if (schemaNode instanceof YangRpc) {
                        // RPC resource id need not be converted to model
                        // object id.
                        lastIndexNode = schemaNode;
                        return null;
                    }

                    if (key instanceof ListKey) {
                        midb = YobUtils.handleListKey(midb, registry, schemaNode, key);
                    } else if (key instanceof LeafListKey) {
                        LeafListKey llKey = (LeafListKey) key;
                        midb = YobUtils.handleLeafListKey(midb, registry, schemaNode,
                                                 llKey);
                    } else {
                        midb = YobUtils.handleNodeKey(midb, registry, schemaNode, key);
                    }
                    if (!(schemaNode instanceof YangLeaf) && !(schemaNode
                            instanceof YangLeafList)) {
                        lastIndexNode = schemaNode;
                    }
                }
            }
        }
        return midb.build();
    }
}
