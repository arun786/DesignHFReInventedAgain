package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("Rubber Duck");
    }
}
