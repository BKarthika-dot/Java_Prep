import java.util.Scanner;
class Anagram_checker{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        int n1=str1.length();
        int n2=str2.length();
        StringBuffer sb=new StringBuffer(str2);
        int flag=0;
        
        if(n1!=n2){
            System.out.println("not anagrams");
            return;
        }
        else{
           for(int i=n1-1;i>=0;i--){
                boolean found=false;
                char c=str1.charAt(i);
                for(int j=sb.length()-1;j>=0;j--){
                    if(c==sb.charAt(j)){
                        sb.deleteCharAt(j);
                        found=true;
                        break;
                    }
                }
                if(!found){
                    flag=1;
                }
            }
        }
        if(flag==0){
            System.out.println("given strings are anagrams");
        }
        else{
            System.out.println("given strings are NOT anagrams");
        }
    }
}