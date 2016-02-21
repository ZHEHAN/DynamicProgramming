
public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
        int sum=0;
        int start=0;
        int result=Integer.MAX_VALUE;
        int length=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            while(sum>=s&&start<nums.length){
                length=i-start+1;
                sum=sum-nums[start++];
                result=Math.min(length,result);
            }
//            result=Math.min(length,result);
        }
        return result==Integer.MAX_VALUE ? 0 : result; 
    }
	
	public static void main(String[] args){
		int[] s={1,4,4};
		int a=4;
		int result=minSubArrayLen(a,s);
		System.out.println(result);
	}
}
