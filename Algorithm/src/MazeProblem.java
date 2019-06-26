import java.util.Scanner;

public class MazeProblem {

    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(T>=1 && T<=100) {

	        for(int i=1; i<=T; i++) {
	        	int length = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	            
	            
	            String path = scanner.nextLine();
	            
	            if(length<2) continue;
	            if(path.length() != 2*length - 2 )  	continue;
	            if(!path.matches("^[ES]+$")) continue;
	            
	        	if ( validDirectionCount(length, path))
	    		{
	        		
	        		System.out.println(" Case #" + i + ": " + findAlternatePath(path));
	    		}   		
	        	
	        }
        
        }
        scanner.close();
  
	}
	
	public static String findAlternatePath(String path) {
		StringBuilder builder = new StringBuilder();
		for(char direction: path.toCharArray()) {
			if (direction == 'S') builder.append('E');
			else if (direction == 'E') builder.append('S');
		}
		return builder.toString();
	}
	public static boolean validDirectionCount(int length, String path) {
		boolean valid = false;
		int countE=0;
		int countS=0;
		for(char c: path.toCharArray()) {
			if (c=='S') countS++;
			if (c=='E') countE++;
		}
		if(countS == length-1 && countE==length-1) {
			valid = true;
		}
	
		
		return valid;
			
	}
	
	
}



