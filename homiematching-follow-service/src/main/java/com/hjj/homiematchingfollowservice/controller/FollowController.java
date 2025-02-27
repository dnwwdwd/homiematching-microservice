package com.hjj.homiematchingfollowservice.controller;

import com.hjj.homiematchingcommon.common.BaseResponse;
import com.hjj.homiematchingcommon.common.ErrorCode;
import com.hjj.homiematchingcommon.common.ResultUtils;
import com.hjj.homiematchingcommon.exception.BusinessException;
import com.hjj.homiematchingmodel.request.FollowQueryRequest;
import com.hjj.homiematchingmodel.vo.FollowRequest;
import com.hjj.homiematchingmodel.vo.FollowVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Resource
    private FollowService followService;

    /**
     * 搜索关注或粉丝
     */
    @PostMapping("/list")
    public BaseResponse<List<FollowVO>> listFollows(@RequestBody FollowQueryRequest followQueryRequest,
                                                    HttpServletRequest request) {
        if (followQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<FollowVO> followVOList = followService.listFollows(followQueryRequest, request);
        return ResultUtils.success(followVOList);
    }

    @PostMapping("/add")
    public BaseResponse<Boolean> addFollow(@RequestBody FollowRequest followRequest, HttpServletRequest request) {
        if (followRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long userId = followRequest.getUserId();
        boolean isFollowed = followRequest.getIsFollowed();
        if (isFollowed) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "您已关注");
        }
        boolean b = followService.addFollow(userId, request);
        return ResultUtils.success(b);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteFollow(@RequestBody FollowRequest followRequest, HttpServletRequest request) {
        if (followRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long userId = followRequest.getUserId();
        boolean isFollowed = followRequest.getIsFollowed();
        if (!isFollowed) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "您还未关注");
        }
        boolean b = followService.deleteFollow(userId, request);
        return ResultUtils.success(b);
    }

}
