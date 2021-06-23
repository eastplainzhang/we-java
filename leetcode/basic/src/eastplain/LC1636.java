package eastplain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-06 16:51
 */
public class LC1636 {
}


class FrequencySort {

    // 重写hashmap的排序
    public int[] method_hashmap(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //转化为Integer[] 数组
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        //自定义排序
        Arrays.sort(arr, (o1, o2) -> map.get(o1).equals(map.get(o2)) ? o2 - o1 : map.get(o1) - map.get(o2));

        //转化为int[] 数组
        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }

    // 桶排序
    public int[] method_bucket(int[] nums) {

        int[] count = new int[201];

        for (int num : nums) {
            count[num + 100] += 1;
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = 201 * count[nums[i] + 100] - nums[i] + 100;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = 100 - nums[i] % 201;
        }

        return nums;
    }
}
