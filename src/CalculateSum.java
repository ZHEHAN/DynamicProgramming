public class CalculateSum {
	public static int maxPathSum(TreeNode root){
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
	
	public static int calculateSum(TreeNode root, int[] max){
		if(root==null) return 0;
		int left=calculateSum(root.left, max);
		int right=calculateSum(root.right, max);
		int current=Math.max(root.val, Math.max(root.val+left, root.val+right));
		max[0]=Math.max(max[0], Math.max(current, left+root.val+right));
		return current;
	}
	
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(3);
		root.left=left;
		root.right=right;
//		int result=maxPathSum(root);
//		System.out.println("result=" + result);
		int max=0;
		System.out.println("max1=" + max);
		max=1;
		System.out.println("max2=" + max);
	}
}
