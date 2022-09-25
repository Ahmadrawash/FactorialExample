
public class Sort {
    public static void main(String args[])
    {
        int array[] = { 2, 10, 3, 5, 1};
        MergeSortArray msa = new MergeSortArray();
        PrintArray(array);
        msa.MergeSortArray(array);
        PrintArray(array);
    }
    public static void PrintArray(int[] a)
    {
        for (int i: a) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
