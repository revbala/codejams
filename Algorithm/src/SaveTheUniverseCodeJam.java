import java.util.Scanner;

public class SaveTheUniverseCodeJam {

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(T>=1 && T<=100) {

	        for(int i=1; i<=T; i++) {
	        	String[] input = scanner.nextLine().split(" ");

	        	int D = Integer.parseInt(input[0]);	        	
	        	
	        	String P = input[1];
	    		
	    		if(D >=1 && D<=109 && P.length()>=2 && P.length()<=30 && P.matches("^[CS]+$")) {
	    			if(P.matches("^[S]+$"))
		    			System.out.println("Case #" + i + ": IMPOSSIBLE");
		    		else
		    			System.out.println("Case #" + i + ": " + minswaps(P, D));
	    		}
	    		
	        	
	        }
        
        }
        scanner.close();
    
		

	}
	public static int minswaps(String str, int expectedDamage){
		
	
		char[] instructions = str.toCharArray();
	    int swaps =0;
	    int minimumDamage = calculateDamage(instructions);
	    if(minimumDamage == expectedDamage) return swaps;
	    
	    for(int i=0;i<instructions.length; i++) {
	    	for(int j=i+1; j<instructions.length; j++) {
	    		if(instructions[j-1]<instructions[j]) {
	    			char temp = instructions[j];
	    			instructions[j] = instructions[j-1];
	    			instructions[j-1] = temp;
	    			swaps++;
	    			if(calculateDamage(instructions) <=expectedDamage)
	    				return swaps;
	    			
	    					
	    		}
	    	}
	    }
	    		
	    return swaps;
	    
		
	}
	
	public static int calculateDamage(char[] instructions) {
		
		int damage = 0;
		int strength = 1;
		
		for(int i=0; i<instructions.length; i++) {
			if(instructions[i] == 'C') strength = strength*2;
			else if(instructions[i] == 'S') damage = damage + strength;			
			
		}
		
		return damage;
	}
}



