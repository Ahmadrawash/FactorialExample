public class MergeSortArray {
  public void  MergeSortArray(int[] A){
     MergeSort(A, 0, A.length-1);
 }
  void MergeSort(int[] A, int low, int high)
 {
     int mid = (int)(Math.ceil(low + high)/2);
     if (low < high)
     {
         MergeSort(A, low, mid);
         MergeSort(A, mid+1, high);
         merge(A, low, mid, high);
     }
 }
 public void merge(int[] A, int low, int mid, int high)
 {
     int n1 = mid-low;
     int n2 = high-mid;
     int[] fhalf = new int[n1];
     for(int i = low, ind =0 ; i < n1; i++, ind++)
         fhalf[ind] = A[i];
     int[] shalf = new int[n2];
     for(int i = mid+1, ind = 0 ; i < n2; i++, ind++)
         shalf[ind] = A[i];
     int m = 0,  n = 0;
     for(int k = low; k < n1+n2 ; k++)
     {
         if (fhalf[m] < shalf[n])
         {
             A[k] = fhalf[m];
             m++;
         }
         else if (shalf[n] < fhalf[m])
         {
             A[k] = shalf[n];
             n++;
         }
     }
 }
}

