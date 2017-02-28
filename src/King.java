import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suman maharjan on 20/02/2017.
 Alice and Bob want to play a game. The game is played on a chessboard with R rows and C columns, for a total of RC squares. Some of these squares are burned.

 A king will be placed on an unburned square of the board, and Alice and Bob will make successive moves with the king.

 In a move, the player must move the king to any of its 8 neighboring squares, with the following two conditions:

 The destination square must not be burned
 The king must never have been in the destination square before.
 If a player can't make a move, he or she loses the game. Alice will move first; you need to determine who will win, assuming both players play optimally.

 Input

 The first line of input gives the number of cases, N.
 N test cases follow. The first line of each case will contain two integers, R and C. The next R lines will contain strings of length C, representing the C squares of each row. Each string will contain only the characters '.', '#' and 'K':

 '#' means the square is burned;
 '.' means the square is unburned, and unoccupied; and
 'K' means the king is in that cell at the beginning of the game.
 There will be only one 'K' character in each test case.

 Output
 For each test case, output one line containing "Case #X: " (where X is the case number, starting from 1) followed by A if Alice wins, or B if Bob wins.

 Limits
 1 ≤ N ≤ 100

 Small dataset
 1 ≤ R, C ≤ 4

 Large dataset
 1 ≤ R, C ≤ 15

 Sample
 Input
 2
 2 2
 K.
 .#
 4 2
 K#
 .#
 .#
 .#
 Output
 Case #1: B
 Case #2: A
 */
