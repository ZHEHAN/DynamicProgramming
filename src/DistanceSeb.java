public class DistanceSeb {
    public static int numDistinct(String S, String T) {
        if(S==null||T==null) {
            return 0;
        }
        if(S.length()<T.length()) {
            return 0;
        }
   	//���ƹ�ʽ�õ�
        int [][] dp = new int[S.length()+1][T.length()+1];
        dp[0][0] = 1;
        //����һ���ַ����任��һ���մ���ֻ��һ�ֱ任����
        for(int i=0;i<S.length();i++) {
            dp[i][0] = 1;    
        }
        //���ƹ�ʽ
        for(int i=1;i<=S.length();i++) {
            for(int j=1;j<=T.length();j++) {
                //���S��T�ĵ�ǰ�ַ���ȣ���ô������ѡ��������S�ĵ�ǰ�ַ�����Ҫ
                dp[i][j] = dp[i-1][j];
                if(S.charAt(i-1)==T.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
    
    public static void main(String[] args){
    	String s1="rrrrr";
    	String s2="rrrr";
    	int result=numDistinct(s1,s2);
    	System.out.println(result);
    }
}