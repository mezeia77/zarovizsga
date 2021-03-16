package hu.nive.ujratervezes.zarovizsga.kennel;

public class Dog {

    private String name;
    private int happiness;

    public Dog(String name) {
        this.name = name;
        this.happiness = 0;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public void feed(){
        if(getClass().getName().equals("hu.nive.ujratervezes.zarovizsga.kennel.Beagle")){
            happiness+=2;
        } else {
            happiness+=4;
        }
    }
    public void play(int hours){
        if(getClass().getName().equals("hu.nive.ujratervezes.zarovizsga.kennel.Beagle")){
            happiness=2*hours;
        } else {
            happiness=3*hours;
        }
    }

}
