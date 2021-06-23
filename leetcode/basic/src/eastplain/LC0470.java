package eastplain;

import java.util.Arrays;

/**
 * LC0470
 * 20201204
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-pao-ying-bi-kai-shi-xun-xu-jian-jin-ba-zhe-da/
 */
public class LC0470 {

    public static void main(String[] args) {

        Coin1 c1 = new Coin1();
        Coin2 c2 = new Coin2();
        TransRand tr = new TransRand();
        System.out.println(Arrays.toString(tr.trans(10000)));
    }
}


/**
 * 抛硬币问题 1
 * 硬币不均匀，产生均匀的结果
 * 例如一枚硬币，抛一次产生0和1的概率分别为0.4和0.6
 * 要求编写一个函数使得产生0和1的概率都是0.5
 */
class Coin1 {

    public int init_coin() {
        if ((int) (Math.random() * 10) > 3) { return 1; }
        else { return 0; }
    }

    public float[] method(int time) {
        int[] count = new int[2];
        float[] ans = new float[2];
        int realtime = 0;
        while (realtime < time) {
            int temp1 = init_coin();
            int temp2 = init_coin();
            if (temp1 == 1 && temp2 == 0) { count[0] += 1; realtime += 1; }
            if (temp1 == 0 && temp2 == 1) { count[1] += 1; realtime += 1; }
        }
        ans[0] = (float) count[0] / time;
        ans[1] = (float) count[1] / time;
        return ans;
    }
}


/**
 * 抛硬币问题 2
 * 硬币均匀，产生不均匀的结果
 * 例如一枚硬币，抛一次产生0和1的概率都是0.5
 * 要求编写一个函数使得产生0和1的概率分别为0.4和0.6
 */
class Coin2 {

    public int init_coin() {
        if ((int) (Math.random() * 10) > 4) { return 1; }
        else { return 0; }
    }

    public float[] method(int time) {
        int[] count = new int[2];
        float[] ans = new float[2];
        int realtime = 0;
        while (realtime < time) {
            int temp1 = init_coin();
            int temp2 = init_coin();
            int temp3 = init_coin();
            if (temp1 == 0 && temp2 == 0 && temp3 == 0) { count[0] += 1; realtime += 1; }
            if (temp1 == 0 && temp2 == 0 && temp3 == 1) { count[0] += 1; realtime += 1; }
            if (temp1 == 0 && temp2 == 1 && temp3 == 0) { count[1] += 1; realtime += 1; }
            if (temp1 == 0 && temp2 == 1 && temp3 == 1) { count[1] += 1; realtime += 1; }
            if (temp1 == 1 && temp2 == 0 && temp3 == 0) { count[1] += 1; realtime += 1; }
        }
        ans[0] = (float) count[0] / time;
        ans[1] = (float) count[1] / time;
        return ans;
    }
}


/**
 * rand7 to rand10
 */
class TransRand {

    public int rand7 () {
        return (int) (Math.random() * 7);
    }

    public float[] trans(int time) {
        float[] ans = new float[10];
        int realtime = 0;
        while (realtime < time) {
            int temp = rand7() * 7 + rand7();
            if (temp < 40) {
                ans[temp % 10] += 1;
                realtime += 1;
            }
        }
        for (int i = 0; i < 10; ++i) {
            ans[i] /= time;
        }
        return ans;
    }
}