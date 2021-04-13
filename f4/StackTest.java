package f4;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste StackTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class StackTest
{   public static void main(String[] args){
        Stack s = new Stack();
        
        s.push("A");
        s.push("B");
        s.push("C");
        
        System.out.println(s.toString());
        System.out.println(!s.empty());
        String topo = s.top();
        System.out.println(topo.equals("C"));
        s.pop();
        s.pop();
        System.out.println(s.length()==1);
        s.pop();
        System.out.println(s.empty());
        
   }
}
