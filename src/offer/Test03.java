package offer;

import java.util.HashSet;

/**
 * 剑指offer第3题
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test03 {
    /**
     * 1.顺序查找法
     * 空间 O(n)，时间 O(n)
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        // 使用额外的空间存储数字
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])) {
                // 找到了之前出现过的数字，直接返回
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        // 全部都遍历了，没有返回-1
        return -1;
    }

    /**
     * 2.位置置换法
     * 空间 O(1)，时间 O(n)
     * @param nums
     */
    public static int findRepeatNumber2(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            if (nums[start] == start) {
                start++;
                continue;
            }
            // 判断i位置的数字是否与该值相同
            int tmp = nums[start];
            if (nums[tmp] == tmp) {
                return tmp;
            }
            nums[start] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }
}
