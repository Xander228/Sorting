package sorting;


public class QuickSort
{
    
    public QuickSort()
    {     
    }
    
    public void sort(int[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }
    
    public void sort(int[] arr, int startIndex, int endIndex)
    {
        
        int pivotIndex = (int)Math.floor(Math.random()*(endIndex + 1 - startIndex) + startIndex);
        int pivot = arr[pivotIndex];
        
        arr[pivotIndex] = arr[endIndex];
        arr[endIndex] = pivot;
        
        int indexA = startIndex;
        int indexB = endIndex;
        
        while (indexA != indexB) 
        {
            if (arr[indexA] > pivot){
                indexB--;
                int temp = arr[indexB];
                arr[indexB] = arr[indexA];
                arr[indexA] = temp;
            } else indexA++;
        }
        
        if (indexB - 1 != endIndex)
        {
            int temp = arr[indexB];
            arr[indexB] = arr[endIndex];
            arr[endIndex] = temp;
        }
        
        if (indexA - startIndex > 1) sort(arr, startIndex, indexA - 1);
        if (endIndex - indexB > 1) sort(arr, indexB + 1, endIndex);
    }
}
