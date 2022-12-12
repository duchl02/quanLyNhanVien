package quanLyNhanVien.searchAlgorithm;

public class TernarySearch {
    public int ternarySearch(int[] arr, int start, int end, int target) {
        int mid1;
        int mid2;
        do {
            mid1 = start + (end - start) / 3;
            mid2 = end - (end - start) / 3;

            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }
            if (target < arr[mid1]) {
                end = mid1 - 1;
            } else if (target > arr[mid2]) {
                start = mid2 - 1;
            } else {
                start = mid1 + 1;
                end = mid2 - 1;
            }
        } while (start <= end);
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        TernarySearch search = new TernarySearch();
        System.out.println(search.ternarySearch(array, 0, array.length - 1, 4));
    }
}
