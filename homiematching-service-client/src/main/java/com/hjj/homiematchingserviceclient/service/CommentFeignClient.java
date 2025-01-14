package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-comment-service", path = "/api/comment/inner")
public interface CommentFeignClient {
}
