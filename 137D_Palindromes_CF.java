
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
    static Integer [][]memo;
    static int K;
    static int N;
    static PrintWriter pw;
    static char[] string;

    static int dp(int ind, int K){
        if(ind==N){
            return 0;
        }
        if(memo[ind][K]!=null){
            return memo[ind][K];
        }
        int ans=palindrome(ind, N-1);
        for(int i=ind;i<N && K>0 ;i++){
            int x=palindrome(ind,i);
            ans=Math.min(ans,x+dp(i+1,K-1));
        }
        return memo[ind][K]=ans;
    }
    static int palindrome(int i, int j){
        int counter=0;
        while(j>i){
            if(string[i]!=string[j]){
                counter++;
            }
            j--;
            i++;
        }
        return counter;
    }
    static void print(int ind, int K){
        if(ind==N) {
            return;
        }
        int optimal=dp(ind, K);
        for(int i=ind;i<N;i++){
            int x=palindrome(ind,i);
            int take;
            if(K > 0 && i != N - 1)
                take=x+dp(i+1,K-1);
            else
                take = palindrome(ind, N-1);
            if(optimal==take) {
                int y = ind;
                int z = i;
                String s = "";
                while (z > y) {
                    if (string[z] != string[y]) {
                        string[z] = string[y];
                    }
                    y++;
                    z--;
                }
                for (int f = ind; f <= i; f++) {
                    pw.print(string[f]);
                }
                if (i!=N-1) {
                    pw.print("+");
                }
            }
                if (K > 0)
                    print(ind+1,K-1);
                break;
            }
        }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringBuilder sb= new StringBuilder();
        string= br.readLine().toCharArray();
        N=string.length;
        StringTokenizer st= new StringTokenizer(br.readLine());
        K=Integer.parseInt(st.nextToken());
        K--;
        memo= new Integer[N][K+1];
        pw.println(dp(0,K));
        print(0,K);
        pw.flush();
    }
}
