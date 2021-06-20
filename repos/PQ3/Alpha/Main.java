import java.util.Arrays;

public class Main
{
    private static int max = 10000000;
    private static int min = 1;

    public static String Comparator(BubbleSort bSort, ShellSort shSort, SelectionSort sSort)
    {
        String name = "";
        if(bSort.time < shSort.time)
        {
            if(bSort.time < sSort.time) {name = "Bubble sort is the fastest method"; }
            else
            { name = "Shell sort is the fastest method"; }
        }
        else
        {
            if(shSort.time < sSort.time) {name = "Shell sort is the fastest method"; }
            else { name = "Selection sort is the fastest method"; }
        }

        return name;
    }

    public int[] returnRandomArray()
    {
        int[] payRoll = new int[100000];
        for(int index = 0; index < 99999; index++)
        {
            payRoll[index] = (int)Math.floor(Math.random()*(max-min+1) + min);
        }

        return payRoll;
    }

    public static void main(String[] args)
    {
        SelectionSort sSort = new SelectionSort();
        BubbleSort bSort = new BubbleSort();
        ShellSort shSort = new ShellSort();
        //Creates an array of employee pay numbers
        long start;
        long time;
        int[] payRollShellSort = new int[100000];
        int[] payRollBubbleSort = new int[100000];
        int[] payRollSelectionSort = new int[100000];

        //Creates the range of random values

        //Populates the array with 100,000 values between max and min
        for(int index = 0; index < 99999; index++)
        {
            payRollShellSort[index] = (int)Math.floor(Math.random()*(max-min+1) + min);
            payRollBubbleSort[index] = payRollShellSort[index];
            payRollSelectionSort[index] = payRollShellSort[index];
        }

        //Calculates time taken using shell sort
        start = System.nanoTime();
        shSort.sort(payRollShellSort);
        time = System.nanoTime() - start;
        shSort.time = time;


        //Calculates time taken using bubble sort
        start = System.nanoTime();
        bSort.sort(payRollBubbleSort);
        time = System.nanoTime() - start;
        bSort.time = time;

        //Calculates time taken sort using selection sort
        start = System.nanoTime();
        sSort.sort(payRollSelectionSort);
        time = System.nanoTime() - start;
        sSort.time = time;

        System.out.println("Selection sort time is: " + sSort.time + " nanoseconds");
        System.out.println("Bubble sort time is: " + bSort.time + " nanoseconds" );
        System.out.println("Shell sort time is: " + shSort.time + " nanoseconds");

        System.out.println("");
        String name = Comparator(bSort,shSort,sSort);
        System.out.println(name);

    }
}
