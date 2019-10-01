/**
 * This class is used to test implemented BinaryTree methods
 * Shaina Mainar
 * HW5 Summer 2018
 *
 */

public class HW5 {
    // Test program
    public static void main( String [ ] args ) {
        BinaryTree<String> tree1 = new BinaryTree<>("hello");
        tree1.printTreeLevelOrder();
        BinaryTree<String> tree2 = new BinaryTree<>();
        tree2.printTreeLevelOrder();
        BinaryTree<String> tree3 = new BinaryTree<>("Charleston", tree1, tree2);
        tree3.printTreeLevelOrder();
        tree3 = new BinaryTree<>("there", new BinaryTree<>("America"), tree3);
        tree3.printTreeLevelOrder();
        tree3.printTreePreOrder(); // Can't tell the structure of the tree
        System.out.println("==========================");
        tree3.printTreeLevelOrder();
        System.out.println("Depth of hello is: " + tree3.depth("hello"));
        tree3.printTreeLevelOrder();
        System.out.println("The size of the tree is: " + tree3.size());
        BinaryTree<String> tree4 = new BinaryTree<>("wow", tree2, tree3);
        tree4 = new BinaryTree<>("barbara", new BinaryTree<>("there"), tree4);
        tree4.printTreeLevelOrder();
        System.out.println("The size of the tree is: " + tree4.size());
        System.out.println("Depth of nothing is: " + tree4.depth("nothing"));
        System.out.println("Pre-order");
        tree4.printTreePreOrder();
        System.out.println("%%%%%%%%%%%%%%%^^^^^^%%%%%%%%%%%");
        System.out.println("Post-order");
        tree4.printTreePostOrder();
        System.out.println("%%%%%%%%%%%%%%%^^^^^^%%%%%%%%%%%");
        System.out.println("In order");
        tree4.printTreeInOrder();
        System.out.println("%%%%%%%%%%%%%%%^^^^^^%%%%%%%%%%%");
        //testing an empty tree
        BinaryTree<String> empty = new BinaryTree<>();
        System.out.println("EMPTY TREE");
        empty.printTreeLevelOrder();
        System.out.println("Size of empty tree is: " + empty.size());
        System.out.println("Pre-order");
        empty.printTreePreOrder();
        System.out.println("%%%%%%%%%%%%%%%^^^^^^%%%%%%%%%%%");
        System.out.println("Post-order");
        empty.printTreePostOrder();
        System.out.println("%%%%%%%%%%%%%%%^^^^^^%%%%%%%%%%%");
        System.out.println("In order");
        empty.printTreeInOrder();
        System.out.println("%%%%%%%%%%%%%%%^^^^^^%%%%%%%%%%%");
    }


}
