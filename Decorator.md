# Decorator Pattern

![Decorator Pattern](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/decorator.png)

    package com.arun.designpattern.decoratorpattern;
    
    /**
     * @author arun on 9/24/20
     */
    public class DecoratorPatternDemo {
    
        public static void main(String[] args) {
    
            //meat sandwich
            Sandwich sandwich = new MeatDecorator(new SimpleSandwich());
            System.out.println(sandwich.make());
    
            //meat with dressing sandwich
            Sandwich dressingSandwich = new DressingDecorator(sandwich);
            System.out.println(dressingSandwich.make());
    
            //meat , tofu sandwich with dressing
            Sandwich tofuMeatSandwich = new TofuDecorator(dressingSandwich);
            System.out.println(tofuMeatSandwich.make());
    
            //only Sandwich tofu decorator with dressing
            Sandwich onlyTofuSandwich = new TofuDecorator(new DressingDecorator(new SimpleSandwich()));
            System.out.println(onlyTofuSandwich.make());
    
    
        }
    }
    
    
    //Component
    interface Sandwich {
        String make();
    }
    
    //concrete component
    class SimpleSandwich implements Sandwich {
    
        @Override
        public String make() {
            return "Bread";
        }
    }
    
    //decorator
    abstract class SandwichDecorator implements Sandwich {
        protected Sandwich customSandwich;
    
        public SandwichDecorator(Sandwich customSandwich) {
            this.customSandwich = customSandwich;
        }
    
        @Override
        public String make() {
            return customSandwich.make();
        }
    }
    
    
    //Concrete Decorator
    class MeatDecorator extends SandwichDecorator {
        public MeatDecorator(Sandwich customSandwich) {
            super(customSandwich);
        }
    
        @Override
        public String make() {
            return customSandwich.make() + addMeat();
        }
    
        private String addMeat() {
            return " + turkey";
        }
    }
    
    //another Decorator
    class DressingDecorator extends SandwichDecorator {
    
        public DressingDecorator(Sandwich customSandwich) {
            super(customSandwich);
        }
    
        @Override
        public String make() {
            return customSandwich.make() + addDressing();
        }
    
        private String addDressing() {
            return " + mustard";
        }
    }
    
    
    //Another decorator
    class TofuDecorator extends SandwichDecorator {
        public TofuDecorator(Sandwich customSandwich) {
            super(customSandwich);
        }
    
        @Override
        public String make() {
            return customSandwich.make() + addTofu();
        }
    
        private String addTofu() {
            return " + Tofu";
        }
    }
