package eastplain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-13 11:38
 */
public class LC0547 {

    public static void main(String[] args) {
        int[][] demo = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum().method(demo));
    }
}


class UnionFind {

    private Map<Integer, Integer> father;
    private int numOfSets = 0;

    public UnionFind() {
        father = new HashMap<Integer, Integer>();
        numOfSets = 0;
    }

    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
            numOfSets += 1;
        }
    }

    public int find(int x) {
        int root = x;

        while (father.get(root) != null) {
            root = father.get(root);
        }

        if (x != root) {
            int original_father = father.get(x);
            father.put(x, root);
            x = original_father;
        }

        return root;
    }

    public void merge(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);

        if (root_x != root_y) {
            father.put(root_x, root_y);
            numOfSets -= 1;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getNumOfSets() {
        return numOfSets;
    }
}


class FindCircleNum {

    public int method(int[][] isConnected) {

        UnionFind uf = new UnionFind();

        for (int i = 0; i < isConnected.length; ++i) {
            uf.add(i);
            for (int j = 0; j < i; ++j) {
                if (isConnected[i][j] == 1) {
                    uf.merge(i, j);
                }
            }
        }

        return uf.getNumOfSets();
    }
}