public class King {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List outputs=new ArrayList<>();
        int testCases=scanner.nextInt();
        int row,columns;
        String[] inputs;
        if (check_TestCases(testCases)) {
            for (int i = 0; i < testCases; i++) {
                row = scanner.nextInt();
                columns = scanner.nextInt();
                if (check_RC(row, columns)){
                    inputs=new String[row];
                    for (int j=0; j<row;j++){
                        inputs[j]=takeInputString();
                    }
                    outputs.add(compute(inputs));
                }
            }
        }
        for (int i=0; i<testCases;i++){
            int k=i+1;
            System.out.println("Case #"+k+":"+outputs.get(i).toString());
        }
    }
    public static String compute(String[] inputs){

        boolean win=true;

        while (!check_CheckMate(inputs)){
            win=toggle_WL(win);
//            System.out.println(win);
            inputs=findNextPosition(inputs);
        }
        if (check_CheckMate(inputs)){
            if (win){
                return "B";
            }else{
                return "A";
            }
        }
        return " ";
    }
    public static String[] findNextPosition(String[] inputs){
        for (int i=0; i<inputs.length;i++){
            for (int j=0; j<inputs[i].length();j++){
                if (inputs[i].toUpperCase().charAt(j)=='K'){
                    int row=i;
                    int column=j;
                    inputs[i]=burn_it(i,j,inputs);
                    if (row==0 && column==0){
                        if (inputs[row].charAt(column+1)=='.'){
                            inputs[row]=move_K(row,column+1,inputs);
//                            System.out.println(inputs[row]);
                        }else{
                            if (inputs[row+1].charAt(column+1)=='.'){
                                inputs[row+1]=move_K(row+1,column+1,inputs);
                            }else{
                                if (inputs[row+1].charAt(column)=='.'){
                                    inputs[row+1]=move_K(row+1,column,inputs);
                                }
                            }
                        }
                    }else{
                        if (row==0 && column==inputs[i].length()-1){
                            if (inputs[row].charAt(column-1)=='.'){
                                inputs[row]=move_K(row,column-1,inputs);
                            }else{
                                if (inputs[row+1].charAt(column-1)=='.'){
                                    inputs[row+1]=move_K(row+1,column-1,inputs);
//                                    System.out.println(inputs[row+1]);
                                }else{
                                    if (inputs[row+1].charAt(column)=='.'){
                                        inputs[row+1]=move_K(row+1,column,inputs);
                                    }
                                }
                            }
                        }else{
                            if (row==inputs.length-1 && column==0){
                                if (inputs[row-1].charAt(column+1)=='.'){
                                    inputs[row-1]=move_K(row-1,column+1,inputs);
                                }else{
                                    if (inputs[row-1].charAt(column)=='.'){
                                        inputs[row+1]=move_K(row+1,column,inputs);
                                    }else{
                                        if (inputs[row].charAt(column+1)=='.'){
                                            inputs[row]=move_K(row,column+1,inputs);
                                        }
                                    }
                                }
                            }else{
                                if (row==inputs.length-1 && column==inputs[i].length()-1){
                                    if (inputs[row-1].charAt(column)=='.'){
                                        inputs[row-1]=move_K(row-1,column,inputs);
                                    }else{
                                        if (inputs[row].charAt(column-1)=='.'){
                                            inputs[row]=move_K(row,column-1,inputs);
                                        }else{
                                            if (inputs[row-1].charAt(column-1)=='.'){
                                                inputs[row-1]=move_K(row-1,column-1,inputs);
                                            }
                                        }
                                    }
                                }else {
                                    if (row == 0) {
                                        if (inputs[row].charAt(column - 1) == '.'){
                                            inputs[row]=move_K(row,column-1,inputs);
                                        }else{
                                            if (inputs[row].charAt(column + 1) == '.'){
                                                inputs[row]=move_K(row,column+1,inputs);
                                            }else{
                                                if (inputs[row + 1].charAt(column - 1) == '.'){
                                                    inputs[row+1]=move_K(row+1,column-1,inputs);
                                                }else{
                                                    if (inputs[row + 1].charAt(column + 1) == '.'){
                                                        inputs[row+1]=move_K(row+1,column+1,inputs);
                                                    }else{
                                                        if (inputs[row + 1].charAt(column) == '.'){
                                                            inputs[row+1]=move_K(row+1,column,inputs);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        if (column==0){
                                            if (inputs[row+1].charAt(column+1)=='.'){
                                                inputs[row+1]=move_K(row+1,column+1,inputs);
                                            }else{
                                                if ( inputs[row-1].charAt(column+1)=='.'){
                                                    inputs[row-1]=move_K(row-1,column+1,inputs);
                                                }else{
                                                    if (inputs[row-1].charAt(column)=='.'){
                                                        inputs[row-1]=move_K(row-1,column,inputs);
                                                    }else{
                                                        if (inputs[row+1].charAt(column)=='.'){
                                                            inputs[row+1]=move_K(row+1,column,inputs);
                                                        }else{
                                                            if (inputs[row].charAt(column+1)=='.'){
                                                                inputs[row]=move_K(row,column+1,inputs);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }else{
                                            if (row==inputs.length-1){
                                                if (inputs[row].charAt(column-1)=='.'){
                                                    inputs[row]=move_K(row,column-1,inputs);
                                                }else{
                                                    if (inputs[row-1].charAt(column-1)=='.'){
                                                        inputs[row-1]=move_K(row-1,column-1,inputs);
                                                    }else{
                                                        if (inputs[row-1].charAt(column)=='.'){
                                                            inputs[row-1]=move_K(row-1,column,inputs);
                                                        }else{
                                                            if (inputs[row-1].charAt(column+1)=='.'){
                                                                inputs[row-1]=move_K(row-1,column+1,inputs);
                                                            }else{
                                                                if (inputs[row].charAt(column+1)=='.'){
                                                                    inputs[row]=move_K(row,column+1,inputs);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                if (column==inputs[i].length()){
                                                    if (inputs[row-1].charAt(column)=='.'){
                                                        inputs[row-1]=move_K(row-1,column,inputs);
                                                    }else{
                                                        if (inputs[row+1].charAt(column)=='.'){
                                                            inputs[row+1]=move_K(row+1,column,inputs);
                                                        }else{
                                                            if (inputs[row].charAt(column-1)=='.'){
                                                                inputs[row]=move_K(row,column-1,inputs);
                                                            }else{
                                                                if (inputs[row+1].charAt(column-1)=='.'){
                                                                    inputs[row+1]=move_K(row+1,column-1,inputs);
                                                                }else{
                                                                    if (inputs[row-1].charAt(column-1)=='.'){
                                                                        inputs[row-1]=move_K(row-1,column-1,inputs);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }else{
                                                    if (inputs[row+1].charAt(column+1)=='.'){
                                                        inputs[row+1]=move_K(row+1,column+1,inputs);
                                                    }else{
                                                        if (inputs[row-1].charAt(column-1)=='.'){
                                                            inputs[row-1]=move_K(row-1,column-1,inputs);
                                                        }else{
                                                            if (inputs[row+1].charAt(column-1)=='.'){
                                                                inputs[row+1]=move_K(row+1,column-1,inputs);
                                                            }else{
                                                                if (inputs[row-1].charAt(column+1)=='.'){
                                                                    inputs[row-1]=move_K(row-1,column+1,inputs);
                                                                }else{
                                                                    if (inputs[row+1].charAt(column)=='.'){
                                                                        inputs[row+1]=move_K(row+1,column,inputs);
                                                                    }else{
                                                                        if (inputs[row].charAt(column+1)=='.'){
                                                                            inputs[row]=move_K(row,column+1,inputs);
                                                                        }else{
                                                                            if (inputs[row-1].charAt(column)=='.' ){
                                                                                inputs[row-1]=move_K(row-1,column,inputs);
                                                                            }else{
                                                                                if (inputs[row].charAt(column-1)=='.'){
                                                                                    inputs[row]=move_K(row,column-1,inputs);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return inputs;
                }

            }
        }
        return inputs;
    }
    public static String burn_it(int i, int j, String[] inputs){
        char[] input_char=inputs[i].toCharArray();
        input_char[j]='#';
        return String.valueOf(input_char);
    }
    public static String move_K(int row, int column, String [] inputs){
        char[] input_char=inputs[row].toCharArray();
        input_char[column]='K';
        return String.valueOf(input_char);
    }
    public static boolean check_CheckMate(String[] inputs){
        for (int i=0; i<inputs.length;i++){
            for (int j=0; j<inputs[i].length();j++){
                if (inputs[i].toUpperCase().charAt(j)=='K'){
                    int row=i;
                    int column=j;
                    if (row==0 && column==0){
                        if (inputs[row].charAt(column+1)=='#' && inputs[row+1].charAt(column+1)=='#' && inputs[row+1].charAt(column)=='#'){
                            return true;
                        }
                    }else{
                        if (row==0 && column==inputs[i].length()-1){
                            if (inputs[row].charAt(column-1)=='#' && inputs[row+1].charAt(column-1)=='#' && inputs[row+1].charAt(column)=='#'){
                                return true;
                            }
                        }else{
                            if (row==inputs.length-1 && column==0){
                                if (inputs[row-1].charAt(column+1)=='#' && inputs[row-1].charAt(column)=='#' && inputs[row].charAt(column+1)=='#'){
                                    return true;
                                }
                            }else{
                                if (row==inputs.length-1 && column==inputs[i].length()-1){
                                    if (inputs[row-1].charAt(column)=='#' && inputs[row].charAt(column-1)=='#' && inputs[row-1].charAt(column-1)=='#'){
                                        return true;
                                    }
                                }else {
                                    if (row == 0) {
                                        if (inputs[row].charAt(column - 1) == '#' && inputs[row].charAt(column + 1) == '#' && inputs[row + 1].charAt(column - 1) == '#'
                                                && inputs[row + 1].charAt(column + 1) == '#' && inputs[row + 1].charAt(column) == '#'){
                                            return true;
                                        }
                                    }else{
                                        if (column==0){
                                            if (inputs[row+1].charAt(column+1)=='#' && inputs[row-1].charAt(column+1)=='#' && inputs[row-1].charAt(column)=='#'
                                                    && inputs[row+1].charAt(column)=='#' && inputs[row].charAt(column+1)=='#'){
                                                return true;
                                            }
                                        }else{
                                            if (row==inputs.length-1){
                                                if (inputs[row].charAt(column-1)=='#' && inputs[row-1].charAt(column-1)=='#' && inputs[row-1].charAt(column)=='#'
                                                        && inputs[row-1].charAt(column+1)=='#' && inputs[row].charAt(column+1)=='#'){
                                                    return true;
                                                }
                                            }else{
                                                if (column==inputs[i].length()){
                                                    if (inputs[row-1].charAt(column)=='#' && inputs[row+1].charAt(column)=='#' && inputs[row-1].charAt(column-1)=='#'
                                                            && inputs[row].charAt(column-1)=='#' && inputs[row+1].charAt(column-1)=='#'){
                                                        return true;
                                                    }
                                                }else{
                                                    if (inputs[row+1].charAt(column+1)=='#' && inputs[row-1].charAt(column-1)=='#' && inputs[row+1].charAt(column-1)=='#'
                                                            && inputs[row-1].charAt(column+1)=='#' && inputs[row+1].charAt(column)=='#' && inputs[row].charAt(column+1)=='#'
                                                            && inputs[row-1].charAt(column)=='#' && inputs[row].charAt(column-1)=='#'){
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean toggle_WL(boolean win){
        if (win){
            return false;
        }else{
            return true;
        }
    }

    public static String takeInputString()
    {
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public static boolean check_TestCases(int N)
    {
        if (N>=1 && N<=100){
            return true;
        }else{
            return false;
        }
    }
    public static boolean check_RC(int R, int C){
        if (R>=1 && C<=15){
            return true;
        }else{
            return false;
        }
    }
}
