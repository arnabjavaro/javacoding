package MinHeap;

public class MinHeapApp {
    public static void main(String[] args) {

        MinHeapImpl a = new MinHeapImpl();
        int[] arr = {10, 7, 11, 5, 20, 3, 2, 1};

        a.insertNewValue(arr[0]);
        a.insertNewValue(arr[1]);
        a.insertNewValue(arr[2]);

        System.out.println(a.peek());

        a.insertNewValue(arr[3]);
        a.insertNewValue(arr[4]);
        System.out.println(a.peek());

        a.insertNewValue(arr[5]);
        System.out.println(a.peek());

        a.insertNewValue(arr[6]);
        a.insertNewValue(arr[7]);
        System.out.println(a.peek());

        a.poll();
        System.out.println(a.peek());

        a.buildMinHeap(arr);

    }
}
