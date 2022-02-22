package jvm.垃圾回收机制.垃圾回收策略;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * 描述:
 * 查看当前使用的垃圾收集器
 *
 * @author chenjiehao
 * @create 2021-09-02
 */
public class test {
    public static void main(String args[]) {
        List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }
    }

}
