package com.hjj.homiematchingfrenidservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjj.homiematchingmodel.domain.Friend;
import com.hjj.homiematchingmodel.request.FriendQueryRequest;
import com.hjj.homiematchingmodel.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FriendService extends IService<Friend> {

    boolean addFriend(long userId, long friendId);

    List<UserVO> listFriends(Long userId, HttpServletRequest request);
    List<UserVO> searchFriends(FriendQueryRequest friendQueryRequest, long userId);
}
