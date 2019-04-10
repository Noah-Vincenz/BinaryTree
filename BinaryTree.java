import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

public class BinaryTree {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    BinaryTreeNode root = new BinaryTreeNode(30);
    BinaryTreeNode btn1 = new BinaryTreeNode(8);
    BinaryTreeNode btn2 = new BinaryTreeNode(52);
    BinaryTreeNode btn3 = new BinaryTreeNode(3);
    BinaryTreeNode btn4 = new BinaryTreeNode(20);
    BinaryTreeNode btn5 = new BinaryTreeNode(10);
    BinaryTreeNode btn6 = new BinaryTreeNode(29);
    
    Map<Integer, BinaryTreeNode> btnMap = new HashMap<Integer, BinaryTreeNode>();
    btnMap.put(30, root);
    btnMap.put(8, btn1);
    btnMap.put(52, btn2);
    btnMap.put(3, btn3);
    btnMap.put(20, btn4);
    btnMap.put(10, btn5);
    btnMap.put(29, btn6);
    
    btn1.setParent(root);
    btn2.setParent(root);
    btn3.setParent(btn1);
    btn4.setParent(btn1);
    btn5.setParent(btn4);
    btn6.setParent(btn4);
    

    while ((line = in.readLine()) != null) {
      String[] arr = line.split(" ");
      List<Integer> ancestorsOfA = new ArrayList<Integer>();
      List<Integer> ancestorsOfB = new ArrayList<Integer>();
      BinaryTreeNode btnA = btnMap.get(Integer.parseInt(arr[0]));
      BinaryTreeNode btnB = btnMap.get(Integer.parseInt(arr[1]));

      while (btnA.hasParent) {
        ancestorsOfA.add(btnA.parent.getData());
        btnA = btnA.getParent();
      }
      
      while (btnB.hasParent) {
        ancestorsOfB.add(btnB.parent.getData());
        btnB = btnB.getParent();
      }
      int commonAncestor = 1000;
      ancestorsOfA.sort(Comparator.naturalOrder());
      for (int i = 0; i < ancestorsOfA.size(); ++i) {
        if (ancestorsOfB.contains(ancestorsOfA.get(i))) {
          commonAncestor = ancestorsOfA.get(i);
          break;
        }
      }
      if (commonAncestor == 1000) {
        System.out.println("No common ancestor found.");
      } else {
        System.out.println(commonAncestor);
      }
      
    }
  }
}

class BinaryTreeNode {
  
  public BinaryTreeNode parent;
  public int data;
  public boolean hasParent = false;
  
  public BinaryTreeNode(int data) {
    this.data = data;
  }
  
  public void setParent(BinaryTreeNode parent) {
    this.parent = parent;
    hasParent = true;
  }
  
  public int getData() {
    return this.data;
  }
  
  public BinaryTreeNode getParent() {
    return this.parent;
  }
}