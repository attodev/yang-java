/*
 * Copyright 2016-present Open Networking Foundation
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

package com.airlenet.yang.compiler.datamodel;

import com.airlenet.yang.model.YangNamespace;

/**
 * Represents YANG node identifier's namespace.
 */
public class DefaultYangNamespace implements YangNamespace {

    /*
     * Reference for namespace.
     */
    private final String namespace;

    /**
     * Creates an instance of namespace which is used to initialize the
     * nameSpace for requested data tree node.
     *
     * @param ns namespace of the requested node
     */
    public DefaultYangNamespace(String ns) {
        namespace = ns;
    }

    @Override
    public String getModuleNamespace() {
        return namespace;
    }

    @Override
    public String getModuleName() {
        return namespace;
    }
}