
public class ISort {

	public static void main(String[] args) {
		int length = args.length;
		int[] numbers = new int[length];

		for (int i = 0; i < length; i++) 
		{
			numbers[i] = Integer.parseInt(args[i]);
		}
		
		InsertionSort(numbers);
		

	}
	
	public static void printArray(int[] array) 
	{
		int l = array.length;
		for(int i = 0; i < l;i++)
		System.out.print(array[i] + " ");
	}
	
	public static void InsertionSort(int[] array) 
	{	
		int l = array.length;
		long start_time = System.nanoTime();
		for (int i = 1; i < l; i++) // We ignore the first element of the array since we consider it 'sorted'
		{	
			int element_to_insert = array[i];
			int empty_position = i;
			
			while(empty_position > 0 && array[empty_position-1] > element_to_insert)
			{
				array[empty_position] = array[empty_position-1];
				empty_position--;
			}
			
			array[empty_position] = element_to_insert;
		}
		long end_time = System.nanoTime();
		long run_time = end_time - start_time;
		printArray(array);
		System.out.println("\ncompleted in " + run_time + "ns");
	}

}
