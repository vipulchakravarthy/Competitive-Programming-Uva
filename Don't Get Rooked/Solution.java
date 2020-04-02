import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int n, res;
    static char[][] grid = new char[10][10];
    
    static boolean isValid(int x, int y){
        boolean flag = true;
        
        //same column forward
        for(int i = x+1; i < n; i++){
            if(grid[i][y] == 'X') break;
            
            flag &= (grid[i][y] != '0');
        }

        //same column backward
        for(int i = x-1; i >= 0; i--){
            if(grid[i][y] == 'X') break;
            flag &= (grid[i][y] != '0');
        }


        //same row forward
        for (int i = y+1; i < n; i++) {
            if (grid[x][i] == 'X') break;
            flag &= (grid[x][i] != '0');
        }

        //same row backward
        for (int i = y-1; i >= 0; i--) {
            if (grid[x][i] == 'X') break;
            flag &= (grid[x][i] != '0');
        }

        return flag;
        
    }   
    
    static void check(int num){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '.' && isValid(i,j)){
                	// if it is a open space and valid we can keep rook
                    grid[i][j] = '0';
                    
                    check(num+1);
                    //back track so consider it as . again
                    grid[i][j]='.';
                }
            }
        }
        res = Math.max(res, num);
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            n = Integer.parseInt(scan.nextLine());
            if(n==0) break;
            
            for(int i = 0; i < n; i++){
                char[] temp = scan.nextLine().toCharArray();
                for(int j = 0; j < n; j++){
                    grid[i][j] = temp[j];
                }
            }
            
            res = 0;
            check(0);
            System.out.println(res);
            
        }
    }
}