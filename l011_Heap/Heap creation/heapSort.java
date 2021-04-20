public class heapSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean compareTo(int a, int b, boolean isMax){
        if(isMax) return a > b;
        else return a < b;
    }

    public static void heapify(int pi, int[] arr, int li, boolean isMax){
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2; 

        if()
    }
    
}
