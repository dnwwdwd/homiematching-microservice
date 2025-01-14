package com.hjj.homiematchingmodel.vo;

import lombok.Data;

@Data
public class PrivateMessageVO {

    private Long id;

    private Long friendId;

    private String avatarUrl;

    private String text;

    private String createTime;

    private String username;

}
