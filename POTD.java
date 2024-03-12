/*1171. Remove Zero Sum Consecutive Nodes from Linked List
Solved
Medium
Topics
Companies
Hint
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
 

Constraints:

The given linked list will contain between 1 and 1000 nodes.
Each node in the linked list has -1000 <= node.val <= 1000 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class POTD {
    public ListNode removeZeroSumSublists(ListNode head) {
      ListNode d = new ListNode(0);
      d.next=head;
      int sum=0;
      Map<Integer,ListNode> hm = new HashMap<>();
      for(ListNode c = d;c!=null;c=c.next){
           sum+=c.val;
            if(hm.containsKey(sum)){
            ListNode pre = hm.get(sum);
            ListNode ford = pre.next;
            int p = sum+(ford!=null?ford.val:0);
           while(p!=sum){
            hm.remove(p);
            ford=ford.next;
            p+=(ford!=null?ford.val:0);
           }
           pre.next=c.next;
         }
          else{
            hm.put(sum,c);
           }
      }
      return d.next;
    }
}

/**public ListNode removeZeroSumSublists(ListNode head) {
        int arr [] = convert(head);
        int brr[] = ans(arr);
        ListNode ans = convertarr(brr);
        return ans;

    }
    public int[] ans(int arr[]){
         int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++){
         int sum =0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                   if(sum!=0){
                  al.add(arr[j]);
                }
            }
        }
        int brr[] = new int[al.size()];
        for(int i=0;i<al.size();i++){
            brr[i]=al.get(i);
        }
        return brr;
    }
    public ListNode convertarr(int arr[]){
        if(arr==null || arr.length==0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }
        return head;

    }
    public int len(ListNode h){
        ListNode t = h;
        int l = 0;
        while(t!=null){
            l++;
            t=t.next;
        }
        return l;
    }

    public int[] convert(ListNode head){
        int arr[] = new int[len(head)];
        int ind=0;
        ListNode cur = head;
        while(cur!=null){
            arr[ind]=cur.val;
            cur=cur.next;
            ind++;
        }
        return arr;
    } */