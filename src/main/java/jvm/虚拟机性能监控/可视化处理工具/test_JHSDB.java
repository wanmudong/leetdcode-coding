package jvm.虚拟机性能监控.可视化处理工具;

import org.omg.CORBA.ObjectHolder;

/**
 * 描述:
 * scanoops 命令中找类,类路径中不可以存在中文
 *
 * @author chenjiehao
 * @create 2021-09-08
 */
public class test_JHSDB {
    static class Test {

        static test_JHSDB.ObjectHolder staticObj = new test_JHSDB.ObjectHolder();
        test_JHSDB.ObjectHolder instanceObj = new test_JHSDB.ObjectHolder();

        void foo() {
            test_JHSDB.ObjectHolder localObj = new test_JHSDB.ObjectHolder();
            System.out.println("done"); // 这里设一个断点
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new test_JHSDB.Test();
        test.foo();
    }
}
