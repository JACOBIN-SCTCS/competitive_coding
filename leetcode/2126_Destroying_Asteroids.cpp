class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        
        sort(asteroids.begin(), asteroids.end());
        long running_mass = mass;
        for(int i=0 ; i < asteroids.size(); ++i) {
            if(running_mass >= asteroids[i]) {
                running_mass+= asteroids[i];
            }
            else {
                return false;
            }
        }
        return true;

    }
};
