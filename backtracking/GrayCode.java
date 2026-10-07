//for an integer n generate 2^n numbers in the range (0,2^n-1)
//the binary values of those numbers should differ by only one bit; first and last binary strings must differ by one bit only
//input: n=2  ----> output: [0,1,3,2]
//because 4 binary strings are [00,01,11,10] 

import java.util.*;
class Main{
    public static void backtrack(int n,List<Integer> result,boolean choice,StringBuilder sb){

        //base case - when string is of length n convert it to decimal and add to result
        if(sb.length()==n){
            result.add(Integer.parseInt(sb.toString(),2));
            return;
        }
        
        //making choices based on the previous decision
        //choice shows which bit is allowed after my current decision
        if(!choice){
            sb.append(0);
            backtrack(n,result,false,sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(1);
            backtrack(n,result,true,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        else{
            sb.append(1);
            backtrack(n,result,false,sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(0);
            backtrack(n,result,true,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public static void main(String[] args){

        Scanner sc=new  Scanner(System.in);
        int n=sc.nextInt();

        List<Integer> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        backtrack(n,result,false,sb);
        System.out.println(result);

        sc.close();
    }
}