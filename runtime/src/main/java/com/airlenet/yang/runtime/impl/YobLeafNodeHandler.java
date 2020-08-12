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
import com.airlenet.yang.compiler.datamodel.YangSchemaNode;
import com.airlenet.yang.compiler.datamodel.YangType;
import com.airlenet.yang.compiler.datamodel.utils.builtindatatype.YangDataTypes;
import com.airlenet.yang.model.DataNode;
import com.airlenet.yang.model.LeafNode;
import com.airlenet.yang.model.ModelConverterException;
import com.airlenet.yang.runtime.YangModelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Represents a single instance leaf node handler in YANG object builder.
 */
class YobLeafNodeHandler extends YobHandler {

    private static final Logger log =
            LoggerFactory.getLogger(YobLeafNodeHandler.class);

    @Override
    YobWorkBench createObject(YangSchemaNode schemaNode,
                                     DefaultYangModelRegistry registry) {
        // For single instance leaf no need to create an object.
        return null;
    }

    /**
     * Builds the object.
     *
     * @param curWorkbench current workbench
     * @param registry YANG schema registry
     */
    @Override
    void buildObject(YobWorkBench curWorkbench,
                            YangModelRegistry registry) {
        // For single instance leaf no need to build an object.
    }

    @Override
    void setInParent(DataNode leafNode,
                            YobWorkBench curWb,
                            YobWorkBench parentWb,
                            DefaultYangModelRegistry registry) {
        Class<?> parentClass = null;
        try {
            YangSchemaNode schemaNode = YobUtils.getChildSchemaNode(leafNode, curWb
                    .schemaNode());
            YangSchemaNode referredSchema = schemaNode;
            while (referredSchema.getReferredSchema() != null) {
                referredSchema = referredSchema.getReferredSchema();
            }

            String setterInParent = referredSchema.getJavaAttributeName();
            Object parentObj = curWb.getParentObject(registry, schemaNode);
            parentClass = parentObj.getClass();
            YangType<?> type = ((YangLeaf) referredSchema).getDataType();
            YangDataTypes dataType = type.getDataType();
            if (((LeafNode) leafNode).value() != null || ModelConverterUtil.isTypeEmpty(type)) {
                Field leafName = parentClass.getDeclaredField(setterInParent);
                Method setterMethod = parentClass.getDeclaredMethod(
                        setterInParent, leafName.getType());
                YobUtils.setDataFromStringValue(dataType, ((LeafNode) leafNode).value(),
                                       setterMethod, parentObj, referredSchema,
                                       curWb.schemaNode());
            }
        } catch (NoSuchMethodException | InvocationTargetException |
                IllegalAccessException | NoSuchFieldException e) {
            log.error(YobConstants.L_FAIL_TO_INVOKE_METHOD, parentClass.getName());
            throw new ModelConverterException(YobConstants.E_FAIL_TO_INVOKE_METHOD + parentClass
                    .getName(), e);
        }
    }
}
