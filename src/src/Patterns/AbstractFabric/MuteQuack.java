package Patterns.AbstractFabric;

public class MuteQuack implements QuackBehavior{
    public void quack() {
        System.out.println("I can't quack, sorry!");
    }
}
