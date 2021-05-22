
class Element
{
    int score;
    int age;
    
    Element(int score, int age)
    {
        this.score =score;
        this.age = age;
    }
}

class CustomComparator implements Comparator<Element>
{
    @Override
    public int compare(Element e1 ,  Element e2)
    {
        if(e1.age==e2.age)
            return Integer.compare(e1.score,e2.score);
        else
            return Integer.compare(e1.age,e2.age);
    }
}


class Solution {
    public int bestTeamScore(int[] scores, int[] ages) 
    {
        Element[] players = new Element[scores.length];
        for(int i=0;i<scores.length;++i)
            players[i] = new Element(scores[i],ages[i]);
            
        Arrays.sort(players,new CustomComparator());
        int[] dp = new int[scores.length];
        
        int ans= Integer.MIN_VALUE;
        for(int i=0;i<players.length;++i)
        {
            dp[i] = players[i].score;
            for(int j=0;j<i;++j)
            {
                if(players[i].score>= players[j].score)
                {
                    dp[i] = Math.max(dp[i], players[i].score + dp[j] );
                }
            }
            ans = Math.max(dp[i],ans);
            
        }
        return ans;
        
    }
}
