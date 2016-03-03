import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        ArrayList<Integer> tem=new ArrayList<Integer>();
        if(candidates==null||candidates.length==0) return result;
        Arrays.sort(candidates);
        dfs(candidates,0,target,tem,result);
        return result;
    }
    
    public static void dfs(int[] candidates, int start, int target, ArrayList<Integer> tem, ArrayList<List<Integer>> result){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<Integer>(tem));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]) continue;
            tem.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],tem,result);
            tem.remove(tem.size()-1);
            
        }
    }
    
    public static void main(String[] args){
    	int[] can=new int[]{2,2,3,6,7};
    	List<List<Integer>> result= combinationSum(can,7);
    	for(int i=0;i<result.size();i++){
    		for(int j=0;j<result.get(i).size();j++){
    			System.out.print(result.get(i).get(j));
    		}
    		System.out.println("----------------------");
    	} 
    }
}