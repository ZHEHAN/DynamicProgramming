import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        if(num.length==0||num==null)
            return res;
        boolean[] visited = new boolean[num.length];  
        Arrays.sort(num);
        permutation_helper(num,res,item,visited);
        return res;
    }
    
    public static void permutation_helper(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item,boolean[] visited){
        if(item.size()==num.length){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = 0; i<num.length;i++){
            if(visited[i]==true||(i!=0&&num[i]==num[i-1]&&visited[i-1]==false)){
            	continue;
            }
            	item.add(num[i]);
                visited[i]=true;
                permutation_helper(num,res,item,visited);
                item.remove(item.size()-1);
                visited[i]=false;
        }
    }
    
    public static void main(String arg[]){
    	int[] a=new int[]{1, 1, 2};
    	ArrayList<ArrayList<Integer>> result= permute(a);
    	for(int i=0;i<result.size();i++){
    		for(int j=0;j<result.get(i).size();j++){
    			System.out.print(result.get(i).get(j));
    		}
    		System.out.println("----------------------");
    	} 
    }
}