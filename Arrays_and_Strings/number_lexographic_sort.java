/*n number of digits[0-9] will be given as input. They should be sorted based on their lexographic order.
  [1,2,3] will get sorted to [1,3,2].
 */
import java.util.Scanner;
import java.util.Arrays;
class number_lexographic_sort{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter size of array");
        int n=scanner.nextInt();
        int [] a=new int [n];
        System.out.println("enter "+n+" digits from 0-9");
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int [] no={0,1,2,3,4,5,6,7,8,9};
        String [] num={"zero","one","two","three","four","five","six","seven","eight","nine"};
        String [] str=new String [n];
        for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                if(a[i]==no[j]){
                    str[i]=num[j];
                }
            }
        }
        Arrays.sort(str);
        for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                if(str[i].equals(num[j])){
                    System.out.printf("%d ",no[j]);
                }
            }
        }
    }
}