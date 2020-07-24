package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class MallardDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}
