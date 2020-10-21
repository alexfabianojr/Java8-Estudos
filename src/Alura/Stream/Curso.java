package Alura.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ExemploCursos {
    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));

        cursos.forEach(System.out::println);

        cursos.forEach(elemento -> System.out.println(elemento.getNome()));

        //mesma logica de cima
        //mas extraindo a logica num metodo externo para fazer referencia
        cursos.forEach(ExemploCursos::imprimirNome);

        //retorna Cursos
        cursos.stream()
                .filter(elemento -> elemento.getAlunos() >= 100)
                .forEach(elemento -> System.out.println(elemento.getNome()));

        //retorna int
        cursos.stream()
                .filter(elemento -> elemento.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        IntStream streamDeInts = cursos.stream()
                .filter(elemento -> elemento.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos);

        System.out.println(streamDeInts);

        int sum = cursos.stream()
                .filter(elemento -> elemento.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(sum);

        Optional<Curso> anyCurso = cursos.stream()
                .filter(e -> e.getAlunos() >= 100)
                .findAny();

        //curso que pode jogar excecao
        Curso c1 = anyCurso.get();

        //outra opcao
        Curso c2 = anyCurso.orElse(null); //ou qualquer coisa no lugar do null

        anyCurso.ifPresent(e -> System.out.println(e.getNome()));

        cursos.stream()
                .filter(e -> e.getAlunos() >= 100)
                .findAny()
                .ifPresent(e -> System.out.println(e.getNome()));

        OptionalDouble media = cursos.stream()
                .filter(e -> e.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .average();

        List<Curso> collect = cursos.stream()
                .filter(e -> e.getAlunos() >= 100)
                .collect(Collectors.toList());

        Map<String, Integer> map = cursos.stream()
                .filter(e -> e.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        Curso::getNome,
                        Curso::getAlunos
                ));

        cursos.stream()
                .filter(e -> e.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        Curso::getNome,
                        Curso::getAlunos
                ))
                .forEach(
                        (nome, alunos) -> System.out.println(nome + " tem "
                                                + alunos + " alunos")
                );

        cursos.parallelStream()
                .filter(e -> e.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        Curso::getNome,
                        Curso::getAlunos
                ))
                .forEach(
                        (nome, alunos) -> System.out.println(nome + " tem "
                                + alunos + " alunos")
                );
    }

    private static void imprimirNome(Curso elemento) {
        System.out.println(elemento.getNome());
    }
}

public class Curso {

    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }
}

