package eastplain;

public class LC0029 {
    public static void main(String[] args) {
        Divide d = new Divide();
        System.out.println(d.method(-2147483648, -1));
    }
}


class Divide {

    // 用递归做的话，会栈溢出
//    public int method(int dividend, int divisor) {
//
//        if (dividend >= 0 && divisor > 0) {
//            if (dividend < divisor) {
//                return 0;
//            }
//            return 1 + method(dividend - divisor, divisor);
//        }
//        else if (dividend <= 0 && divisor < 0) {
//            return method(-dividend, - divisor);
//        }
//        else {
//            return -method(dividend, -divisor);
//        }
//    }

    public int method(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while(dividend <= divisor) {
            dividend -= divisor;
            result += 1;
        }
        return k ? result : -result;

    }
}