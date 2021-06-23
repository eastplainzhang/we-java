package eastplain;

public class LC1108 {

    public static void main(String[] args) {
        System.out.println(new DefangIPaddr().method("1.1.1.1"));
    }
}


class DefangIPaddr {

    public String method(String address) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < address.length(); ++i) {
            if (address.charAt(i) == '.') {
                builder.append("[.]");
            }
            else {
                builder.append(address.charAt(i));
            }
        }

        return builder.toString();
    }

}
