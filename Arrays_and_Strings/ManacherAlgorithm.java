//finding longest pallindromic substring in O(n) time

//cdbacabda --> bacab

import java.util.Scanner;

public class ManacherAlgorithm {
    static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        String s=scanner.nextLine();
        String t="";
        for(int i=0;i<s.length();i++){
            t+="#";
            t+=s.charAt(i);
        }

        int [] p=new int[t.length()];
        int c=0;
        int r=0;
        int maxLen=0;
        int maxCenter=0;

        for(int i=0;i<t.length();i++){
            int mirror=2*c - i;

            if(i<r){
                p[i]=Math.min(r-i,p[mirror]);
            }

            //expand at i
            int a=i+(1+p[i]);
            int b=i-(1+p[i]);

            while(a<t.length() && b>=0 && t.charAt(a)==t.charAt(b)){
                p[i]++;
                a++;
                b--;
            }

            if(i+p[i]>r){
                c=i;
                r=i+p[i];
                
            }

            if(p[i]>maxLen){
                maxLen=p[i];
                maxCenter=i;
            }

        }

        int start=(maxCenter-maxLen)/2;
        int length;

        if(maxLen%2==0){
            length=maxLen+1;
        }else{
            length=maxLen;
        }

        System.out.println(s.substring(start,start+length));
        scanner.close();
    }
}
