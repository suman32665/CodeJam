import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suman maharjan on 25/02/2017.
 *
 * Reverse the words of the given text
 */
public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List inputs = new ArrayList<>();
        if (valid_testCases(testCases)) {
            for (int i = 0; i < testCases; i++) {
                String s = inputString();
                if (!check_Input(s)) {
                    inputs.add(s);
                }
            }
        }
        for (int i=0; i<inputs.size();i++){
            String split[]=inputs.get(i).toString().split(" ");
            String s=new String();
            for (int j=split.length-1; j>=0;j--){
                if (j!=0){
                    s=s+split[j]+" ";
                }else{
                    s=s+split[j];
                }
            }
            int k=i+1;
            System.out.println("Case #"+k+":"+s);
        }
    }
    public static String inputString(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public static boolean check_Input(String string){
        if (string.length()>=1 && string.length()<=1000){
            if (string.charAt(string.length()-1)==' ' || string.charAt(0)==' '){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
    public static boolean valid_testCases(int number)
    {
        if (number<=100){
            return true;
        }else{
            return false;
        }
    }
}
