/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;



class Permutations{
    public static void main(String args[]) throws Exception {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String s = br.readLine();
		int n = Integer.parseInt(s);
		String input_string = br.readLine().replaceAll("\\s","");
		//System.out.println(input_string);

		Queue<String> q = new LinkedList<>();
		HashMap<String,Integer> map = new HashMap<>();
		map.put(input_string,0);
		q.add(input_string);

		
		
		char[] characters = new char[n];
		for(int i=0;i<input_string.length();++i)
		{
			characters[i] = input_string.charAt(i);

		}

		Arrays.sort(characters);
		String sorted_string = new String(characters);
		//System.out.print(sorted_string);

		
		


		
		while(!q.isEmpty())
		{
			String curr = q.remove();
			if(curr.equals(sorted_string))
				break;

			for(int i=1;i<curr.length();++i)
			{
				


				characters = curr.toCharArray();
				int ptri=0;
				int ptrj=i;
				char tmp;
				while(ptri<=ptrj)
				{
						tmp = characters[ptrj];
						characters[ptrj] = characters[ptri];
						characters[ptri]=tmp;
						ptrj--;
						ptri++;
				}

				String modified_string = new String(characters);
				if(!map.containsKey(modified_string))	
				{
					map.put(modified_string,map.get(curr)+1);
					q.add(modified_string);
				}	




				/*for(int j=i+1;j<curr.length();++j)
				{
					characters = curr.toCharArray();
					int ptrj=j;
					int ptri=i;
					
					char tmp;

					while(ptri<=ptrj)
					{
						tmp = characters[ptrj];
						characters[ptrj] = characters[ptri];
						characters[ptri]=tmp;
						ptrj--;
						ptri++;
					}
					String modified_string = new String(characters);
					if(!map.containsKey(modified_string))	
					{
						map.put(modified_string,map.get(curr)+1);
						q.add(modified_string);
					}			
				}*/




			}

		}

		System.out.print(map.get(sorted_string));
		


    }
}

