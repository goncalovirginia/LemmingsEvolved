import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		TurboScanner in = new TurboScanner(System.in);
		int numTrials = in.nextInt();
		
		for (int t = 0; t < numTrials; t++) {
			int numLemmings1 = in.nextInt();
			char[] tribes1 = new char[numLemmings1];
			int[] points1 = new int[numLemmings1];
			
			for (int s = 0; s < numLemmings1; s++) {
				tribes1[s] = in.nextChar();
				in.nextChar();
				points1[s] = in.nextInt();
			}
			
			int numLemmings2 = in.nextInt();
			char[] tribes2 = new char[numLemmings2];
			int[] points2 = new int[numLemmings2];
			
			for (int s = 0; s < numLemmings2; s++) {
				tribes2[s] = in.nextChar();
				in.nextChar();
				points2[s] = in.nextInt();
			}
			
			System.out.println((new Trial(tribes1, points1, tribes2, points2)).maxPoints());
		}
		
	}
	
	private static long maxTrialPoints(char[] tribes1, int[] points1, char[] tribes2, int[] points2) {
		return 0;
	}
	
}
