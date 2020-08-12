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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.airlenet.yang.gen.v1.event.event.DefaultEvent;
import com.airlenet.yang.gen.v1.event.event.event.DefaultC;
import com.airlenet.yang.model.DataNode;
import com.airlenet.yang.model.DefaultModelObjectData.Builder;
import com.airlenet.yang.model.InnerNode;
import com.airlenet.yang.model.ModelObjectId;
import com.airlenet.yang.model.NodeKey;
import com.airlenet.yang.model.ResourceData;
import com.airlenet.yang.model.ResourceId;
import com.airlenet.yang.model.SchemaId;

import java.util.Iterator;
import java.util.List;

import static com.airlenet.yang.model.DataNode.Type.SINGLE_INSTANCE_LEAF_VALUE_NODE;
import static com.airlenet.yang.model.DataNode.Type.SINGLE_INSTANCE_NODE;
import static com.airlenet.yang.runtime.impl.MockYangSchemaNodeProvider.processSchemaRegistry;
import static com.airlenet.yang.runtime.impl.MockYangSchemaNodeProvider.registry;
import static com.airlenet.yang.runtime.impl.TestUtils.validateDataNode;

/**
 * Unit test cases for resource id conversion from model object id.
 */
public class YtbNotificationTest {

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
     * Processes notification with container node as child.
     */
    @Test
    public void processNotificationTest() {

        DefaultC c = new DefaultC();
        c.eventClass("xyz");
        DefaultEvent event = new DefaultEvent();
        event.c(c);
        data = new Builder();
        data.addModelObject(event);
        rscData = treeBuilder.getResourceData(data.build());

        List<DataNode> nodes = rscData.dataNodes();
        DataNode n = nodes.get(0);
        TestUtils.validateDataNode(n, "event", TestUtils.NOTIF_NS,
                         SINGLE_INSTANCE_NODE, true, null);
        Iterator<DataNode> it = ((InnerNode) n).childNodes().values().iterator();
        n = it.next();
        TestUtils.validateDataNode(n, "c", TestUtils.NOTIF_NS, SINGLE_INSTANCE_NODE,
                         true, null);

        Iterator<DataNode> it1 = ((InnerNode) n).childNodes().values()
                .iterator();
        n = it1.next();
        TestUtils.validateDataNode(n, "event-class", TestUtils.NOTIF_NS, SINGLE_INSTANCE_LEAF_VALUE_NODE,
                         false, "xyz");
    }
}
