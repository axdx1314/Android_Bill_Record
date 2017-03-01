package com.ldm.cashbook.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * description： 作者：ldm 时间：20172017/3/1 11:12 邮箱：1786911211@qq.com
 */
@Entity
public class CashModel implements Serializable {
    private static final long serialVersionUID = 4046555564483893134L;
    @Id(autoincrement = true)
    private Long id;//数据库id
    @Property(nameInDb = "costName")
    private String costName;//支出名称
    @Property(nameInDb = "costTime")
    private String costTime;//支出时间
    @Property(nameInDb = "costNumber")
    private String costNumber;//支出金额
    @Generated(hash = 255499096)
    public CashModel(Long id, String costName, String costTime, String costNumber) {
        this.id = id;
        this.costName = costName;
        this.costTime = costTime;
        this.costNumber = costNumber;
    }
    @Generated(hash = 560329084)
    public CashModel() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCostName() {
        return this.costName;
    }
    public void setCostName(String costName) {
        this.costName = costName;
    }
    public String getCostTime() {
        return this.costTime;
    }
    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }
    public String getCostNumber() {
        return this.costNumber;
    }
    public void setCostNumber(String costNumber) {
        this.costNumber = costNumber;
    }
}
