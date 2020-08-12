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
import com.airlenet.yang.model.ResourceId;
import com.airlenet.yang.model.SchemaContext;
import com.airlenet.yang.runtime.impl.TestYangSerializerContext;

import static com.airlenet.yang.runtime.SerializerHelper.addToResourceId;
import static com.airlenet.yang.runtime.SerializerHelper.initializeResourceId;
import static com.airlenet.yang.runtime.impl.TestUtils.IETFNS;
import static com.airlenet.yang.runtime.impl.TestUtils.checkRootLevelContext;
import static com.airlenet.yang.runtime.impl.TestUtils.validateResourceId;

/**
 * Tests the initialize resource id methods in serializer helper.
 */
public class ResourceIdInitializationTest {

    TestYangSerializerContext context = new TestYangSerializerContext();

    /*
     * Reference for resource id builder.
     */
    ResourceId.Builder rIdBlr;

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
     * Checks initialize resource id.
     */
    @Test
    public void initializeResourceIdTest() {

        rIdBlr = initializeResourceId(context);
        checkRootLevelContext((SchemaContext) rIdBlr.appInfo());
    }

    @Test
    public void addToResourceIdTest() {

        rIdBlr = initializeResourceId(context);
        rIdBlr = addToResourceId(rIdBlr, "networks", IETFNS, value);
        rIdBlr = addToResourceId(rIdBlr, "network", null, value);
        value = "network1";
        rIdBlr = addToResourceId(rIdBlr, "network-id", null, value);
        ResourceId id = rIdBlr.build();

        nA = new String[]{"/", "networks", "network", "network-id"};
        nsA = new String[]{null, IETFNS, IETFNS, IETFNS};
        valA = new String[]{"network1"};
        validateResourceId(nA, nsA, valA, id);
    }
}
