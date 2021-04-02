class AuthenticationManager {

    int ttl;
    HashMap<String,Integer> map = new HashMap<>();
    
    public AuthenticationManager(int timeToLive) 
    {   
        this.ttl = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime)
    {
        map.put(tokenId,currentTime+this.ttl);
        
    }
    
    public void renew(String tokenId, int currentTime) 
    {
        if(map.containsKey(tokenId) && map.get(tokenId)> currentTime)
            map.put(tokenId,currentTime+this.ttl);    
    }
    
    public int countUnexpiredTokens(int currentTime) {
        
        map.entrySet().removeIf(x -> x.getValue() <= currentTime);
        return map.size();
    }
}


