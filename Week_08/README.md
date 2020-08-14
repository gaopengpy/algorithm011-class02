本周主要学习了位运算、布隆过滤器和LRU缓存以及排序算法

1.冒泡排序
public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {1, 0, 3, 4, 5, -6, 10, 9, 8, 7};
    System.out.println("原始数据: " + Arrays.toString(arr));

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    System.out.println("冒泡排序: " + Arrays.toString(arr));
  }
}


2.选择排序
public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {1, 0, 3, 4, 5, -6, 10, 9, 8, 7};
    System.out.println("原始数据: " + Arrays.toString(arr));

    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
    System.out.println("选择排序: " + Arrays.toString(arr));
  }
}

3.插入排序
public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = {1, 0, 3, 4, 5, -6, 10, 9, 8, 7};
    System.out.println("原始数据: " + Arrays.toString(arr));

    for (int i = 0; i < arr.length; i++) {

      int preIndex = i - 1;
      int current = arr[i];

      while (preIndex >= 0 && arr[preIndex] > current) {
        arr[preIndex + 1] = arr[preIndex];
        preIndex--;
      }
      arr[preIndex + 1] = current;
    }
    System.out.println("插入排序: " + Arrays.toString(arr));
  }
}

4.希尔排序
public class ShellSort {

  public static void main(String[] args) {
    int[] arr = {1, 0, 3, 4, 5, -6, 10, 9, 8, 7};
    System.out.println("原始数据: " + Arrays.toString(arr));

    int len = arr.length;
    for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
      for (int i = 0; i < len; i++) {
        int j = i;
        int current = arr[i];
        while (j - gap >= 0 && current < arr[j - gap]) {
          arr[j] = arr[j - gap];
          j = j - gap;
        }
        arr[j] = current;
      }
    }

    System.out.println("希尔排序: " + Arrays.toString(arr));
  }
}


5.归并排序
public class MergeSort {
  public static void main(String[] args) {

    int[] arr = {1, 0, 3, 4, 5, -6, 10, 9, 8, 7};
    System.out.println("原始数据: " + Arrays.toString(arr));

    customMergeSort(arr, 0, arr.length - 1);

    System.out.println("归并排序: " + Arrays.toString(arr));
  }

  public static void customMergeSort(int[] a, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      // 对左侧子序列进行递归排序
      customMergeSort(a, start, mid);
      // 对右侧子序列进行递归排序
      customMergeSort(a, mid + 1, end);
      // 合并
      customDoubleMerge(a, start, mid, end);
    }
  }

  public static void customDoubleMerge(int[] a, int left, int mid, int right) {
    int[] tmp = new int[a.length];
    int p1 = left, p2 = mid + 1, k = left;
    while (p1 <= mid && p2 <= right) {
      if (a[p1] <= a[p2]) tmp[k++] = a[p1++];
      else tmp[k++] = a[p2++];
    }
    while (p1 <= mid) tmp[k++] = a[p1++];
    while (p2 <= right) tmp[k++] = a[p2++];
    // 复制回原素组
    for (int i = left; i <= right; i++) a[i] = tmp[i];
  }
}


6.快速排序
public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
    System.out.println("原始数据: " + Arrays.toString(arr));
    customQuickSort(arr, 0, arr.length - 1);
    System.out.println("快速排序: " + Arrays.toString(arr));
  }

  public static void customQuickSort(int[] arr, int low, int high) {
    int i, j, temp, t;
    if (low >= high) {
      return;
    }
    i = low;
    j = high;
    temp = arr[low];
    while (i < j) {
      // 先看右边，依次往左递减
      while (temp <= arr[j] && i < j) {
        j--;
      }
      // 再看左边，依次往右递增
      while (temp >= arr[i] && i < j) {
        i++;
      }
      t = arr[j];
      arr[j] = arr[i];
      arr[i] = t;
    }
    arr[low] = arr[i];
    arr[i] = temp;
    // 递归调用左半数组
    customQuickSort(arr, low, j - 1);
    // 递归调用左半数组
    customQuickSort(arr, j + 1, high);
  }
}


