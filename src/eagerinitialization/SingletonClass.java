package eagerinitialization;

public class SingletonClass {

    //initially we create a instance
    private static final SingletonClass INSTANCE = new SingletonClass();

    //Making the constructor private is what keeps the users from creating new instances.
    private SingletonClass() {
    }

    public static SingletonClass getInstance(){
        return INSTANCE;
    }
}

//NOTES

/*
Whether anyone asks for a instance of a class or not, we create an instance of that class
We create a private static variable with the final keyword initially.
So if someone asks for an instance(getInstance method) , we can provide the instance.
So that is Eager Initialization. We create an instance of the class whether someone asks or not. When needed we can return the instance.

The downside of eager initialization in the context of singleton design pattern is primarily related to the unnecessary creation of the singleton instance before it is actually needed. Here are some potential downsides of eager initialization:
1.	Memory Usage: With eager initialization, the singleton instance is created and initialized as soon as the class is loaded by the JVM. This means that the instance occupies memory even if it is never used during the program's execution. In situations where the singleton instance is resource-intensive or memory-consuming, eager initialization can lead to wastage of resources.
2.	Performance Impact: Eager initialization can impact the application's startup time and overall performance. Creating and initializing the singleton instance upfront can introduce additional overhead during the application's initialization phase. This can be problematic if the singleton's initialization process is time-consuming or requires extensive resources.
3.	Lack of Flexibility: Eager initialization does not provide flexibility in handling scenarios where the singleton instance might not be needed at all. It can be particularly problematic in large-scale applications where certain components or modules may not require the singleton instance during their execution. In such cases, eager initialization can lead to unnecessary overhead and hinder the application's scalability.
4.	Inability to Handle Exceptions: Eager initialization does not handle exceptions that might occur during the creation or initialization of the singleton instance. If an exception is encountered, it can potentially disrupt the application's normal flow and make it difficult to recover from the error. Lazy initialization, on the other hand, provides better exception handling capabilities by creating the instance only when it is requested.
It's important to consider these downsides when choosing between eager initialization and lazy initialization for singleton implementation. Depending on the specific requirements and constraints of your application, lazy initialization (on-demand instantiation) might be a more suitable approach to mitigate these downsides and optimize resource usage.



 */
