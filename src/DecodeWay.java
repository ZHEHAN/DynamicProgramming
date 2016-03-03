public class DecodeWay {
    public static int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        if(s.charAt(0)=='0') return 0;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        int tmp;
        for(int i=2;i<=s.length();i++){
            tmp=Integer.parseInt(s.substring(i-1,i));
            System.out.println("tmp1======"+tmp);
            if(tmp!=0) dp[i]=dp[i-1];
            if(s.charAt(i-2)!='0'){
                tmp=Integer.parseInt(s.substring(i-2,i));
                System.out.println("tmp2======"+tmp);
                if(tmp>0&&tmp<27) dp[i]=dp[i]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
    
    public static void main(String[] args){
    	String s="1010";
    	int res=numDecodings(s);
    	System.out.println(res);
    }
}