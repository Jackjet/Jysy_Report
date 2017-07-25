package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_voteitem")
public class VmbVoteitem {
    @Id
    private Integer voteitemid;

    private Integer votesolutionid;

    private String name;

    private String itemlogourl;

    private String description;

    private String url;

    /**
     * @return voteitemid
     */
    public Integer getVoteitemid() {
        return voteitemid;
    }

    /**
     * @param voteitemid
     */
    public void setVoteitemid(Integer voteitemid) {
        this.voteitemid = voteitemid;
    }

    /**
     * @return votesolutionid
     */
    public Integer getVotesolutionid() {
        return votesolutionid;
    }

    /**
     * @param votesolutionid
     */
    public void setVotesolutionid(Integer votesolutionid) {
        this.votesolutionid = votesolutionid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return itemlogourl
     */
    public String getItemlogourl() {
        return itemlogourl;
    }

    /**
     * @param itemlogourl
     */
    public void setItemlogourl(String itemlogourl) {
        this.itemlogourl = itemlogourl;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}