import java.util.*;
import java.io.*;
 
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
        	boolean flag = true;
            String[] arr = new String[Integer.parseInt(in.readLine().trim())];
            for (int i = 0; i < arr.length; i++)
                arr[i] = in.readLine().trim();
            Arrays.sort(arr);
            HashMap<String, Integer> map = new HashMap<>();
			   for(int i = 0; i< arr.length; i++){
			   String inp = arr[i];
				if(flag){
					String temp = inp.charAt(0) +"";
					int j = 1;
					while(j < inp.length()){
						if(map.get(temp) != null){
							flag = false;
							break;
						}
						temp += inp.charAt(j);
						j++;
					}
					if(flag){
						map.put(inp,1);
					}
				}
			}
			if(flag){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}

        }
    }
}