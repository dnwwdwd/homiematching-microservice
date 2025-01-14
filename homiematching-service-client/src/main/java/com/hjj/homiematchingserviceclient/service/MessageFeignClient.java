package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-message-service", path = "/api/message/inner")
public interface MessageFeignClient {
}
