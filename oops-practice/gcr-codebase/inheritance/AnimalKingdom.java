// Superclass
class Animal {
    protected String name;
    protected int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}
// Subclass Dog
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
// Subclass Cat
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
// Subclass Bird
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println("Bird chirps");
    }
}
public class AnimalKingdom {
    public static void main(String[] args) {
        Animal dog = new Dog("Spike", 10);
        Animal cat = new Cat("Beerus", 6);
        Animal bird = new Bird("Timmy", 2);
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}