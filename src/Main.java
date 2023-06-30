import lazyinitialization.SingletonClass;

public class Main {
    public static void main(String[] args){
        SingletonClass instance = SingletonClass.getInstance();

        System.out.println(instance); //An instance will be printed

        SingletonClass instance1 = SingletonClass.getInstance();

        System.out.println(instance1); //Same  instance that was created earlier will be printed
    }
}
