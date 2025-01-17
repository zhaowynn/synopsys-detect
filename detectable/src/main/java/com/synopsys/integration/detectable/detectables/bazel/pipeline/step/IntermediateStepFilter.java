package com.synopsys.integration.detectable.detectables.bazel.pipeline.step;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntermediateStepFilter implements IntermediateStep {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String regex;

    public IntermediateStepFilter(String regex) {
        this.regex = regex;
    }

    @Override
    public List<String> process(List<String> input) {
        List<String> output = new ArrayList<>();
        logger.trace(String.format("Filtering with regex %s", regex));
        for (String inputItem : input) {
            if (inputItem.matches(regex)) {
                logger.trace(String.format("Filter keeping: %s", inputItem));
                output.add(inputItem);
            }
        }
        return output;
    }
}
