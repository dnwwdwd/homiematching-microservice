package com.hjj.homiematchingfrenidservice.controller;

import com.hjj.homiematchingcommon.common.BaseResponse;
import com.hjj.homiematchingcommon.common.ErrorCode;
import com.hjj.homiematchingcommon.common.ResultUtils;
import com.hjj.homiematchingcommon.exception.BusinessException;
import com.hjj.homiematchingfrenidservice.service.FriendService;
import com.hjj.homiematchingmodel.domain.User;
import com.hjj.homiematchingmodel.request.FriendAddRequest;
import com.hjj.homiematchingmodel.request.FriendQueryRequest;
import com.hjj.homiematchingmodel.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/friend")
public class FriendController {

    @Resource
    UserService userService;

    @Resource
    FriendService friendService;

    @PostMapping("/add")
    public BaseResponse<Boolean> addFriend(@RequestBody FriendAddRequest friendAddRequest, HttpServletRequest request) {
        Long friendId = friendAddRequest.getFriendId();
        if (friendId == null || friendId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        long userId = loginUser.getId();
        boolean result = friendService.addFriend(userId, friendId);
        return ResultUtils.success(result);
    }

    @GetMapping("/list")
    public BaseResponse<List<UserVO>> listFriends(HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        long userId = loginUser.getId();
        List<UserVO> friendList = friendService.listFriends(userId, request);
        return ResultUtils.success(friendList);
    }

    @PostMapping("/search")
    public BaseResponse<List<UserVO>> searchFriends(@RequestBody FriendQueryRequest friendQueryRequest, HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        long userId = loginUser.getId();
        if (friendQueryRequest == null || StringUtils.isBlank(friendQueryRequest.getSearchParam())) {
            return listFriends(request);
        }
        List<UserVO> userVOS = friendService.searchFriends(friendQueryRequest, userId);
        return ResultUtils.success(userVOS);
    }
}
