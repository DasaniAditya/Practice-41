//Kth largest in a stream

class KthLargest {
    PriorityQueue<Integer> queue;
    int temp;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        for(int i : nums) {
            queue.add(i);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        temp = k;
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size() > temp) {
            queue.poll();
        }
        
        return queue.peek();
        
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 //Add array to form integer
 class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        if(num == null || num.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> list = new ArrayList<Integer>();

		int i = num.length-1;
		int carry = 0;

		while(i >= 0) {
			int temp = k % 10;
			carry = temp + num[i] + carry;
            i--;
			list.add(carry % 10);
			carry /= 10;
			k /= 10;
		}

		while(k > 0){
			int temp = k % 10;
			carry += temp;
			list.add(carry % 10);
			carry /= 10;
			k /= 10;
		}

		if(carry > 0) list.add(carry);
		Collections.reverse(list);
		return list;
    }
}