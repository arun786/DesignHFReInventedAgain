# DesignHFReInventedAgain

## Design Principle
    Identify the aspects of your application that vary and separate them from what stays the same.
    Program to an interface, not an Implementation.
    
    
![Fly Behavior](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/FlyWithBehavior.png)
        
    public interface FlyBehavior {
        void fly();
    }
    
    
    public class FlyNoWay implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Can't fly");
        }
    }

    public class FlyWithWings implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Fly with wings");
        }
    }
    
    
    
    
    
    public interface QuackBehavior {
        void Quack();
    }
    
    
    public class Quack implements QuackBehavior{
        @Override
        public void Quack() {
            System.out.println("Duck Quacks");
        }
    }
    
    
    public class Squeak implements QuackBehavior {
        @Override
        public void Quack() {
            System.out.println("Duck Squeaks");
        }
    }
    
    public class MuteQuack implements QuackBehavior {
        @Override
        public void Quack() {
            System.out.println("Duck cant quack");
        }
    }