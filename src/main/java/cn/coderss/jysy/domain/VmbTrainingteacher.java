package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_trainingteacher")
public class VmbTrainingteacher {
    @Id
    @Column(name = "trainingTeacherId")
    private Integer trainingteacherid;

    @Column(name = "trainingScheduleId")
    private Integer trainingscheduleid;

    @Column(name = "teacherId")
    private Integer teacherid;

    /**
     * @return trainingTeacherId
     */
    public Integer getTrainingteacherid() {
        return trainingteacherid;
    }

    /**
     * @param trainingteacherid
     */
    public void setTrainingteacherid(Integer trainingteacherid) {
        this.trainingteacherid = trainingteacherid;
    }

    /**
     * @return trainingScheduleId
     */
    public Integer getTrainingscheduleid() {
        return trainingscheduleid;
    }

    /**
     * @param trainingscheduleid
     */
    public void setTrainingscheduleid(Integer trainingscheduleid) {
        this.trainingscheduleid = trainingscheduleid;
    }

    /**
     * @return teacherId
     */
    public Integer getTeacherid() {
        return teacherid;
    }

    /**
     * @param teacherid
     */
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }
}