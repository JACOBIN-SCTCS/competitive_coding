class Solution {
    public boolean isValid(String s)
    {
        char[] st = new char[s.length()];
        int top=-1;
        
        int idx=0;
        while(idx<s.length())
        {
            st[++top] = s.charAt(idx);
            idx+=1;
            if(top>=2 && st[top]=='c' && st[top-1]=='b' && st[top-2]=='a')
            {
                top-=3;
            }
        }
        if(top!=-1)
            return false;
        else
            return true;
    }
}
