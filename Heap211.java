import java.util.Arrays;

public class Heap211 {
    int size; 
    int[] heap; 
    Heap211() {
        //deafault size of 30, 1 extra because index starts at 1        
    	heap = new int[31]; 
        size = 0;
    }
    int parent(int index) {
    	return index / 2;
    }
    int leftChild(int index) {
    	return index * 2;
    }     
    int rightChild(int index) {
        return index * 2 + 1;
    }     
    boolean hasParent(int index) {
        return index > 1;
    }
    boolean hasLeftChild(int index) {
        return leftChild(index)<= size;
    }
    boolean hasRightChild(int index) {       
        return rightChild(index) <= size;
    }
    void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }


	
	public void add(int value) {

	    
	    heap[size + 1] = value;  // add as rightmost leaf (the end)
	    if(size+1>= heap.length) {
	    	heap = Arrays.copyOf(heap, heap.length*2);
	    }
	    // "bubbling up" as necessary to fix ordering
	    int index = size + 1;
	    boolean found = false;
	    while (!found && hasParent(index)) {
	        int parent = parent(index);
	        if (heap[index] < heap[parent]) {
	            swap(heap, index, parent(index));
	            index = parent(index);
	        } else {
	            found = true;  // found proper location; stop
	        }
	    }
	    size++;
	}
	public int remove() {   // precondition: queue is not empty
	    int result = heap[1];      // last leaf -> root
	    heap[1] = heap[size];
	    size--;
	    int index = 1;    // "bubble down" to fix ordering
	    boolean found = false;
	    while (!found && hasLeftChild(index)) {
	        int left = leftChild(index);
	        int right = rightChild(index);
	        int child = left;
	        if (hasRightChild(index) &&
	                heap[right] < heap[left]) {
	            child = right;
	        }
	        if (heap[index] > heap[child]) {
	            swap(heap, index, child);
	            index = child;
	        } else {
	            found = true;  // found proper location; stop
	        }
	    }
	    return result;
	}



}
