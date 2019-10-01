
import org.omg.CORBA.Any;

import java.util.*; // Needed for level-order print routine
/**
 * BinaryTree class
 * 
 * Implements an unbalanced binary tree - this is not a search tree.
 * @author mccauleyr
 * Modified by Shaina Mainar
 * HW5 Summer 2018
 *
 * @param <AnyType>
 */
public class BinaryTree<AnyType> extends HW5_AbstractClass<AnyType> {

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }

    /** The tree root - the tree class instance variable. */
    private BinaryNode<AnyType> root;

    // Create an empty binary tree
    public BinaryTree() {
    	root = null;
    }
    
    public BinaryTree(AnyType rootElement) {
    	root = new BinaryTree.BinaryNode<AnyType>(rootElement);
    }
    
    // Build a binary tree from existing binary trees, adding a new root value
    // Either or both subtrees could be null
    public BinaryTree(AnyType rootElement, BinaryTree<AnyType> leftTree, BinaryTree<AnyType> rightTree) {
    	 root = new BinaryTree.BinaryNode<>(rootElement, leftTree.root, rightTree.root);
    }

    @Override
    public void printTreeInOrder() {
        printTreeInOrder(root);
    }

    private void printTreeInOrder(BinaryTree.BinaryNode<AnyType> t){
        if(t!=null){
            printTreeInOrder(t.left);
            System.out.println(t.element);
            printTreeInOrder(t.right);
        }
    }

    @Override
    public void printTreePostOrder() {
        printTreePostOrder(root);

    }
    private void printTreePostOrder(BinaryTree.BinaryNode<AnyType> t){
        if(t != null){
            printTreePostOrder(t.left);
            printTreePostOrder(t.right);
            System.out.println(t.element);
        }
    }


    @Override
    public int size() {
        return size(root);
    }

    //adds left side and right side of tree as well as root
    private int size(BinaryTree.BinaryNode<AnyType> t){
        if(t == null)
            return 0;
        return size(t.left) + size(t.right) + 1;
    }
    @Override
    public int depth(AnyType x) {
        return depth(root, x, 0);
    }
    //added level for iteration purposes
    private int depth(BinaryTree.BinaryNode<AnyType> t, AnyType x, int level) {
        //Assuming root is level 0, if node is null return 0
        if (t == null)
            return 0;
        //return level if the element equals the value we are trying to find
        if (t.element.equals(x))
            return level;
        //find left before finding right.
        int count = depth(t.left, x, level + 1);
        if (count != 0)
            return count;
        return depth(t.right, x, level + 1);

    }
    
    /* 
     * Public interface to preorder traversal - uses private
     * recursive helper method to accomplish job.
     */
    public void printTreePreOrder () {
    	printTreePreOrder(root);
    }
    
    /**
     * private recursive method to print tree contents in preorder
     * @param t
     */
    private void printTreePreOrder(BinaryTree.BinaryNode<AnyType> t) {
    	if (t != null) {
    		System.out.println(t.element); // assumes element printable
    		printTreePreOrder(t.left);
    		printTreePreOrder(t.right);
    	}
    }

    /**
     * Internal method to compute height of a subtree.
     * Outsiders currently cannot access this method.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    /**
     * Does a level-order traversal, printing out a tree that looks
     * something like a tree
     */
    public void printTreeLevelOrder() {
    	printTreeLevelOrder(root);
    }

    /** 
     * Output all nodes, level by level
     * @ param node - the node that roots the current subtree
     */
    private void printTreeLevelOrder(BinaryNode<AnyType> node) {
    	System.out.println("\n============ Start of tree ============");
        if (node == null) {
           System.out.print(" - ");
        }
        else {
          //Queue that holds the nodes on the current level
          Queue<BinaryNode<AnyType>> thisLevel = new LinkedList<>();
          //Queue that holds the nodes on the next level
          Queue<BinaryNode<AnyType>> nextLevel = new LinkedList<>(); 
          //put the root on the current level's queue
          thisLevel.add(node);
          int h = height(root);
          int levelTotal = 0;  //keeps track of the total levels printed so we don't  pass the height and print a billion "null"s
          while(!thisLevel.isEmpty()&& (levelTotal<= h))
          {

              while (!thisLevel.isEmpty()) // print nodes at current level
              {
                 if (thisLevel.peek() != null)
                 {
                    System.out.print(thisLevel.peek().element + " ");
                    // if there is a left pointer , put on next level; if none, put a null
                    node = thisLevel.peek().left; // look at the left pointer of node
                    nextLevel.add(node); 
                    node = thisLevel.remove().right; // get right pointer and remove node
                    nextLevel.add(node); 
                 }
                 else
                 {
                    System.out.print(" - ");
                    nextLevel.add(null); 
                    nextLevel.add(null);
                    thisLevel.remove();
                 }
              }  // end while (!thisLevel.isEmpty())
              // Moving to the next level, copy nodes to thisLevel so we know to 
              // advance level count and line in output
              while (!nextLevel.isEmpty())
              {
                    thisLevel.add(nextLevel.remove());
              } // end while (!nextLevel.isEmpty()
              System.out.println(); 
              levelTotal++;
          } // end while(!thisLevel.isEmpty()&& (levelTotal<= h))
        System.out.println("=========== end of tree ============="); // an extra line feed to separate this prinout of from next
      }

    }


}
