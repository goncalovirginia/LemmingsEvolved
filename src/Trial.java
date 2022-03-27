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
		return maxPoints(points1.length - 1, points2.length - 1);
	}
	
	private long maxPoints(int i, int j) {
		if (i < 0 || j < 0) {
			return 0;
		}
		
		long sum = 0;
		
		if (tribes1[i] == tribes2[j]) {
			sum = points1[i] + points2[j];
		}

		return Math.max(sum + maxPoints(i-1, j-1), Math.max(maxPoints(i-1, j), maxPoints(i, j-1)));
	}
}
