package Amigoscode.Optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Object> empty = Optional.empty();

        System.out.println(empty);
        System.out.println(empty.isPresent());

        Optional<String> hello = Optional.of("hello");

        System.out.println(hello.get());

        String orElse = (String) empty.orElse("world");

        System.out.println(orElse);

        String orElse2 = hello
                .map(String::toUpperCase)
                .orElse("world");

        System.out.println(orElse2);

        String orElse3 = hello
                .map(String::toUpperCase)
                .orElseGet( () -> {
                    //...extra computation to retrieve the value
                    return "world";
                });

        System.out.println(orElse3);

        //hello.ifPresent(word -> System.out.println(word));
        hello.ifPresent(System.out::println);

    }
}
