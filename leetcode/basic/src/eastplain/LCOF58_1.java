package eastplain;

public class LCOF58_1 {

    public static void main(String[] args) {

        ReverseWorld r = new ReverseWorld();
        String demo = new String("   hello  java leetcode world   ");
        System.out.println(r.method(demo));
    }
}


class ReverseWorld {

    public String method(String s) {

        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) {
            if(strs[i].equals("")) {
                continue;
            }
            res.append(strs[i] + " ");
        }
        return res.toString().trim();

    }
}
