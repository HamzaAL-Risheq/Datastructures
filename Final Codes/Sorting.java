package FinalProject;

public class Sorting {
	public static void selectionSort(int arr[]) {
		int min = 0, index = 0;
		for (int i = 0; i < arr.length - 1; i++) { // For loop to move on all the array indexes.
			for (int j = i; j < arr.length; j++) { // For loop to find the minimum from current index to end of the
													// array.
				if (j == i) {
					min = arr[i]; // Initialize minimum value.
					index = j;
				} else if (arr[j] < min) { // If a smaller element is found, update minimum value and index.
					min = arr[j];
					index = j;
				}
			}
			if (index != i) { // If the minimum value is not at the current index so do swap operation.
				int swap = arr[i];
				arr[i] = arr[index];
				arr[index] = swap;
			}
		}
	}

	public static void merge(int left[], int right[], int arr[]) {
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nL && j < nR) { // Merge elements from left and right arrays in sorted order.
			if (left[i] <= right[j]) { // If element in left array is smaller or equal add it to the merged array.
				arr[k] = left[i];
				i++;
			} else { // If element in right array is smaller, add it to the merged array
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < nL) { // Add remaining elements from left array to the merged array
			arr[k] = left[i];
			arr[k] = left[i];
			k++;
			i++;
		}
		while (j < nR) { // Add remaining elements from right array to the merged array
			arr[k] = right[j];
			k++;
			j++;
		}
	}

	public static void mergeSort(int arr[]) {
		int n = arr.length;
		if (n < 2) // Base case: If array size is less than 2, it is already sorted
			return;
		int mid = n / 2;
		int left[] = new int[mid];
		int right[] = new int[n - mid];
		for (int i = 0; i <= mid - 1; i++)
			left[i] = arr[i]; // Copy elements from start to mid-1 into the left subarray.

		for (int i = mid; i <= n - 1; i++)
			right[i - mid] = arr[i]; // Copy elements from mid to end into the right subarray.
		mergeSort(left); // Recursively sort the left subarray.
		mergeSort(right); // Recursively sort the right subarray.
		merge(left, right, arr); // Merge the sorted left and right subarrays.
	}

	public static void generateArray(int arr[], int size, int flag) {
		// flag = 1 means sorted
		// flag = 0 means reversely sorted
		if (flag == 1) {
			for (int i = 0; i < size; i++)
				arr[i] = i;
		} else {
			for (int i = size; i > 0; i--)
				arr[size - i] = i;
		}
	}

	public static void main(String[] args) {
		int arr5000Sorted[] = new int[5000];
		generateArray(arr5000Sorted, 5000, 1);
		int arr5000Unsorted[] = new int[5000];
		generateArray(arr5000Unsorted, 5000, 0);

		int arr50000Sorted[] = new int[50000];
		generateArray(arr50000Sorted, 50000, 1);
		int arr50000Unsorted[] = new int[50000];
		generateArray(arr50000Unsorted, 50000, 0);

		int arr500000Sorted[] = new int[500000];
		generateArray(arr500000Sorted, 500000, 1);
		int arr500000Unsorted[] = new int[500000];
		generateArray(arr500000Unsorted, 500000, 0);

		////////////////////////////////////////////////
		//////////// Selection Sort ////////////
		////////////////////////////////////////////////
		System.out.println("******************************************************");
		System.out.println("**************Time to run Selection Sort**************");
		System.out.println("******************************************************");
		// time to sort array 5000 sorted using selection
		long startTime = System.nanoTime();
		selectionSort(arr5000Sorted);
		long elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 5000 sorted using selection sort in millis: " + elapsedTime / 1000000);

		// time to sort array 5000 unsorted using selection
		startTime = System.nanoTime();
		selectionSort(arr5000Unsorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 5000 unsorted using selection sort in millis: " + elapsedTime / 1000000);

		// time to sort array 50000 sorted using selection
		startTime = System.nanoTime();
		selectionSort(arr50000Sorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 50000 sorted using selection sort in millis: " + elapsedTime / 1000000);

		// time to sort array 50000 unsorted using selection
		startTime = System.nanoTime();
		selectionSort(arr50000Unsorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out
				.println("Time to sort array 50000 unsorted using selection sort in millis: " + elapsedTime / 1000000);

		// time to sort array 500000 sorted using selection
		startTime = System.nanoTime();
		selectionSort(arr500000Sorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 500000 sorted using selection sort in millis: " + elapsedTime / 1000000);

		// time to sort array 500000 unsorted using selection
		startTime = System.nanoTime();
		selectionSort(arr500000Unsorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out
				.println("Time to sort array 500000 unsorted using selection sort in millis: " + elapsedTime / 1000000);

		////////////////////////////////////////////////
		//////////// Merge Sort ////////////
		////////////////////////////////////////////////

		System.out.println("******************************************************");
		System.out.println("**************Time to run Merge Sort**************");
		System.out.println("******************************************************");

		// time to sort array 5000 sorted using merge
		startTime = System.nanoTime();
		mergeSort(arr5000Sorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 5000 sorted using merge sort in millis: " + elapsedTime / 1000000);

		// time to sort array 5000 unsorted using merge
		startTime = System.nanoTime();
		mergeSort(arr5000Unsorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 5000 unsorted using merge sort in millis: " + elapsedTime / 1000000);

		// time to sort array 50000 sorted using merge
		startTime = System.nanoTime();
		mergeSort(arr50000Sorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 50000 sorted using merge sort in millis: " + elapsedTime / 1000000);

		// time to sort array 50000 unsorted using merge
		startTime = System.nanoTime();
		mergeSort(arr50000Unsorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 50000 unsorted using merge sort in millis: " + elapsedTime / 1000000);

		// time to sort array 500000 sorted using merge
		startTime = System.nanoTime();
		mergeSort(arr500000Sorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 500000 sorted using merge sort in millis: " + elapsedTime / 1000000);

		// time to sort array 500000 unsorted using merge
		startTime = System.nanoTime();
		mergeSort(arr500000Unsorted);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time to sort array 500000 unsorted using merge in millis: " + elapsedTime / 1000000);

	}
}
