/**
 * detectable
 *
 * Copyright (c) 2020 Synopsys, Inc.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.synopsys.integration.detectable.detectables.conan.graph;

import java.util.List;

import com.synopsys.integration.util.Stringable;

public class GenericNode<T> extends Stringable {
    // if rootNode: conanfile.{txt,py}[ (projectname/version)]
    // else       : package/version[@user/channel]
    private final String ref;
    private final String filename; // conanfile.txt, conanfile.py
    private final String name;
    private final String version;
    private final String user;
    private final String channel;

    private final String recipeRevision;
    private final String packageId;
    private final String packageRevision;
    private final List<T> requiresRefs;
    private final List<T> buildRequiresRefs;
    private final boolean rootNode;

    public GenericNode(String ref, String filename, String name, String version, String user, String channel,
        String recipeRevision, String packageId, String packageRevision,
        List<T> requiresRefs,
        List<T> buildRequiresRefs,
        boolean rootNode) {
        this.ref = ref;
        this.filename = filename;
        this.name = name;
        this.version = version;
        this.user = user;
        this.channel = channel;
        this.recipeRevision = recipeRevision;
        this.packageId = packageId;
        this.packageRevision = packageRevision;
        this.requiresRefs = requiresRefs;
        this.buildRequiresRefs = buildRequiresRefs;
        this.rootNode = rootNode;
    }

    public String getRef() {
        return ref;
    }

    public String getFilename() {
        return filename;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getUser() {
        return user;
    }

    public String getChannel() {
        return channel;
    }

    public String getRecipeRevision() {
        return recipeRevision;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getPackageRevision() {
        return packageRevision;
    }

    public List<T> getRequiresRefs() {
        return requiresRefs;
    }

    public List<T> getBuildRequiresRefs() {
        return buildRequiresRefs;
    }

    public boolean isRootNode() {
        return rootNode;
    }
}
