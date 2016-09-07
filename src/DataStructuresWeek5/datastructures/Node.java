
package datastructures;

/**
 *
 * @author tisafoster
 */

//Node to be used in linked list, containing donor info and reference to next node
public class Node
{
    public Donor payload;
    public Node next;
    
    //Constructor 1: For adding a node to an empty list
    public Node(Donor theDonor)
    {
        payload = theDonor;
    }
    
    //Constructor 2: For adding a node to a list already containing at least one node.
    public Node(Donor theDonor, Node nextNode)
    {
         payload = theDonor;
         next = nextNode;
    }
}
