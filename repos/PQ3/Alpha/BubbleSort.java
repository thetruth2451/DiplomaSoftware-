public class BubbleSort
{
   public long time;

   int[] sort(int arr[])
   {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
       time = System.nanoTime() - start;
       return arr;
    }
}
