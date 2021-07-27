package infrastructure;

import java.util.List;

/**
 * 定义 N叉树的结构
 *
 * @author EastPlain
 * @date 2021/7/27 22:38
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
