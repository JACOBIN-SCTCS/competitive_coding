class Solution {
    public String convertToTitle(int columnNumber) 
    {
        StringBuilder sb = new StringBuilder();
        int temp = columnNumber;

        while(temp > 0)
        {
            temp -=1;
            int reminder  = (temp) % 26 ;
            sb.append((char)( reminder + 'A'));
        
            temp = temp / 26;
        }   

        String ret = sb.reverse().toString();
        return ret; 
    }
}
