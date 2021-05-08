/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */


class Helper
{
	boolean win(String[] rows, char symbol)
	{	
		for(int i=0;i<3;++i)
		{
			if(rows[i].charAt(0)==symbol && rows[i].charAt(1)==symbol && rows[i].charAt(2)==symbol)
				return true;
			if(rows[0].charAt(i)==symbol && rows[1].charAt(i)==symbol && rows[2].charAt(i)==symbol)
				return true;
		}
		if(rows[0].charAt(0)==symbol && rows[1].charAt(1)==symbol && rows[2].charAt(2)==symbol)
			return true;
		if(rows[0].charAt(2)==symbol && rows[1].charAt(1)==symbol && rows[2].charAt(0)==symbol)
			return true;

		return false;

	}
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Helper h = new Helper();
		while(t>0)
		{
			String[] rows = new String[3];
			rows[0] = br.readLine();
			rows[1] = br.readLine();
			rows[2] = br.readLine();
			
			int x_count=0;
			int o_count=0;
			for(int i=0;i<3;++i)
				for(int j=0;j<rows[i].length();++j)
				{
					if(rows[i].charAt(j)=='X')
						x_count+=1;
					 if(rows[i].charAt(j)=='O')
						o_count+=1;
				}

			if(x_count!=o_count &&  x_count!=(o_count+1))
				System.out.println(3);
			else
			{
				boolean p1_win = h.win(rows,'X');
				boolean p2_win = h.win(rows,'O');
				if(p1_win && p2_win)
				{
					System.out.println(3);
				}
				else if(p1_win || p2_win)
				{
					if(p1_win && x_count==(o_count+1))
						System.out.println(1);
					else if(p2_win && x_count==o_count)
						System.out.println(1);
					else
						System.out.println(3);
				}	
				else if(x_count+o_count==9)
				{
					System.out.println(1);
				}
				else
				{
				    System.out.println(2);
				}
			}


			t-=1;
		}
	}
}

