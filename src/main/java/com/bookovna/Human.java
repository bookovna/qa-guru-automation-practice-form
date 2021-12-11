package com.bookovna;

public class Human {
    private int age;
    private String firstName;
    private String lastName;
    private boolean hasACat = false;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isHasACat() {
        return hasACat;
    }

    public void setHasACat(boolean hasACat) {
        this.hasACat = hasACat;
    }

    private class Head {
        String name = "человеческая голова";
        String diameter;
    }

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void sayFirstName() {
        System.out.println("Имя — " + firstName);
    }

    public void sayLastName() {
        System.out.println("Фамилия — " + lastName);
    }

    public void sayCatsName(Cat cat) {
        System.out.println("Имя кошки — " + cat.getName());
    }

    public void sayCatsAge(Cat cat) {
        System.out.println("Возраст кошки — " + cat.getAge());
    }

    public void sayCatsWeight(Cat cat) {
        System.out.println("Кошка весит " + cat.getWeight() + " кг");
    }

    public void sayAge() {
        System.out.println("Возраст — " + age);
    }

    public void incrementAge() {
        age = age + 1;
    }

    public static void sayClassName() {
        System.out.println(Human.class.getName());
    }
}
