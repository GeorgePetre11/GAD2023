package Factory_Method_Design_Pattern1;

import java.util.Scanner;

abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int attackPower;

    public GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public abstract void attack();

    public abstract void defend();

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}

class Knight extends GameCharacter {
    public Knight(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(name + " slashes with a sword!");
    }

    @Override
    public void defend() {
        System.out.println(name + " raises a shield to block the attack!");
    }
}

class Mage extends GameCharacter {
    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a fireball!");
    }

    @Override
    public void defend() {
        System.out.println(name + " conjures a protective barrier!");
    }
}

abstract class GameCharacterFactory {
    public abstract GameCharacter createCharacter();
}

class KnightFactory extends GameCharacterFactory {
    @Override
    public GameCharacter createCharacter() {
        return new Knight("Sir Lancelot", 100, 20);
    }
}

class MageFactory extends GameCharacterFactory {
    @Override
    public GameCharacter createCharacter() {
        return new Mage("Gandalf", 80, 30);
    }
}

class Game {
    private GameCharacterFactory characterFactory;
    private GameCharacter playerCharacter;

    public void selectCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your character:");
        System.out.println("1. Knight");
        System.out.println("2. Mage");

        int choice = scanner.nextInt();
        if (choice == 1) {
            characterFactory = new KnightFactory();
        } else if (choice == 2) {
            characterFactory = new MageFactory();
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        playerCharacter = characterFactory.createCharacter();
        System.out.println("You have selected " + playerCharacter.getName());
    }

    public void playGame() {
        if (playerCharacter == null) {
            System.out.println("Please select a character first!");
            return;
        }

        System.out.println("Game started!");
        playerCharacter.attack();
        playerCharacter.defend();
        System.out.println("Game over!");
    }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        Game game = new Game();
        game.selectCharacter();
        game.playGame();
    }
}
