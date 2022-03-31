import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numTrials = Integer.parseInt(in.readLine());
		
		for (int t = 0; t < numTrials; t++) {
			int numLemmings1 = Integer.parseInt(in.readLine());
			char[] tribes1 = new char[numLemmings1+1];
			long[] points1 = new long[numLemmings1+1];
			
			readSequence(in, numLemmings1, tribes1, points1);
			
			int numLemmings2 = Integer.parseInt(in.readLine());
			char[] tribes2 = new char[numLemmings2+1];
			long[] points2 = new long[numLemmings2+1];
			
			readSequence(in, numLemmings2, tribes2, points2);
			
			long[] solution = solve(tribes1, points1, tribes2, points2);
			System.out.printf("%d %d\n", solution[0], solution[1]);
		}
		
		in.close();
	}
	
	private static void readSequence(BufferedReader in, int numLemmings, char[] tribes, long[] points) throws IOException {
		for (int l = 1; l <= numLemmings; l++) {
			String[] lemming = in.readLine().split(" ");
			tribes[l] = lemming[0].charAt(0);
			points[l] = Long.parseLong(lemming[1]);
		}
	}
	
	private static long[] solve(char[] tribes1, long[] points1, char[] tribes2, long[] points2) {
		long[][] maxPoints = new long[points1.length][points2.length], minPairs = new long[points1.length][points2.length];
		long currMaxPoints, currMinPairs;
		
		for (int i = 1; i < points1.length; i++) {
			for (int j = 1; j < points2.length; j++) {
				currMaxPoints = maxPoints[i-1][j-1];
				currMinPairs = minPairs[i-1][j-1];
				
				if (tribes1[i] == tribes2[j]) {
					currMaxPoints += points1[i] + points2[j];
					currMinPairs += 1;
				}
				
				if (maxPoints[i-1][j] > currMaxPoints) {
					currMaxPoints = maxPoints[i-1][j];
					currMinPairs = minPairs[i-1][j];
				}
				else if (maxPoints[i-1][j] == currMaxPoints && minPairs[i-1][j] < currMinPairs) {
					currMinPairs = minPairs[i-1][j];
				}
				
				if (maxPoints[i][j-1] > currMaxPoints) {
					currMaxPoints = maxPoints[i][j-1];
					currMinPairs = minPairs[i][j-1];
				}
				else if (maxPoints[i][j-1] == currMaxPoints && minPairs[i][j-1] < currMinPairs) {
					currMinPairs = minPairs[i][j - 1];
				}
				
				maxPoints[i][j] = currMaxPoints;
				minPairs[i][j] = currMinPairs;
			}
		}
		
		return new long[] {maxPoints[points1.length-1][points2.length-1], minPairs[points1.length-1][points2.length-1]};
	}
	
}
