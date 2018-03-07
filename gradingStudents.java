import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] solve(int[] grades){
        int[] r = new int[grades.length];
        for(int i = 0; i < grades.length; i++) {
          int g = grades[i];
          if(g < 38) { r[i] = g; }
          else if(g % 10 > 7) { r[i] = g - (g % 10) + 10; } 
          else if(g % 10 > 2 && g % 10 < 5) { r[i] = g - (g % 5) + 5; }
          else { r[i] = g; }
        }
      return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        

    }
}
