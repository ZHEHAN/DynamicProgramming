public class UniquePathTwo {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if(obstacleGrid[0][0] ==1) return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] step = new int[n];
		step[0] = 1;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(obstacleGrid[i][j]==1)
					step[j] = 0;
				else if(j>0){
					step[j] = step[j-1]+step[j];
				}
			}
		}
		return step[n-1];
    }
    
    public static void main(String[] args){
    	int[][] nums={{0,0,0},{0,1,0},{0,0,0}};
    	int result=uniquePathsWithObstacles(nums);
    	System.out.println(result);
    }
}