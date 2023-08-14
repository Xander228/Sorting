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
    MergeSort mergeSort = new MergeSort();
    static int testNumber = 0;
    static int testSize = 20000;
    public static void main(String[] args) 
    {
    Test test = new Test();
    System.out.println("\n\nTesting..."); 
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 200; i++)
    {
        test.randTest(testSize);
    }
    long timeElapsed = System.currentTimeMillis() - startTime;
    System.out.printf("Tested %s cases of size %s in %s milliseconds", testNumber, testSize, timeElapsed); 
    }

    public Test() 
    {
        
    }
    public void randTest(int testSize) 
    {
        this.testNumber++;
        int[] testAnswer = new int[testSize];
        int[] testCase = new int[testSize];
        for (int i = 0; i < testCase.length; i++) 
        {
            testAnswer[i] = i;
            testCase[i] = i;
        }
        for (int i = 0, switchIndex = 0, temp; i < testCase.length; i++) 
        {
            switchIndex = (int)Math.floor((Math.random() * testCase.length) );
            temp = testCase[i];
            testCase[i] = testCase[switchIndex];
            testCase[switchIndex] = temp;
        }
        mergeSort.sort(testCase);
        if (!Arrays.equals(testCase,testAnswer))
        {
            System.out.printf("Random test case %s, size %s, failed\n",this.testNumber, testSize);
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
    public void smallTest() 
    {
        int[] testCase1 = {4,3,6,5,2,1,8,7,9};
        int[] testCase2 = {9,8,7,6,5,4,3,2,1};
        int[] testAnswer = {1,2,3,4,5,6,7,8,9};
        
        mergeSort.sort(testCase1);
        mergeSort.sort(testCase2);
        
        if (Arrays.equals(testCase1,testAnswer)) System.out.println("Small test case 1 correct");
        else 
        {
            System.out.println("Small test case 1 failed");
            System.out.print("Output: ");
            for (int i = 0; i < testAnswer.length; i++) 
            {
                System.out.printf("%s,", testCase1[i]);
            }
            System.out.println();
        }
        if (Arrays.equals(testCase2,testAnswer)) System.out.println("Small test case 2 correct");
        else 
        {
            System.out.println("Small test case 2 failed");
            System.out.print("Output: ");
            for (int i = 0; i < testAnswer.length; i++) 
            {
                System.out.printf("%s,", testCase2[i]);
            }
            System.out.println();
        }
    }
}
