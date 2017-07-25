package cn.coderss.jysy.domain;

import javax.persistence.*;

public class Vid {
    private String filesize3;

    private String duration;

    private String filesize2;

    private String vid;

    private String filesize1;

    /**
     * @return filesize3
     */
    public String getFilesize3() {
        return filesize3;
    }

    /**
     * @param filesize3
     */
    public void setFilesize3(String filesize3) {
        this.filesize3 = filesize3;
    }

    /**
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return filesize2
     */
    public String getFilesize2() {
        return filesize2;
    }

    /**
     * @param filesize2
     */
    public void setFilesize2(String filesize2) {
        this.filesize2 = filesize2;
    }

    /**
     * @return vid
     */
    public String getVid() {
        return vid;
    }

    /**
     * @param vid
     */
    public void setVid(String vid) {
        this.vid = vid;
    }

    /**
     * @return filesize1
     */
    public String getFilesize1() {
        return filesize1;
    }

    /**
     * @param filesize1
     */
    public void setFilesize1(String filesize1) {
        this.filesize1 = filesize1;
    }
}