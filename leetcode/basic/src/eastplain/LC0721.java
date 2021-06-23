package eastplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-13 15:28
 */
public class LC0721 {
}


class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<Integer, String> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < accounts.size(); ++i) {
            if (!map.containsValue(accounts.get(i).get(1))) {
                map.put(i, accounts.get(i).get(1));
            }
        }

        for (int i : map.keySet()) {
            list.add(accounts.get(i));
        }

        return list;
    }
}
