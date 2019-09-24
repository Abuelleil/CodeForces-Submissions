
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
        double k=Double.parseDouble(st.nextToken());
        k=k/100;
        double [] arr= new double [n];
        StringTokenizer st1= new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st1.nextToken());
        }
        double hi=1000;
        double lo=0;
        double ans=0;
        for(int i=0;i<100;i++){
            double sum=0;
            double mid=(hi+lo)/2;
            for(int j=0;j<arr.length;j++){
                if(arr[j]>mid){
                    sum+=arr[j] - mid;
                }
            }
            sum-=sum*k;
            for(int z=0;z<arr.length;z++){
                if(arr[z]<mid){
                    sum-=mid-arr[z];
                }
            }
            if(sum>=0){
                lo=mid;
                ans=mid;
            }else
                hi=mid;
        }
        pw.println(ans);
        pw.flush();

    }
}