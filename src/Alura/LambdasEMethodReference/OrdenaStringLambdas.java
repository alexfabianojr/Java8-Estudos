package Alura.LambdasEMethodReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStringLambdas {
    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("Alura Online");
        palavras.add("Editora Casa do Codigo");
        palavras.add("Caelum");

        //palavras.sort((s1, s2) -> compara2Strings(s1, s2));

        //Method Reference ::
        palavras.sort(OrdenaStringLambdas::compara2Strings);

        //palavras.forEach(element -> System.out.println(element));
        palavras.forEach(System.out::println);

        palavras.sort(OrdenaStringLambdas::outroCompara2Strings);

        palavras.forEach(System.out::println);

        palavras.sort(Comparator.comparingInt(String::length));

        palavras.forEach(System.out::println);
    }

    private static int outroCompara2Strings(String s1, String s2) {

        return Integer.compare(s1.length(), s2.length());
    }

    public static int compara2Strings(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        } else if (s1.length() > s2.length()) {
            return 1;
        } else {
            return 0;
        }
    }
}
