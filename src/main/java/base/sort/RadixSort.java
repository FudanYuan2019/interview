package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/19 15:12
 */
public class RadixSort {
    public static void main(String args[]){
        RadixSort radixSort = new RadixSort();
        int[] A = radixSort.radixSort(new int[]{1,2,3,5,2,3}, 6);
        for (int a : A){
            System.out.print(a + " ");
        }
        System.out.println();
    }
    public int[] radixSort(int[] A, int n) {
        // write code here
        if(null==A ||n<2) return A;
        int[] bucket=new int[n]; // 初始化桶个数
        int[] count=new int[10];  //
        for(int i=1;i<=4;i++){
            for(int j=0;j<10;j++){
                count[j]=0;
            }
            for(int j=0;j<n;j++){
                count[getNum(A[j],i)]++;
            }
            for(int k=1;k<10;k++){
                count[k]=count[k]+count[k-1];
            }
            for(int m=n-1;m>=0;m--){
                int num=getNum(A[m],i);
                bucket[count[num]-1]=A[m];
                count[num]--;
            }
            for(int c=0;c<n;c++){
                A[c]=bucket[c];
            }
        }
        return A;
    }
    private int getNum(int x,int d){
        int[] a={1,1,10,100,1000};
        return (x/a[d]%10);
    }
}
