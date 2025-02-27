package com.hjj.homiematchingmessageservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjj.homiematchingmodel.domain.Message;
import com.hjj.homiematchingmodel.request.MessageQueryRequest;
import com.hjj.homiematchingmodel.vo.InteractionMessageVO;
import com.hjj.homiematchingmodel.vo.MessageVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 何佳骏
* @description 针对表【message】的数据库操作Service
* @createDate 2024-07-31 20:19:53
*/
public interface MessageService extends IService<Message> {

    public boolean addStarMessage(Message message);
    public boolean addLikeMessage(Message message);
    public boolean addFollowMessage(Message message);

    InteractionMessageVO listInteractionMessage(HttpServletRequest request);


    List<MessageVO> listMessages(MessageQueryRequest messageQueryRequest, HttpServletRequest request);
}
