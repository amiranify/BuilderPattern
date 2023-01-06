package ru.netology;

public class Main {
    public static void main(String... args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Урюпинск")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Арсюша")
                .setSurname(mom.getSurname())
                .setAge(3)
                .setAddress(mom.getAddress())
                .build();
        Person dad = new PersonBuilder()
                .setName("Вольдемар")
                .setSurname(mom.getSurname())
                .setAge(40)
                .setAddress(mom.getAddress())
                .build();
        System.out.println("У " + mom.name + " и "+ dad.name + " " + dad.surname + " есть сын, " + son);
        System.out.println(dad);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
