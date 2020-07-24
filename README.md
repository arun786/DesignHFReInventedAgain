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
    
    
    public class MallardDuck extends Duck {
    
        public MallardDuck() {
            flyBehaviour = new FlyWithWings();
            quackBehavior = new Quack();
        }
    
        @Override
        public void display() {
            System.out.println("Its a Mallard Duck");
        }
    }
    
    
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


    public class DecoyDuck extends Duck {
    
        public DecoyDuck() {
            flyBehaviour = new FlyNoWay();
            quackBehavior = new MuteQuack();
        }
    
        @Override
        public void display() {
            System.out.println("Decoy Duck");
        }
    }

    public class RubberDuck extends Duck {
    
        public RubberDuck() {
            flyBehaviour = new FlyNoWay();
            quackBehavior = new MuteQuack();
        }
    
        @Override
        public void display() {
            System.out.println("Rubber Duck");
        }
    }


![Duck class with Interfaces](https://github.com/arun786/DesignHFReInventedAgain/blob/master/src/main/resources/image/full.png)


    public class DuckSimulator {
        public static void main(String[] args) {
            Duck mallardDuck = new MallardDuck();
            mallardDuck.display();
            mallardDuck.performFly();
            mallardDuck.performQuack();
    
            System.out.println("============");
            Duck redHeadDuck = new RedHeadDuck();
            redHeadDuck.display();
            redHeadDuck.performFly();
            redHeadDuck.performQuack();
    
            System.out.println("----------");
            Duck decoyDuck = new DecoyDuck();
            decoyDuck.display();
            decoyDuck.performFly();
            decoyDuck.performQuack();
    
            System.out.println("----------");
            Duck rubberDuck = new RubberDuck();
            rubberDuck.display();
            rubberDuck.performFly();
            rubberDuck.performQuack();
        }
    }
    
    o/p will be as below
    
    Its a Mallard Duck
    Fly with wings
    Duck Quacks
    ============
    Red head duck
    Fly with wings
    Duck Squeaks
    ----------
    Decoy Duck
    Can't fly
    Duck cant quack
    ----------
    Rubber Duck
    Can't fly
    Duck cant quack