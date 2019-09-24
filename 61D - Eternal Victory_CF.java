
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;


public class Main {
        int end;
        int cost;
        public Main(int end, int cost){
            this.end=end;
            this.cost=cost;
        }
//    public static int[] mergesort(int l, int r) { //O(nlogn)
//        if (l == r) return new int[]{arr[l]};
//        int mid = l + r >> 1;
//        int[] left = mergesort(l, mid);
//        int[] right = mergesort(mid + 1, r);
//        int[] result = new int[r - l + 1];
//        int i = 0;
//        int j = 0;
//        int idx = 0;
//        while (i < left.length && j < right.length) {
//            if (left[i] <= right[j]) {
//                result[idx++] = left[i++];
//            } else {
//                result[idx++] = right[j++];
//            }
//        }
//        while (i < left.length) {
//            result[idx++] = left[i++];
//        }
//        while (j < right.length) {
//            result[idx++] = right[j++];
//        }
//        return result;
//    }
    public static ArrayList<Main> [] arrlist;
    public static int [] arr;
    public static boolean vis[];
    public static long sum;
    public static int dfs(int u){
        vis[u]=true;
        int ans=0;
        for(Main v:arrlist[u]){
            if(!vis[v.end]){
                ans=Math.max(ans,dfs(v.end)+v.cost);
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        arrlist = new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            arrlist[i] = new ArrayList<>();
        }
        sum=0L;
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            sum += cost;
            arrlist[start].add(new Main(end, cost));
            arrlist[end].add(new Main(start, cost));
        }
        pw.println(2*sum-dfs(0));
        pw.flush();
    }
}
