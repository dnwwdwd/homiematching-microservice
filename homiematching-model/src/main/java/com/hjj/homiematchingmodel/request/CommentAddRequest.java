package com.hjj.homiematchingmodel.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentAddRequest implements Serializable {

    private String text;

    private Long blogId;

}
