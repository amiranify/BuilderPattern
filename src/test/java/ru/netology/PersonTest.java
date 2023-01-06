package ru.netology;

import org.junit.jupiter.api.Assertions;

class PersonTest {

    Person person = new PersonBuilder()
            .setName("Анна")
            .setSurname("Вольф")
            .setAge(31)
            .setAddress("Урюпинск")
            .build();

    @org.junit.jupiter.api.Test
    void setAddress() {
        Assertions.assertEquals("Урюпинск", person.address);
    }

    @org.junit.jupiter.api.Test
    void happyBirthday() {
        person.happyBirthday();
        Assertions.assertEquals(32, person.age);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Assertions.assertEquals(1303220693, person.hashCode());

    }

    @org.junit.jupiter.api.Test
    void newChildBuilder() {
        Person son = person.newChildBuilder().setName("Арсений").setAge(3).build();
        Assertions.assertEquals(person.getSurname(), son.getSurname());
        Assertions.assertEquals(person.getAddress(), son.getAddress());
    }
}