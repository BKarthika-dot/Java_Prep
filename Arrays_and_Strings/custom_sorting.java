/*sorting an array of strings based on their lengths */
import java.util.Scanner;
class custom_sorting{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=scanner.nextLine();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(str[j].length()>str[j+1].length()){
                    String temp=str[j];
                    str[j]=str[j+1];
                    str[j+1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.printf("%s ",str[i]);
        }
    } 
}