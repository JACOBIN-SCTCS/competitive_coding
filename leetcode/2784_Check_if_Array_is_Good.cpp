class Solution {
public:
    bool isGood(vector<int>& nums) {

        int size = nums.size();    
        int max_element = 0;
        int freq = 0;
        int map[202];


        for(auto it: nums) {
            if(it > max_element) {
                max_element = it;
                freq = 1;
            }
            else if(it == max_element) {
                freq+=1;
            }
            map[it] +=1;
        }


        if(size == (max_element+1) && freq == 2) {
            for(int i=1; i<= max_element; ++i) {
                if(map[i] == 0) 
                    return false;
            }
            return true;
        }

        return false;

    }
};
