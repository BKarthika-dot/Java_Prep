// Example 1:

// Input: s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]
// Example 2:

// Input: s = "0000"
// Output: ["0.0.0.0"]
// Example 3:

// Input: s = "101023"
// Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 
import java.util.*;
public class ValidIPaddress{
    private static void backtrack(List<String> result,String s,StringBuilder sb,int start,int count){
        
        //base case - should have found 4 segments and must have traversed all characters in string
        if(count==4){
            if(start==s.length()){
                result.add(sb.substring(0,sb.length()-1));
            }
            return;
        }

        //make choice - append
        for(int i=start;i<s.length();i++){
            
            int len=sb.length(); //save initial length
            sb.append(s.substring(start,i+1));

            //constraints

            //length must not be greater than 3
            if(i-start+1>3){
                sb.setLength(len); //return to initial sb
                break;
            }

            //number should be between 0 and 255 (inclusive)
            if(Integer.parseInt(s.substring(start,i+1))>255){
                sb.setLength(len); //return to initial sb
                break;
            }

            //leading zeros shouldnt be present 0 can be accepted but 01,00,etc. shouldn't occur
            if(i!=start && s.charAt(start)=='0'){
                sb.setLength(len); //return to initial sb
                break;
            }
            
            sb.append('.');
            backtrack(result,s,sb,i+1,count+1);

            sb.setLength(len);
        }


    }
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        List<String> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int count=0;
        int start=0;

        backtrack(result,s,sb,start,count);

        System.out.println(result);

        sc.close();
    }
}