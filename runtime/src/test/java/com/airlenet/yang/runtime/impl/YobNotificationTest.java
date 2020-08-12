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

import com.airlenet.yang.runtime.impl.serializerhelper.YangNotificationTest;
import org.junit.Test;
import com.airlenet.yang.gen.v1.event.event.DefaultEvent;
import com.airlenet.yang.gen.v1.event.event.event.DefaultC;
import com.airlenet.yang.model.DataNode;
import com.airlenet.yang.model.DefaultResourceData;
import com.airlenet.yang.model.ModelObject;
import com.airlenet.yang.model.ModelObjectData;
import com.airlenet.yang.model.ResourceData;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static com.airlenet.yang.runtime.SerializerHelper.initializeDataNode;

/**
 * Tests the YANG object building for the YANG data nodes based on the non
 * schema augmented nodes.
 */
public class YobNotificationTest {
    TestYangSerializerContext context = new TestYangSerializerContext();

    @Test
    public void anydataTest() {
        DataNode.Builder dBlr = initializeDataNode(context);
        DataNode dataNode = YangNotificationTest.notificationTree(dBlr);
        ResourceData data = DefaultResourceData.builder()
                .addDataNode(dataNode).build();
        DefaultYobBuilder builder = new DefaultYobBuilder(context.getRegistry());
        ModelObjectData modelObjectData = builder.getYangObject(data);
        List<ModelObject> modelObjectList = modelObjectData.modelObjects();
        ModelObject modelObject = modelObjectList.get(0);
        DefaultEvent event = ((DefaultEvent) modelObject);
        DefaultC c = ((DefaultC) event.c());
        assertThat(c.eventClass().toString(), is("xyz"));
    }
}
