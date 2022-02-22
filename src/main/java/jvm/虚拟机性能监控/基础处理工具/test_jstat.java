package jvm.虚拟机性能监控.基础处理工具;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-07
 */
public class test_jstat {
    public static void main(String[] args) {
        while (true){
            try {
                // jstat 虚拟机统计信息监视工具
                // jstat [ option vmid [interval[s|ms] [count]] ]
                // jstat -gcutil
                //  S0     S1     E      O      M           CCS           YGC           YGCT             FGC            FGCT              GCT
                //   s1    s2      eden   old   metaspace   压缩使用比例   young gc 次数   young gc 耗时    full gc 次数   full gc 次数      gc 总耗时
                Thread.sleep(3000);
                System.out.println(1);
                List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
                for(GarbageCollectorMXBean b : l) {
                    System.out.println(b.getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
