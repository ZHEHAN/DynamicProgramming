import java.util.Stack;

public class MaxRecatngle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int[] height=new int[matrix[0].length];
        int result=0;
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0') height[j]=0;
                else height[j]=height[j]+1;
            }
            result=Math.max(largest(height),result);
        }
        return result;
    }
    
    public static int largest(int[] height){
        
        Stack<Integer> s=new Stack<Integer>();
        int res=0;
        
        for(int i=0;i<height.length;i++){
            while(!s.isEmpty()&&height[i]<=height[s.peek()]){
                int index=s.pop();
                int cur=s.isEmpty()?i*height[index]:(i-s.peek()-1)*height[index];
                res=Math.max(res,cur);
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int index=s.pop();
            int cur=s.isEmpty()?height.length*height[index]:(height.length-s.peek()-1)*height[index];
            res=Math.max(res,cur);
        }
        return res;
    }
    
    public static void main(String[] args){
    	char[][] c={{'1','1','1',}, {'0','0','0'}};
    	int result=maximalRectangle(c);
    	System.out.println(result);
    }
}