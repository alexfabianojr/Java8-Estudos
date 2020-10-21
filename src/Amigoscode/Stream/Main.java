package Amigoscode.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = getPeople();

        List<Person> females = new ArrayList<>();

        //Imperative Approach (modo antigo)

        for (Person person : people) {
            if (person.getGender().equals((Gender.FEMALE))) {
                females.add(person);
                System.out.println(person);
            }
        }

        //Declarative Approach

        //Filter
        females = people.stream()
                //.filter(e -> e.getGender().equals(Gender.FEMALE))
                .filter(Main::getFemalesPersons)
                .collect(Collectors.toList());

        females.forEach(System.out::println);

        //Sort
        List<Person> sorted = people.stream()
                .sorted(
                        Comparator
                                .comparing(Person::getAge)
                                .thenComparing(Person::getGender)
                                .reversed())
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);

        //All match
        boolean allMatch = people.stream()
                //.allMatch(person -> person.getAge() > 0)
                .allMatch(Main::isPersonOlderThan8);

        System.out.println(allMatch);

        //Any match
        boolean anyMatch = people.stream()
                .anyMatch(Main::isPersonOlderThan8);

        System.out.println(anyMatch);

        //None match
        boolean noneMatch = people.stream()
                //.noneMatch(person -> person.getName().equals("Antonio"))
                .noneMatch(Main::isNameAntonio);

        System.out.println(noneMatch);

        //Max
        Optional<Person> maxAge = people.stream()
                .max(Comparator.comparing(Person::getAge));

        maxAge.ifPresent(System.out::println);

        //Min
        Optional<Person> minAge = people.stream()
                .min(Comparator.comparing(Person::getAge));

        minAge.ifPresent(System.out::println);

        //Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(
//                (gender, people1) -> {
//                    System.out.println(gender);
//                    people1.forEach(System.out::println);
//                    System.out.println();
//                }
                Main::getGenreAndPersons
        );

        Optional<String> oldestFemaleAge = people.stream()
                .filter(Main::getFemalesPersons)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return Arrays.asList(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

    private static boolean getFemalesPersons(Person e) {
        return e.getGender().equals(Gender.FEMALE);
    }

    private static boolean isPersonOlderThan8(Person person) {
        return person.getAge() > 8;
    }

    private static boolean isNameAntonio(Person person) {
        return person.getName().equals("Antonio");
    }

    private static void getGenreAndPersons(Gender gender, List<Person> people1) {
        System.out.println(gender);
        people1.forEach(System.out::println);
        System.out.println();
    }
}
