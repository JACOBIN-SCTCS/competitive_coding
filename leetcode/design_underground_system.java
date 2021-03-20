
class CheckInNode
{
    String station;
    int time;
    
    CheckInNode(String station,int  time)
    {
        this.station =station;
        this.time=time;
        
    }
}

class CheckOutNode
{
    int distance;
    int count;
    
    CheckOutNode(int distance,int count)
    {
        this.distance=distance;
        this.count=count;
    }
}


class UndergroundSystem {

    HashMap<Integer,CheckInNode> checkmap= new HashMap<>();
    HashMap<String,CheckOutNode> checkoutmap = new HashMap<>();
    
    public UndergroundSystem() 
    {
        
    }
    
    public void checkIn(int id, String stationName, int t)
    {
        checkmap.put(id,new CheckInNode(stationName,t));    
    }
    
    public void checkOut(int id, String stationName, int t) 
    {
        if(!checkmap.containsKey(id))
            return ;
        
        CheckInNode node = checkmap.remove(id);
        String check_string = node.station+","+stationName;
        
        if(!checkoutmap.containsKey(check_string))
        {
            checkoutmap.put(check_string,new CheckOutNode(t-node.time,1));
        }
        else
        {
            CheckOutNode cout = checkoutmap.get(check_string);
            cout.distance += (t-node.time);
            cout.count+=1;
            checkoutmap.put(check_string,cout);
        }
        
    }
    
    public double getAverageTime(String startStation, String endStation) 
    {
        double result = (double)0;
        String check_string = startStation+","+endStation;
        if(checkoutmap.containsKey(check_string))
        {
           result = ((double)checkoutmap.get(check_string).distance) /checkoutmap.get(check_string).count;  
        }
        return result;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
