import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e){ 
                    e.printStackTrace(); 
                }
            }
            return st.nextToken(); 
        }
  
        int nextInt(){ 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong(){ 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble(){ 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ 
                str = br.readLine(); 
            }catch (IOException e){ 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    
    public static boolean prime(int n){
        for(int i=2;i*i<=n;i++){if(n%i==0){return false;}}
        return true;
    }

    static long gcd(long a, long b)
    {return (b == 0) ? a : gcd(b, a % b);} 
    
    public static int numberOfFactors(int num){
        int count=0;
        for(int i=1;i*i<=num;i++){
            if(num%i==0){count+=( (i*i==num) ? 1 : 2);}
        }
        return count;
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader scan=new FastReader(); 
        OutputStream out=new BufferedOutputStream(System.out);
        int t=Integer.parseInt(scan.nextLine());
        for(int i=0;i<t;i++){
            String v= scan.nextLine();
            int a=0,b=0,c=0,current=-1;
            String newStr = "";
            char prev='0';
            List<Integer> list = new ArrayList<Integer>();
            for(int j=0;j<v.length();j++){
                if(v.charAt(j)=='1'){a++;}else
                if(v.charAt(j)=='2'){b++;}else
                if(v.charAt(j)=='3'){c++;}
                if(v.charAt(j)!=prev){
                    prev = v.charAt(j);
                    current++;
                    list.add(1);
                    newStr+=v.charAt(j);
                }else{
                    list.set(current,list.get(current)+1);
                }

            }
            long max=200000;
            long newV =200000;
            for(int j=1;j<list.size()-1;j++){
                if(newStr.charAt(j-1) != newStr.charAt(j+1)){
                    newV = list.get(j)+2;
                }
                if(newV<max){
                    max=newV;
                }
            }
            if(a==0 || b==0 || c==0){
                System.out.println(0);
                continue;
            }else{
                System.out.println(max);
            }
        }
        
    }
}