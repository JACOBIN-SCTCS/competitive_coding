
class Trie {
    public:
        Trie* children[26];
        bool isLeaf;

        Trie() {
            isLeaf = false;
            for(int i=0; i < 26; ++i) 
                children[i] = nullptr;
        }
};

void insertWord(Trie* trie, string word) {

    Trie* ptr = trie;
    for(char w: word) {
        int idx = w-'a';
        if(ptr->children[idx] == nullptr)
            ptr->children[idx] = new Trie();
    
        
        ptr = ptr->children[idx];

    }
    ptr->isLeaf = true;
}

bool search(Trie* trie, string word, int editLeft, int idx, int n) {
    
    if(idx == n)
        return true;
    
    char c = word[idx];

    bool res = false;
    if(trie != nullptr) {
        for(int i=0; i < 26; ++i) {
            char character = 'a' + i;
            if(c== character) {
                res = res || search(trie->children[i], word, editLeft,idx+1,n);
            }
            else {
                if(trie->children[i] != nullptr) { 
                    if(editLeft <= 0)
                        return false;
                    else {
                        res = res || search(trie->children[i], word, editLeft-1,idx+1,n);
                    }
                }
            }
        }

    }
    
    return res;
}


class Solution {
    public:
        vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) 
        {
            Trie* trie = new Trie();

            for(int i=0; i < dictionary.size(); ++i) {
                insertWord(trie, dictionary[i]);
            }
            int n = dictionary[0].size();
            vector<string> ans ; 

            for(int i=0; i< queries.size(); ++i) {
                string query = queries[i];
                bool res = search(trie, query, 2, 0, n);
                if(res) {
                    ans.push_back(query);
                }
            }

            return ans;
        }
};
