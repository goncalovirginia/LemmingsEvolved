import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		TurboScanner in = new TurboScanner(System.in);
		int numTrials = in.nextInt();
		
		for (int t = 0; t < numTrials; t++) {
			int numLemmings1 = in.nextInt();
			char[] tribes1 = new char[numLemmings1+1];
			int[] points1 = new int[numLemmings1+1];
			
			readSequence(in, numLemmings1, tribes1, points1);
			
			int numLemmings2 = in.nextInt();
			char[] tribes2 = new char[numLemmings2+1];
			int[] points2 = new int[numLemmings2+1];
			
			readSequence(in, numLemmings2, tribes2, points2);
			
			int[] result = (new Trial(tribes1, points1, tribes2, points2)).solve();
			System.out.printf("%d %d\n", result[0], result[1]);
		}
	}
	
	private static void readSequence(TurboScanner in, int numLemmings, char[] tribes, int[] points) throws IOException {
		for (int l = 1; l <= numLemmings; l++) {
			tribes[l] = in.nextChar(); in.nextChar();
			points[l] = in.nextInt();
		}
	}
	
}
