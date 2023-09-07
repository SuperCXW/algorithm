package org.cxw;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 司诚
 * @description 两数之和 第一题 经常想不起来
 * 说明意识不到位
 * @date 2023/9/7
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                continue;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}
