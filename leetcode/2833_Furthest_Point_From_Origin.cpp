class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {

        int l_count =0 ;
        int r_count = 0; 
        int blanks = 0;

        for(int i=0; i< moves.length(); ++i) {
            if(moves[i] == 'L') 
                l_count+=1;
            else if (moves[i]== 'R') 
                r_count +=1;
            else 
                blanks+=1;
        }

        return ((max(l_count, r_count) + blanks) - (min(l_count, r_count)));
        
    }
};
