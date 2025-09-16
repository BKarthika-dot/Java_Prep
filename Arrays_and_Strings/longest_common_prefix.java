/*Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings. */
import java.util.Scanner;
class longest_common_prefix{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size");
        int n=sc.nextInt();
        sc.nextLine();
        String [] strs=new String [n];

        System.out.println("enter string elements");

        for(int i=0;i<n;i++){
            strs[i]=sc.nextLine();
        }
        StringBuffer sb=new StringBuffer(strs[0]);

        for(int i=1;i<n;i++){
            int j=0;
            String w=strs[i];
            while(j<sb.length() && j<w.length() && sb.charAt(j)==w.charAt(j)){
                j++;
            }
            sb.delete(j,sb.length());
        }
        String ans=sb.toString();
        System.out.println("Longest common prefix: "+ans);

        sc.close();
    }
    
}