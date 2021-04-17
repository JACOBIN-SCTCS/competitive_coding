class DisjointSet
{
    int[] components;
    
    DisjointSet()
    {
        components = new int[26];
        for(int i=0;i<26;++i)
            components[i]=i;
    }
    
    public int  find(int a)
    {
        if(components[a]==a)
            return a;
        else
            return find(components[a]);
    }
    
    public void union(int a, int b)
    {
        int repa = find(a);
        int repb = find(b);
        if(repa==repb)
            return;
        
        components[repa] = repb;
    }
    
    public boolean checkComponent(int a , int b)
    {
        int repa = find(a);
        int repb = find(b);
        if(repa==repb)
            return true;

        return false;
    }
}

class Solution 
{
    public boolean equationsPossible(String[] equations) 
    {
        DisjointSet set = new DisjointSet();
        for(int i=0;i<equations.length;++i)
        {
            int chara = equations[i].charAt(0)-'a';
            int charb = equations[i].charAt(3)-'a';
            if(equations[i].charAt(1)== '=')
            {
              
                set.union(chara,charb);
            }
           
        }
        
        for(String str:equations)
        {
            if(str.charAt(1)=='!')
            {
                int chara = str.charAt(0)-'a';
                int charb = str.charAt(3)-'a';
                if(set.checkComponent(chara, charb))
                    return false;
            }
        }
        
        return true;
    }
}
