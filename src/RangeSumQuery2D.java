
public class RangeSumQuery2D {
    int[][] sumMatrix;
    int row;
    int col;

    boolean noVal = false;
    public RangeSumQuery2D(int[][] matrix) {
        this.row = matrix.length;
        if(row == 0){
            noVal = true;
            return;
        }
        this.col = matrix[0].length;
        if(col == 0){
            noVal = true;
            return;
        }
        sumMatrix = new int[row+1][col+1];

        for(int i = 0;i<row+1;i++)
            sumMatrix[i][0] = 0;
        for(int i = 0;i<col+1;i++)
            sumMatrix[0][i] = 0;

        //init other
        for(int i = 1;i<row+1;i++){
            for(int j = 1;j<col+1;j++){
                sumMatrix[i][j] = sumMatrix[i-1][j]+sumMatrix[i][j-1]-sumMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(noVal)
            return 0;

        return sumMatrix[row2+1][col2+1] - sumMatrix[row2+1][col1] - sumMatrix[row1][col2+1] + sumMatrix[row1][col1];
    }
    
    public static void main(String args[]){
    	int[][] matrix=new int[][]{
    		{1,2,3,4,5},
    		{1,2,3,4,5},
    		{1,2,3,4,5}
    	};
    	
    	
    }
}
