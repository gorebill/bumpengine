package com.zhongyi.be.core;

import com.zhongyi.be.entity.LdfsyActive;
import com.zhongyi.be.entity.LdfsyQb;
import com.zhongyi.be.entity.LdfsyVo;
import com.zhongyi.be.entity.base.BumpBase;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.util.Hash;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by gorebill on 24/6/15.
 *
 *
 * TODO: 1.定义外键表
 * TODO: 2.定义对外键引用的persist
 * TODO: 3.定义其它表
 *
 */
public class BumpCore {

    static private BumpCore singleton = null;

    private EntityManagerFactory entityMangerFactory = null;
    private EntityManager entityManager = null;

    public final static String HBASE_UNIT = "bumpPU";
    public final static String HBASE_KEYSPACE = "BumpEngineDB";
    public final static String HBASE_SCHEMA = HBASE_KEYSPACE+"@"+HBASE_UNIT;

    protected BumpCore() {
        this.entityMangerFactory = Persistence.createEntityManagerFactory(HBASE_UNIT);
        this.entityManager = entityMangerFactory.createEntityManager();
        this.entityManager.setFlushMode(FlushModeType.COMMIT);
    }

    /**
     * Singleton BumpCore constructor.
     * @return BumpCore
     */
    static public BumpCore getInstance() {

        if(null == singleton || null == singleton.entityManager
                || !singleton.entityManager.isOpen()
                || !singleton.entityMangerFactory.isOpen()) {

            try{
                singleton.entityManager.close();
                singleton.entityMangerFactory.close();
            }catch(Exception e){}

            BumpCore instance=new BumpCore();
            singleton = instance;
        }

        return singleton;
    }

    /**
     * Initialize hbase.
     * @return Boolean
     */
    public boolean initDatabase() {

        return true;
    }

    /**
     * 5.3	写入ldfsy记录
     * @param ldfsyRecords
     * @return
     */
    public boolean writeLdfsyCjqb(List<LdfsyQb> ldfsyRecords) throws Exception {
        try {
            this.entityManager.getTransaction().begin();

            for (LdfsyQb record : ldfsyRecords) {

                for (LdfsyVo vo : record.getLdfsyVos()) {

                    LdfsyActive ldfsyActive = new LdfsyActive();
                    // set timestamp作为active表的rowkey
                    ldfsyActive.setTimeStamp(vo.getTimeStamp());

                    // 复制属性值
                    ldfsyActive.setActive(record.isActive());
                    //ldfsyActive.setElecId(record.getElecId);// TODO: 如果确定要elecId, 这行要uncomment
                    ldfsyActive.setModel(record.getModel());
                    ldfsyActive.setSigId(record.getSigId());
                    ldfsyActive.setFsybh(record.getFsybh());
                    ldfsyActive.setFsylx(record.getFsylx());
                    ldfsyActive.setFsyxh(record.getFsyxh());
                    ldfsyActive.setDwsx(record.getDwsx());
                    ldfsyActive.setZyxdj(record.getZyxdj());
                    ldfsyActive.setDyjscwjbs(record.getDyjscwjbs());
                    ldfsyActive.setSfyjsc(record.getSfyjsc());

                    ldfsyActive.setBwlx(vo.getBwlx());
                    ldfsyActive.setGxyhmc(vo.getGxyhmc());
                    ldfsyActive.setSsbdbh(vo.getSsbdbh());
                    ldfsyActive.setGxsj(vo.getGxsj());
                    ldfsyActive.setJhbdbh(vo.getJhbdbh());
                    ldfsyActive.setJhzbbh(vo.getJhzbbh());
                    ldfsyActive.setJhbdjd(vo.getJhbdjd());
                    ldfsyActive.setJhbdwd(vo.getJhbdwd());
                    ldfsyActive.setJhbdgd(vo.getJhbdgd());
                    ldfsyActive.setFy(vo.getFy());
                    ldfsyActive.setFw(vo.getFw());
                    ldfsyActive.setBz(vo.getBz());

                    ldfsyActive.setSplx(vo.getSplx());
                    ldfsyActive.setCplx(vo.getCplx());
                    ldfsyActive.setMklx(vo.getMklx());
                    ldfsyActive.setMntzlx(vo.getMntzlx());
                    ldfsyActive.setMctzlx(vo.getMctzlx());
                    ldfsyActive.setTxjhlx(vo.getTxjhlx());
                    ldfsyActive.setTxbssmys(vo.getTxbssmys());
                    ldfsyActive.setTxsmzq(vo.getTxsmzq());
                    ldfsyActive.setSpplzxz(vo.getSpplzxz());
                    ldfsyActive.setSpplzdz(vo.getSpplzdz());
                    ldfsyActive.setMccfjgMax(vo.getMccfjgMax());
                    ldfsyActive.setMccfjgMin(vo.getMccfjgMin());
                    ldfsyActive.setMkMax(vo.getMkMax());
                    ldfsyActive.setMkMin(vo.getMkMin());

                    this.persist(ldfsyActive);
                }


                this.persist(record);
            }

            this.entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            this.entityManager.getTransaction().rollback();
            return false;
        }
    }

    /**
     * Find all entities by class.
     * @param c
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> findAll(Class<T> c) throws Exception {
        List<T> results;

        try{
            if(!this.isDBOpen()) {
                throw new Exception("BumpCore instance has been expired.");
            }

            results = this.entityManager.createQuery(String.format("select qb from %s qb", c.getSimpleName())).getResultList();

        }catch(Exception e){
            throw e;
        }

        return results;
    }

    /**
     * Persist entity.
     * @param entity
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T extends BumpBase> boolean persist(T entity) throws Exception {
        try{
            if(!this.isDBOpen()) {
                throw new Exception("BumpCore instance has been expired.");
            }

            this.entityManager.persist(entity);

        }catch(Exception e){
            throw e;
        }

        return true;
    }

    /**
     * Check db connection.
     * @return
     */
    public boolean isDBOpen() {
        if(null == singleton || null == singleton.entityManager
                || !this.entityManager.isOpen()
                || !this.entityMangerFactory.isOpen()) {
            return false;
        }

        return true;
    }


    /*
    public void shutdown() {
        if (null != singleton) {
            singleton.entityManager.close();
            singleton.entityMangerFactory.close();
        }
    }
    */

    /*
    public void teardown() {
    }
    */

}
