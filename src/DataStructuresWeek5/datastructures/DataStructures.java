
package datastructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tisafoster
 */
public class DataStructures
{

    //Entry point of the program.
    public static void main(String[] args) throws IOException
    {
        SortedLinkedList sortedList = new SortedLinkedList();
        HashTable hashTable = new HashTable(5);
        SortedArrayList sortedArray = new SortedArrayList();
        
        InputData(sortedList, hashTable, sortedArray);
        System.out.println("Sorted array contents:\n" + sortedArray);
        
        //Search for George Pipps with sequential search
        PrintSearchResults(sortedList.sequentialSearchByLastName("Pipps"));
        
        //Search for George Pipps with binary search
        PrintSearchResults(sortedArray.binarySearchByLastName("Pipps"));
       
        //Search for Donor ID 25
        PrintSearchResults(hashTable.searchByDonorId(25));
    }
    
    //Reads donor information from file, creates donor, and adds references to each of the structures
    public static void InputData(SortedLinkedList list, HashTable hashTable, SortedArrayList array) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(
                "contributors.csv"));
        String line;
        Scanner scanner;
        String firstName = "";
        String lastName = "";
        String country = "";
        String phone = "";
        double contribution = 0;
        int id = 0;
        int index = 0;
        
        //Loops through each line of CSV file
        while ((line = reader.readLine()) != null) 
        {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            
            //Loops through each piece of data in the line
            while (scanner.hasNext()) {
                String data = scanner.next();
                switch (index)
                {
                    case 0: firstName = data.trim();
                        break;
                    case 1: lastName = data.trim();
                        break;
                    case 2: country = data.trim();
                        break;
                    case 3: phone = data.trim();
                        break;
                    case 4: contribution = Double.parseDouble(data);
                        break;
                    case 5: id = Integer.parseInt(data);
                        break;
                    default: System.out.println("Invalid data::" + data);
                        break;
                }
                index++;
            }
            index = 0;
            
            //Creates donor from the given data
            Donor donor = new Donor(firstName, lastName, country, phone, contribution, id);
            
            //Adds donor to the sorted linked list
            list.add(donor);
            
            //Adds donor to the hash table
            hashTable.addDonor(donor);
            
            //Adds donor to the sorted arraylist
            array.addDonor(donor);
        }
        reader.close();
    }
    
    public static void PrintSearchResults(Donor searchResult)
    {
         if (searchResult != null)
        {
            System.out.println("\nSearch results:\n" + searchResult);
        }
        else 
            System.out.println("\nSearch results:\n\nDonor not found.");
    }
}   

