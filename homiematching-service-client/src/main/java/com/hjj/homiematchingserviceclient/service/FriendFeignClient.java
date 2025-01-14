package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-friend-service", path = "/api/friend/inner")
public interface FriendFeignClient {
}
