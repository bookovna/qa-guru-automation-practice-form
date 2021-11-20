package com.bookovna;

public class Human {
    int age;
    String firstName;
    String lastName;
    boolean hasACat;

    public void sayFirstName() {
        System.out.println(firstName);
    }

    public void sayLastName() {
        System.out.println(lastName);
    }

    public void sayCatsName(Cat cat) {
        System.out.println(cat.name);
    }

    public void sayCatsAge(Cat cat) {
        System.out.println(cat.age);
    }

    public void sayCatsWeight(Cat cat) {
        System.out.println(cat.weight);
    }

    public void sayAge() {
        System.out.println(age);
    }

    public void incrementAge() {
        age = age + 1;
    }
}
