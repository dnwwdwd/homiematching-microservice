package com.hjj.homiematchingimageservice.controller;

import com.hjj.homiematchingcommon.common.BaseResponse;
import com.hjj.homiematchingcommon.common.ErrorCode;
import com.hjj.homiematchingcommon.common.ResultUtils;
import com.hjj.homiematchingcommon.constant.RedisConstant;
import com.hjj.homiematchingcommon.exception.BusinessException;
import com.hjj.homiematchingmodel.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Resource
    private AliOSSManager aliOSSManager;

    @Resource
    private RedisLimiterManager redisLimiterManager;

    @Resource
    private UserService userService;

    @PostMapping("/blog/coverImage/upload")
    public BaseResponse<String> uploadBlogCoverImage(@RequestPart MultipartFile file,
                                                     HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        long userId = loginUser.getId();
        String url = null;
        // 限制每个用户每分钟上传 1 次
        redisLimiterManager.doRateLimiter(RedisConstant.BLOG_COVER_IMAGE_UPLOAD_KEY + userId, 1, 4);
        try {
            url = aliOSSManager.upload(file);
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传图片失败");
        }
        return ResultUtils.success(url);
    }

    @PostMapping("/blog/image/upload")
    public BaseResponse<String> uploadBlogImage(@RequestPart MultipartFile file, HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        long userId = loginUser.getId();
        String url = null;
        // 限制每个用户每分钟上传 2 次
        redisLimiterManager.doRateLimiter(RedisConstant.BLOG_IMAGE_UPLOAD_KEY + userId, 1, 10);
        try {
            url = aliOSSManager.upload(file);
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传图片失败");
        }
        return ResultUtils.success(url);
    }

    @PostMapping("/avatar/upload")
    public BaseResponse<String> uploadAvatar(@RequestPart MultipartFile file, HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        long userId = loginUser.getId();
        String url = null;
        // 限制每个用户每分钟上传 2 次
        redisLimiterManager.doRateLimiter(RedisConstant.BLOG_IMAGE_UPLOAD_KEY + userId, 1, 4);
        try {
            url = aliOSSManager.upload(file);
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传图片失败");
        }
        return ResultUtils.success(url);
    }
}
