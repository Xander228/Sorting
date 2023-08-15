package sorting;
import java.util.Arrays;


/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class Test
{
    QuickSort quickSort = new QuickSort();
    MergeSort mergeSort = new MergeSort();
    AlegSort alegSort = new AlegSort();
    BubbleSort bubbleSort = new BubbleSort();
    
    static int testSize = 100000000;
    public static void main(String[] args) 
    {
        Test test = new Test();
        System.out.println("\n\nTesting..."); 
        for (int i = 0; i < 5; i++)
        {
            test.randTest(testSize);
        }
    }

    public Test() 
    {
        
    }
    public void randTest(int testSize) 
    {
        int[] testAnswer = new int[testSize];
        int[] testCase1 = new int[testSize];
        int[] testCase2 = new int[testSize];
        for (int i = 0; i < testSize; i++) 
        {
            testAnswer[i] = i;
            testCase1[i] = i;
        }
        
        for (int i = 0, switchIndex = 0, temp; i < testSize; i++) 
        {
            switchIndex = (int)Math.floor((Math.random() * testSize) );
            temp = testCase1[i];
            testCase1[i] = testCase1[switchIndex];
            testCase1[switchIndex] = temp;
            
        }
        
        for (int i = 0; i < testSize; i++) 
        {
            testCase2[i] = testCase1[i];
        }
        
        long startTime;
        long timeElapsed;
        
        startTime = System.currentTimeMillis();
        quickSort.sort(testCase1);
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("Tested algorithm 1 successfully with array size %s in %s milliseconds\n", testSize, timeElapsed);
        checkForError(testCase1, testAnswer, 1);
        
        startTime = System.currentTimeMillis();
        mergeSort.sort(testCase2);
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("Tested algorithm 2 successfully with array size %s in %s milliseconds\n", testSize, timeElapsed);
        checkForError(testCase2, testAnswer, 2);
        System.out.println();
    }
    
    public void checkForError(int[] testCase, int[] testAnswer, int algNum) 
    {
        if (!Arrays.equals(testCase,testAnswer))
        {
            System.out.printf("Algorithm %s, array size %s, failed\n",algNum, testSize);
            System.out.print("Expected: ");
            for (int i = 0; i < testAnswer.length; i++) 
            {
                System.out.printf("%s,", testAnswer[i]);
            }
            System.out.print("\n Recived: ");
            for (int i = 0; i < testAnswer.length; i++) 
            {
                System.out.printf("%s,", testCase[i]);
            }
            System.out.println();
        }
    }
}
