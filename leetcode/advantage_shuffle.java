
class Node 
{
    int value;
    int index;
    Node(int value,int index)
    {
        this.value = value;
        this.index=index;
    }
}

class NodeComparator implements Comparator<Node>
{
    
    @Override
    public int compare(Node o1, Node o2) {
        
        if(o1.value>o2.value)
            return -1;
        else if(o1.value<o2.value)
            return 1;
            
        return 0;
    }
}

class Solution 
{
    public int[] advantageCount(int[] A, int[] B)
    {
        Arrays.sort(A);
        int last = A.length-1,begin =0;
        
        Node[] list = new Node[B.length];
        for(int i=0;i<B.length;++i)
        {
            list[i] = new Node(B[i],i);
        }
        
        Arrays.sort(list,new NodeComparator());
        int[] result = new int[A.length];
        
        for(int i=0;i<list.length;++i)
        {
            if(A[last]>list[i].value)
            {
                result[list[i].index]=A[last];
                last-=1;
            }
            else
            {
                result[list[i].index] = A[begin];
                begin+=1;
            }
        }
        return result;
        
    }
}
