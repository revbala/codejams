package hacerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GameOfThronesPalindrome {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
    	Hashtable< Character, Integer> charMap = new Hashtable<Character, Integer>();
    	
    	for(char c : s.toCharArray()) {
    		if(charMap.get(c) !=null) {
    			charMap.remove(c);
    		}else {
    			charMap.put(c, 1);
    		}
    	}
    	
    	if(charMap.size()<=1) {
    		return "YES";
    	}
    	
    	return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}