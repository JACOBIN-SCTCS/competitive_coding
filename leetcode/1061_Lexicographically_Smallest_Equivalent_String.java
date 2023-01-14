class Unionfind
{
    int[] parent = new int[26];

    Unionfind()
    {
        for(int i=0;i<26;++i)
        {
            parent[i] = i;
        }
    }

    public int find(int i)
    {
        while(parent[i]!=i)
            i = parent[i];
        
        return i;
    }

    public void union(int i, int j)
    {
        int parent_i = this.find(i);
        int parent_j = this.find(j);

        if(parent_i == parent_j)
            return;
        
        if(parent_i < parent_j)
        {
            parent[parent_j] = parent_i;
        }
        else
        {
            parent[parent_i] = parent_j;
        }
    }

}


class Solution 
{
    public String smallestEquivalentString(String s1, String s2, String baseStr) 
    {
        Unionfind uf = new Unionfind();

        for(int i=0;i<s1.length();++i)
        {
            int char1 = (int) s1.charAt(i)-'a';
            int char2 = (int) s2.charAt(i)-'a';

            uf.union(char1,char2);
        }     
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();++i)
        {
            char replacement = (char)( 'a' + uf.find(baseStr.charAt(i)-'a'));
            sb.append(replacement);
        }
        return sb.toString();
    }
}
