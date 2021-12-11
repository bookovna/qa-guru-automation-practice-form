package com.bookovna;

public class Main {

    public static void main(String[] args) {
        Human masha = new Human("Маша", "Иванова");
        Cat baisy = new Cat("Бейси");

        masha.setAge(32);
        masha.setHasACat(true);

        masha.sayFirstName();
        masha.sayLastName();
        masha.incrementAge();
        masha.sayAge();

        baisy.setAge(12);
        baisy.setWeight(4);
        masha.sayCatsName(baisy);
        masha.sayCatsWeight(baisy);

        baisy.incrementAge();
        baisy.incrementWeight();

        masha.sayCatsWeight(baisy);
        baisy.purr();

    }
}
