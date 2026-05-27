class Solution {
public:
    int numberOfSpecialChars(string word) {
        
        int n = word.length();
        vector<int> caps(26, n);
        vector<int> small(26,-1);


        for(int i=0; i < n; ++i) {
            char c = word[i];
            int offset = 0;
            if(isupper(c)) {
                offset = c - 'A';
                caps[offset]  = min(caps[offset], i );
            }
            else {
                offset = c - 'a';
                small[offset] = max(small[offset],i);
            }
        }

        int count = 0;
        for(int i=0; i < 26; ++i) {
            if(small[i] != -1 &&  caps[i] != n) {
                if(small[i] <= caps[i])
                    count+=1;
            }
        }

        return count;

    }
};
