import java.util.Random;

public class app {
  public static void main(String[] args) {
    printNode(treeBuild(10), "");
  }

  static void printNode(Node node, String sp) {
    if (node != null) {
      System.out.println(sp + node.value);
      printNode(node.right, sp + "--");
      printNode(node.left, sp + "--");
    }
  }

  static Node treeBuild(int n) {
    Node node = null;
    if (n == 0)
      return node;
    else {
      node = new Node(new Random().nextInt(100));
      node.left = treeBuild(n / 2);
      node.right = treeBuild(n - n / 2 - 1);
    }
    return node;
  }


}


class RedBlackTree {
  Node root;

  private boolean addNode(Node node, int value) {
    if (node.value == value) {
      return false;
    } else {
      if (node.value > value) {
        if (node.left != null) {
          boolean result = addNode(node.left, value);
          node.left = rebalance(node.left);
          return result;
        } else {
          node.left = new Node();
          node.left.color = Color.RED;
          node.left.value = value;
        }
      } else {
        if (node.right != null) {
          boolean result = addNode(node.right, value);
          node.right = rebalance(node.right);
          return result;
        } else {
          node.right = new Node();
          node.right.color = Color.RED;
          node.right.value = value;
          return true;
        }
    }
  }
}

class Node {
  int value;
  Color color;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
  }  

  public Node() {
    this.value = -1;
  }  

  @Override
  public String toString() {
      
      return "Node {" + 
          "value=" + value +
          ", color=" + color +
          "}";
  }
}

enum Color {
  RED, BLACK
}
