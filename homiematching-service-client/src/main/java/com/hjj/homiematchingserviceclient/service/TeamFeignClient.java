package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-team-service", path = "/api/team/inner")
public interface TeamFeignClient {
}
