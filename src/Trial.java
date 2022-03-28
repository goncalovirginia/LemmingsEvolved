public class Trial {
	
	char[] tribes1, tribes2;
	int[] points1, points2;
	
	public Trial(char[] tribes1, int[] points1, char[] tribes2, int[] points2) {
		this.tribes1 = tribes1;
		this.points1 = points1;
		this.tribes2 = tribes2;
		this.points2 = points2;
	}
	
	public int[] solve() {
		int[][] maxPoints = new int[points1.length][points2.length];
		int[][] minPairs = new int[points1.length][points2.length];
		int i, j;
		
		for (i = 1; i < points1.length; i++) {
			for (j = 1; j < points2.length; j++) {
				if (tribes1[i] == tribes2[j]) {
					maxPoints[i][j] = maxPoints[i-1][j-1] + points1[i] + points2[j];
					minPairs[i][j] = 1;
					
					if (maxPoints[i-1][j-1] > 0) {
						minPairs[i][j] += minPairs[i-1][j-1];
					}
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
		
		return new int[] {maxPoints[i][j], minPairs[i][j]};
	}
	
}
