public class Trial {
	
	char[] tribes1, tribes2;
	int[] points1, points2;
	
	public Trial(char[] tribes1, int[] points1, char[] tribes2, int[] points2) {
		this.tribes1 = tribes1;
		this.points1 = points1;
		this.tribes2 = tribes2;
		this.points2 = points2;
	}
	
	public long maxPoints() {
		if (points1.length == 0 || points2.length == 0) {
			return 0;
		}
		
		long[][] table = new long[points1.length][points2.length];
		
		for (int i = 0; i < points1.length; i++) {
			if (tribes1[i] == tribes2[0]) {
				table[i][0] = points1[i] + points2[0];
			}
		}
		
		for (int j = 0; j < points2.length; j++) {
			if (tribes1[0] == tribes2[j]) {
				table[0][j] = points1[0] + points2[j];
			}
		}
		
		for (int i = 1; i < points1.length; i++) {
			for (int j = 1; j < points2.length; j++) {
				long sum = 0;
				
				if (tribes1[i] == tribes2[j]) {
					sum = points1[i] + points2[j];
				}
				
				table[i][j] = table[i-1][j-1] + sum;
				
				if (table[i-1][j] > table[i][j]) {
					table[i][j] = table[i-1][j];
				}
				if (table[i][j-1] > table[i][j]) {
					table[i][j] = table[i][j-1];
				}
			}
		}
		
		return table[points1.length - 1][points2.length - 1];
	}
	
	
}
