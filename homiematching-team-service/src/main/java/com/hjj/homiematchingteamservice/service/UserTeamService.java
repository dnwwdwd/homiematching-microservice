package com.hjj.homiematchingteamservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjj.homiematchingmodel.domain.UserTeam;

public interface UserTeamService extends IService<UserTeam> {

    boolean teamHasUser(long teamId, long userId);

}
