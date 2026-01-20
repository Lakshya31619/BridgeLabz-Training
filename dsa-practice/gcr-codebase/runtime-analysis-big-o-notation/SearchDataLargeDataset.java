public class SearchDataLargeDataset {
    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int size = 1_000_000;
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
        int target = size - 1;
        // Linear Search Time
        long startLinear = System.nanoTime();
        int linearResult = linearSearch(data, target);
        long endLinear = System.nanoTime();
        System.out.println("Linear Search Index: " + linearResult);
        System.out.println("Linear Search Time: " + (endLinear - startLinear) + " ns");
        // Binary Search Time
        long startBinary = System.nanoTime();
        int binaryResult = binarySearch(data, target);
        long endBinary = System.nanoTime();
        System.out.println("Binary Search Index: " + binaryResult);
        System.out.println("Binary Search Time: " + (endBinary - startBinary) + " ns");
    }
}