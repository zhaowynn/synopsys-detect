/*
 * Copyright (C) 2017 Black Duck Software Inc.
 * http://www.blackducksoftware.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Black Duck Software ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Black Duck Software.
 */
package com.blackducksoftware.integration.hub.detect.bomtool.cocoapods

import org.junit.Before
import org.junit.Test
import com.blackducksoftware.integration.hub.bdio.graph.DependencyGraph
import com.blackducksoftware.integration.hub.detect.nameversion.NameVersionNodeTransformer
import com.blackducksoftware.integration.hub.detect.testutils.DependencyGraphTestUtil
import com.blackducksoftware.integration.hub.detect.testutils.TestUtil

public class CocoapodsPackagerTest {
    private final TestUtil testUtil= new TestUtil()
    private final CocoapodsPackager cocoapodsPackager = new CocoapodsPackager()

    @Before
    void init() {
        cocoapodsPackager.nameVersionNodeTransformer = new NameVersionNodeTransformer()
    }

    @Test
    void simpleTest() {
        final String podlockText = testUtil.getResourceAsUTF8String('cocoapods/simplePodfile.lock')
        final DependencyGraph projectDependencies = cocoapodsPackager.extractDependencyGraph(podlockText)
        DependencyGraphTestUtil.assertGraph('cocoapods/simpleExpected_graph.json', projectDependencies);
    }

    @Test
    void complexTest() {
        //final String podlockText = testUtil.getResourceAsUTF8String('cocoapods/complexPodfile.lock')
        //final DependencyGraph projectDependencies = cocoapodsPackager.extractDependencyGraph(podlockText)
        //testUtil.testJsonResource('cocoapods/complexExpected.json', projectDependencies)
    }
}
