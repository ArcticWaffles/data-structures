
package datastructures;

/**
 *
 * @author tisaf
 */
public class SortedLinkedList {
    
    Node head;
    
    //Adds a new donor to the correct spot in the linked list, using an insertion sort
    public void add(Donor donor)
    {
       String lastName = donor.getLastName();
       
       //If the list is empty, the new donor becomes the head
       if (head == null)
       {
           head = new Node(donor);
       }
       
       //If new last name is lexicographically "less than or equal to" that of the head, it becomes the new head
       else if (lastName.compareToIgnoreCase(head.payload.getLastName()) <= 0)
       {
           Node newNode = new Node(donor, head);
           head = newNode;
       }
       
       //If new last name is "greater than" the head, it is inserted after the head
       else
       {
           Node newNode = new Node(donor, head.next);
           //"previous" variable keeps track of the previous node for the purpose of reassigning references
           Node previous = head;
           head.next = newNode;
           
           //While new last name is "greater than" that of the following node, it continues moving down the list
           while (newNode.next != null && lastName.compareToIgnoreCase(newNode.next.payload.getLastName()) > 0)
           {
               //change the previous node's reference
               previous.next = newNode.next;
               //update "previous" variable
               previous = newNode.next;
               //change the reference of the node being sorted
               newNode.next = newNode.next.next;
               //change the new "previous" node to point to the node being sorted
               previous.next = newNode;
           }
       }
    }
    
    //Performs sequential search of linked list by last name
    public Donor sequentialSearchByLastName(String keyLastName)
    {
        Node currentNode = head;
        while (currentNode != null)
        {
            if (keyLastName.equalsIgnoreCase(currentNode.payload.getLastName()))
            {
                return currentNode.payload;
            }
            else currentNode = currentNode.next;
        }
        return null;
    }
    
    //Converts all info in the linked list to a string for printing
    @Override
    public String toString()
    {
        Node currentNode = head;
        String allPayloads = "";
        while (currentNode != null)
        {
            allPayloads = allPayloads.concat(currentNode.payload.toString());
            currentNode = currentNode.next;
        }
        return allPayloads;
    }
    
}

