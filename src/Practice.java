import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suman maharjan on 14/02/2017.
 */
public class Practice {
    public static void main(String[] args) {
        String s="suman";
        change(s);
        System.out.println(s);

    }
    public static void change(String s)
    {
        s=s.replaceAll("s","asd");
        System.out.println(s);
    }
}
