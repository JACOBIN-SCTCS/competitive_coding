#include<bits/stdc++.h>
#include<string>

using namespace std;

int main()
{
	char w[6];
	map<string,int> word_map;
	int index=1;

	for(w[0]='a';w[0]<='z';++w[0])
	{
		w[1]='\0';
		word_map[string(w)]=index;
		index+=1;
		
	}
	


	for(w[0]='a';w[0]<='z'-1;++w[0])
	{
		for(w[1]=w[0]+1;w[1]<='z';++w[1])
		{

			w[2]='\0';
			word_map[string(w)]=index;
			index+=1;

		}
	}




	for(w[0]='a';w[0]<='z'-2;++w[0])
	{
		for(w[1]=w[0]+1;w[1]<='z'-1;++w[1])
		{
			for(w[2]=w[1]+1;w[2]<='z';++w[2])
			{

				w[3]='\0';
				word_map[string(w)]=index;
				index+=1;
			}

		}
	}




	for(w[0]='a';w[0]<='z'-3;++w[0])
	{
		for(w[1]=w[0]+1;w[1]<='z'-2;++w[1])
		{
			for(w[2]=w[1]+1;w[2]<='z'-1;++w[2])
			{
				for(w[3]=w[2]+1;w[3]<='z';++w[3])
				{
						
					w[4]='\0';
					word_map[string(w)]=index;
					index+=1;
				}				
			}

		}
	}






	for(w[0]='a';w[0]<='z'-4;++w[0])
	{
		for(w[1]=w[0]+1;w[1]<='z'-3;++w[1])
		{
			for(w[2]=w[1]+1;w[2]<='z'-2;++w[2])
			{
				for(w[3]=w[2]+1;w[3]<='z'-1;++w[3])
				{
					for(w[4]=w[3]+1;w[4]<='z';++w[4])
					{
						
						w[5]='\0';
						word_map[string(w)]=index;
						index+=1;
					}
				}				
			}

		}
	}







	
	//cout<<word_map["vwxyz\0"];
	
	string input;
	while(cin>>input)
	{
		cout<<word_map[input]<<endl;
	}
	


	
	return 0;
	

}
