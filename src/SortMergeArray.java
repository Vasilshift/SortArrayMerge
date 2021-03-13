import java.sql.Array;
import java.util.*;
public class SortMergeArray {
    public static void Sort(int[] A) {
        if (A.length <= 1) {
            return;
        }
        int leftsize = A.length / 2;
        int rightsize = A.length - leftsize;
        int[] Leftarray = new int[leftsize];
        int[] Rightarray = new int[rightsize];
        System.arraycopy(A, 0, Leftarray, 0, leftsize);
        System.arraycopy(A, leftsize, Rightarray, 0, rightsize);
        Sort(Leftarray);
        Sort(Rightarray);
        SortMerge(A, Leftarray, Rightarray);
    }

    public static void SortMerge(int[] A, int[] Leftarray, int[] Rightarray){
        int leftindex = 0;
        int rightindex = 0;
        int targetindex = 0;
        int remain = Leftarray.length + Rightarray.length;
        while(remain > 0){
            if (leftindex >= Leftarray.length){
                A[targetindex]  = Leftarray[leftindex++];
            }
            else if(rightindex >= Rightarray.length){
                A[targetindex] = Rightarray[rightindex++];
            }
            else if(Leftarray[leftindex] < Rightarray[rightindex]){
                A[targetindex] = Leftarray[leftindex++];
            }
            else {
                A[targetindex] = Rightarray[rightindex++];
            }
            targetindex++;
            remain--;
        }
    }


    public static void main(String[] args) {
        int[] A = {5,2,4,6,3,1,8,3};
        for (int i =0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
          Sort(A);
        System.out.println();
        for (int k =0; k < A.length; k++) {
            System.out.print(A[k] + " ");
        }
    }
}
