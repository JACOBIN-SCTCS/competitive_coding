class Solution {
    public int compress(char[] chars) 
    {
        if(chars.length==1)
        {
            chars[0] = chars[0];
            return 1;
        }
        
        char current_character = chars[0];
        int current_character_count = 1;
        int total_character_count = 0;

        int ptr = 1;
        int trackptr = 0;
        while(ptr < chars.length)
        {
            if(chars[ptr]==chars[ptr-1])
            {
                current_character_count+=1;
            }
            else
            {
                chars[trackptr] = chars[ptr-1]; 
                trackptr+=1;
                total_character_count +=1;

                if(current_character_count>1)
                {
                    int tmp = current_character_count;
                    while(tmp>0)
                    {
                        int digit_count = 0;
                        while(tmp>0)
                        {
                            digit_count+=1;
                            tmp/=10;
                        }
                        tmp = current_character_count;
                        for(int i=digit_count-1;i>=0;i--)
                        {
                            int digit = tmp%10;
                            tmp = tmp/10;
                            chars[trackptr + i] = (char)('0'+ digit);
                            total_character_count +=1;

                        }
                        trackptr = trackptr+digit_count;
                    }
                }
                current_character_count = 1;

            }
            ptr+=1;
        }
        chars[trackptr] = chars[ptr-1]; 
        trackptr+=1;
        total_character_count +=1;
        int tmp = current_character_count;
        while(tmp > 1) 
        {
            int digit_count = 0;
            while(tmp>0)
            {
                digit_count+=1;
                tmp/=10;
            }
            tmp = current_character_count;
            for(int i=digit_count-1;i>=0;i--)
            {
                int digit = tmp%10;
                tmp = tmp/10;
                chars[trackptr + i] = (char)('0'+ digit);
                total_character_count +=1;

            }
            trackptr = trackptr+digit_count;
        }

        return total_character_count;
    }
}
