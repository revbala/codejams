import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Roadies {

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(T>=1 && T<=5) {

	        for(int i=1; i<=T; i++) {
	        	int N= scanner.nextInt(); ///number of Players
	        	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        	
	        	String scoreSpaceSeparted = scanner.nextLine();
	        	if(scoreSpaceSeparted.contains(" 0 ")) continue;

	        	String[] scores = scoreSpaceSeparted.split(" ");
	        	int[] scoresInt = new int[N];
	        	boolean invalidscore = false;
	        	if(N>=1 && N<=100 && scores.length == N) {
	        		for(int j=0; j<N; j++) {
	        			scoresInt[j] = Integer.parseInt(scores[j]);
	        			if(scoresInt[j] <=0 && scoresInt[j]>=100000) {
	        				invalidscore = true;
	        				break;
	        			}
	        		}
	        		if(invalidscore) continue;
	        		System.out.println(maxSum(scoresInt, N));
	        	}
	        }
        
        }
        scanner.close();
  
	}
	
	public static int maxSum(int[] scores, int length){
		
		int[] subset = new int[length];
		Set<Integer> uniqueSet = new HashSet<Integer>();

		int subsetSize = 0;
		boolean unique = true;
		for(int i=0; i<length; i++) {
			//find largest element in the array
			if(scores[i] == -1) continue;
			subsetSize = 0;
			subset[subsetSize++] = scores[i];
			unique = true;
			for(int j=1; j<length; j++) {
				if(scores[j] == 0) continue;
				if(digitMatches(String.valueOf(scores[i]), String.valueOf(scores[j]))) {
					//build a subset of values
					subset[subsetSize++] = scores[j];
					unique = false;
				}
				
			}
			if(unique) {
				uniqueSet.add(scores[i]);
			}
			else {
				uniqueSet.add(findMaxfromSubset(subset, subsetSize));
			}
			
		}
		
		System.out.println(uniqueSet);
		return uniqueSet.stream().mapToInt(i-> i).sum();
	}
	
	public static boolean digitMatches(String a , String b) {
		for (int i=0; i<a.length(); i++) {
			for(int j =0; j<b.length(); j++) {
				if(a.charAt(i) == b.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static int findMaxfromSubset(int[] subset, int subsetSize){
		int max = 0;
		for(int i=0; i<subsetSize; i++) {
			if(max < subset[i]) {
				max = subset[i];
			}
		}
		return max;
	}

	
}



