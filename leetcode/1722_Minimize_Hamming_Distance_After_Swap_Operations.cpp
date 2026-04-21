// Referred editorial for the hints to solve the problem.
class UnionFind {
    public:
        int n;
        vector<int> parent;
        vector<int> rank;
    
        UnionFind(int n) {
            this->n = n;
            parent.resize(n,0);
            rank.resize(n,0);
            for(int i=0; i < n ; ++i) {
                parent[i] = i;
            }
        }

        int find_oper(int x) {
            if(parent[x] != x) {
                parent[x] = this->find_oper(parent[x]);
            } 
            return parent[x];
        }

        void union_oper(int x, int y) {
            x = this->find_oper(x);
            y = this->find_oper(y);

            if(x == y)
                return;
            
            if(rank[x] < rank[y]) 
                swap(x,y);
            
            parent[y] = x;
            if(rank[x] == rank[y]) 
                rank[x] ++;
        }
};

class Solution {
    
    public:
        int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
            
            int n = source.size();
            UnionFind uf(n);

            for(int i=0; i < allowedSwaps.size(); ++i) {
                uf.union_oper(allowedSwaps[i][0], allowedSwaps[i][1]);
            }

            unordered_map<int,unordered_map<int,int>> sets;
          
            for(int i=0; i < n ; ++i) {
                int f = uf.find_oper(i);
                sets[f][source[i]]++;
            }

            int ans = 0 ;
            for(int i =0; i < n ; ++i) {
                int f = uf.find_oper(i);
                if(sets[f][target[i]] > 0) {
                    sets[f][target[i]]--;
                }
                else {
                    ans +=1;
                }
            }

            return ans;
        }
};
