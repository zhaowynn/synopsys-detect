/*
 * polaris
 *
 * Copyright (c) 2021 Synopsys, Inc.
 *
 * Use subject to the terms and conditions of the Synopsys End User Software License and Maintenance Agreement. All rights reserved worldwide.
 */
package com.synopsys.integration.polaris.common.api.auth.model;

import com.synopsys.integration.polaris.common.api.PolarisComponent;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

// this file should not be edited - if changes are necessary, the generator should be updated, then this file should be re-created

public class TypedParamsIncludedRelationsParams extends PolarisComponent {
    @SerializedName("params")
    private Map<String, IncludedRelationsParams> params = null;

    public TypedParamsIncludedRelationsParams putParamsItem(final String key, final IncludedRelationsParams paramsItem) {
        if (this.params == null) {
            this.params = new HashMap<>();
        }
        this.params.put(key, paramsItem);
        return this;
    }

    /**
     * Get params
     * @return params
     */
    public Map<String, IncludedRelationsParams> getParams() {
        return params;
    }

    public void setParams(final Map<String, IncludedRelationsParams> params) {
        this.params = params;
    }

}
