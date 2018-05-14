
public class ISort {

	public static void main(String[] args) {
		int length;
		int[] numbers;

		if (args[0].equals("debug")) {
			length = args.length;
			numbers = new int[length - 1];

			for (int i = 1, j = 0; i < length; i++, j++)
				numbers[j] = Integer.parseInt(args[i]);

			InsertionSortDebug(numbers);
		} else {

			length = args.length;
			numbers = new int[length];

			for (int i = 0; i < length; i++)
				numbers[i] = Integer.parseInt(args[i]);

			InsertionSort(numbers);

		}

	}

	public static void printArray(int[] array) {
		int l = array.length;
		for (int i = 0; i < l; i++)
			System.out.print(array[i] + " ");
	}

	public static void InsertionSort(int[] array) {
		int l = array.length;
		long start_time = System.nanoTime();
		for (int i = 1; i < l; i++) // We ignore the first element of the array since we consider it 'sorted'
		{
			int element_to_insert = array[i];
			int empty_position = i - 1;

			while (empty_position >= 0 && array[empty_position] > element_to_insert) // element compared is greater
			{
				array[empty_position + 1] = array[empty_position]; // shifting elements if they are greater than the current element
				empty_position--;
			}
			// element compared is smaller
			array[empty_position + 1] = element_to_insert;
		}
		long end_time = System.nanoTime();
		long run_time = end_time - start_time;
		printArray(array);
		System.out.println("\ncompleted in " + run_time + "ns");
	}

	public static void InsertionSortDebug(int[] array) {
		int l = array.length;

		long start_time = System.nanoTime();
		// First item is considered sorted
		for (int i = 0; i < l; i++) {
			if (i == 0)
				System.out.print("[" + array[i] + "]" + " ");
			else
				System.out.print(array[i] + " ");
		}
		System.out.print("|\n");

		for (int i = 1; i < l; i++) // We ignore the first element of the array since we consider it 'sorted'
		{
			int element_to_insert = array[i];
			int compared_item = i - 1;
			int copy_compared_item = compared_item;
			
			while(copy_compared_item >= 0) // Write prints here based on conditions
			{	
				if(element_to_insert < array[copy_compared_item])
					{
						for (int j = 0; j < l; j++) {
				
						if (j == i)
							System.out.print("[" + array[j] + "]" + " ");
						else if(j == copy_compared_item)
							System.out.print("i" + array[j] + "i" + " ");
						else
							System.out.print(array[j] + " ");					
						}
						System.out.print("<\n");
						if(copy_compared_item == 0)
						{
							for (int j = 0; j < l; j++) {
								
								if (j == i)
									System.out.print("[" + array[j] + "]" + " ");
								else
									System.out.print(array[j] + " ");					
								}
								System.out.print("|\n");
								break;
						}
						//copy_compared_item--;
					}
				
				if(element_to_insert > array[copy_compared_item]) 
				{
					for (int j = 0; j < l; j++) {
						
						if (j == i)
							System.out.print("[" + array[j] + "]" + " ");
						else if(j == copy_compared_item)
							System.out.print("i" + array[j] + "i" + " ");
						else
							System.out.print(array[j] + " ");
					}
					System.out.print(">\n");
					break;
				}
				
				copy_compared_item--;
					
				
					
				
			}
			while (compared_item >= 0 && array[compared_item] > element_to_insert) // element compared is greater
			{
				array[compared_item + 1] = array[compared_item]; // shifting elements if they are greater than the current element
				compared_item--;
			}
			// element compared is smaller (shifts in to the empty_position
			array[compared_item + 1] = element_to_insert;
			
		}
		long end_time = System.nanoTime();
		long run_time = end_time - start_time;
		printArray(array);
		System.out.println("\ncompleted in " + run_time + "ns");

		}
	}


