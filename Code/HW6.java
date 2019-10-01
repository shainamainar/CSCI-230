/**
 * HW6 Summer 2018
 * Shaina Mainar
 * This class is used to test AvlTree.java
 */
public class HW6 {
    /**
     * Used version 2 of doubleWithRightChild for testing
     *
     */
    public static void main(String[] args) throws UnderflowException{
        AvlTree<Integer> t1 = new AvlTree<>();
        System.out.println("\nADDING TO TREE...");
        for(int i = 0; i < 15; i++){
            t1.insert(i);
            t1.printTreeLevelOrder();
        }
        System.out.println("\n\n\n\n");
        System.out.println("REMOVING FROM TREE");
        int count = 0;
        while(!t1.isEmpty()){
            t1.remove(count);
            t1.printTreeLevelOrder();
            count++;
        }

    }

}
