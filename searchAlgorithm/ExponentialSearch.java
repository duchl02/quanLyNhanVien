package quanLyNhanVien.searchAlgorithm;
public class ExponentialSearch extends BinarySearchs {
    public int exponentialSearch(int arr[], int target){
        int i = 1;

        while (i < arr.length && target > arr[i]){
            i = i * 2;
        }

        return binarySearch(arr, i/2, Math.min(i, arr.length -1), target);
    }

    public static void main(String[] args){
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        ExponentialSearch search = new ExponentialSearch();
        System.out.println(search.exponentialSearch(array,8));
    }
}
