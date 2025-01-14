package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-user-service", path = "/api/user/inner")
public interface UserFeignClient {
}
