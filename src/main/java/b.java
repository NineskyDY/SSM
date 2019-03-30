import java.util.Arrays;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-09 21:17
 */
public class b {
    int test (int n,int m,int[] a){
        int count = 0;
        int [] b = new int[m+1];
        for(int i=0;i<m+1;i++){
            b[i] = -1;
        }
        int i = 0;
        int min ;
        int max = 0;
        while (i<n&&count<m){
            if(a[i]!=0){
                if(b[a[i]] ==-1) {
                    count++;}
                b[a[i]] = i;
                if(i>max) max = i;
            }
            i++;
        }


        if(i == n) return -1;
        Arrays.sort(b);
        min = b[1];
        return max-min+1;
    }
    public static void main(String[] args) {
        a a = new a();
        int q =a.test(12,5,new int[]{2,5,3,1,3,2,4,2,0,5,1,2});
        System.out.println(q);
    }

}
