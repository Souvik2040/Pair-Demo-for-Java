package pairdemo;

import java.util.Scanner;
import javafx.util.Pair;
import java.io.*;
import java.util.ArrayList;

/**
 * This program allows users to enter names and scores of
 * students into a .txt file; the program then allows the user to view 
 * all the names and scores that are currently in the file.
 * @author Souvik Saha
 */

public class PairDemo {
    
    // Private Static Variables
    private static final String filename = "Students.txt";
    private static ArrayList<Pair<String, Double>>  students =
                new ArrayList<Pair<String, Double>>();

    /* /////////////////// MAIN ////////////////////// */
    
    public static void main(String[] args) throws IOException {
        // Variables
        String name;
        double score;
        boolean running = true;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("This portal allows you to add the name and "
                    + "score of a student in a file.");
       
        // while loop lets user enter student's name and score
        while (running) {
            // getVal allows user to input student information
            Pair<String, Double> input = getVal();
            name = input.getKey();
            score = input.getValue();
            System.out.println(name + "\t" + score);
            
            // addStudent call adds the pair to the array list
            addStudent(input);
            
            // user decides to continue/quit
            System.out.println("Do you want to continue? (Y/N)");
            char temp = sc.nextLine().charAt(0);
            if (temp == 'n' || temp == 'N') running = false;
        }
        
        // writeFile call writes the array list to Students.txt
        writeFile();
        
        // user decides to view list
        System.out.println("Do you want to view the list of "
                    + "students in the file? (Y/N)");
        char reply = sc.nextLine().charAt(0);
        // readFile call reads names and scores from Students.txt
        if (reply == 'y' || reply == 'Y') readFile();
    }
    
    /* /////////////////// METHODS /////////////////// */
    
    /**
     * This method allows users to enter a student's name and score,
     * which is then added into a pair instance.
     * @return Returns Pair instance containing name and score.
     */
    
    public static Pair<String, Double> getVal() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter the name of a student.");
        String name = sc.nextLine();
        System.out.println("Please enter the score of the student.");
        double score = sc.nextDouble();
        
        Pair<String, Double> input = new Pair<>(name, score);
        return input;
    }
    
    /**
     * This method adds a Pair instance into the array list.
     * @param student Takes Pair instance with name and score.  
     */
    
    public static void addStudent(Pair<String, Double> student) {
        students.add(student);
    }
    
    /**
     * This method extracts a Pair instance from the array list
     * using an index and returns the Pair instance.
     * @param index Takes integer index.
     * @return Returns Pair instance from array list corresponding to index.
     */
    
    public static Pair<String, Double> getStudent(int index){
        return students.get(index);
    }
    
    /**
     * This method opens the Students.txt file and writes the 
     * student information contained in the array list.
     * @throws IOException 
     */
    
    public static void writeFile() throws IOException{
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter pw = new PrintWriter(fw);
        
        int length = students.size();
        
        // for loop to go through every Pair instance
        for (int i = 0; i < length; i++) {
            Pair<String, Double> temp = getStudent(i);
            String name = temp.getKey();
            double score = temp.getValue();
            // writes student's name and score in a new line
            pw.println(name + "\t" + score);
        }
        
        pw.close();
    }
    
    /**
     * This method opens the Students.txt file and reads the student 
     * information and displays it in a list. 
     * @throws IOException 
     */
    
    public static void readFile() throws IOException {
        String line;
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        
        System.out.println("\nThis is a list of all the "
                    + "students in the file and their scores.\n");
        line = br.readLine();
        
        // while loop to read every line and print it
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        
        br.close();
    }
}