
public class UniqueBinarySearchTree {
	public static int nthUglyNumber(int n) {
//        int[] f=new int[n];
//        if(n==1) return 1;
//        int index2=1;
//        int index3=1;
//        int index5=1;
//        for(int i=1;i<n;i++){
//            int min=Math.min(Math.min(2*index2,3*index3),5*index5);
//            if(2*index2==min){
//                //Two=Two*index2++;
//                f[i]=2*index2++;
//            }
//            if(3*index3==min){
//                //Three=Three*index3++;
//                f[i]=3*index3++;;
//            }
//            if(5*index5==min){
//                //Five=Five*index5++;
//                f[i]=5*index5++;
//            }
//        }
//        return f[n-1];
		
		int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
//      System.out.println("uglyNumbers[0]:1");
         
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
 
        int counter = 1;
        while (counter < n) {
             
            int min = Math.min(Math.min(
                uglyNumbers[idx2] * 2, 
                uglyNumbers[idx3] * 3), 
                uglyNumbers[idx5] * 5);
             
            if (min == uglyNumbers[idx2] * 2) {
//              System.out.println("min==ugly[idx2]*2:" + uglyNumbers[idx2] * 2);
//              System.out.println("idx2:" + idx2 + "¡ú" + (idx2 + 1));
                idx2++;
            }
 
            if (min == uglyNumbers[idx3] * 3) {
//              System.out.println("min==ugly[idx3]*3:" + uglyNumbers[idx3] * 3);
//              System.out.println("idx3:" + idx3 + "¡ú" + (idx3 + 1));
                idx3++;
            }
 
            if (min == uglyNumbers[idx5] * 5) {
//              System.out.println("min==ugly[idx5]*5:" + uglyNumbers[idx5] * 5);
//              System.out.println("idx5:" + idx5 + "¡ú" + (idx5 + 1));
                idx5++;
            }
             
            uglyNumbers[counter] = min;
//          System.out.println("uglyNumbers[" + counter + "]:" + min);
            counter++;
        }
 
//      System.out.println("-----------");
//      System.out.println("return:" + uglyNumbers[n - 1]);
         
        return uglyNumbers[n - 1];
    }
	
	public static void main(String[] args){
		int n=11;
		int result=nthUglyNumber(n);
		System.out.println(result);
	}
}
