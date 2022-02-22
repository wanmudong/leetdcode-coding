package jvm;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-08
 */
public class test_JHSDB {
    static class Test {

        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设一个断点
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }
}