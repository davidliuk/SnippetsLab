// 懒汉式，线程安全版
// 双锁校验式，线程安全的
class Singleton {
    private volatile static Singleton instance; 
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                // 防止排队等锁的对象进入同步块后又new一个对象出来导致得到不同的实例
                if (instance == null) {
                    // 分配空间，初始化对象，将变量指向分配的地址空间
                    instance = new Singleton();
                }
            }
        }
    }
}

// 饿汉式
class Hungry {
    // 类加载的时候就实例化，并且创建单例对象
    private static final Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }
}
