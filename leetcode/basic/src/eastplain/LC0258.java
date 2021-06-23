package eastplain;

/**
 * LC0258
 * 20201205
 * Time     100
 * Storage  83
 */
public class LC0258 {

    public static void main(String[] args) {
        AddDigits a = new AddDigits();
        System.out.println(a.method(157));
    }
}


class AddDigits {

    public int method(int num) {  // 使用循环的方法
        int sum = 0;
        while (num > 9) {
            num = add(num);
        }
        return num;
    }

    public int add(int num) {
        int sum = 0;
        while (num > 9) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }
}
