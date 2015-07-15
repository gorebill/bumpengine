package com.zhongyi.be.entity;

import com.zhongyi.be.entity.base.BumpBase;
import com.zhongyi.be.exception.BumpException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by gorebill on 23/6/15.
 *
 * Reference:
 * See https://github.com/flipkart-incubator/hbase-object-mapper/blob/master/src/test/java/com/flipkart/hbaseobjectmapper/entities/Citizen.java
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "LdfsyActive")
public class LdfsyActive implements BumpBase {

    /**
     * timestamp作为id, 对应ldfsyVo中的tsid
     */
    @Id
    private Long timeStamp;

    @Column(name="active")
    private boolean active;

    // TODO: 到底要不要?
    //@Column(name="elecId")
    //private String elecId;

    @Column(name="model")
    private String model;

    @Column(name="sigId")
    private String sigId;

    @Column(name="fsybh")
    private String fsybh;

    @Column(name="fsylx")
    private String fsylx;

    @Column(name="fsyxh")
    private String fsyxh;

    @Column(name="dwsx")
    private String dwsx;

    @Column(name="zyxdj")
    private String zyxdj;

    @Column(name="dyjscwjbs")
    private String dyjscwjbs;

    @Column(name="sfyjsc")
    private String sfyjsc;

    // vos的属性
    @Column(name = "bwlx")
    private String bwlx;

    @Column(name = "gxyhmc")
    private String gxyhmc;

    @Column(name = "ssbdbh")
    private String ssbdbh;

    @Column(name = "gxsj")
    private Date gxsj;

    @Column(name = "jhbdbh")
    private String jhbdbh;

    @Column(name = "jhzbbh")
    private String jhzbbh;

    @Column(name = "jhbdjd")
    private Float jhbdjd;

    @Column(name = "jhbdwd")
    private Float jhbdwd;

    @Column(name = "jhbdgd")
    private Float jhbdgd;

    @Column(name = "fy")
    private Float fy;

    @Column(name = "fw")
    private Float fw;

    @Column(name = "bz")
    private String bz;

    // 工作参数
    @Column(name = "splx")
    private String splx;

    @Column(name = "cplx")
    private String cplx;

    @Column(name = "mklx")
    private String mklx;

    @Column(name = "mntzlx")
    private String mntzlx;

    @Column(name = "mctzlx")
    private String mctzlx;

    @Column(name = "txjhlx")
    private String txjhlx;

    @Column(name = "txbssmys")
    private String txbssmys;

    @Column(name = "txsmzq")
    private String txsmzq;

    @Column(name = "spplzxz")
    private String spplzxz;

    @Column(name = "spplzdz")
    private String spplzdz;

    @Column(name = "mccfjgMax")
    private String mccfjgMax;

    @Column(name = "mccfjgMin")
    private String mccfjgMin;

    @Column(name = "mkMax")
    private String mkMax;

    @Column(name = "mkMin")
    private String mkMin;


    public LdfsyActive() {
        super();
    }

}
