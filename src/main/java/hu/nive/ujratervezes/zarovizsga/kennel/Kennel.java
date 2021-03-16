package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();
    Dog dog;

    public Kennel() {
    }

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void feedAll() {
        dog.feed();
    }

    public Dog findByName(String name) {
        for (Dog dog:dogs){
            if (dog.getName().equals(dog)){
                return dog;
            }
        }
        throw new IllegalArgumentException("Dog not found: " + name);
    }

    public void playWith(String name, int hours) {
        for (Dog dog:dogs){
            if (dog.getName().equals(dog)){
                dog.play(hours);
            }
        }
        throw new IllegalArgumentException("Dog not found: " + name);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> result = new ArrayList<>();
        for (Dog dog:dogs){
            if (dog.getHappiness()>minHappiness){
                result.add(dog.getName());
            }
        }
        return result;
    }
}
