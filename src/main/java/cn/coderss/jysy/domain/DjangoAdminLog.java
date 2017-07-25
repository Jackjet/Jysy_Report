package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "django_admin_log")
public class DjangoAdminLog {
    @Id
    private Integer id;

    @Column(name = "action_time")
    private Date actionTime;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "content_type_id")
    private Integer contentTypeId;

    @Column(name = "object_repr")
    private String objectRepr;

    @Column(name = "action_flag")
    private Short actionFlag;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "change_message")
    private String changeMessage;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return action_time
     */
    public Date getActionTime() {
        return actionTime;
    }

    /**
     * @param actionTime
     */
    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return content_type_id
     */
    public Integer getContentTypeId() {
        return contentTypeId;
    }

    /**
     * @param contentTypeId
     */
    public void setContentTypeId(Integer contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    /**
     * @return object_repr
     */
    public String getObjectRepr() {
        return objectRepr;
    }

    /**
     * @param objectRepr
     */
    public void setObjectRepr(String objectRepr) {
        this.objectRepr = objectRepr;
    }

    /**
     * @return action_flag
     */
    public Short getActionFlag() {
        return actionFlag;
    }

    /**
     * @param actionFlag
     */
    public void setActionFlag(Short actionFlag) {
        this.actionFlag = actionFlag;
    }

    /**
     * @return object_id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    /**
     * @return change_message
     */
    public String getChangeMessage() {
        return changeMessage;
    }

    /**
     * @param changeMessage
     */
    public void setChangeMessage(String changeMessage) {
        this.changeMessage = changeMessage;
    }
}