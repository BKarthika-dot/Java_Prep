import java.util.*;
//find lexicographically first palindrome
public class FirstPalindrome {
    public static void main(String[] args){
        String s="adbadcbec";

        int [] freq=new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        int odd=0;
        char middle='\0';

        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                odd++;
                middle=(char)('a'+i);
            }
            
        }
        if(odd>1){
            System.out.println("No palindrome");
            return;
        }

        StringBuilder left=new StringBuilder();


        //building left half
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i]/2;j++){
                left.append((char)('a'+i));
            }
        }
        
        //reverse left to get right half
        StringBuilder right=new StringBuilder(left);
        right.reverse();

        //adding middle element
        if(odd==1) left.append(middle);

        left.append(right);

        System.out.println(left);



    }
}
