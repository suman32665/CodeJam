import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suman maharjan on 09/02/2017.
 */
public class RummyStore {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int losspoint=0;
        String inputSet=new String();
        List inputValuesArray=new ArrayList<>();
        List output=new ArrayList<>();
        String outputstring;
        int numberOfRummyHands=scanner.nextInt();

        for (int i=0; i<numberOfRummyHands;i++){
            inputSet=take_input();
            String split[]=inputSet.split(" ");
            for (int j=0;j<split.length;j++){
                inputValuesArray.add(Integer.parseInt(split[j]));
            }
            Collections.sort(inputValuesArray);
            outputstring="Rummy Hand: "+ inputSet +" "+losspoint;

        output.add(outputstring);
        }
        for (int i=0; i<numberOfRummyHands;i++){
            System.out.println(output.get(i));
        }
    }
    public static void find_commonCombination(List inputValuesArray, int number)
    {

    }

    public static String take_input()
    {
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
}
