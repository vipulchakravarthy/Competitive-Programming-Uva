import java.io.*;
import java.util.*;

class Agency implements Comparable<Agency>{
	String name;
	int a;
	int b;
	int start;
	int target;
	int minCost = 0;
	Agency(String name, int A, int B, int start, int target){
		this.name = name;
		this.a = A;
		this.b = B;
		this.start = start;
		this.target = target;
		this.minCost = caculateAmount(this.start, this.target);
	}

	public int caculateAmount(int N, int M){
		if(N == M) return 0;

		int half = N /2;

		int ans = 0;

		if(half >= M) {
			ans = Math.min(this.a*(N-half), this.b) + caculateAmount(half, M);
		}else{
			ans = this.a + caculateAmount(N-1, M);
		}
		return ans;
	}

	public int compareTo(Agency that){
		if(this.minCost < that.minCost){
			return -1;
		}else if(this.minCost > that.minCost){
			return 1;
		}else{
			return this.name.compareTo(that.name);
		}
	} 


	public String toString(){
		return this.name+" "+this.minCost;
	}


} 

class Solution{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int tc = Integer.parseInt(scan.nextLine());
		int item = 1;
		while(tc-- > 0){
			String[] tokens = scan.nextLine().split(" ");
			int start = Integer.parseInt(tokens[0]); 
			int target = Integer.parseInt(tokens[1]);
			int noOfAgencies = Integer.parseInt(tokens[2]);
			Agency[] agencies = new Agency[noOfAgencies];
			for(int i = 0; i < noOfAgencies; i++){
				String[] params = scan.nextLine().split(":");
				String[] wages = params[1].split(",");
				agencies[i] = new Agency(params[0], Integer.parseInt(wages[0]), Integer.parseInt(wages[1]), start, target);
				// agecies[i].caculateAmount();
			}

			Arrays.sort(agencies);
			System.out.println("Case " + item++);
			for(int i = 0; i < noOfAgencies; i++){
				System.out.println(agencies[i]);
			}
		}
	}
}