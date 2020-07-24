package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("Red head duck");
    }
}
