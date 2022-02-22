package jvm.虚拟机性能监控.基础处理工具;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-07
 */
public class test_jstack {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                    for (Map.Entry entry : allStackTraces.entrySet()) {
                        System.out.println("Thread" + entry.getKey());
                        System.out.println("StackTraceElement" + entry.getValue().toString());
                    }
                }
            }
        };
        run.run();
        while (true){
            try {
                // jstack Java堆栈跟踪工具
                // jstack [ option ] vmid
                // jstack -l
                //  Thread.getAllStackTraces();
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
