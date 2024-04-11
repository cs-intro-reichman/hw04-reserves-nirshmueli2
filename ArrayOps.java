public class ArrayOps {
    public static void main(String[] args) {
        int[] array = new int[] { 0, 1, 2, 4, 5, 3, 8, 9, 6 };
        int ans = findMissingInt(array);
        System.out.println(ans);

        int[] otherarray = new int[] { 3, 1, 23, 4, 52, 3, 3, 9, 52, 100, 101 };
        int ans2 = secondMaxValue(otherarray);
        System.out.println(ans2);

        int[] array1 = new int[] { 0, 1, 2, 2, 3, 4 };
        int[] array2 = new int[] { 2, 1, 0, 4, 3, 5 };
        boolean ans3 = containsTheSameElements(array1, array2);
        System.out.println(ans3);

        boolean ans4 = isSorted(array1);
        System.out.println(ans4);

    }

    public static int findMissingInt(int[] array) {
        int curNum = -1;
        int prevchar = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                curNum = 0;
            }
        }
        if (curNum != 0) {
            return 0;
        }
        for (int j = 0; j < array.length; j++) {
            for (int u = 0; u < array.length; u++) {
                if (array[u] == curNum + 1) {
                    curNum++;
                    break;
                }
            }
            if (prevchar == curNum) {
                return (prevchar + 1);
            }
            prevchar++;
        }
        return -1;
    }

    public static int secondMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] newarray = remove(array, max);
        int secondmax = newarray[0];
        for (int i = 1; i < newarray.length; i++) {
            if (newarray[i] > secondmax) {
                secondmax = newarray[i];
            }
        }
        return secondmax;
    }

    public static int[] remove(int[] arr, int element) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                count++;
            }
        }
        int[] ans = new int[arr.length - count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element) {
                ans[index] = arr[i];
                index++;
            }
        }
        return ans;
    }

    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        boolean side1 = containedintheother(array1, array2);
        boolean side2 = containedintheother(array2, array1);
        boolean both = side1 && side2;
        return both;
    }

    public static boolean containedintheother(int[] array1, int[] array2) {
        boolean ans = false;
        for (int i = 0; i < array1.length; i++) {
            for (int u = 0; u < array2.length; u++) {
                if (array1[i] == array2[u]) {
                    ans = true;
                    break;
                } else {
                    ans = false;
                }
            }
            if (!ans) {
                return ans;
            }
        }
        return ans;
    }

    public static boolean isSorted(int[] array) {
        boolean DecreasingTest = isDecreasing(array);
        boolean increasingTest = isIncreasing(array);
        boolean answer = DecreasingTest || increasingTest;
        return answer;

    }

    public static boolean isDecreasing(int[] array) {
        boolean Decreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                Decreasing = false;
                break;
            }
        }
        return Decreasing;
    }

    public static boolean isIncreasing(int[] array) {
        boolean increasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                increasing = false;
                break;
            }
        }
        return increasing;
    }

}
