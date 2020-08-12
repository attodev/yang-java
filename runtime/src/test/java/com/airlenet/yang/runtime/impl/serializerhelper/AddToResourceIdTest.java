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

package com.airlenet.yang.runtime.impl.serializerhelper;

import org.junit.Test;
import com.airlenet.yang.model.DataNode;
import com.airlenet.yang.model.ResourceId;
import com.airlenet.yang.runtime.HelperContext;
import com.airlenet.yang.runtime.impl.TestYangSerializerContext;

import java.util.LinkedList;
import java.util.List;

import static com.airlenet.yang.runtime.SerializerHelper.addToResourceId;
import static com.airlenet.yang.runtime.SerializerHelper.initializeResourceId;
import static com.airlenet.yang.runtime.impl.TestUtils.validateResourceId;

/**
 * Tests the serializer helper methods.
 */
public class AddToResourceIdTest {

    public static final String LNS = "yrt:list";

    TestYangSerializerContext context = new TestYangSerializerContext();

    /*
     * Reference for data node info.
     */
    HelperContext info;

    /*
     * Reference for data node builder.
     */
    DataNode.Builder dBlr;

    /*
     * Reference for resource id.
     */
    ResourceId id;

    /*
     * Reference for the value.
     */
    String value;

    /*
     * Reference for string array to used for resource id testing.
     */
    String[] nA;
    String[] nsA;
    String[] valA;

    /**
     * Test add to resource id with all list key.
     */
    @Test
    public void addToDataListTest() {

        ResourceId.Builder rIdBlr = initializeResourceId(context);
        List<String> valueSet = new LinkedList<>();
        valueSet.add("1");
        valueSet.add("2");
        valueSet.add("3");
        rIdBlr = addToResourceId(rIdBlr, "l1", LNS, valueSet);
        ResourceId id = rIdBlr.build();

        //Tree validation
        nA = new String[]{"/", "l1", "k1", "k2", "k3"};
        nsA = new String[]{null, LNS, LNS, LNS, LNS};
        valA = new String[]{"1", "2", "3"};
        validateResourceId(nA, nsA, valA, id);
    }

    /**
     * Test add to resource id without any key.
     */
    @Test
    public void addToDataList1Test() {

        ResourceId.Builder rIdBlr = initializeResourceId(context);
        List<String> valueSet = null;
        rIdBlr = addToResourceId(rIdBlr, "l1", LNS, valueSet);
        ResourceId id = rIdBlr.build();

        //Tree validation
        nA = new String[]{"/", "l1"};
        nsA = new String[]{null, LNS};
        valA = new String[]{};
        validateResourceId(nA, nsA, valA, id);
    }
}
