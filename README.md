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
    

![Quack Behavior](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/QB.png)
    
    
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
    
    
![Duck class](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/duck.png)


    public abstract class Duck {
        protected FlyBehavior flyBehaviour;
        protected QuackBehavior quackBehavior;
    
        public abstract void display();
    
        public void performFly() {
            flyBehaviour.fly();
        }
    
        public void performQuack() {
            quackBehavior.Quack();
        }
    
        public void swim() {
            System.out.println("All ducks swim");
        }
    }





![Duck class with Interfaces](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/full.png)
