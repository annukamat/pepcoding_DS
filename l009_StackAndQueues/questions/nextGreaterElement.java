public class nextGreaterElement {

    public static int[] ngor(int[] arr){
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i=0; i<n; i++){
            while(st.size() != 0 && arr[st.getFirst()] < arr[i]){
                ans[st.removeFirst()] = arr[i];
            }   
            st.addFirst(i);
            }

    return ans;
    }


    public static int[] ngol(int[] arr){
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i=n-1; i>=0; i--){
            while(st.size() != 0 && arr[st.getFirst()] < arr[i]){
                ans[st.removeFirst()] = arr[i];
            }   
            st.addFirst(i);
            }

    return ans;
    }

    public static int[] nsor(int[] arr){
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        
        for(int i=0; i<n; i++){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }   
            st.addFirst(i);
            }

    return ans;
    }


    public static int[] nsol(int[] arr){
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i=n-1; i>=0; i--){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }   
            st.addFirst(i);
            }
        return ans;
    }

    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        int[] rt = nsor(heights);
        int[] lt = nsol(heights);

        for(int i=0; i<n; i++){
            int h = heights[i];
            int w = rt[i] - lt[i] - 1;      //  b - a - 1
            area = Math.max(area, w * h);
        }
        return area;
    }


}

