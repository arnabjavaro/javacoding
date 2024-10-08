package MinHeap;

public class MinHeapImpl {
    int size;
    int[] arr = new int[20];

    public void insertNewValue(int val) {
        arr[size] = val;
        int index = size;
        int parent = (index - 1)/2;

        while(parent >= 0 && arr[parent] > arr[index]) {
            int t = arr[parent];
            arr[parent] = arr[index];
            arr[index] = t;

            t = parent;
            index = parent;
            parent = (t - 1) / 2;
        }

        size++;
    }

    public int peek() {
        return arr[0];
    }

    public int poll() {
        int max = arr[0];
        arr[0] = arr[size -1];
        size = size - 1;
        minHeapify(0);
        return max;
    }

    public void minHeapify(int index) {
        int l, r;
        l = 2 * index + 1;
        r = 2 * index + 2;

        int smallest = index;
        if(l < this.size && arr[l] < arr[smallest]) {
            smallest = l;
        }

        if(r < this.size && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if(smallest != index) {
            int t = arr[smallest];
            arr[smallest] = arr[index];
            arr[index] = t;

            minHeapify(smallest);
        }
    }

    public void buildMinHeap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;

        for(int i = size/2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }
}
