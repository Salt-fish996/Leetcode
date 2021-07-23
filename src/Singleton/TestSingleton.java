package Singleton;

/**
 * @author hyy
 * @date 2019/11/22 19:32
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton s = LazySingleton.getSingleton();
        Singleton s2 = LazySingleton.getSingleton();
        System.out.println(s == s2);
        System.out.println(LazySingleton.getSingletonLazy() == LazySingleton.getSingletonLazy());
    }
}
