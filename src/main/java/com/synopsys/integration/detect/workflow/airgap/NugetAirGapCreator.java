/**
 * synopsys-detect
 *
 * Copyright (c) 2019 Synopsys, Inc.
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
package com.synopsys.integration.detect.workflow.airgap;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synopsys.integration.detect.exception.DetectUserFriendlyException;
import com.synopsys.integration.detect.exitcode.ExitCodeType;
import com.synopsys.integration.detect.tool.detector.inspectors.nuget.NugetInspectorInstaller;
import com.synopsys.integration.detectable.detectable.exception.DetectableException;

import ch.qos.logback.core.util.FileUtil;

public class NugetAirGapCreator {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final NugetInspectorInstaller nugetInspectorInstaller;

    public NugetAirGapCreator(final NugetInspectorInstaller nugetInspectorInstaller) {
        this.nugetInspectorInstaller = nugetInspectorInstaller;
    }

    public void installNugetDependencies(File nugetFolder) throws DetectUserFriendlyException {
        logger.info("Installing nuget dotnet inspector.");
        installThenCopy(nugetFolder, "nuget_dotnet", true);

        logger.info("Installing nuget classic inspector.");
        installThenCopy(nugetFolder, "nuget_classic", false);
    }

    private void installThenCopy(File nugetFolder, String folderName, boolean dotnet) throws DetectUserFriendlyException {
        try {
            File inspectorFolder = new File(nugetFolder, folderName);
            File installTarget;
            if (dotnet) {
                installTarget = nugetInspectorInstaller.installDotNet(inspectorFolder, Optional.empty());
            } else {
                installTarget = nugetInspectorInstaller.installExeInspector(inspectorFolder, Optional.empty());
            }
            FileUtils.copyDirectory(installTarget, inspectorFolder);
            FileUtils.deleteDirectory(installTarget);
        } catch (DetectableException | IOException e) {
            throw new DetectUserFriendlyException("An error occurred installing to the " + folderName + " inspector folder.", e, ExitCodeType.FAILURE_GENERAL_ERROR);
        }

    }
}