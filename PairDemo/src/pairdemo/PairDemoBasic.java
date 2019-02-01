package pairdemo;

import javafx.util.Pair;

public class PairDemoBasic { 

    /* /////////////////// MAIN ////////////////////// */ 

    public static void main(String[] args) {
        // Pair pair1 = new Pair("John", 43.5);
        Pair<String, Double> pair1 = new Pair<>("John", 43.5);
        
        Pair<Integer, Character> pair2 = new Pair<>(45, 'H');
        
        String name = pair1.getKey();
        double score = pair1.getValue();
        
        int num = pair2.getKey(); 
        char letter = pair2.getValue();
        
        System.out.println(name + " + " + score);
        System.out.println(num + " + " + letter);
    }

    /* /////////////////// METHODS /////////////////// */

}