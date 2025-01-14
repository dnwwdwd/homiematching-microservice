package com.hjj.homiematchingmodel.vo;

import lombok.Data;

@Data
public class StarRequest {
    private boolean isStarred;

    private long blogId;

    public boolean getIsStarred() {
        return isStarred;
    }
}
