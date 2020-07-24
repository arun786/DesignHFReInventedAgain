package com.arun.designpattern.strategypattern;

/**
 * @author arun on 7/24/20
 */
public class Quack implements QuackBehavior{
    @Override
    public void Quack() {
        System.out.println("Duck Quacks");
    }
}
