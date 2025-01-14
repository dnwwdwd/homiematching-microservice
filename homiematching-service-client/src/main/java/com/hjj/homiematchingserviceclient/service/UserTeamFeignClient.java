package com.hjj.homiematchingserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "homiematching-user-team-service", path = "/api/user_team/inner")
public interface UserTeamFeignClient {



}
