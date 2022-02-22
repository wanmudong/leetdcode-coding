package jvm.虚拟机性能监控.基础处理工具;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-07
 */
public class test_jps {
    public static void main(String[] args) {
        while (true){
            try {
                // jps 虚拟机进程状况工具
                // test jps -l
                // test jps -v  输出虚拟机进程启动的JVM参数
                Thread.sleep(3000);
                System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
