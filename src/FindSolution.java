import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suman maharjan on 16/01/2017.
This program finds the possible combination of letters L,O,C,U,S of length 4
 */
public class FindSolution {
    public static void possibleStrings(int maxLength, char[] alphabet, String curr,List possibleCombinations){
//        List possibleCombinations=new ArrayList<>();
        if (curr.length()==maxLength){
            possibleCombinations.add(curr);

        }else{
            for (int i=0; i<alphabet.length;i++){
                String oldCurr=curr;
                curr+=alphabet[i];
                possibleStrings(maxLength, alphabet, curr, possibleCombinations);
                curr=oldCurr;
            }
        }
//        System.out.println(possibleCombinations);

    }
    public static void main(String[] args) {
        String fileName="D:\\whitespaces\\src\\FindSolution.txt";
        String line=null;
        List words=new ArrayList<>();

        FileReader fileReader= null;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine())!=null){
                String split[]=line.split(" ");
                for (int i=0; i<split.length; i++){
                    words.add(split[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] alphabet=new char[]{'L','O','C', 'U', 'S'};
        List possibleCombinations=new ArrayList<>();
        possibleStrings(4, alphabet,"",possibleCombinations);

//        System.out.println(possibleCombinations);
        int j=0;
        for (int i=0; i<possibleCombinations.size();i++){
            if (words.contains(possibleCombinations.get(i))){
                j++;
                System.out.println(j+". " + possibleCombinations.get(i));
            }
        }
    }
}