public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int sum=0;
        int left=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=s){
                min=Math.min(min,i-left+1);
                sum-=nums[left++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    
    public static void main(String[] args){
    	int[] a={6,5,4};
    	int s=2;
    	int result=minSubArrayLen(s,a);
    	System.out.println(result);
    }
}