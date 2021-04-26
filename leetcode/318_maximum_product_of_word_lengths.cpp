class Solution {
public:
    int maxProduct(vector<string>& words) 
    {
        vector<bitset<26>> bits(words.size());
        for(int i=0;i<words.size();++i)
        {
            bits[i].reset();
            for(int j=0;j<words[i].length();++j)
            {
                bits[i].set(words[i][j]-'a');
            }
        }
        
        bitset<26> t(0);   
        int max_ans =0; 
        for(int i=0;i<words.size();++i)
        {
            for(int j=i+1;j<words.size();++j)
            {
                bitset<26> curr;
                curr = bits[i];
                curr &= bits[j];
                if(curr == t)
                {
                    if(max_ans < words[i].length()*words[j].length())
                    {
                        max_ans = words[i].length()*words[j].length();
                    }
                }
            }
        }
        return max_ans;
    }
};
