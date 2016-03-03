import java.util.ArrayList;
import java.util.Arrays;

public class SubsetTwo {
    static void dfs(int [] number_array, int start, int number, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result) {
        if(number==array.size()) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        for(int i=start;i<number_array.length;i++){
        	array.add(number_array[i]);
        	dfs(number_array,i+1,number,array,result);
        	array.remove(array.size()-1);
        	while(i<(number_array.length-1)&&number_array[i]==number_array[i+1]) {
                i++;
            }
        }
//        int i=start;
//        while(i<number_array.length) {
//            array.add(number_array[i]);
//            dfs(number_array,i+1,number,array,result);
//            array.remove(array.size()-1);
//            //跳过相同的元素
//            while(i<(number_array.length-1)&&number_array[i]==number_array[i+1]) {
//                i++;
//            }
//            i++;
//        }
    }
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
          ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
          ArrayList<Integer> array = new ArrayList<Integer>();
          result.add(array);
          if(S==null) {
              return result;
          }
          Arrays.sort(S);
          for(int i=1;i<=S.length;i++) {
              array.clear();
              dfs(S,0,i,array,result);
          }
          return result;
    }
    
    public static void main(String[] args){
    	int[] a=new int[]{1,2,2};
    	ArrayList<ArrayList<Integer>> result=subsets(a);
    	for(int i=0;i<result.size();i++){
    		for(int j=0;j<result.get(i).size();j++){
    			System.out.print(result.get(i).get(j));
    		}
    		System.out.println("----------------------");
    	} 
    }
}

/*
public class Solution {
    void dfs(int[] number_array, int start, int number, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result) {
        if(array.size()==number) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        int i = start;
        while(i<number_array.length) {
            array.add(number_array[i]);
            dfs(number_array,i+1,number,array,result);
            array.remove(array.size()-1);
            //跳过相同的元素
            while(i<(number_array.length-1)&&number_array[i]==number_array[i+1]) {
                i++;
            }
            i++;
        }
    }
    
    
    public  ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>       array = new ArrayList<Integer>();
        result.add(array);
        if(num==null) {
            return result;
        }
        Arrays.sort(num);
        for(int i=1;i<=num.length;i++) {
            array.clear();
            dfs(num,0,i,array,result);
        }
        return result;
    }
}
*/