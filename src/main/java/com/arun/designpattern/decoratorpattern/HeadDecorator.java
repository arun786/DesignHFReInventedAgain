package com.arun.designpattern.decoratorpattern;

/**
 * @author arun on 9/25/20
 */
public class HeadDecorator {
    public static void main(String[] args) {

        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " costs " + espresso.cost());

        //espresso + Mocha
        Beverage mochaEspresso = new Mocha(espresso);
        System.out.println(mochaEspresso.getDescription() + "costs " + mochaEspresso.cost());

        //espresso + milk
        Beverage milkEspresso = new Milk(espresso);
        System.out.println(milkEspresso.getDescription() + "costs " + milkEspresso.cost());

        //espresso + mocha + milk
        Beverage mochaMilkEspresso = new Mocha(milkEspresso);
        System.out.println(mochaMilkEspresso.getDescription() + "costs " + mochaMilkEspresso.cost());

        //houseBlend
        Beverage houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription() + " costs " + houseBlend.cost());

        //houseBlend + mocha
        Beverage mochaHouseBlend = new Mocha(houseBlend);
        System.out.println(mochaHouseBlend.getDescription() + " costs " + mochaHouseBlend.cost());

    }
}

abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract long cost();
}

class Espresso extends Beverage {
    @Override
    public String getDescription() {
        return description = "Espresso";
    }

    @Override
    public long cost() {
        return 10;
    }
}

class HouseBlend extends Beverage {
    @Override
    public String getDescription() {
        return description = "House Blend";
    }

    @Override
    public long cost() {
        return 20;
    }
}


abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;

    public abstract long cost();
}


class Mocha extends BeverageDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " mocha ";
    }

    @Override
    public long cost() {
        return beverage.cost() + 5;
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " milk ";
    }

    @Override
    public long cost() {
        return beverage.cost() + 6;
    }
}