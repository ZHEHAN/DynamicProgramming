
public class HouseRobber {
	public static int rob(int[] num) {
        int n=num.length;
        int[] d=new int[n];
        d[0]=num[0];
        d[1]=Math.max(num[0],num[1]);
        
        for(int i=2;i<n;i++){
            d[i]=Math.max(d[i-2]+num[i],d[i-1]);
        }
        return d[n-1];
    }
    
    public static void main(String[] args){
    	int[] nums={1,1,1,2};
    	int result=rob(nums);
    	System.out.println(result);
    }
}
