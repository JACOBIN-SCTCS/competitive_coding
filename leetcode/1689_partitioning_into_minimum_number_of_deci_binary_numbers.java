class Solution {
    public int minPartitions(String n) 
    {
        int max_num  = 0;
        for(int i=0;i<n.length();++i)
        {
            int num = n.charAt(i)-'0';
            max_num = Math.max(num,max_num);
        }
        return max_num;
    }
}
