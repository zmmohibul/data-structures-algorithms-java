public class MergeSort {
    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int[] result = new int[arr1.length + arr2.length];
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i += 1;
            } else {
                result[k] = arr2[j];
                j += 1;
            }
            k += 1;
        }

        if (i < arr1.length) {
            while (i < arr1.length) {
                result[k] = arr1[i];
                k += 1;
                i += 1;
            }
        }

        if (j < arr2.length) {
            while (j < arr2.length) {
                result[k] = arr2[j];
                k += 1;
                j += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 5, 9, 31};
        int[] arr2 = new int[] {3, 4, 7, 11};

        int[] result = merge(arr1, arr2);

        for (int item : result) {
            System.out.println(item);
        }

    }
}
