import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int fizzBuzzCount = 0;
        if(isNumber(s1)){
            fizzBuzzCount = Integer.parseInt(s1) + 3;
        } else if(isNumber(s2)){
            fizzBuzzCount = Integer.parseInt(s2) + 2;
        } if(isNumber(s3)){
            fizzBuzzCount = Integer.parseInt(s3) + 1;
        }

        if(fizzBuzzCount % 3 == 0 && fizzBuzzCount % 5 == 0){
            System.out.println("FizzBuzz");
        } else if (fizzBuzzCount % 3 == 0){
            System.out.println("Fizz");
        } else if (fizzBuzzCount % 5 == 0){
            System.out.println("Buzz");
        } else {
            System.out.println(fizzBuzzCount);
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}