package com.zhongyi.be.entity;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;
import com.zhongyi.be.core.BumpCore;
import com.zhongyi.be.entity.base.BumpBase;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by gorebill on 23/6/15.
 *
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
//@Entity
@Embeddable
//@Table(name = "LdfsyVo")//, schema = BumpCore.HBASE_SCHEMA
//@IndexCollection(columns = { @Index(name = "id")})
public class LdfsyVo implements BumpBase {

    //@Id
    //@TableGenerator(name = "id_gen", allocationSize = 30, initialValue = 100)
    //@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)//
    //@Column(name = "uuid")
    //private int uuid;

    //@Id
    //@GeneratedValue(strategy = GenerationType.TABLE)

    /**
     * 即原hashmap的long型key
     */
    @Column(name = "timeStamp")
    private Long timeStamp;

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


    /**
     * embeded不能用protected
     */
    public LdfsyVo() {
        super();
    }

    /**
     * 必须提供timestamp作为id
     * @param tsid
     */
//    public LdfsyVo(long tsid) {
//        super();
//        this.tsid=tsid;
//    }

    /*
    public LdfsyVo(String ldbwType, String ldbwUpdater, Date ldbwUpdateDate) {
        super();

        this.ldbwType=ldbwType;
        this.ldbwUpdater=ldbwUpdater;
        this.ldbwUpdateDate=ldbwUpdateDate;
    }
    */

}
