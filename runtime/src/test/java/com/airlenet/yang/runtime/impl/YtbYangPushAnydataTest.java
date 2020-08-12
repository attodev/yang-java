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

import com.airlenet.yang.runtime.impl.serializerhelper.YangPushPatchAnydataTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.airlenet.yang.gen.v1.yrtietfeventnotifications.rev20161027.yrtietfeventnotifications.SubscriptionId;
import com.airlenet.yang.gen.v1.yrtietfinterfaces.rev20140508.yrtietfinterfaces.DefaultInterfacesState;
import com.airlenet.yang.gen.v1.yrtietfinterfaces.rev20140508.yrtietfinterfaces.interfacesstate.DefaultYangAutoPrefixInterface;
import com.airlenet.yang.gen.v1.yrtietfinterfaces.rev20140508.yrtietfinterfaces.interfacesstate.YangAutoPrefixInterface;
import com.airlenet.yang.gen.v11.yrtietfyangpatch.rev20170222.yrtietfyangpatch.TargetResourceOffset;
import com.airlenet.yang.gen.v11.yrtietfyangpatch.rev20170222.yrtietfyangpatch.yangpatch.DefaultYangPatch;
import com.airlenet.yang.gen.v11.yrtietfyangpatch.rev20170222.yrtietfyangpatch.yangpatch.yangpatch.DefaultEdit;
import com.airlenet.yang.gen.v11.yrtietfyangpatch.rev20170222.yrtietfyangpatch.yangpatch.yangpatch.edit.DefaultValue;
import com.airlenet.yang.gen.v11.yrtietfyangpush.rev20161028.yrtietfyangpush.DefaultPushChangeUpdate;
import com.airlenet.yang.gen.v11.yrtietfyangpush.rev20161028.yrtietfyangpush.pushchangeupdate.DefaultDatastoreChanges;
import com.airlenet.yang.model.DataNode;
import com.airlenet.yang.model.DefaultModelObjectData.Builder;
import com.airlenet.yang.model.ModelObjectId;
import com.airlenet.yang.model.NodeKey;
import com.airlenet.yang.model.ResourceData;
import com.airlenet.yang.model.ResourceId;
import com.airlenet.yang.model.SchemaId;

import java.util.List;

import static com.airlenet.yang.gen.v1.yrtietfinterfaces.rev20140508.yrtietfinterfaces.interfacesstate.yangautoprefixinterface.OperStatusEnum.DOWN;
import static com.airlenet.yang.gen.v11.yrtietfyangpatch.rev20170222.yrtietfyangpatch.yangpatch.yangpatch.edit.OperationEnum.MERGE;
import static com.airlenet.yang.runtime.impl.MockYangSchemaNodeProvider.processSchemaRegistry;
import static com.airlenet.yang.runtime.impl.MockYangSchemaNodeProvider.registry;

/**
 * Unit test cases for resource id conversion from model object id.
 */
public class YtbYangPushAnydataTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private ResourceData rscData;
    private DefaultDataTreeBuilder treeBuilder;
    private ResourceId id;
    private List<NodeKey> keys;
    private SchemaId sid;
    private ModelObjectId mid;
    private Builder data;
    DefaultYangModelRegistry reg;

    /**
     * Prior setup for each UT.
     */
    @Before
    public void setUp() {
        processSchemaRegistry();
        reg = registry();
        treeBuilder = new DefaultDataTreeBuilder(reg);
    }


    /**
     * Processes anydata with augmented node as child.
     */
    @Test
    public void processAnydataTest() {
        ModelObjectId id = new ModelObjectId.Builder()
                .addChild(DefaultPushChangeUpdate.class)
                .addChild(DefaultDatastoreChanges.class)
                .build();
        ModelObjectId id2 = new ModelObjectId.Builder()
                .addChild(DefaultYangPatch.class).build();

        ModelObjectId id1 = new ModelObjectId.Builder()
                .addChild(DefaultPushChangeUpdate.class)
                .addChild(DefaultDatastoreChanges.class)
                .addChild(DefaultYangPatch.class)
                .addChild(DefaultEdit.class, null)
                .addChild(DefaultValue.class)
                .build();
        ModelObjectId id3 = new ModelObjectId.Builder()
                .addChild(DefaultInterfacesState.class)
                .build();
        reg.registerAnydataSchema(id, id2);
        reg.registerAnydataSchema(id1, id3);

        DefaultPushChangeUpdate update = new DefaultPushChangeUpdate();
        long val = 89;
        update.subscriptionId(new SubscriptionId(val));

        DefaultDatastoreChanges changes = new DefaultDatastoreChanges();
        DefaultYangPatch patch = new DefaultYangPatch();
        patch.patchId("1");
        DefaultEdit edit = new DefaultEdit();
        edit.editId("edit1");
        edit.operation(MERGE);
        edit.target(new TargetResourceOffset("/ietf-interfaces/interfaces-state"));

        DefaultInterfacesState state = new DefaultInterfacesState();
        YangAutoPrefixInterface inter = new DefaultYangAutoPrefixInterface();
        inter.name("eth0");
        inter.operStatus(DOWN);
        state.addToYangAutoPrefixInterface(inter);

        DefaultValue value = new DefaultValue();
        value.addAnydata(state);
        edit.value(value);
        patch.addToEdit(edit);
        changes.addAnydata(patch);
        update.datastoreChanges(changes);

        data = new Builder();
        data.addModelObject(update);
        rscData = treeBuilder.getResourceData(data.build());

        List<DataNode> nodes = rscData.dataNodes();
        DataNode n = nodes.get(0);
        YangPushPatchAnydataTest.validatePushDataNodeTree(n, true);
    }
}
