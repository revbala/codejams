import java.util.Scanner;

public class SolutionUsingLoop {

    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(T>=1 && T<=100) {

	        for(int i=1; i<=T; i++) {
	        	int length = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            String path = scanner.nextLine();
	            
	        	if (length>1 && path.length() == 2*length-2)
	    		{
	        		String result = solveMaze(length, path);
	        		System.out.println(" Case #" + i + ": " + result);
	    		}   		
	        	
	        }
        
        }
        scanner.close();
  
	}
	
	public static String solveMaze(int length, String lydiasPath) {
		
		int[][] maze = fillMatrix(length, lydiasPath);
		StringBuilder builder = new StringBuilder();
		
		int i=0, j=0;
		
		while(true) {	
			if (i==maze.length-1 && j==maze.length-1) {
				break;
			}
			
			if(j==length-1) {
				
				
				//reached last column
				//incase of conflicting path
				if((maze[i][j] == 1 && maze[i+1][j] == 1) || maze[i][j]==-1) {
					char direction = builder.charAt(builder.length()-1);
					builder.deleteCharAt(builder.length()-1);
					if(direction == 'S') i--;				
					if(direction == 'E') j--;
					maze[i][j]=-1;
					continue;
				}
				
				//proceed downwards
				builder.append('S');
				//advance counters
				i++;
			}
			else if(i==length-1) {
				//reached last row
				//incase of conflicting path
				if((maze[i][j] == 1 && maze[i][j+1] == 1) || maze[i][j]==-1) {
					char direction = builder.charAt(builder.length()-1);
					builder.deleteCharAt(builder.length()-1);
					if(direction == 'S') i--;				
					if(direction == 'E') j--;
					maze[i][j]=-1;
					continue;
				}
				//reached last column proceed east
				builder.append('E');
				//advance counters
				j++;
			}			
			else if(!(maze[i][j] == 1 && maze[i][j+1] == 1) && !(maze[i][j] == -1 && maze[i][j+1] == -1)) {
				builder.append('E');
				//advance counters
				j++;
			}
			else if(!(maze[i][j] ==1 && maze[i+1][j] == 1) && !(maze[i][j] == -1 && maze[i+1][j] == -1)) {
				builder.append('S');
				//advance counters
				i++;
			}
			
		}
		
		return builder.toString();
	}

	
	public static int[][] fillMatrix(int length, String path){
		int[][] maze= new int[length][length];
		for(int i=0;i<length;i++) {
			for(int j=0; j<length; j++) {
				maze[i][j] = 0;
			}
		}
		
		int i=0, j=0;
		maze[0][0] = 1;
		for(char direction : path.toCharArray()) {
			if(direction == 'E')
				j++;
			if(direction == 'S')
				i++;
			maze[i][j] = 1;
		}
		
		return maze;
	}
}



