import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;


public class Main {
    //        public static void sort(int[] arr, int l, int r) { //O(nlogn)
//        if(l > r) return;
//        int mid = l + (r - l)/2; // = (l+r)/2
//        sort(arr, l, mid - 1);
//        sort(arr, mid, r);
//     merge(arr, l, mid, r);
//    }
//
//        public static void merge(int[] arr, int l, int mid, int r) { //O(n)
//        int size1 = l + mid;
//        int size2 = r - mid;
//        int[] a = new int[size1];
//        int[] b = new int[size2];
//        int k = l;
//        for (int i = 0; i < size1; i++) {
//            a[i] = arr[k++];
//        }
//        for (int i = 0; i < size2; i++) {
//            b[i] = arr[k++];
//        }
//        k = l;
//        int i = 0, j = 0;
//    }
//    static int [][]grid;
    public static int id;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>PQ= new PriorityQueue<>();
        ArrayList<String> AL= new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st1= new StringTokenizer(br.readLine());
            int a=0;
            String  s=st1.nextToken();
            if(s.equals("insert")){
                a=Integer.parseInt(st1.nextToken());
                PQ.add(a);
                AL.add("insert "+a);
            }else if(s.equals("removeMin")){
                if(!PQ.isEmpty()) {
                    PQ.remove();
                }else {
                    AL.add("insert "+1);

                }
                AL.add("removeMin");
            }else if(s.equals("getMin")) {
                a = Integer.parseInt(st1.nextToken());
                while (!PQ.isEmpty() && PQ.peek() < a) {
                    PQ.remove();
                    AL.add("removeMin");
                }
                if (PQ.isEmpty() || !(PQ.peek() == a)) {
                    AL.add("insert " + a);
                    PQ.add(a);
                }
                AL.add("getMin " + a);
            }
        }
        pw.println(AL.size());
        for(String s: AL){
            pw.println(s);
        }
        pw.flush();
    }
}