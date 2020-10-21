package Alura.DefaultMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsDefaultMethods {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("Alura Online");
        palavras.add("Editora Casa do Codigo");
        palavras.add("Caelum");

        Collections.sort(palavras);
        System.out.println(palavras);

        Comparator<String> comparador = new ComparadorPorTamanho();
        Collections.sort(palavras, comparador);

        System.out.println(palavras);

        for(String s : palavras) {
            System.out.println(s);
        }

        //Java8
        //Default Method - metodos dentro de uma interface com corpo (concreto)

        System.out.println("--------- JAVA 8 ---------");

        palavras.sort(comparador);
        System.out.println(palavras);

        Consumer<String> consumidor = new ImprimeNaLinha();

        palavras.forEach(consumidor);
    }
}

class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }

    @Override
    public Consumer<String> andThen(Consumer<? super String> consumer) {
        return null;
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        } else if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}
