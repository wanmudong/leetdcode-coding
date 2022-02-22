package jvm.垃圾回收机制.垃圾回收策略;

/**
 * 描述:
 * 对象优先在eden区分配
 *
 * @author chenjiehao
 * @create 2021-09-02
 */
public class test1 {
    // 当前是java1.8,常量存储在堆中
    private static final int _1MB = 1024 * 1024;

//    public static void main(String[] args) {
//        testAllocation();
//    }

    /** * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 */
    /**
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:+UseConcMarkSweepGC
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4,allocation5,allocation6;

        allocation1 = new byte[2 * _1MB];

        allocation2 = new byte[2 * _1MB];

        allocation3 = new byte[2 * _1MB];

        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC

//        allocation5 = new byte[4 * _1MB]; // 出现一次Minor GC
//
//
//        allocation6 = new byte[4 * _1MB]; // 出现一次Minor GC

    }
}
