import java.util.*;

class NthRoot
{


double solve(int root , int num)
{
  
  
  double start=0.0;
  double end=(double)num;
  double middle=((start+end)/2.0);
  double val=1.0;
  while(val >0.05)
  {
    double prod=1.0;
    for(int i=0;i<root;i++)
    {
      
      prod=prod*middle;
    }
    val=Math.abs(num-prod);
    if(prod>num)
    {
     end=middle; 
     middle=(start+end)/2.0;
    }
    else
    {
      
      start=middle; 
      middle=(start+end)/2.0;
      
    }
    
    
  }
  
  return middle;
  
  
  
}
	/*
	double solve(int n , int num)
	{
		double result = (double) num;
		double start = 0d;
		double end = result;
		double mid=0d;
		while(Math.abs(Math.pow(mid,n) - result)> 0.01)
		{
			mid = (start+end)/2;

			if(Math.pow(mid,n)==result)
			{
				break;
			}

			if(Math.pow(mid,n)> result)
			{
				end = mid;
			}
			else
			{
				start = mid;
			}

		}
		return mid;




	}

	*/



	public static void main(String args[])
	{

		NthRoot obj = new NthRoot();
		int n=4;
		int num = 500;
		double ans = obj.solve(n,num);
		System.out.println(ans+" ");

	}
}
