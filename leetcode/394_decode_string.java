class Solution {
    public String decodeString(String s) 
    {
        Stack<Integer> counts = new Stack<>();
        Stack<Character> characters = new Stack<>();
        int count =0 ;
        
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                count = count*10 + (s.charAt(i)-'0');
            }
            else if(s.charAt(i)==']')
            {
                int rep = counts.pop();
                String curr = "";
                while(characters.peek()!='[')
                {
                    curr = characters.pop() + curr;
                }
                characters.pop();
                for(int k=0;k<rep;++k)
                {
                    for(int j=0;j<curr.length();++j)
                    {
                        characters.push(curr.charAt(j));
                    }
                }
                
            }
            else
            {
                if(count!=0)
                    counts.push(count);
                count=0;
                characters.push(s.charAt(i));
            }
        }
        
        String final_string="";
        while(!characters.isEmpty())
        {
            final_string = characters.pop() + final_string;
        }
        return final_string;
    }
}
