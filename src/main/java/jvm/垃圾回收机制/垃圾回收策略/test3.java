package jvm.垃圾回收机制.垃圾回收策略;

/**
 * 描述:
 * 长期存活的对象进入老年代
 *
 * @author chenjiehao
 * @create 2021-09-02
 */
public class test3 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testTenuringThreshold();
    }

    /** * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1  -XX:+PrintTenuringDistribution -XX:+UseConcMarkSweepGC */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {

        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4]; // 什么时候进入老年代决定于XX:MaxTenuringThreshold设置

        allocation2 = new byte[4 * _1MB];

        allocation3 = new byte[4 * _1MB]; // 第一次minor gc   allocation1   allocation2

        allocation3 = null;

        allocation3 = new byte[4 * _1MB];

    }
}
