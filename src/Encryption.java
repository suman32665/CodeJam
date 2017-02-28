/**
 * Created by suman maharjan on 07/02/2017.
 */
public class Encryption {
    public static void main(String[] args) {
        String input="if man was meant to stay on the ground god would have given us roots";
        int row, column;

        System.out.println("Input Text:"+input);
        input=input.replace(" ","");

        double sqrt=Math.sqrt(input.length());
        row=(int)Math.floor(sqrt);
        column=(int)Math.ceil(sqrt);
        String array[]=new String[row];

        int index=0;
        int begining=0, ending=column;

        if (input.length()<=row*column){
            while (index<row){
                array[index]=input.substring(begining,ending);
                begining+=column;
                ending+=column;
                if (ending>input.length()){
                    ending=input.length();
                }
                System.out.println(array[index]);
                index++;
            }
        }
        String encryptedText="";
        for (int i=0; i<column;i++){
            for (int j=0; j<row;j++){
                if (i<array[j].length()) {
                    encryptedText += array[j].charAt(i);
                }
            }
            encryptedText+=" ";
        }
        System.out.println("Encrypted Text:"+encryptedText);
    }
}
