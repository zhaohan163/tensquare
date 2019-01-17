package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Pl
 * @Author 123456
 * @Description TODO
 * @Version 1.0
 * @Date 2019/1/17 16:45
 **/
@Entity
@Table(name="tb_pl")
public class Pl {

    private String problemid;
    @Id
    private String lableid;
    public String getLableid() {
        return lableid;
    }
    public void setLableid(String lableid) {
        this.lableid = lableid;
    }
    public String getProblemid() {
        return problemid;
    }
    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }
}
