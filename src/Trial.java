public class Trial {
	
	char[] tribes1, tribes2;
	int[] points1, points2;
	
	public Trial(char[] tribes1, int[] points1, char[] tribes2, int[] points2) {
		this.tribes1 = tribes1;
		this.points1 = points1;
		this.tribes2 = tribes2;
		this.points2 = points2;
	}
	
	public int[] maxPoints() {
		if (points1.length == 0 || points2.length == 0) {
			return new int[] {0, 0};
		}
		
		int[][] maxPoints = new int[points1.length][points2.length];
		int[][] minPairs = new int[points1.length][points2.length];
		
		for (int i = 0; i < points1.length; i++) {
			if (tribes1[i] == tribes2[0]) {
				maxPoints[i][0] = points1[i] + points2[0];
				minPairs[i][0] = 1;
			}
		}
		
		for (int j = 0; j < points2.length; j++) {
			if (tribes1[0] == tribes2[j]) {
				maxPoints[0][j] = points1[0] + points2[j];
				minPairs[0][j] = 1;
			}
		}
		
		for (int i = 1; i < points1.length; i++) {
			for (int j = 1; j < points2.length; j++) {
				int sum = 0;
				
				if (tribes1[i] == tribes2[j]) {
					sum = points1[i] + points2[j];
				}
				
				maxPoints[i][j] = maxPoints[i-1][j-1] + sum;
				
				if (sum == maxPoints[i][j]) {
					minPairs[i][j] = 1;
				}
				else {
					minPairs[i][j] = minPairs[i-1][j-1] + 1;
				}
				
				if (maxPoints[i-1][j] > maxPoints[i][j]) {
					maxPoints[i][j] = maxPoints[i-1][j];
					minPairs[i][j] = minPairs[i-1][j];
				}
				if (maxPoints[i][j-1] > maxPoints[i][j]) {
					maxPoints[i][j] = maxPoints[i][j-1];
					minPairs[i][j] = minPairs[i][j-1];
				}
			}
		}
		
		return new int[] {maxPoints[points1.length - 1][points2.length - 1], minPairs[points1.length - 1][points2.length - 1]};
	}
	
}
