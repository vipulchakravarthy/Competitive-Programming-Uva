import java.util.*;

class Solution{

	public static int[][] grid;
	public static int d;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		while(tc-- > 0){
			d = scan.nextInt();
			int rats = scan.nextInt();
			grid = new int[1025][1025];

			for(int i = 0; i < rats;i++){
				populateGrid(scan.nextInt(), scan.nextInt(), scan.nextInt());
			}

			int[] res = getResult();

			System.out.println(res[0] +" "+res[1] + " "+res[2]);
		}
	}

	public static boolean valid(int index){
		if(index >= 0 && index <= grid.length-1){
			return true;
		}
		return false;
	}

	public static void populateGrid(int x, int y, int pop){

		for(int i = x-d; i <= x+d; i++){
			if(valid(i)){
				for(int j = y-d; j <= y+d; j++){
					if(valid(j)){
						grid[i][j] += pop;
					}
				}
			}
		}
	}

	public static int[] getResult(){
		int x = -1;
		int y  = -1;
		int total = -1;

		for(int i = 0; i < grid.length; i++){
			for(int j= 0; j < grid.length; j++){
				if(grid[i][j] > total){
					x = i;
					y = j;
					total = grid[i][j];
				}
			}
		}

		int[] res = {x, y, total};
		return res;
	}
}