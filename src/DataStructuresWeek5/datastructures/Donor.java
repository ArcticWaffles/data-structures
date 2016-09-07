
package datastructures;

/**
 *
 * @author tisafoster
 */
public class Donor
{
    private String firstName;
    private String lastName;
    private String country;
    private String phone;
    private double contribution;
    private int id;
    
    public Donor(String theFirstName, String theLastName, String theCountry, String thePhoneNumber, double theContribution, int theId)
    {
        firstName = theFirstName;
        lastName = theLastName;
        country = theCountry;
        phone = thePhoneNumber;
        contribution = theContribution;
        id = theId;
    }
    
    private Donor()
    {}
    
    @Override
   public String toString()
   {
       return "\nID: " + id + "\nName: " + firstName + " " + lastName + "\nCountry: " + country
               + "\nPhone: " + phone + "\nContribution: " + contribution + "\n";
   }

   
   //Getters and setters

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * @return the phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * @return the contribution
     */
    public double getContribution()
    {
        return contribution;
    }

    /**
     * @param contribution the contribution to set
     */
    public void setContribution(double contribution)
    {
        this.contribution = contribution;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

}
