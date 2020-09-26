# Decorator Pattern

![Decorator Pattern](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/decorator.png)


![class Diagram](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/DecoratorPattern.png)
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


# String decorator

Since String class is final we cannot inherit the methods, so we can delegate all the methods

of String class and add a new functionality to the new class, in this case it checks the

number of vowels in a string.

    package com.arun.designpattern.decoratorpattern;
    
    import java.io.UnsupportedEncodingException;
    import java.nio.charset.Charset;
    import java.util.Locale;
    import java.util.stream.IntStream;
    import java.util.stream.Stream;
    
    /**
     * @author arun on 9/25/20
     */
    
    public class StringDecorator {
    
        public static void main(String[] args) {
            MagicString magicString = new MagicString("hello");
            System.out.println("Number of vowels : " + magicString.countNoOfVowels());
        }
    
    
    }
    
    class MagicString {
        private final String string;
    
        public MagicString(String string) {
            this.string = string;
        }
    
        //create a method which will count the number of vowels in a string
    
        public long countNoOfVowels() {
            return string.chars().mapToObj(c -> (char) c).filter(c -> "aeiou".contains(c.toString())).count();
        }
    
        @Override
        public String toString() {
            return string;
        }
    
        //delegated methods
    
        public int length() {
            return string.length();
        }
    
        public boolean isEmpty() {
            return string.isEmpty();
        }
    
        public char charAt(int index) {
            return string.charAt(index);
        }
    
        public int codePointAt(int index) {
            return string.codePointAt(index);
        }
    }


# Beverage

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

# Shape Decorator

    package com.arun.designpattern.decoratorpattern;
    
    /**
     * @author arun on 9/25/20
     */
    
    
    public class ShapeDecorator {
    
        public static void main(String[] args) {
            Shape circle = new Circle(10);
            System.out.println(circle.info());
    
            //i want a circle of red color
            Shape coloredCircle = new ColoredCircle(circle, "red");
            System.out.println(coloredCircle.info());
        }
    }
    
    
    //component
    interface Shape {
        String info();
    }
    
    //concrete component
    class Circle implements Shape {
        private final int radius;
    
        public Circle(int radius) {
            this.radius = radius;
        }
    
        @Override
        public String info() {
            return "A circle of radius of " + radius;
        }
    }
    
    
    //decorator
    abstract class CircleDecorator implements Shape {
        //composition
        protected Shape shape;
    
        CircleDecorator(Shape shape) {
            this.shape = shape;
        }
    
        @Override
        public String info() {
            return shape.info();
        }
    }
    
    //decorator concrete implementation
    class ColoredCircle extends CircleDecorator {
        private final String color;
    
        public ColoredCircle(Shape shape, String color) {
            super(shape);
            this.color = color;
        }
    
        @Override
        public String info() {
            return shape.info() + " having color " + color;
        }
    }
