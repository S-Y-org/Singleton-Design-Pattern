package lazyinitialization;

public class SingletonClass {

    private static SingletonClass instance = null;

    private SingletonClass() {
    }

    public static SingletonClass getInstance(){
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }
}

/*
Here we don’t create an instance initially.
If someone asks for an instance only, we create a new instance
This is lazy initialization.

 */