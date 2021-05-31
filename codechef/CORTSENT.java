/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        int t;
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        
        while(t>0)
        {
            String[] s = br.readLine().split("\\s+");
            int k = Integer.parseInt(s[0]);
            
            int idx=1;
            while(idx<=k)
            {
                String curr = s[idx];
                boolean lana = false;
                boolean lanb  = false;
                boolean flag = false;
                char ch = curr.charAt(0);
                if((ch>='A')&&(ch<='M') || (ch>='n' && ch<='z'))
                    break;
                else if(ch>='a' && ch<='m')
                {
                    lana=true;
                    lanb=false;
                }
                else 
                {
                    lana=false;
                    lanb=true;
                }
                for(int i=1;i<curr.length();++i)
                {
                    char current = curr.charAt(i);
                    if((lana &&(current>='N' && current<='Z'))
                        
                        || (lanb &&(current>='a' &&  current<='m'))
                        || (current>='A' && current<='M') || (current>='n' && current<='z')
                    )
                    {
                        flag=true;
                        break;
                    }
                }
                if(flag==true)
                    break;
                idx+=1;
            }
            if(idx<=k)
               System.out.println("NO");
            else
                System.out.println("YES");
                
            t-=1;
        }
	}
}

