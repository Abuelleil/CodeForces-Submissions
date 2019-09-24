
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;


public class Main implements Comparable<Main> {
    int strength;
    int bonus;

    public Main(int s, int b) {
        this.strength = s;
        this.bonus = b;
    }

    @Override
    public int compareTo(Main m) {
        return this.strength-m.strength;
    }

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
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Main>PQ= new PriorityQueue<>();
        int strength=0;
        int bonus=0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            strength= Integer.parseInt(st1.nextToken());
            bonus= Integer.parseInt(st1.nextToken());
            Main m= new Main(strength, bonus);
            PQ.add(m);
        }
        boolean flag=true;
        for(;PQ.size()>0;){
            if(PQ.peek().strength>=s){
                PQ.remove();
                flag=false;
                break;
            }else {
                s += PQ.remove().bonus;
            }
        }
        if(flag){
            pw.println("YES");
        }else{
            pw.println("NO");
        }
        pw.flush();
    }
}