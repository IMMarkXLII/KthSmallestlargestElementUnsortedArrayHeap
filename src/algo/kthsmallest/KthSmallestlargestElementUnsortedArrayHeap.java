/**
 * @author ashish.adhikari
 */
package algo.kthsmallest;


/**
 * @author ashish.adhikari
 *
 */
public class KthSmallestlargestElementUnsortedArrayHeap {
	static int[] heap;
	static int heapSize = -1;
	public static void main(String[] args) {
		int arr[] = {12, 3, 5, 7, 19};
	    int n = arr.length, i = 1;
	    for(i=1; i<=5;i++) {
	    	heap = null;
	    	heapSize = -1;
	    	System.out.println("K'th smallest element where k=" + i + " is " + kthSmallest(arr, n, i));
	    }
	}

	/**
	 * @param arr
	 * @param n
	 * @param k
	 * @return
	 */
	private static int kthSmallest(int[] arr, int n, int k) {
		minheap(arr, n);
		int res = -1;
		for (int i=0; i<k; i++) {
//			System.out.println(java.util.Arrays.toString(java.util.Arrays.copyOf(heap, heapSize+1)));
			res = extractMin(arr);
		}
		return res;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int extractMin(int[] arr) {
		
		if(heapSize == -1)
			return -1;
		int root = heap[0];
		heap[0] = heap[heapSize--]; 
		int count = 0;
		while(count <= heapSize/2 && (heap[count] > heap[count*2 +1] || heap[count] > heap[count*2 +2])) {
			if(heap[count*2+1] > heap[count*2+2]) {
				int temp = heap[count];
				heap[count] = heap[count*2+2];
				heap[count*2+2] = temp;
				count = count*2 +2;
			}else {
				int temp = heap[count];
				heap[count] = heap[count*2+1];
				heap[count*2+1] = temp;
				count = count*2 + 1;
			}
		}
		return root;
	}

	/**
	 * @param arr
	 * @param n
	 */
	private static void minheap(int[] arr, int n) {
		heap = new int[n];
		for(int i: arr) {
			insertIntoHeap(i);
		}
	}

	/**
	 * @param i
	 */
	private static void insertIntoHeap(int i) {
		heap[++heapSize] = i;
		
		int count = heapSize;
		while(count >=0 && heap[(count-1)/2] > heap[count]) {
			heap[count] = heap[(count-1)/2];
			count = (count-1)/2;
		}
		if(count != heapSize && count>=0) {
			heap[count] = i;
		}
	}
	
	
}
