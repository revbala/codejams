package hacerrank;

import java.util.Hashtable;
import java.util.Scanner;

public class RansomeNote {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        Hashtable<String, Integer> magazine = new Hashtable<String, Integer>();

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            if(magazine.get(magazineItem)!=null)
            	magazine.put(magazineItem,magazine.get(magazineItem)+1);
            else
            	magazine.put(magazineItem,1);
        }
        

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String found="Yes";
        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            if(magazine.get(noteItem)==null)  {
            	found="No"; break;
            }
            else {
            	int count = magazine.get(noteItem);
            	count--;
            	if(count==0) magazine.remove(noteItem);
            	else magazine.put(noteItem, count);
            }
        }

        System.out.println(found);

        scanner.close();
    }
}
