import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suman maharjan on 09/02/2017.
 Q #3. Count the Dividing Pairs
 Number Theory provides many fascinating properties.
 You have most likely written programs dealing with different groups of numbers such as Prime, Perfect, Amicable,
 Happy, Powerful, and Untouchable numbers, just to name a few.  In this problem, you’ll attack yet another fascinating
 property of numbers, one dealing with pairs of numbers.   An integer D is said to be a proper divisor of an integer N
 if D ≠ N and there exist an integer Q such that N = Q * D.  For example, 4 is a proper divisor of 8 and 5 is a proper
 divisor of 15, but 9 is not a proper divisor of 9 and 6 is not a proper divisor of 8.  Note that zero is not a proper
 divisor of any number but all numbers (except zero) are proper divisors of zero.    We will call (D, N) as defined
 above “proper dividing pairs”.   The Problem:   Given a list of integers A = {A1, A2, …, Ap}, you are to determine
 (count) the number of proper dividing pairs (Ai, Aj), where 1 ≤ i, j ≤ p.   The Input:   The first input line contains
 a positive integer, n, indicating the number of test cases to process.  Each test case starts with an integer, p (2 ≤ p ≤ 106),
 indicating the number of integers in the list.  The following input line will provide p integers, Ai (0 ≤ Ai ≤ 107).
 The Output:
 For each test case, print “Test case #t: m”, where t indicates the case number starting with 1 and m indicates the number
 of proper dividing pairs.  Leave a blank line after the output for each test case.     Note that, as illustrated in Sample
 Input/Output, duplicate values in the input list are considered as different elements in the list and they each contribute
 to the total count (proper dividing pairs).
 Sample Input:
 5  3  1 2 3  4  1 2 3 1  2  7 5  3  29 0 17  10  32 16 8 4 2 2 4 8 16 32
 Sample Output:
 Test case #1: 2
 Test case #2: 4
 Test case #3: 0
 Test case #4: 2
 Test case #5: 40



 */
public class CountDividingPairs {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        List output=new ArrayList<>();
        int testCases=scanner.nextInt();
        int p;
        List inputIntegers=new ArrayList<>();
        for (int i=0; i<testCases;i++) {
            p = scanner.nextInt();
            if (check_P(p)) {
                for (int j = 0; j < p; j++) {
                    int A=scanner.nextInt();
                    if (check_Integer(A)){
                        inputIntegers.add(A);
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
            if (inputIntegers.size()==p){
                output.add(compute(inputIntegers,i+1));
                inputIntegers.clear();
            }else{
                break;
            }
        }
        for (int i=0;i<testCases;i++){
            System.out.println(output.get(i));
        }
    }
    public static String compute(List A, int caseNumber){
        int count=0;
        for (int i=0; i<A.size();i++){
            for (int j=0; j<A.size(); j++){
                if (A.get(i)!=A.get(j) && Integer.parseInt(A.get(j).toString())!=0 ){
                    if (Integer.parseInt(A.get(i).toString())%Integer.parseInt(A.get(j).toString())==0){
                        count++;
                    }
                }
            }
        }
        return("Test case #"+caseNumber+": "+count);

    }
    public static boolean check_P(int p){
        if (p>=2 && p<=106){
            return true;
        }else{
            return false;
        }
    }
    public static boolean check_Integer(int A)
    {
        if (A>=0 && A<=107){
            return true;
        }else{
            return false;
        }
    }
}
