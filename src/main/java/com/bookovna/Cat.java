package com.bookovna;

public class Cat {
    private String name;
    private boolean isDomestic;
    private int age;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void setDomestic(boolean domestic) {
        isDomestic = domestic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private class Head {
        String name = "кошачья голова";
        String diameter;
        private class Whiskers {
            int amountOfWhiskers;
            int averageLength;
        }
    }

    private class Tail {
        String name = "кошачий хвостик";
        boolean isLong;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void purr() {
        System.out.println("Кошка говорит mrrrrrrrrrrrrr");
    }

    public void incrementAge() {
        age = age + 1;
    }

    public void incrementWeight() {
        weight = weight + 1;
    }
}
