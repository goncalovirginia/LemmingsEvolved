import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		TurboScanner in = new TurboScanner(System.in);
		int numTrials = in.nextInt();
		
		for (int t = 0; t < numTrials; t++) {
			int numLemmings1 = in.nextInt();
			char[] tribes1 = new char[numLemmings1+1];
			long[] points1 = new long[numLemmings1+1];
			
			readSequence(in, numLemmings1, tribes1, points1);
			
			int numLemmings2 = in.nextInt();
			char[] tribes2 = new char[numLemmings2+1];
			long[] points2 = new long[numLemmings2+1];
			
			readSequence(in, numLemmings2, tribes2, points2);
			
			long[] solution = solve(tribes1, points1, tribes2, points2);
			System.out.printf("%d %d\n", solution[0], solution[1]);
		}
		
		in.close();
	}
	
	private static void readSequence(TurboScanner in, int numLemmings, char[] tribes, long[] points) throws IOException {
		for (int l = 1; l <= numLemmings; l++) {
			tribes[l] = in.nextChar(); in.nextChar();
			points[l] = in.nextInt();
		}
	}
	
	private static long[] solve(char[] tribes1, long[] points1, char[] tribes2, long[] points2) {
		long[][] maxPoints = new long[points1.length][points2.length], minPairs = new long[points1.length][points2.length];
		
		for (int i = 1; i < points1.length; i++) {
			for (int j = 1; j < points2.length; j++) {
				maxPoints[i][j] = maxPoints[i-1][j-1];
				minPairs[i][j] = minPairs[i-1][j-1];
				
				if (tribes1[i] == tribes2[j]) {
					maxPoints[i][j] += points1[i] + points2[j];
					minPairs[i][j] += 1;
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
		
		return new long[] {maxPoints[points1.length-1][points2.length-1], minPairs[points1.length-1][points2.length-1]};
	}
	
}
