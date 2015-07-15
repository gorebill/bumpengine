package com.zhongyi.be.entity;

import com.impetus.kundera.index.IndexCollection;
import com.impetus.kundera.index.Index;
import com.zhongyi.be.entity.base.BumpBase;
import com.zhongyi.be.exception.BumpException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

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
@Table(name = "LdfsyQb")//, schema = BumpCore.HBASE_SCHEMA
//@IndexCollection(columns = { @Index(name = "__ldfsyVos")})//, @Index(name = "idx_2"), @Index(name = "idx_3")
public class LdfsyQb implements BumpBase {

    /**
     *
     * Reference:
     * https://github.com/impetus-opensource/Kundera/wiki/Primary-Key-Auto-generation
     */
    //@Id
    //@TableGenerator(name = "id_gen", allocationSize = 30, initialValue = 100)
    //@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)//
    //@Column(name = "uuid")
    //private int uuid;

    @Id
    //@Column(name="id")
    private String id;

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

    @ElementCollection
    @Column(name="ldfsyVos")
    private List<LdfsyVo> ldfsyVos=new ArrayList<>();
    //@CollectionTable(name="LdfsyVo")
    //@MapKeyColumn(name="ldfsyVos")
    //@OneToMany(cascade=CascadeType.ALL)//(mappedBy = "id")
    //@MapKeyColumn(name="id")
    //@MapKeyJoinColumn(name="id")
    //@JoinColumn(name="id")
    //@MapKey(name="id")
    //private Map<Long, LdfsyVo> ldfsyVos=new HashMap<>();

    //@ElementCollection
    //@Column(name="comments")
    //private Map<Long, String> comments;


    /**
     * 一对多报文
     * Reference:
     * https://github.com/impetus-opensource/Kundera/wiki/Twitter-Example
     */
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "uuid")
    //private Set<LdfsyVo> ldfsyBws;

    protected LdfsyQb() {
        super();
    }

    public LdfsyQb(String model, String sigId) {
        super();

        if(null==model) new BumpException("model cannot be null");
        if(null==sigId) new BumpException("sigId cannot be null");

        this.model=model;
        this.sigId=sigId;
        this.id=String.format("%s,%s", model, sigId);
    }

    /*
    public LdfsyQb(String ldfsyType, String ldfsySubType, String ldfsyOwner,//Integer uuid,
                   String ldfsyPriority, String ldfsyPrintFlag) {
        super();

        //this.uuid=uuid;
        this.ldfsyType=ldfsyType;
        this.ldfsySubType=ldfsySubType;
        this.ldfsyOwner=ldfsyOwner;
        this.ldfsyPriority=ldfsyPriority;
        this.ldfsyPrintFlag=ldfsyPrintFlag;
    }
    */

}
