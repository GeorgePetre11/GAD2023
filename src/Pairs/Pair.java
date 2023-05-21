package Pairs;

public class Pair <T extends Shoe> {
    private T first;
    private T second;

    public Pair(T firstElement, T secondElement) {
        first = firstElement;
        second = secondElement;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
 interface Shoe {}
class Running implements Shoe {
    private String color;
    private int size;

    public Running(String color, int size){
        this.color = color;
        this.size = size;
}
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Running)) {
            return false;
        }
        Running otherRunning = (Running) other;
        return this.color.equals(otherRunning.color) && this.size == otherRunning.size;
    }
}
class Heels implements Shoe {}
class Boots implements Shoe {}


