package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public abstract class Duck {
    protected FlyBehavior flyBehaviour;
    protected QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehavior.Quack();
    }

    public void swim() {
        System.out.println("All ducks swim");
    }
}
