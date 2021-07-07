class Element
{
    int x;
    int y;
    
    Element(int x , int y)
    {
        this.x = x;
        this.y = y;
    }
}



class Solution {
    public String alphabetBoardPath(String target) 
    {
        HashMap<Character,Element> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx<26)
        {
            int x = idx/5;
            int y = idx%5;
            char character = (char)(idx+'a');
            map.put(character,new Element(x,y));
            idx+=1;
        }
        int startx = 0;
        int starty = 0 ;
        for(int i=0;i<target.length();++i)
        {
            char current = target.charAt(i);
            Element e = map.get(current);
            
            int dx = e.x - startx;
            int dy = e.y - starty;
            
            char vertical = 'D';
            char horizontal = 'R';
            if(dx<0)
                vertical='U';
            if(dy<0)
                horizontal = 'L';
            
            int x_inc = Math.abs(dx);
            int y_inc = Math.abs(dy);
            if(current=='z')
            {
                while(y_inc>0)
                {
                    sb.append(horizontal);
                    y_inc-=1;
                }
                while(x_inc>0)
                {
                    sb.append(vertical);
                    x_inc-=1;
                        
                }
            }
            else
            {
                while(x_inc>0)
                {
                    sb.append(vertical);
                    x_inc-=1;
                }
                while(y_inc>0)
                {
                    sb.append(horizontal);
                    y_inc-=1;
                }
            }
            sb.append('!');  
            startx=e.x;
            starty=e.y;
        }
        
        return sb.toString();
    }
}
