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
public class test_jmap {
    public static void main(String[] args) {
        while (true){
            try {
                // jmap Java内存映像工具
                // jmap [ option ] vmid
                // jinfo -flag CMSInitiatingOccupancyFraction 1444
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
