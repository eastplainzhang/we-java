package eastplain;

public class LCOF67 {

    public static void main(String[] args) {
        strToInt strToInt = new strToInt();
        System.out.println(strToInt.method("66"));
    }
}


class strToInt {

    public int method(String str) {

        str = str.trim();

        int num = Integer.parseInt(str);
        return num;
    }
}
