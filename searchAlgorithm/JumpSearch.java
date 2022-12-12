package quanLyNhanVien.searchAlgorithm;

public class JumpSearch {
    public int jumpSearch(int[] arr, int target) {
        int blockSize = (int) Math.sqrt(arr.length);
        int start = 0;
        int next = blockSize;

        while (start < arr.length && target > arr[next - 1]) {
            start = next;
            next = next + blockSize;

            if (next >= arr.length) {
                next = arr.length;
            }
        }

        for (int i = start; i <= next; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        JumpSearch search = new JumpSearch();
        System.out.println(search.jumpSearch(array, 8));
    }
}
