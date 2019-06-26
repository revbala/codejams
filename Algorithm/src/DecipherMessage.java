import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DecipherMessage {

    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(T>=1 && T<=100) {

	        for(int i=1; i<=T; i++) {
	        	String[] firstLine = scanner.nextLine().split(" ");
	        	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        	if(firstLine.length!=2) continue;
	        	

	            BigInteger N = new BigInteger(firstLine[0]);
	            int L = Integer.parseInt(firstLine[1]);
	            
	            String[] cipher = scanner.nextLine().split(" ");
	            
	            if ( L>=25 && L<=100 && L==cipher.length)
	    		{
	            	
		            	String message = decipherMessage(cipher, N);
		            	if(message.matches("^[A-Z]+$"))
		            		System.out.println("Case #" + i + ": " + message);
	            	
	    		}   		
        	
        	}
            	
        
        }
        scanner.close();
  
	}
	
	public static String decipherMessage(String[] cipher, BigInteger maxLimit){
		
		int[] expandedText = new int[cipher.length + 1];
		Set<Integer> cipherSet = new TreeSet<Integer>();

		int divisor = findSecondCharacter(cipher);
		int counter=0;
		for(int i=0; i<cipher.length; i++) {
			int cipherInt = Integer.parseInt(cipher[i]);
			if(i==0) {				
				expandedText[counter++] = cipherInt/divisor;
				cipherSet.add(cipherInt/divisor);
				expandedText[counter++] = divisor;
				
			}else {
				expandedText[counter++] = cipherInt/divisor;
				divisor = expandedText[counter-1];
			}
			cipherSet.add(divisor);
		}
		
		if(cipherSet.size()<26) return "";
		Map<Integer, Character> alphabetMap = new HashMap<Integer, Character>();
		int c = (int) 'A';
		List<Integer> cipherlist = new ArrayList<Integer>(cipherSet);
		Collections.sort(cipherlist);
					
		for (Integer item : cipherlist) {
			
			alphabetMap.put( item, (char) c++);
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<expandedText.length; i=i+1) {
			builder.append(alphabetMap.get(expandedText[i]));
		}
		
		return builder.toString();
	}
	
	public static int findSecondCharacter(String[] cipher){
		
		//take the first two ciphers and find the number
		int[] expandedText = new int[2];
		int secondChar = 0;
		int cipherCounter = 0;
		for(int counter=0; counter<2; counter++) {
			int cipherInt = Integer.parseInt(cipher[counter]);
			for(int i=2; i<=cipherInt/2; i++) {
				if(i!=2 && i%2==0) continue;
				for(int j=2; j<=cipherInt/2; j++) {
					if(i*j==cipherInt && isPrime(i) && isPrime(j)){
						
						if(cipherCounter-1>=0) {
							
							if(expandedText[cipherCounter-1] == i || expandedText[cipherCounter-2] == i) {
								secondChar = i;
								break;
							}else if(expandedText[cipherCounter-1] == j || expandedText[cipherCounter-2] == j)
							{
								secondChar = j;
								break;
							}
							
						}else {
							expandedText[cipherCounter++] = i;
							expandedText[cipherCounter++] = j;
						}
					}
				}
			}
		}
								
		return secondChar;
		
	}
	
	
	public static boolean isPrime(int number) {

		boolean isPrime = true;
		if(number == 2) {
			return true;
		}else
		{
			for (int j=3; j<=number/2; j++) {
				if(number%j == 0) {
					//not a prime
					isPrime = false; break;
				}
			}
		}
		
		return isPrime;
	}
}



