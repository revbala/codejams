import java.util.Scanner;

public class CodeJamSplitCurrency {

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(T>=1 && T<=100) {

	        for(int i=1; i<=T; i++) {
	        	int amount = scanner.nextInt();
	        	if (String.valueOf(amount).contains("4"))
	    		{
	        		int[] result = splitAmount(amount);
	        		System.out.println(" Case #" + i + ": " + result[0] + " " + result[1]);
	    		}   		
	        	
	        }
        
        }
        scanner.close();
    
		

	}
	public static int[] splitAmount(int amount){
		
		int[] amounts = new int[2];
	    
		amounts[0] = amount;
		amounts[1] = 0;
		int position = 1;
		do{
			if(amounts[0]/position%10 == 4) {
				//split the amount by shifting 3 to left
				amounts[0] = amounts[0]-3*position; 
				amounts[1] = amounts[1] + 3*position;
			}

			position = position*10;
		}while(amounts[0]/position > 1);
		
		return amounts;
	}	

}



