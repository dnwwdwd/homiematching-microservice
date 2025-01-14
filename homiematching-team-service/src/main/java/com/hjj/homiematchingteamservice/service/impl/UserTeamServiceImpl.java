package com.hjj.homiematchingteamservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjj.homiematchingmodel.domain.UserTeam;
import com.hjj.homiematchingteamservice.mapper.UserTeamMapper;
import com.hjj.homiematchingteamservice.service.UserTeamService;
import org.springframework.stereotype.Service;

@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

    @Override
    public boolean teamHasUser(long teamId, long userId) {
        return this.lambdaQuery().eq(UserTeam::getTeamId, teamId).eq(UserTeam::getUserId, userId).count() > 0;
    }
}




