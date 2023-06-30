package threadsafemethodinitialization;

public class SingletonClass {

        private static volatile SingletonClass instance = null;

        private SingletonClass() {
        }

    public static synchronized SingletonClass getInstance(){
                if(instance == null){
                    instance = new SingletonClass();
                }
                return instance;
            }//making the entire method synchronized means, whenever one thread is accessing
    // the getInstance(), it will make sure only one thread access the whole method
    //The only difference between this and lazy initialization is, in lazy initialization
    // it was not thread safe.
    //Here its thread safe
    }

