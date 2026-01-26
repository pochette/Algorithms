package Patterns.Singleton;

public class Singleton {
    private static Singleton instance;
    private String value;

    private Singleton() {
    }

    private Singleton (Singleton instance) {
        super();
    }

    static Singleton getPrototype() {
        return new Singleton();
    }
    static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
