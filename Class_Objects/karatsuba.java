//O(n^log3) run time
//divide and conqer approach
//a static method can directly call only other static methods (unless it first creates an object).
import java.util.*;

public class karatsuba {
    private static long divide_and_conquer(int x,int y){
        if(x<10 || y<10){
            return x*y;
        }

        int n1=(int)Math.log10(Math.abs(x))+1;
        int n2=(int) Math.log10(Math.abs(y))+1;
        int n=Math.max(n1,n2);
        int m=n/2;
        int power=(int)Math.pow(10,m);

        int a=x/power;
        int b=x%power;
        int c=y/power;
        int d=y%power;

        long ac=divide_and_conquer(a,c);
        long bd=divide_and_conquer(b,d);
        long abcd=divide_and_conquer(a+b,c+d);
        
        

        return ac*(int)Math.pow(10,2*m)+(abcd-ac-bd)*(int)Math.pow(10,m)+bd;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();

        long ans=divide_and_conquer(a,b);
        System.out.println(ans);
    }
}
