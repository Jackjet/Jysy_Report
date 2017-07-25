package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_commentreceive")
public class VmbCommentreceive {
    @Id
    @Column(name = "commentreceiveId")
    private Integer commentreceiveid;

    /**
     * 源评论
     */
    @Column(name = "sourcecommentsId")
    private Integer sourcecommentsid;

    /**
     * 回复评论
     */
    @Column(name = "receivecommentsId")
    private Integer receivecommentsid;

    /**
     * @return commentreceiveId
     */
    public Integer getCommentreceiveid() {
        return commentreceiveid;
    }

    /**
     * @param commentreceiveid
     */
    public void setCommentreceiveid(Integer commentreceiveid) {
        this.commentreceiveid = commentreceiveid;
    }

    /**
     * 获取源评论
     *
     * @return sourcecommentsId - 源评论
     */
    public Integer getSourcecommentsid() {
        return sourcecommentsid;
    }

    /**
     * 设置源评论
     *
     * @param sourcecommentsid 源评论
     */
    public void setSourcecommentsid(Integer sourcecommentsid) {
        this.sourcecommentsid = sourcecommentsid;
    }

    /**
     * 获取回复评论
     *
     * @return receivecommentsId - 回复评论
     */
    public Integer getReceivecommentsid() {
        return receivecommentsid;
    }

    /**
     * 设置回复评论
     *
     * @param receivecommentsid 回复评论
     */
    public void setReceivecommentsid(Integer receivecommentsid) {
        this.receivecommentsid = receivecommentsid;
    }
}