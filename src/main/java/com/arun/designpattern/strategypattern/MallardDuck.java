package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Its a Mallard Duck");
    }
}
