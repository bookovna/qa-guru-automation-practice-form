package com.bookovna;

public class Main {

    public static void main(String[] args) {
        Human masha = new Human();

        masha.firstName = "Маша";
        masha.lastName = "Иванова";
        masha.age = 32;
        masha.hasACat = true;

        Cat baisy = new Cat();
        baisy.name = "Бейси";
        baisy.age = 12;
        baisy.isDomestic = true;
        baisy.weight = 4;

        masha.sayFirstName();
        masha.sayLastName();
        masha.incrementAge();
        masha.sayAge();

        masha.sayCatsName(baisy);
        masha.sayCatsWeight(baisy);

        baisy.incrementAge();
        baisy.incrementWeight();

        masha.sayCatsWeight(baisy);
        baisy.purr();
    }
}
