package hacerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner; 

public class SimpleArraySum {/*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) throws ParseException{
        /*
         * Write your code here.
         */
    	SimpleDateFormat informat = new SimpleDateFormat("hh:mm:ssaa");
    	SimpleDateFormat outformat = new SimpleDateFormat("HH:mm:ss");
    	
    	return outformat.format(informat.parse(s));

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
  }