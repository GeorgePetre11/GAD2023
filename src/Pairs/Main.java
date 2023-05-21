package Pairs;

public class Main {


    public static void main (String[] args) {

        Running runningShoe1 = new Running("RED", 41);
        Running runningShoe2 = new Running("RED", 41);
        Pair<Running> pairOK = new Pair<>(runningShoe1, runningShoe2);
        if(runningShoe1.equals(runningShoe2)) {
            System.out.println("The shoes are the same.");
        } else {
            System.out.println("The shoes are different.");
        }
    }
}
