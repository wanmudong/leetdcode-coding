package jvm.垃圾回收机制.垃圾回收策略;

/**
 * 描述:
 * 大对象直接进入老年代
 *
 * @author chenjiehao
 * @create 2021-09-02
 */
public class test2 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    /** * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8  -XX:PretenureSizeThreshold=3145728 */
    /**
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:+UseConcMarkSweepGC
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;

        allocation = new byte[4 * _1MB]; //直接分配在老年代中

    }
}
