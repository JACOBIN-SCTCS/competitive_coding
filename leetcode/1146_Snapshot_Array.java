/*

    GAVE MEMORY LIMIT EXCEEDED ERROR
class SnapshotArray {
    
    List<int[]> snapshot;
    int length;
    int times_called = 0;
    public SnapshotArray(int length) 
    {
        snapshot = new ArrayList<int[]>();
        int[] current_snap = new int[length];
        snapshot.add(current_snap);
        this.length= length;
    }
    
    public void set(int index, int val) {
        snapshot.get(snapshot.size()-1)[index] = val;
    }
    
    public int snap() 
    {
        int[] new_snap = new int[this.length];
        for(int i=0;i<snapshot.get(snapshot.size()-1).length;++i)
        {
            new_snap[i] = snapshot.get(snapshot.size()-1)[i];
        }
        snapshot.add(new_snap);
        times_called+=1;
        return (times_called-1);
    }
    
    public int get(int index, int snap_id) {
       
       
        return snapshot.get(snap_id)[index];
    }
}
*/


// Had to refer Editorial for TreeMap
class SnapshotArray {
    
    TreeMap<Integer,Integer>[] map;
    int current_snap_id;

    public SnapshotArray(int length) 
    {
        map = new TreeMap[length];
        for(int i=0;i<length;++i)
        {
            map[i] = new TreeMap<Integer,Integer>();
            map[i].put(0,0);
        }
        current_snap_id = 0;
    }
    
    public void set(int index, int val) 
    {
        map[index].put(current_snap_id,val);
    }
    
    public int snap() 
    {
        current_snap_id+=1;
        return (current_snap_id-1);
    }
    
    public int get(int index, int snap_id) 
    {
        return map[index].floorEntry(snap_id).getValue();

    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
