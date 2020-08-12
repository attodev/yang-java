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

package com.airlenet.yang.runtime.impl.schemacontext;

import org.junit.Test;
import com.airlenet.yang.compiler.datamodel.DefaultYangNamespace;
import com.airlenet.yang.compiler.datamodel.YangLeaf;
import com.airlenet.yang.compiler.datamodel.YangLeafList;
import com.airlenet.yang.compiler.datamodel.YangNode;
import com.airlenet.yang.compiler.datamodel.YangSchemaNodeIdentifier;
import com.airlenet.yang.compiler.datamodel.exceptions.DataModelException;
import com.airlenet.yang.model.SchemaId;
import com.airlenet.yang.runtime.impl.DefaultYangModelRegistry;

import static com.airlenet.yang.model.DataNode.Type.MULTI_INSTANCE_NODE;
import static com.airlenet.yang.model.DataNode.Type.SINGLE_INSTANCE_NODE;
import static com.airlenet.yang.runtime.impl.TestUtils.checkLeafListSchemaContext;
import static com.airlenet.yang.runtime.impl.TestUtils.checkLeafSchemaContext;
import static com.airlenet.yang.runtime.impl.TestUtils.checkSchemaContext;
import static com.airlenet.yang.runtime.impl.MockYangSchemaNodeProvider.processSchemaRegistry;
import static com.airlenet.yang.runtime.impl.MockYangSchemaNodeProvider.registry;

/**
 * Tests the default schema context methods.
 */
public class CaseSchemaContextTest {

    private static final String CASENS = "yrt:choice-case";
    private DefaultYangModelRegistry registry;

    /**
     * Do the prior setup for each UT.
     */
    private void setUp() {
        processSchemaRegistry();
        registry = registry();
    }

    /**
     * Checks module level choice-case data node parent context.
     */
    @Test
    public void caseSchemaContTest() throws DataModelException {
        setUp();
        SchemaId id = new SchemaId("pretzel", CASENS);
        YangLeaf leaf = (YangLeaf) registry.getChildContext(id);
        checkLeafSchemaContext("pretzel", CASENS, "/", null, leaf);

        id = new SchemaId("light", CASENS);
        leaf = (YangLeaf) registry.getChildContext(id);
        checkLeafSchemaContext("light", CASENS, "/", null, leaf);

        id = new SchemaId("potato", CASENS);
        YangLeafList leafList = (YangLeafList) registry.getChildContext(id);
        checkLeafListSchemaContext("potato", CASENS, "/", null,
                                   leafList);

        id = new SchemaId("banana", CASENS);
        YangNode child = (YangNode) registry.getChildContext(id);
        checkSchemaContext("banana", CASENS, "/", null,
                           MULTI_INSTANCE_NODE, child);

        id = new SchemaId("cold-drink", CASENS);
        child = (YangNode) registry.getChildContext(id);
        checkSchemaContext("cold-drink", CASENS, "/", null,
                           SINGLE_INSTANCE_NODE, child);

        YangSchemaNodeIdentifier rId = new YangSchemaNodeIdentifier();
        rId.setName("flavor");
        rId.setNameSpace(new DefaultYangNamespace(CASENS));
        leafList = (YangLeafList) child.getChildSchema(rId).getSchemaNode();
        checkLeafListSchemaContext("flavor", CASENS, "cold-drink", CASENS,
                                   leafList);
    }
}
