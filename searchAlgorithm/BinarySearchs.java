package quanLyNhanVien.searchAlgorithm;

public class BinarySearchs {
    public int binarySearch(int[] arr, int start, int end, int target){
        int mid ;
        do {
            mid = (end + start) / 2;
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] < target){
                // start = mid + 1;
                return binarySearch(arr, mid + 1, end, target);
            } else if(arr[mid] > target){
                // end = mid - 1;
                return binarySearch(arr, start, mid - 1, target);

            }
        } while (start < end);
        return -1;
    }

    public static void main(String[] args){
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        BinarySearchs search = new BinarySearchs();
        System.out.println(search.binarySearch(array,0, array.length - 1 ,8));
    }
}
