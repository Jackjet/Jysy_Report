package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "new_table")
public class NewTable {
    @Id
    @Column(name = "idnew_table")
    private Integer idnewTable;

    /**
     * @return idnew_table
     */
    public Integer getIdnewTable() {
        return idnewTable;
    }

    /**
     * @param idnewTable
     */
    public void setIdnewTable(Integer idnewTable) {
        this.idnewTable = idnewTable;
    }
}