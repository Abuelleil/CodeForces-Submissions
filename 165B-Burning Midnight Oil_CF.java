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
    public static int N;
    public static int [] arr;
    public static int  ans;
    public static int tracks;
    public static int [] list;
    public static PrintWriter pw;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int lo=0;
        int hi= (int) 1e9;
        int mid=0;
        int ans=0;
        while(hi>=lo) {
            mid = (hi + lo) / 2;
            int sum=0;
            for (int j = 0; mid /(int) Math.pow(k, j) != 0; j++) {
                sum+=mid / (int)Math.pow(k, j);
            }
            if (sum>=n) {
                hi=mid-1;
                ans=mid;
            } else {
                lo=mid+1;
            }
        }
        pw.println(ans);
        pw.flush();
    }
}