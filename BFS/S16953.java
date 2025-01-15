import java.util.*;
import java.io.*;
public class S16953{
	public static long resultcount = (long)Math.pow(10,9)+1;
	 public static void bfs(long num1,long num2, int count ){
         if(num1==num2){resultcount = Math.min(count,resultcount);return;}
         if(num1>num2){return ;}
         bfs(num1*2,num2,count+1);
         bfs(Long.parseLong(Long.toString(num1)+"1"),num2,count+1);
     }

    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());
       
      
        bfs(a,b,0);
        
        if(resultcount==(long)Math.pow(10,9)+1){
             bw.write(Long.toString(-1));
        }else{
            bw.write(Long.toString(resultcount+1));
        }   

        bw.flush();
    }
}