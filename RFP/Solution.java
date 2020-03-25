import java.util.*;
import java.io.*;


class Proposal implements Comparable<Proposal>{
	String name;
	int reqMet;
	int totalReq;
	double compliance;
	double price;
	int v;
	public Proposal(String n, int reqM, int totalR, double pri, int val){
		this.name = n;
		this.reqMet = reqM;
		this.totalReq = totalR;
		this.compliance = (this.reqMet)/(double)(this.totalReq);
		this.price = pri;
		this.v = val;

	}

	public int compareTo(Proposal that){
		if(this.compliance < that.compliance){
			return -1;
		}else if(this.compliance > that.compliance){
			return 1;
		}else{
			if(this.price < that.price){
				return 1;
			}else if(this.price > that.price){
				return -1;
			}else{
				if(this.v < that.v){
					return 1;
				}else if(this.v > that.v){
					return -1;
				}
			}
		}
		return 0;
	}


}



class Solution{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st;
		int tot = 1;
		while((st = br.readLine())!= null && !st.equals("0 0")){
			StringTokenizer tokens = new StringTokenizer(st);
			int requirements = Integer.parseInt(tokens.nextToken());
			int numOfProposals = Integer.parseInt(tokens.nextToken());
		
			Proposal[] props = new Proposal[numOfProposals];

			for(int i = 0; i < requirements; i++){
				br.readLine();
			} 

			for(int j = 0; j < numOfProposals; j++){
				String name = br.readLine();
				tokens = new StringTokenizer(br.readLine());
				double price = Double.parseDouble(tokens.nextToken());
				int met = Integer.parseInt(tokens.nextToken());
				props[j] = new Proposal(name, met, 
					requirements, price,j);

				for(int k = 0; k < met; k++){
					br.readLine();
				}

			}

			Arrays.sort(props);
			
			if(tot > 1){
				System.out.println();
			}
			System.out.println("RFP #" + tot);
			System.out.println(props[numOfProposals-1].name);
			tot++;
		}
	}

}