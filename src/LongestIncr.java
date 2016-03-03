public class LongestIncr {
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums.length == 0){
            return 0;
        }
        // len��ʾ��ǰ����������г��ȣ�Ϊ�˷������tails���Ǽ�1��
        int len = 0;
        // tails[i]��ʾ����Ϊi������������ĩβ������
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        // ��������������²�ͬ�������еļ���
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < tails[0]){
                tails[0] = nums[i];
            } else if (nums[i] >= tails[len]){
                tails[++len] = nums[i];
            } else {
            // ������м䣬���������
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }
    
    private static int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }
    
    public static void main(String[] args){
    	int[] nums={8,9,1,2,3};
    	int result=longestIncreasingSubsequence(nums);
    	System.out.println(result);
    }
}