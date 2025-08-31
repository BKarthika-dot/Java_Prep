/*String compression 
"aaabbc" → "a3b2c1" */

import java.util.Scanner;
class String_compression{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter string: ");
        String line=scanner.nextLine();
        int n=line.length();

        for(int i=0;i<n;i++){
            int j=i+1;
            int count=1;
            char c=line.charAt(i);
            while(j<n&&line.charAt(j)==c){
                count++;
                j++;
            }
            System.out.printf("%c%d",c,count);
            i=j-1;
        }
    }
}

