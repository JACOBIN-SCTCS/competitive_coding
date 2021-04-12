#define isVowel(x) (x=='a'||x=='e'||x=='i'||x=='o'||x=='u')

class Solution {
public:
    int maxVowels(string s, int k)
    {
        
        int vowelcount=0;
        
        for(int i=0;i<k;++i)
            if(isVowel(s[i]))
                vowelcount+=1;
        
        
        int maxcount = vowelcount;
        for(int i=k;i<s.size();++i)
        {
            if(isVowel(s[i]))
                vowelcount+=1;
            if(isVowel(s[i-k]))
                vowelcount-=1;
            
            maxcount = max(maxcount,vowelcount);
        }
        return maxcount;
    }
};
