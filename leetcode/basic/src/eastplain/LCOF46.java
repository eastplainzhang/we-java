package eastplain;

public class LC0F46 {

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(25));
    }
}


class TranslateNum {

    public int translateNum(int num) {

        String s = String.valueOf(num);
        char[] c = s.toCharArray();

        int[] store = new int[c.length + 1];
        store[0] = 1;
        store[1] = 1;

        for (int i = 2; i < store.length; i++) {
            int flag = 0;
            int temp_1 = Integer.parseInt(String.valueOf(c[i - 2]));
            int temp_2 = Integer.parseInt(String.valueOf(c[i - 1]));
            if (temp_1 != 0 && temp_1 * 10 + temp_2 <= 25) {  // temp_1 != 0要注意  否则 506 这样的测试用例不能通过
                flag = 1;
            }
            store[i] = store[i - 1] + flag * store[i - 2];
        }

        return store[store.length - 1];
    }

}
