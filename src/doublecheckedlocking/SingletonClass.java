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



The volatile keyword in Java is used to indicate that a variable may be modified by multiple threads. It ensures that the variable's value is always read from and written to the main memory, rather than being cached in a thread's local cache.
The main use of the volatile keyword is to provide a guarantee of visibility and atomicity in multi-threaded environments. Here are its key characteristics and use cases:
1.	Visibility: When a variable is declared as volatile, any changes made to its value by one thread are immediately visible to other threads. This ensures that all threads are reading the most up-to-date value of the variable from the main memory, rather than using a cached value. It helps in preventing data inconsistencies and synchronization issues between threads.
2.	Atomicity: The volatile keyword ensures that read and write operations on the variable are atomic. Atomicity means that the operation is executed as a single, indivisible unit, without any interference from other threads. This is particularly useful when dealing with variables that are accessed and modified by multiple threads simultaneously.
3.	Use Cases: The volatile keyword is commonly used in scenarios where a variable is shared among multiple threads, and the variable's value needs to be synchronized and consistent across all threads. For example, it can be used for flag variables that control the execution of threads, or for variables used in lock-free algorithms and double-checked locking patterns.
It's important to note that while volatile ensures visibility and atomicity, it does not provide mutual exclusion or synchronization guarantees. For scenarios that require more complex synchronization, the volatile keyword should be combined with other synchronization mechanisms such as locks, mutexes, or the synchronized keyword.
Overall, the volatile keyword is a tool in Java's concurrency model that helps ensure consistent and synchronized access to shared variables in multi-threaded environments.

volatile, synchronized keywords are used when dealing with threads.


 */
