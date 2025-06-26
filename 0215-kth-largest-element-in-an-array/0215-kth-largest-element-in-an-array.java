class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]); // Adding to the heap
            if(pq.size() > k) pq.poll(); 
// If elements are more than size K, then the extra element gets popped out. 
// This way, there are always K elements maintained in the heap, out of which the top would be the Kth Largest element.
        }
        return pq.peek(); // Return Kth Largest Element
    }
}
/**
TC: O(N log K)
SC: O(K)
*/