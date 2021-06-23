package eastplain;

public class LCOF64 {
    public static void main(String[] args) {
        SumNums s = new SumNums();
        System.out.println(s.method(5));
    }
}


class SumNums {

    public int method(int n) {
        int temp = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = temp + i + 1;
            temp = ans;
        }
        return ans;
    }
}
