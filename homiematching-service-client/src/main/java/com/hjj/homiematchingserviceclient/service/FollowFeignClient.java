package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-follow-service", path = "/api/follow/inner")
public interface FollowFeignClient {


}
