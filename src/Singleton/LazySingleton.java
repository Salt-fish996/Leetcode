package Singleton;

/**
 * @author hyy
 * @date 2019/11/22 19:27
 */
//饿汉式
public class LazySingleton {
    private static final Singleton singleton = new Singleton();
    private static Singleton singleton2;
    private LazySingleton(){

    }
    public static Singleton getSingleton(){
        return singleton;
    }

    //懒加载
    public static synchronized Singleton getSingletonLazy(){
        if (singleton2 == null){
            singleton2 = new Singleton();
        }
        return singleton2;
    }

}
