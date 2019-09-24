
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;


public class Main {

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
    public static ArrayList<Integer>[] arrlist;
    public static int [] arr;
    public static boolean vis[];
    public static int dfs(int u){
        vis[u]=true;
        int ans=0;
        for(int v:arrlist[u]){
            if(!vis[v]){
                ans=Math.max(ans,dfs(v)+1);
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
        ArrayList<Integer>boss= new ArrayList<>();
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            arrlist[i] = new ArrayList<>();
        }
        //System.out.println(n);
       for(int i=0;i<n;i++){
           int x=Integer.parseInt(br.readLine());
           if(x!=-1){
               arrlist[x-1].add(i);
           }else{
               boss.add(i);
           }
       } int ans=0;
       for(int j=0;j<boss.size();j++){
           ans=Math.max(ans,dfs(boss.get(j))+1);
       }
       pw.println(ans);
        pw.flush();
    }
}