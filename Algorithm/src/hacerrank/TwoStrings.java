package hacerrank;

import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class TwoStrings {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();
            HashSet<Character> charset= new HashSet<Character>();
            String characterset = "abcdefghijklmnopqrstuvwxyz";
            String found = "NO";
            for(char character: characterset.toCharArray()) {
            	if(s1.indexOf(character)>=0 && s2.indexOf(character)>=0)
            		{
            		found = "YES";
            		break;
            		}
            }
            System.out.println(found);
            
            
        }


        scanner.close();
    }
}
