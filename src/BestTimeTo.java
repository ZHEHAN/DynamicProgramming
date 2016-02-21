public class BestTimeTo {
    public static int maxProfit(int[] prices) {
        int max=0;
        int min=prices[0];
        
        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
    
    public static void main(String[] args){
    	int[] a={1};
    	int result=maxProfit(a);
    	System.out.println(result);
    }
}