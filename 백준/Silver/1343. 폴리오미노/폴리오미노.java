import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String reg1 = "XXXX";
        String reg2 = "XX";

        s= s.replaceAll(reg1, "AAAA").replaceAll(reg2,"BB");
        if(s.contains("X"))
            System.out.println(-1);
        else System.out.println(s);
    }
}