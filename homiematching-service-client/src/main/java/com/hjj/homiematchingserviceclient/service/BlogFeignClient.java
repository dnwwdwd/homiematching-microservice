package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-blog-service", path = "/api/blog/inner")
public interface BlogFeignClient {



}
