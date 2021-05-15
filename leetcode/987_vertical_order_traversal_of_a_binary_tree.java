/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.SortedMap;
import java.util.TreeMap;

class Element
{
    int val;
    int x;
    int y;
    
    Element(int val, int x, int y)
    {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}

class ElementComaparator implements Comparator<Element>
{
    @Override
    public int compare(Element e1, Element e2)
    {
        if(e1.x==e2.x)
            return Integer.compare(e1.val,e2.val);
        else
            return Integer.compare(e1.x,e2.x);
    }
}

class Solution {
    
    SortedMap<Integer,List<Element>> map = new TreeMap<Integer,List<Element>>();
     
    public void DFS(TreeNode root, int row, int column)
    {
        if(root==null)
            return ;
        if(map.containsKey(column))
            map.get(column).add(new Element(root.val,row,column));
        else
        {
            List<Element> list = new ArrayList<Element>();
            list.add(new Element(root.val,row,column));
            map.put(column,list);
        }
        
        DFS(root.left,row+1,column-1);
        DFS(root.right,row+1,column+1);
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        DFS(root,0,0);
        
        for(int key:map.keySet())
        {
           
            List<Element> list = map.get(key);
            Collections.sort(list,new ElementComaparator());
            List<Integer> sol_list = new ArrayList<Integer>();
            for(int i=0;i<list.size();++i)
            {
                sol_list.add(list.get(i).val);
            }
            result.add(sol_list);
            
        }
        return result;
    }
}
