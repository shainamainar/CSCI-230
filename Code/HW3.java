// for testing
import java.util.ArrayList;
import java.util.List;
/**
 * Shaina Mainar
 * HW 3 Summer 2018
 * Uses a LinkedStack to determine if an arithmetic expression has
 * properly matched parenthesis
 *
 */
public class HW3 extends HW3_AbstractClass {
    @Override
    public boolean isItBalanced(String formula) {
        //instantiate linkedstack with Character type
        LinkedStack<Character> linkedStack = new LinkedStack<>();
        //pushes to the stack if character is open paren
        for(int i = 0; i < formula.length(); i++) {
            if(formula.charAt(i) == '('){
                linkedStack.push(formula.charAt(i));
            }
            if(formula.charAt(i) == ')'){
                //return false if the stack is empty meaning there are no open parens
                if(linkedStack.isEmpty()) return false;
                //return false if character is not close parens or if top of stack is not open parens
                else if(!(linkedStack.pop() == '(' && formula.charAt(i) == ')')) return false;
            }
        }
        //return true if there are no parens
        if(linkedStack.isEmpty()) return true;
        else return false;
    }
    public static void main(String[] args){
        HW3 hw3 = new HW3();
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("(4)");
        list.add("(4+2)");
        list.add("4+(2–4)");
        list.add("(4+(2–4))*10");
        list.add("2)+(4");
        list.add("0)");
        list.add("4+((3-5)");
        list.add("4+2)*10");
        list.add("(2+3");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + " is " + hw3.isItBalanced(list.get(i)));
        }
    }
}


