import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class Solution{
	public static void main(String[] args) throws IOException{

		Scanner scan = new Scanner(System.in);
		int cases = 1;
		DecimalFormat f = new DecimalFormat("0.00000");
		while(scan.hasNextInt()){
			// String[] st = scan.nextLine().trim().split(" ");
			int c = scan.nextInt();
			int s = scan.nextInt();
			StringBuffer sb = new StringBuffer();
			int[] arr = new int[c*2];

			int sum = 0;

			double imbal = 0.0;

			for(int i = 0; i < s; i++){
				arr[i] = scan.nextInt();
				sum += arr[i];
			}

			int[] arr2 = arr.clone();
			double avg = sum*1.0/c;
			Arrays.sort(arr2);
			sb.append("Set #" + cases++ + "\n");

			for(int i = 0; i < c; i++){
				int x = arr2[i];
				int y = arr2[2*c-1-i];
				sb.append(" " + i + ":");

				if(x==0 || y == 0){
					if(x != 0) sb.append(" "+x);
					if(y != 0) sb.append(" " + y);

				}else{
					sb.append(" " + x + " "+y); 
				}

				imbal += Math.abs((x+y) -avg);
				sb.append("\n");
			}

			sb.append("IMBALANCE = "+ f.format(imbal) +"\n");
			System.out.println(sb);
		}
	}
}