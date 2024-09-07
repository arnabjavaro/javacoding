package MaxHeap;

public class MaxHeapImpl {
    int size;
    int[] arr = new int[20];

    public void insertNewValue(int val) {
        arr[size]=val;
        int index=size;
        int parent=(size-1)/2;

        while(parent>=0 && arr[parent]<arr[index]){
            int temp=arr[parent];
            arr[parent]=arr[index];
            arr[index]=temp;

            temp=parent;
            index=parent;
            parent=(temp-1)/2;
        }
        size++;
    }

    public int getMax() {
        return arr[0];
    }

    public int removeMax() {
        int max=arr[0];
        arr[0]=arr[size-1];
        size=size-1;
        maxHeapify(0);
        return max;
    }

    public void maxHeapify(int index) {
       int l,r;
       l=2*index+1;
       r=2*index+2;
       int largest=index;
       if(l<size && arr[l]>arr[largest]){
           largest=l;
       }
       if(r<size && arr[r]>arr[largest]){
           largest=r;
       }
       if(largest!=index){
           int temp=arr[largest];
           arr[largest]=arr[index];
           arr[index]=temp;
           maxHeapify(largest);
       }
    }

    public void buildMaxHeap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;

        for(int i = size/2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }
}
