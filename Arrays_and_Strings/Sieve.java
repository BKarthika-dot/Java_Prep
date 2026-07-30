import java.util.*;
// find all prime numbers less than or equal to n
public class Sieve{
    static int MAX_SIZE=(int) 1e6;

    public static ArrayList<Integer> SimpleSieve(int n){
        boolean [] prime=new boolean[n+1];

        for(int i=0;i<n+1;i++){
            prime[i]=true;
        }

        for(int p=2;p<=n;p++){

            if(prime[p]){
                for(int i=p*p;i<=n;i+=p){
                    prime[i]=false;
                }
            }
        }

        ArrayList<Integer> Primes=new ArrayList<>();

        for(int i=2;i<n+1;i++){
            if(prime[i]) Primes.add(i);
        }

        return Primes;
    }

    //generate primes till <= sqrt(r)  ----> use sieve
    //create dummy array of size (r-l+1)
    //make all multiples of primes in dummy array
    public static ArrayList<Integer> SegmentedSieve(int l,int r){

        int limit=(int)(Math.floor(Math.sqrt(r))+1);

        ArrayList<Integer> primes=SimpleSieve(limit);

        int [] dummy=new int[r-l+1];
        for(int i=0;i<dummy.length;i++) dummy[i]=1;

        for(int p: primes){
            int firstMultiple=(l/p)*p;
            if(firstMultiple<l) firstMultiple+=p;

            for(int j=Math.max(firstMultiple,p*p);j<=r;j+=p){
                dummy[j-l]=0;
            }
        }

        ArrayList<Integer> nums=new ArrayList<>();
        for(int i=l;i<=r;i++){
            if(dummy[i-l]==1) nums.add(i);
        }
        return nums;
    }

    //finding kth prime number 
    public static int KthPrime(int k){
        
        boolean[] prime=new boolean[MAX_SIZE+1];

        for(int i=0;i<=MAX_SIZE;i++) prime[i]=true;

        int counter=0;
        int req=-1;
        for(int p=2;p<=MAX_SIZE;p++){
            if(prime[p]){
                counter++;
                if(counter==k){
                    req=p;
                    return req;
                }
                if((long)p*p<MAX_SIZE){
                    for(int i=p*p;i<=MAX_SIZE;i+=p){
                        prime[i]=false;
                    }
                }
            }
        }
        return req;
    }

    //how many nos in the range 1-10^6 have minm prime factor as n
    public static int minmPrimeFactor(int n){
        boolean [] prime=new boolean[MAX_SIZE+1];

        for(int i=0;i<prime.length;i++){
            prime[i]=true;
        }
        int count=1;
        for(int p=2;p<=MAX_SIZE;p++){
            
            if(prime[p]){
                if((long)p*p<MAX_SIZE){
                    for(int i=p*p;i<=MAX_SIZE;i+=p){
                        if(p==n && prime[i]){
                            count++;
                        }
                        prime[i]=false;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){

        int n=(int)(Math.floor(Math.sqrt(130))+1);

        ArrayList<Integer> Primes=SimpleSieve(n);

        for(int i:Primes){
            System.out.print(i+" ");
        }
        System.out.println();

        int l=110, r=130;

        ArrayList<Integer> SegPrimes=SegmentedSieve(l,r);

        for(int i:SegPrimes){
            System.out.printf(i+" ");
        }
        System.out.println();
        int kthPrime=KthPrime(10001);
        System.out.println(kthPrime);

        int primeFactor=73;
        int minmPrimeFactorCount=minmPrimeFactor(primeFactor);
        System.out.println(minmPrimeFactorCount);
    }
}