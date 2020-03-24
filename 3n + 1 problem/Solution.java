import java.util.*;

class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max,min,x,counter=0,countermax=0;
		while(scan.hasNext()){
			int i = scan.nextInt();
			int j = scan.nextInt();

			if(i>j){
				max=i;
				min=j;
				
			}
			else{
				max=j;
				min=i;
			}
			countermax=0;
			for(x=min;min<=max;min++)
			{
				x=min;
				
				for(counter=1;x != 1;counter++)
				{
					if(x%2 == 1){
						x= 3*x + 1;
						
					}
					else
						x=x/2;
				}
				if(counter>countermax)
					countermax=counter;
			
			}
			System.out.println(i+" "+j+" "+countermax);
		}
	}
}