import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public class Main {
    
    static class Student {
        String name;
        int[][] quizzes;  // 2D array for quiz data
        
        // Constructor — takes name and a row of quiz data
        public Student(String name, int[] quizScores) {
            this.name = name;
            this.quizzes = new int[][]{quizScores};  // Store as 2D array
        }
        
        // Calculate average from the 2D array
        public double getAverage() {
            int total = 0;
            // quizzes[0] = the first (only) row in our 2D array
            for (int score : quizzes[0]) {
                total += score;
            }
            return total / (double) quizzes[0].length;
        }
    }
    
    // LINEAR SEARCH
    public static int findRank(Student[] students, String searchName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(searchName)) {
                return i + 1;  // rank = position + 1
            }
        }
        return -1;  // not found
    }
    
    // BUBBLE SORT (own sort - no Arrays.sort())
    public static void sortByAverage(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Higher average goes first
                if (students[j].getAverage() < students[j + 1].getAverage()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Raw quiz data as 2D array
        int[][] rawQuizData = {
            {75, 78, 88, 85},   // Justine's scores
            {78, 72, 70, 75},   // Jasper's scores
            {70, 80, 77, 76},   // Kent's scores
            {80, 75, 76, 77},   // Alywn's scores
            {70, 70, 70, 70},   // Janus's scores (tie example)
        };
        
        String[] names = {"Justine", "Jasper", "Kent", "Alwyn", "Janus"};
        
        // Build array of Student objects from 2D data
        Student[] students = new Student[names.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i], rawQuizData[i]);
        }
        
        // Sort students
        sortByAverage(students);
        
        // Print leaderboard with tie handling
        System.out.println("=====================================");
        System.out.println("        CLASS LEADERBOARD           ");
        System.out.println("=====================================");
        System.out.printf("%-6s %-12s %-8s%n", "Rank", "Name", "Average");
        System.out.println("-------------------------------------");
        
        for (int i = 0; i < students.length; i++) {
            int rank = i + 1;
            double avg = students[i].getAverage();
            
            // Handle ties — same average = same rank
            if (i > 0 && avg == students[i-1].getAverage()) {
                rank = i;
            }
            
            System.out.printf("%-6d %-12s %-8.2f%n", rank, students[i].name, avg);
        }
        
        System.out.println("=====================================");
        
        // Search demo
        String searchName = "Janus";
        int position = findRank(students, searchName);
        if (position != -1) {
            System.out.println("\n" + searchName + " is ranked #" + position);
        } else {
            System.out.println("\n" + searchName + " not found.");
        }
    }
}
}
