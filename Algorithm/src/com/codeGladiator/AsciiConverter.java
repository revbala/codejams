package com.codeGladiator;

import java.util.Scanner;

public class AsciiConverter {

	 private static final Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
			
	        int T = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        
	        if(T>=1 && T<=100) {

		        for(int i=1; i<=T; i++) {
		        	String line = scanner.nextLine();

		        	StringBuilder builder = new StringBuilder();
		        	if(line.length()>=1 && line.length()<=1000) 
		        	{
		        		for(char c : line.toCharArray()) {
		        			builder.append((int) c);
		        		}
		        	}
		        	
		        	System.out.println(builder.toString());

		        }
	        
	        }
	        scanner.close();
	  
		}
}
