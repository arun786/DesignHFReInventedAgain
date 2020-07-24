package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("Decoy Duck");
    }
}
