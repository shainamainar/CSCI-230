import org.omg.CORBA.Any;

/**
 * DoublyLinkedList can contain any type of data, but all data must be of the same type.
 * Based on the model provided by Weiss (see pictures, page 76) "dummy" nodes are included.
 * 
 * Data is stored in a doubly-linked list with both head and tail pointers.
 * 
 * @ R McCauley built shell
 * Modified by Shaina Mainar
 * HW 4 Summer 2018
 */
public class DoublyLinkedList<AnyType> extends HW4_AbstractClass<AnyType>{
    
    /******** an inner class  **********************
     * The node type for a doubly linked list 
     */
    private static class Node<AnyType> {
        
        public Node(AnyType x, Node p, Node n) {
            data = x; prev = p; next = n;           
        }
        
        public AnyType data;
        public Node<AnyType> next;
        public Node<AnyType> prev;
    }
    /**********************************************************/
    
    // The DoublyLinkedList contains a reference to the both the front and back nodes in the list.
    
    private DoublyLinkedList.Node<AnyType> head; // front marker
    private DoublyLinkedList.Node<AnyType> tail; // back marker
    private int length; // how many nodes in the list
    
    /**
     * Constructor allocates initializes front reference
     */
    public DoublyLinkedList () {
         
        head = new DoublyLinkedList.Node<AnyType>(null, null, null);  
        tail = new DoublyLinkedList.Node<AnyType>(null, head, null); 
        head.next = tail;
        length = 0;    // no nodes in list
	}


	/**
     * Reports number of nodes in the list
     * @return
     */
    public int length(){
    	  return length;
    }

	@Override
	public void addToBack(AnyType x) {
    	//add node before tail
		DoublyLinkedList.Node<AnyType> temp = new DoublyLinkedList.Node<>(x, tail.prev, tail);
		temp.prev.next = temp;
		tail.prev = temp;
		length++;
	}

	@Override
	public void removeFromFront() {
    	//removes node after head
    	if(head.next != tail){
    		head.next = head.next.next;
    		head.next.prev = head;
    		length--;
		}
	}

	@Override
	public void removeFromBack() {
    	//removes node before tail
    	if(tail.prev != head){
    		tail.prev = tail.prev.prev;
    		tail.prev.next = tail;
    		length--;
		}

	}

	@Override
	public AnyType peekFront() {
    	//peeks node after head
		if(head.next == tail)
    	return null;
		else{
			return head.next.data;
		}
	}

	@Override
	public AnyType peekBack() {
    	//peeks node before tail
    	if(tail.prev == head)
		return null;
    	else{
    		return tail.prev.data;
		}
	}

	@Override
	public void removeFromPosition(int pos) {
    	//Walker walks to pos and removes node in pos
		DoublyLinkedList.Node<AnyType> walker = new DoublyLinkedList.Node<>(null, head, head.next);
		if(pos <= length) {
			for (int i = 1; i <= pos; i++) {
				walker = walker.next;
			}
			walker.next.prev = walker.prev;
			walker.prev.next = walker.next;
			length--;
		}

	}

	/**
     *  The following routine is used to mock-up a 
     *  doubly linked list that can be used to test your remove algorithm
     */
    @Override
    public void insertAtFront(AnyType value){
    	// Each node stores a null reference, since AnyType could be any type
        DoublyLinkedList.Node<AnyType> temp = new DoublyLinkedList.Node<>(value, head, head.next); // will be the first node

        head.next = temp;
	    temp.next.prev = temp;
    	length++;
    } 
    	    
    // Verify contents of list
    public void printContents (){
    	
    	   System.out.println("Printing front to back, start of list:");
    	   DoublyLinkedList.Node<AnyType> walker = head.next; // don't print dummy
    	   while (walker != tail){
           // assumes AnyType is printable - has a toString
    		   System.out.println(walker.data);
    		   walker = walker.next;
    	   }
    	   
 /*   	   System.out.println("Printing back to front, start of list:");
    	   walker = tail.prev; // don't print dummy
    	   while (walker != head){
    		   System.out.println(walker.data);
    		   walker = walker.prev;
    	   }
    	   */
    	   System.out.println("List has "+ length +" nodes.\n===="); 
    } // end howLong
    @Override
    public void insertAtPosition(AnyType x, int pos) {
    	
    	if (pos < 1 || pos > length + 1)
    		return;
    	// Find position - point to node before where this node
    	// goes
    	int count = 1;
    	DoublyLinkedList.Node<AnyType> walker = head;
    	while (count < pos) {
    		walker = walker.next;
    		count++;
    	}
    	// Create new node
    	DoublyLinkedList.Node<AnyType> temp = new DoublyLinkedList.Node<>(x,walker, walker.next);
    	temp.next.prev = temp;
    	temp.prev.next = temp;
    	length++;
    	
    }
    
    // This is the main method used to test in class.
    // For HW4, you must create a main in a new HW4 class
    public static void main(String[] args){
    	   final int HOWMANY = 4;

    	   DoublyLinkedList<String> d = new DoublyLinkedList<>();
    	   String nodeLabel = "node";
    	   for (int i = 1; i <= HOWMANY; i++){
    	      d.insertAtFront(nodeLabel + (HOWMANY-i));
    	   }
    	   d.printContents();
    	   d.insertAtPosition("at pos 1", 1);
    	   d.printContents();
      	   d.insertAtPosition("at pos 3", 3);
    	   d.printContents();
    	   d.insertAtPosition("at last pos ", d.length+1);
    	   d.printContents();
    	   d.insertAtPosition("nowhere", 25);
    	   d.printContents();
    	   d.insertAtPosition("nowhere", -4);
    	   d.printContents(); 	   
    }
}
