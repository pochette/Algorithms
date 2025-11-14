package Patterns.AbstractFabric;

public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck() {

    }

    public void performQuack() {
        quackBehavior.quack();
    }
    public void performFly() {
        flyBehavior.fly();
    }
    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
    public abstract void display();

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
