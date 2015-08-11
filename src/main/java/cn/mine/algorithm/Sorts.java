package cn.mine.algorithm;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Sorts {

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int val = nums[left];
        while (left < right) {

            while (left < right && nums[right] > val) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] <= val) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }

        }
        nums[left] = val;
        return left;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            mergeSortImpl(nums, left, mid, right);
        }
    }

    private static void mergeSortImpl(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, k);
    }

    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        boolean isChange = false;
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[j - 1]) {
                    isChange = true;
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
            if (!isChange)
                break;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 10, 4, 5, 1, 3};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
