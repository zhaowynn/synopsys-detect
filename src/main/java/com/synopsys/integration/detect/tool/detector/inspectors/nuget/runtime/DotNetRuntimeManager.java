package com.synopsys.integration.detect.tool.detector.inspectors.nuget.runtime;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.synopsys.integration.detectable.detectable.exception.DetectableException;

public class DotNetRuntimeManager {
    private final DotNetRuntimeFinder runtimeFinder;
    private final DotNetRuntimeParser runtimeParser;
    private List<String> availableRuntimes = null;

    public DotNetRuntimeManager(DotNetRuntimeFinder runtimeFinder, DotNetRuntimeParser runtimeParser) {
        this.runtimeFinder = runtimeFinder;
        this.runtimeParser = runtimeParser;
    }

    public boolean isRuntimeAvailable(Integer... versionTokens) throws DetectableException {
        String versionSearchString = StringUtils.join(versionTokens, ".");
        return isRuntimeAvailable(versionSearchString);
    }

    public boolean isRuntimeAvailable(String version) throws DetectableException {
        if (availableRuntimes == null) {
            availableRuntimes = runtimeFinder.listAvailableRuntimes();
        }
        return runtimeParser.doRuntimesContainVersionStartingWith(availableRuntimes, version);
    }
}
