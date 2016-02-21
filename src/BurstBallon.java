
public class BurstBallon {
	public static int maxCoins(int[] nums) {
		
//		 int n=iNums.length;
//         int[] nums=new int[n+2];
//         for(int i=0;i<n;i++) nums[i+1]=iNums[i];
//         nums[0]=nums[n+1]=1;
//         int[][] dp=new int[n+2][n+2];
//         for(int k=1;k<=n;k++){
//             for(int i=1;i<=n-k+1;i++){
//                 int j=i+k-1;
//                 for(int x=i;x<=j;x++){
//                     dp[i][j]=Math.max(dp[i][j],dp[i][x-1]+nums[i-1]*nums[x]*nums[j+1]+dp[x+1][j]);
//                 }
//             }
//         }
//         return dp[1][n];
        int len=nums.length;
        int[] n=new int[len+2];
        for(int i=0;i<len;i++) n[i+1]=nums[i];
        n[0]=1;
        n[len+1]=1;
        int[][] dp=new int[len+2][len+2];
        
        for(int k=1;k<=len;k++){
            for(int i=1;i<=len-k+1;i++){
                int j=i+k-1;
                for(int x=i;x<=j;x++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][x-1]+n[i-1]*n[x]*n[j+1]+dp[x+1][j]);
                }
                
            }
        }
        return dp[1][len];
    }
	
	public static void main(String[] args){
		int[] nums={3,1,5,8};
		int res=maxCoins(nums);
		System.out.println(res);
	}
}
