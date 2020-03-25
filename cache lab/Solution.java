import java.util.*;
import java.io.*;

class Cache{
	int missCount = 0;
	ArrayList<Integer> lis = new ArrayList<>();
	int size;
	Cache(int s){
		this.size = s;
	}

	void add(int element){
		if(lis.contains(element)){
			lis.remove(lis.indexOf(element));
			lis.add(element);
		}else if(lis.size() == this.size && !lis.contains(element)){
			lis.remove(0);
			lis.add(element);
			this.missCount++;
		}else{	
			lis.add(element);
			this.missCount++;
		}
	}

	int getMissCount(){
		return missCount;
	}

}


class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cacheSizes = Integer.parseInt(br.readLine());

		Cache[] cacheArr = new Cache[cacheSizes];
		String[] st = br.readLine().split(" ");
		
		for(int i = 0; i < cacheSizes; i++){
			cacheArr[i] = new Cache(Integer.parseInt(st[i]));
		}

		String line;
		while((line=br.readLine())!=null){
			String[] token = line.split(" ");
			if(token[0].equals("END")){
				break;
			}

			else if(token[0].equals("RANGE")){
				int b = Integer.parseInt(token[1]);
				int y = Integer.parseInt(token[2]);
				int n = Integer.parseInt(token[3]);
				for(int c = 0; c < cacheSizes; c++){
					for(int k = 0; k < n; k++){
						cacheArr[c].add(b +(y*k));
						// System.out.println(cacheArr[c].lis);
					}
				}
			}

			else if(token[0].equals("ADDR")){
				int address = Integer.parseInt(token[1]);
				for(int c = 0; c < cacheSizes; c++){
					cacheArr[c].add(address);
					// System.out.println(cacheArr[c].lis);
				}
			}else{
				for(int i = 0; i < cacheSizes; i++){
					System.out.print(cacheArr[i].missCount + " ");
					cacheArr[i].missCount = 0;
				}
			}
		}
	}
}