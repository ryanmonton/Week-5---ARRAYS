import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
class Codechef
{
    public class SearchSortMiniTool {
    public static void main(String[] args) {
        
        // Student scores array 
        int[] scores = {85, 93, 78, 91, 88, 98, 95, 87};
        int target = 98; // hinahanap
        
        System.out.println("=== Linear Search ===");
        boolean found = false;
        int foundIndex = -1;
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                found = true;
                foundIndex = i;
                break;
            }
        }
        
        if (found) {
            System.out.println("Value " + target + " found at index: " + foundIndex);
        } else {
            System.out.println("Value " + target + " was NOT found in the array.");
        }
        
        System.out.println("\n=== Original Array ===");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        
        // Make a copy first
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores); // Sort the COPY
        
        System.out.println("\n=== Sorted Array ===");
        for (int score : sortedScores) {
            System.out.print(score + " ");
        }
        
        /* 
         WHY SORT A COPY?
         Because Arrays.sort() modifies the array directly. If we sort the original, we lose the original order of our data forever. Making a copy keeps the original intact for other uses while still letting us see sorted results.
         */
    }
}
/*
Programmer's Name: Ryan A. Monton
Course & Year: DIT 2-7
*/
}
