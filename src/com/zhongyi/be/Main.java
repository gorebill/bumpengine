package com.zhongyi.be;

import com.zhongyi.be.core.BumpCore;
import com.zhongyi.be.entity.LdfsyActive;
import com.zhongyi.be.entity.LdfsyQb;
import com.zhongyi.be.entity.LdfsyVo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("app start");
        testDatabase();
        System.out.println("app finished");
    }

    /**
     * test function
     */
    public static void testDatabase() {
        try{
            BumpCore bumpCore = BumpCore.getInstance();
            bumpCore.initDatabase();

            for(int i=0; i<3; i++) {
                // sleep awhile for an timestamp increment
                Thread.sleep(100);

                System.out.println("Persisting...");
                LdfsyVo ldbw_1=new LdfsyVo();
                ldbw_1.setTimeStamp(System.currentTimeMillis());
                ldbw_1.setBwlx("报文类型 1");
                ldbw_1.setBz("bz 1");

                LdfsyVo ldbw_2=new LdfsyVo();
                ldbw_2.setTimeStamp(System.currentTimeMillis()+1);
                ldbw_2.setBwlx("报文类型 2");
                ldbw_2.setBz("bz 2");

                List<LdfsyVo> vos=new ArrayList<>();
                vos.add(ldbw_1);
                vos.add(ldbw_2);

                LdfsyQb ldfsy_1=new LdfsyQb("model_0", "sigId_"+i);
                ldfsy_1.setLdfsyVos(vos);

                List<LdfsyQb> ldfsyCjqbList=new ArrayList<>();
                ldfsyCjqbList.add(ldfsy_1);
                // * 调用文档的接口writeLdfsyCjqb
                bumpCore.writeLdfsyCjqb(ldfsyCjqbList);

                System.out.println("Persist completed");

                System.out.println("Querying records...");
                //List<LdfsyQb> results = this.entityManager.createQuery("select qb from LdfsyQb qb").getResultList();
                List<LdfsyQb> results = bumpCore.findAll(LdfsyQb.class);
                System.out.println("LdfsyQb size: " + results.size());
                for(LdfsyQb entity : results) {
                /*
                List<Field> fields = new ArrayList<>(Arrays.asList(entity.getClass().getDeclaredFields()));
                for(Field field : fields) {
                    if(field.isAnnotationPresent(Column.class)
                            || field.isAnnotationPresent(OneToOne.class)
                            || field.isAnnotationPresent(OneToMany.class)) {
                        String fieldName = field.getName();
                        if("String".equalsIgnoreCase(field.getType().getSimpleName())) {
                            Method getter = entity.getClass().getDeclaredMethod(String.format("get%s", StringUtils.capitalize(fieldName)));

                            System.out.println(String.format("%s=%s", fieldName, getter.invoke(entity)));
                        }else{
                            System.out.println(String.format("Unsupported type to invoke getter of %s.", fieldName));
                        }
                    }
                }
                */

                    for(LdfsyVo vo : entity.getLdfsyVos()) {
                        System.out.println("--------------vo---------------");
                        System.out.println(vo);
                    }
                    for(LdfsyActive act : bumpCore.findAll(LdfsyActive.class)) {
                        System.out.println("--------------act---------------");
                        System.out.println(act);
                    }
                }
                System.out.println("Querying completed...");
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
