package doublecheckedlocking;
/*If u plan to implement a Singleton in a
multi-threaded environment u can do it like shown below.*/

public class SingletonClass {
    private static volatile SingletonClass instance = null;

    private SingletonClass() {
    }

    public static SingletonClass getInstance(){
        if(instance == null){
            synchronized (SingletonClass.class){
                if(instance == null){
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}

/*
Something that can happen in a multi-threaded environment is that, at the null check, two thread might encounter that there is no instance created.
So then in such a situation both the threads might go and create new instances. Then 2nd instance will be overridden by 1st instance.
To avoid this , we use the Double-checked locking. (When implementing singleton in a multi-threaded environment)
What we do is, we check if the instance == null.
Then we lock the thread using synchronized keyword and then create a new instance.
So in this way we can make sure when one thread is creating an instance, until that thread creates the instance the other thread will not be able to create an instance.
If(instance==null){}  one thread will create an instance.
After that only other thread access this code block.
Then since an instance is already created the null check will fail. And it will return the same instance that was created before.

 */
