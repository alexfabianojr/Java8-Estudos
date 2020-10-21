package JavaBrains.Lambdas;

public class LambdasAsInterfaceType {

    public static void main(String[] args) {

        MyLambda myLambdaFunction = ( ) -> System.out.println("Hello World!");

        MyAdd myAddFunction = ( x, y ) -> x + y;
    }
}

interface MyLambda {
    void foo();
}

interface MyAdd {
    int add(int x, int y);
}
