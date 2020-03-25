package com.hao.multi_datasource.modular.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 */
@TableName("zh_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 发送者id
     */
    @TableField("send_user_id")
    private Long sendUserId;

    /**
     * 接收者id
     */
    @TableField("receive_user_id")
    private Long receiveUserId;

    /**
     * 消息类型（1、系统消息  2、医生回复）
     */
    @TableField("msg_type")
    private Integer msgType;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 事件
     */
    @TableField("event")
    private String event;

    /**
     * 发送时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Message{" +
        "id=" + id +
        ", sendUserId=" + sendUserId +
        ", receiveUserId=" + receiveUserId +
        ", msgType=" + msgType +
        ", title=" + title +
        ", content=" + content +
        ", event=" + event +
        ", createTime=" + createTime +
        "}";
    }
}
