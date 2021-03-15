public class Codec {

    
    HashMap<String,String> map = new HashMap<>();
    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    
    int counter=0;
 
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) 
    {
      
        counter+=1;
        int tmp=counter;
        char c1 = upperAlphabet.charAt(tmp%26); tmp/=26;
        char c2 = lowerAlphabet.charAt(tmp%26); tmp/=26;
        char c3 = numbers.charAt(tmp%10); tmp/=10;
        char c4 = lowerAlphabet.charAt(tmp%26); tmp/=26;
        char c5 = upperAlphabet.charAt(tmp%26); tmp/=26;
        
        String shorten_url = new String("http://tinyurl.com/"+ c1+" "+c2+" "+ c3+" "+" "+c4+" "+c5);
        map.put(shorten_url,longUrl);
        return shorten_url;
        
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) 
    {
        return map.get(shortUrl);    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
