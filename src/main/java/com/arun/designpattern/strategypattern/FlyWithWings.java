package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }
}
