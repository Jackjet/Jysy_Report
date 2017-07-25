package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_commentpraise")
public class VmbCommentpraise {
    @Id
    private Integer commentgoodid;

    @Column(name = "commentsId")
    private Integer commentsid;

    @Column(name = "accountId")
    private Integer accountid;

    private Boolean isgood;

    /**
     * @return commentgoodid
     */
    public Integer getCommentgoodid() {
        return commentgoodid;
    }

    /**
     * @param commentgoodid
     */
    public void setCommentgoodid(Integer commentgoodid) {
        this.commentgoodid = commentgoodid;
    }

    /**
     * @return commentsId
     */
    public Integer getCommentsid() {
        return commentsid;
    }

    /**
     * @param commentsid
     */
    public void setCommentsid(Integer commentsid) {
        this.commentsid = commentsid;
    }

    /**
     * @return accountId
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * @return isgood
     */
    public Boolean getIsgood() {
        return isgood;
    }

    /**
     * @param isgood
     */
    public void setIsgood(Boolean isgood) {
        this.isgood = isgood;
    }
}