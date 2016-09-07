
package datastructures;

/**
 *
 * @author tisaf
 */

public class HashTable {
   
    private static SortedLinkedList[] dataArray;
    
    //Initializes all the linked list stacks in the array
    public HashTable(int bucketCount)
    { 
        dataArray = new SortedLinkedList[bucketCount];
        for (int i = 0; i < dataArray.length; i++)
        {
            dataArray[i] = new SortedLinkedList();
        }
    }
    
    //Converts donor ID to hash value and adds donor to bucket
    public void addDonor(Donor theDonor)
    {
        int hashValue;
        hashValue = theDonor.getId() % dataArray.length;
        dataArray[hashValue].add(theDonor);
    }
   
    //Searches hash table for a donor ID
    public Donor searchByDonorId(int id)
    {
        SortedLinkedList bucket = dataArray[id % dataArray.length];
        Node currentNode = bucket.head;
        while (currentNode != null)
        {
            if (id == currentNode.payload.getId())
            {
                return currentNode.payload;
            }
            else currentNode = currentNode.next;
        }
        return null;
    }
    
    //Retrieves contents of a bucket
    public SortedLinkedList getBucketContents(int bucket)
    {
        return dataArray[bucket];
    }
    
    @Override
     public String toString()
    {
        String bucketList = new String();
        for (SortedLinkedList bucket : dataArray)
        {
            bucketList += bucket;
        }
        return bucketList;
    }
}