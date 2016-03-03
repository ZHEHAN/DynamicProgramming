import java.util.ArrayList;
import java.util.Arrays;

public class RestoreIPAddress {
	
	public static void main(String[] args) {
		RestoreIPAddress s = new RestoreIPAddress();
		ArrayList<String> r = s.restoreIpAddresses("172162541");
		for (String ss : r) {
			System.out.println(ss);
		}
	}
	
	private ArrayList<String>[][] result = new ArrayList[12][4];
	private boolean[][] flag = new boolean[12][4];
	private String s;
	public ArrayList<String> restoreIpAddresses(String s) {
		this.s = s;
        for (int i = 0; i < result.length; i++) {
        	for (int j = 0; j < 4; j++) {
        		if (result[i][j] != null) {
        			result[i][j].clear();
        		}
        	}
        	
        	Arrays.fill(flag[i], false);
        }
        
        if (s.length() < 4) {
        	return new ArrayList<String>();
        }
        
        return recursion(0, 4);
        
    }
	
	private ArrayList<String> recursion(int start, int count) {
		ArrayList<String> current = this.result[start][count - 1];
		if (current == null) {
			current = new ArrayList<String>();
			this.result[start][count - 1] = current;
		}
		
		if (this.flag[start][count - 1]) {
			return this.result[start][count - 1];
		}
		
		if (count == 1) {
			if (start < this.s.length() - 3) {
				this.flag[start][count-1] = true;
				return null;
			} else {
				String ss = this.s.substring(start);
				if (ss.charAt(0) != '0' || ss.length() == 1) {
					int v = Integer.valueOf(ss);
					if (v <= 255) {
						current.add(ss);
					}
				}
				
				this.flag[start][count-1] = true;
				return current;
			}
		}
		
		if (count > 1) { //¼ôÖ¦
			int len = this.s.length() - start - 1;
			int minCount = len / 3;
			if (minCount > count) {
				this.flag[start][count-1] = true;
				return current;
			}
		}
		
		if (current == null) {
			current = new ArrayList<String>();
			this.result[start][count - 1] = current;
		}
		for (int i = 0; i < 3; i++) {
			String prefix = this.s.substring(start, Math.min(start + i + 1, this.s.length()));
			int v = Integer.parseInt(prefix);
			
			if (i > 0 && prefix.charAt(0) == '0') {
				continue;
			}
			
			if (v <= 255 && start + i + 1 < this.s.length()) {
				ArrayList<String> list = recursion(start + i + 1, count - 1);
				if (list != null && !list.isEmpty()) {
					for (String s : list) {
						current.add(prefix + '.' + s);
					}
				}
			}
		}
		
		this.flag[start][count - 1] = true;
		return current;
	}
}
