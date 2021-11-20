package com.bookovna;

public class Cat {
    int age;
    String name;
    boolean isDomestic;
    int weight;

    public void purr() {
        System.out.println("mrrrrrrrrrrrrr sound");
    }

    public void incrementAge() {
        age = age + 1;
    }

    public void incrementWeight() {
        weight = weight + 1;
    }
}
