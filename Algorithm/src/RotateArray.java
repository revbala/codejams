import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RotateArray {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] rotArray = new int[a.length];
        //validate inputs
        if (a.length >=1 && a.length<=100000 && d >=1 && d <=a.length){
            if (a.length == d)
            return a;
            for(int i=0; i<a.length; i++){
                int toIndex = i - d;
                if(toIndex < 0 ) toIndex = toIndex + a.length;
                rotArray[toIndex] = a[i]; 
            }
        }

        return rotArray;          
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    	int[] a = {1,2,3,4,5};
    	
        int[] result = rotLeft(a, 4);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
