
package datastructures;

import java.util.ArrayList;

/**
 *
 * @author tisaf
 */
public class SortedArrayList {
    
    private ArrayList<Donor> array = new ArrayList<>();
    
    //Adds a new donor to the correct spot in the arraylist, using an insertion sort
    public void addDonor(Donor donor)
    {
        String lastName = donor.getLastName();
        
        //If the arraylist is empty, add the donor
        if(array.isEmpty())
        {
            array.add(donor);
            return;
        }
        
        //If the new last name belongs before one of the existing elements, add donor in that element's position
        else
        {
            for (int i = 0; i < array.size(); i++)
            {
                if (lastName.compareToIgnoreCase(array.get(i).getLastName()) <= 0)
                {
                    array.add(i, donor);
                    return;
                }
            }
        }
        //Else add donor to the end of the list
        array.add(array.size(), donor);
    }
    
    //Kicks off binary search by last name
    public Donor binarySearchByLastName(String lastNameQuery)
    {
        return binarySearchByLastName(lastNameQuery, 0, array.size()-1);
    }
    
    //Performs binary search by last name, using recursion
    private Donor binarySearchByLastName(String lastNameQuery, int lower, int upper)
    {
        //If lower > upper, all elements have been searched and the name wasn't found
        if (lower > upper) return null;
        
        int midpoint = (lower + upper)/2;
        String currentLastName = array.get(midpoint).getLastName();
        
        //If the name matches the midpoint element, return that element
        if (lastNameQuery.compareToIgnoreCase(currentLastName) == 0)
        {
            return array.get(midpoint);
        }
        
        //If the name comes before the midpoint element, adjust the parameters to search the lower half
        else if (lastNameQuery.compareToIgnoreCase(currentLastName) < 0)
        {
            return binarySearchByLastName(lastNameQuery, lower, midpoint - 1);
        }
        
        //If the name comes after the midpoint element, adjust the parameters to search the upper half
        else
        {
            return binarySearchByLastName(lastNameQuery, midpoint + 1, upper);
        }
    }
    
    @Override
    public String toString()
    {
        String allDonors = "";
        
        for(Donor donor: array)
        {
            allDonors += donor;
        }
        return allDonors;
    }
}
