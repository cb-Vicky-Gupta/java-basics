package com.opps;

public class Opps {
    static class Animal {
        String name;
        public Animal(String name) {
            this.name = name;
        }
        public void eat() {
            System.out.println(name + " " + "is Eating");
        }
    }

    static class Dog extends Animal {
        String breed;
        public void bark() {
            System.out.println(name + " " + "Woof Woof");
        }
        public Dog(String name, String breed) {
            super(name);
            this.breed = breed;
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Tiger", "Pitbull");
//        dog.name = "Tiger";
//        dog.breed = "Pitbull";
        dog.eat();   // inherited from Animal
        dog.bark();  // Dog's own method
        System.out.println(dog.breed);
    }
}
