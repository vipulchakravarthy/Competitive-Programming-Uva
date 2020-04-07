import java.io.*;
import java.util.*;
import java.util.regex.*;;

public class Solution {

    public static void main(String[] args) throws IOException  {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Pattern delimiters = Pattern.compile(System.getProperty("line.separator")+"|\\s");
        sc.useDelimiter(delimiters); 
        while (sc.hasNextInt()){
            int t = sc.nextInt();
            int r = sc.nextInt();
            int h = sc.nextInt();
            
            boolean[][] tr = new boolean[t][r];
            boolean[][] rh = new boolean[r][h];
            boolean[][] ht = new boolean[h][t];
            int[] costT = new int[t];
            int[] costR = new int[r];
            int[] costH = new int[h];
            
            //for storing travel and restaurant combo
            for(int i = 0; i < t; i++){
                costT[i] = sc.nextInt();
                for(int j = 0; j < r; j++){
                    if(sc.nextInt() == 0){
                        tr[i][j] = true;
                    }
                }
            }
            
            //for storing restaurant and hotel combo
            for(int i = 0; i < r; i++){
                costR[i] = sc.nextInt();
                for(int j = 0; j < h; j++){
                    if(sc.nextInt() == 0){
                        rh[i][j] = true;
                    }
                }
            }
            
             //for storing restaurant and hotel combo
            for(int i = 0; i < h; i++){
                costH[i] = sc.nextInt();
                for(int j = 0; j < t; j++){
                    if(sc.nextInt() == 0){
                        ht[i][j] = true;
                    }
                }
            }
            
            //3 nested for loops to get the minimum package
            int ans = Integer.MAX_VALUE;
            int anst = -1, ansr =-1, ansh = -1;
            for(int i = 0; i < t; i++){
                for(int j = 0; j < r; j++){
                    for(int k = 0; k < h; k++){
                        if(tr[i][j] && rh[j][k] && ht[k][i]){
                            int temp = costT[i] + costR[j] + costH[k];
                            if(temp < ans){
                                ans = temp;
                                anst = i;
                                ansr = j;
                                ansh = k;
                            }
                        }
                    }
                }
            }
            
            if(anst == -1){
                System.out.println("Don't get married!");
            }else{
                System.out.println(anst+" "+ansr +" "+ansh+":"+ans);
            }
        }
    }
}