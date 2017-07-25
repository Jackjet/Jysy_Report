package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "increment_trx")
public class IncrementTrx {
    @Id
    private String jobid;

    @Id
    private String database;

    @Id
    private String table;

    @Id
    private Integer partition;

    private String checkpoint;

    private Long timestamp;

    /**
     * @return jobid
     */
    public String getJobid() {
        return jobid;
    }

    /**
     * @param jobid
     */
    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    /**
     * @return database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * @return table
     */
    public String getTable() {
        return table;
    }

    /**
     * @param table
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * @return partition
     */
    public Integer getPartition() {
        return partition;
    }

    /**
     * @param partition
     */
    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    /**
     * @return checkpoint
     */
    public String getCheckpoint() {
        return checkpoint;
    }

    /**
     * @param checkpoint
     */
    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    /**
     * @return timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}