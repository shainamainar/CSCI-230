/**
 * Shaina Mainar
 * HW 4 Summer 2018
 * Tests DoublyLinkedList Class
 */
public class HW4 {

    public static void main(String[] args){
        final int HOWMANY = 5;
        // Create a DoubleLinkedList that stores the String type.
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        for(int i = 0; i < HOWMANY; i++){
            linkedList.insertAtFront("insertAtFront method " + (HOWMANY -i));
        }
        linkedList.printContents();
        linkedList.insertAtPosition("*insertAtPosition method at 3rd position", 3);
        System.out.println("!Used insertAtPosition method");
        linkedList.printContents();
        linkedList.addToBack("*addToBack method");
        System.out.println("!Used addToBack method");
        linkedList.printContents();
        System.out.println("!Used peekBack method");
        System.out.println("Back Node: " + linkedList.peekBack());
        linkedList.printContents();
        System.out.println("!Used peekFront method");
        System.out.println("Front Node: " + linkedList.peekFront());
        linkedList.printContents();
        linkedList.removeFromBack();
        System.out.println("!Used removeFromBack method");
        System.out.println("Back Node: " + linkedList.peekBack());
        linkedList.printContents();
        linkedList.removeFromFront();
        System.out.println("!Used removeFromFront method");
        System.out.println("Front Node: " + linkedList.peekFront());
        linkedList.printContents();
        linkedList.removeFromPosition(2);
        System.out.println("!Used removeFromPosition method: 2nd position");
        linkedList.printContents();
        //following should do nothing to list
        System.out.println("Removing from position 5... which should not do anything");
        linkedList.removeFromPosition(5);
        linkedList.printContents();
        System.out.println("insertAtPosition: 4");
        linkedList.insertAtPosition("insertAtPos", 4);
        linkedList.printContents();
        while(linkedList.length() != 0){
            System.out.print("Removing from back...");
            linkedList.removeFromBack();
            linkedList.printContents();
        }

    }
}
