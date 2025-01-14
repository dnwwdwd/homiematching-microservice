package com.hjj.homiematchingcommentservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjj.homiematchingmodel.domain.Comment;
import com.hjj.homiematchingmodel.request.CommentAddRequest;
import com.hjj.homiematchingmodel.request.DeleteRequest;
import com.hjj.homiematchingmodel.vo.CommentVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 何佳骏
* @description 针对表【comment(评论表)】的数据库操作Service
* @createDate 2024-08-05 21:09:55
*/
public interface CommentService extends IService<Comment> {

    boolean addComment(CommentAddRequest commentAddRequest, HttpServletRequest request);

    boolean deleteComment(DeleteRequest deleteRequest, HttpServletRequest request);

    List<CommentVO> listComments(long blogId, HttpServletRequest request);

    boolean isMyComment(long userId, long commentId);
}
