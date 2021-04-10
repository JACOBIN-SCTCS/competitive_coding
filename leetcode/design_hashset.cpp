class MyHashSet {
public:
    /** Initialize your data structure here. */
    bitset<1000001> map;
    
    MyHashSet()
    {
    }
    
    void add(int key) {
        
        map.set(key);
    }
    
    void remove(int key) {
        
        map.reset(key);
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) 
    {
        if(map.test(key))
            return true;
        else
            return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
