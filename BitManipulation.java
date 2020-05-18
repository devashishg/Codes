import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


        public static double log(int x, int base) {
            return (Math.log(x) / Math.log(base));
        }


        public static int reverseBits(int n,int len){
            int an=0;
            for(int i=0;i<len;i++){
                if((n & (1<<i)) != 0){
                    an = an | (1<<len-i-1);
                }
            }
            return an;
        }

        public static int reverseBitsI(int n,int len)
        {
            int leftbit,rightbit;
            for(int i=0;i<len/2;i++){
                if((n & (1<<i)) != 0){ rightbit=1; }else{ rightbit=0; }
                if((n & (1<<(len-i-1))) != 0){ leftbit=1; }else{ leftbit=0; }
                if(leftbit!=rightbit){
                    if(leftbit==0){
                        n = n | (1<<(len-i-1));
                        n = n ^ (1<<i);
                    }else{
                        n = n ^ (1<<(len-i-1));
                        n = n | (1<<i);
                    }
                }
            }
            return n;
        }
        public static int invertBits(int n,int len)
        {
            for(int i=0;i<len;i++){
                if((n & (1<<i)) == 0){
                    n = n | (1<<i);
                }else{
                    n = n ^ (1<<i);
                }
            }
            return n;
        }

        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);
            int n=scan.nextInt();
            int output = reverseBits(n,Integer.toBinaryString(n).length());
            int output1 = reverseBitsI(n,Integer.toBinaryString(n).length());
            int output2 = invertBits(n,Integer.toBinaryString(n).length());
            System.out.println(n + "'s binary :" + Integer.toBinaryString(n));
            System.out.println(n + "'s reverse's binary :" + Integer.toBinaryString(output));
            System.out.println(n + "'s reverse's binary :" + Integer.toBinaryString(output1));
            System.out.println(n + "'s Inversion binary :" + Integer.toBinaryString(output2));

        }
    
}








int convertBit(int num){
    int ans=1;
    while(ans<=num){
        ans=ans<<1;
    }
    ans--;
    return ans^num;
}





int convertBit(int num){
    int ans=0,cnt=0;
    while(num>0){
        int r=num%2;
        ans+=(1-r)*pow(2,cnt);
        cnt++;
        num=num/2;
    }
    return ans;
}






