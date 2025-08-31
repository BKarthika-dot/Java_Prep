import java.util.Scanner;
class check_pallindrome{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter string");
        String str=scanner.nextLine();
        
        boolean flag=false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length-1-i)){
                flag=true;
            }
        }
        if(flag){
            System.out.println("this string is NOT a pallindrome");
        }
        else{
            System.out.println("string is a pallindrome");
        }
    }
}