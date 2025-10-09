package Patterns;

import Sort.RadixSort;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.performFly();
        mallardDuck.setQuackBehavior(new Squick());
        mallardDuck.performQuack();


        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.setFlyBehavior(new FLyRocketPowered());
        rubberDuck.performFly();
        rubberDuck.setQuackBehavior(new Quack());
        rubberDuck.performQuack();
    }
}
