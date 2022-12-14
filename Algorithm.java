package quanLyNhanVien;

public class Algorithm {

    // Tim kiem tuyen tinh, kiem tra cac phan tu mang cho den khi giong thi thoi
    int linearSearch(int a[], int n, int x) {
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // tim kiem nhi phan
    // int binarySearch(int a[], int n, int x) {
    //     int left = 0, right = n - 1, mid;
    //     do {
    //         mid = (left + right) / 2;
    //         if (a[mid] == x) {
    //             return mid;
    //         } else if (a[mid] <= x){
    //             left = mid + 1;}
    //         else{
    //             right = mid - 1;}
    //     } while (left <= right);
    //     return -1;
    // }

    // tim kiem noi suy
    int interpolationSearch(int a[], int n, int x) {
        int left = 0, right = n - 1, mid;
        do {
            mid = left + (right - left) / (a[right] - a[left]) * (x - a[left]);
            if (a[mid] == x)
                return mid;
            else if (a[mid] <= x)
                left = mid + 1;
            else
                right = mid - 1;
        } while (left <= right);
        return -1;
    }

    // sap xep doi cho - noi bot
    void interchangeSort(int a[]) {
         int j;
         int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    // sap xep chon
    void selectionSort(int a[]) {
        int n = a.length;

        int min;
        int iMin;
        for (int i = 0; i < n - 1; i++) {
            min = a[i];
            iMin = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[iMin]) {
                    min = a[j];
                    iMin = j;
                }
            swap(a, iMin, i);
        }
    }

    void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // thu???t to??n s???p x???p ch??n
    void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // thuat toan sap xep nhanh
    int partition(int arr[], int low, int high) { 
        int pivot = arr[high];
  
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
  
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
            printArray(arr);
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    void quickSort(int arr[], int low, int high) {
        if (low < high) {
  
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
  
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // thuat toan sap xep tron
    void mergeSort(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void msort(int arr[], int l, int r) {
        if (l < r) {
            printArray(arr);

            // T??m ??i???m ch??nh gi???a
            int m = (l + r) / 2;

            // H??m ????? quy ti???p t???c chia ????i
            msort(arr, l, m);
            msort(arr, m + 1, r);

            mergeSort(arr, l,m, r);
        }
    }
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void heapSort(int arr[]) {
        int n = arr.length;

        // X??y d???ng Heap (s???p x???p l???i m???ng)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Tr??ch xu???t t???ng ph???n t??? t??? Heap
        for (int i = n - 1; i > 0; i--) {
            // Di chuy???n root hi???n t???i ?????n end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // g???i max - heapify tr??n Heap ???? s???p x???p
            heapify(arr, i, 0);
        }
    }

    // ????? vun ?????ng m???t c??y con b???t ngu???n t??? n??t i l??
    // m???t ch??? m???c trong arr[]. n l?? k??ch th?????c c???a Heap
    void heapify(int arr[], int n, int i) {
        int largest = i; // Kh???i t???o largest nh?? root
        int l = 2 * i; // left = 2*i
        int r = 2 * i + 1; // right = 2*i + 1

        // N???u n??t con b??n tr??i l???n h??n n??t con c???a g???c
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // N???u n??t con b??n ph???i l???n h??n largest
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // N???u largest kh??ng ph???i l?? root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Vun ?????ng l???i c??c c??y con b??? ???nh h?????ng
            heapify(arr, n, largest);
        }
    }


    public static void main(String[] args) {
        int newArray[] = { 3,1,2,5,7 };
        // int newArray[] = {1,2,3,4,5,6,7,8,9};
        int length = newArray.length;

        printArray(newArray);
        Algorithm ob = new Algorithm();
        ob.msort(newArray,0, length - 1);
        printArray(newArray);

        // System.out.println(ob.interpolationSearch(newArray, newArray.length, 6));

    }
}
