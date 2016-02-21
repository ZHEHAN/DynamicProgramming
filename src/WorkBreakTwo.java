import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkBreakTwo {
    public static List<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> dp[]=new ArrayList[s.length()+1];
        dp[0]=new ArrayList<String>();
        ArrayList<String> result=new ArrayList<String>();
        ArrayList<String> tem=new ArrayList<String>();
        for(int i=0;i<s.length();i++){
            if(dp[i]==null) continue;
            
            for(String word:dict){
                int len=word.length();
                int end=i+len;
                if(end>s.length()) continue;
                if(s.substring(i,end).equals(word)){
                    if(dp[end]==null) dp[end]=new ArrayList<String>();
                    dp[end].add(word);
                }
            }
        }
        if(dp[s.length()]==null) return result;
        dfs(result, tem, s.length(), dp);
        return result;
}
 public static void dfs(ArrayList<String> result, ArrayList<String> tem, int end, ArrayList<String> dp[]){
     if(end<=0){
         String path=tem.get(tem.size()-1);
         for(int i=tem.size()-2;i>=0;i--){
             path+=" "+tem.get(i);
         }
         result.add(path);
         return;
     }
     
     for(String str:dp[end]){
         tem.add(str);
         dfs(result, tem, end-str.length(), dp);
         tem.remove(tem.size()-1);
     }
 }
 
 public static void main(String[] args){
	 String s="catsanddog";
	 Set<String> h = new HashSet<String>();
	 h.add("cats");
	 h.add("and");
	 h.add("dog");
	 
	 List<String> res=wordBreak(s,h);
	 for(int i=0;i<res.size();i++){
		 System.out.println(res.get(i));
	 }
 }
}