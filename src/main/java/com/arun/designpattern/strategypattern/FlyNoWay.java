package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}
