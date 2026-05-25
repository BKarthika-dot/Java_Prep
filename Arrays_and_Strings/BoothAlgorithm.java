//finding lexicographically smallest rotation of a string in O(n) time
//ccbaadb --> aadbccb
import java.util.*;

public class BoothAlgorithm{
    static void main(String[] args){
        Scanner scanner =new Scanner(System.in);

        String s=scanner.nextLine();

        String ss=s+s;

        int i=0; //candidate 1
        int j=1; //candidate 2
        int k=0; //length

        int n=s.length();

        while(i<n && j<n && k<n){
            char a=ss.charAt(i+k);
            char b=ss.charAt(j+k);

            if(a==b){
                k++;
            }
            else if(a>b){
                i=i+k+1;
                if(i==j)i++;
                k=0;
            }
            else{
                j=j+k+1;
                if(j==i)j++;
                k=0;
            }

        }

        int start=Math.min(i,j);

        System.out.println(ss.substring(start,start+n));
    }
}