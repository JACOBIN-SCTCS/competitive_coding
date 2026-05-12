class Solution {
public:

    bool canFinishTasks(int energy, vector<vector<int>> & tasks) {
        for(auto it: tasks) {
            if(energy >= it[1]) {
                energy = energy - it[0];
            }
            else {
                return false;
            }
        }
        return true;  
    }

    int minimumEffort(vector<vector<int>>& tasks) {
        
        int high = INT_MAX;
        int low = 1;
        int mid=high;

        sort(tasks.begin(), tasks.end(), [](const vector<int> &a, const vector<int> &b) {
            return (a[1]-a[0]) > (b[1]-b[0]);  // simpler comparison
        });

        while(low < high) {
            mid = low + ((high - low) / 2);
            if(canFinishTasks(mid, tasks)) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
};
