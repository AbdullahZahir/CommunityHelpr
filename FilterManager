import java.util.ArrayList;
/**
 * The FilterManager class will bolster the the searching and filtering
 * algorithms. Each method takes a full list and a search value, and through
 * comparisons, finds a perfect match for an opportunity.
 * 
 * Concepts:
 * - Methods w/ parameters
 * - Enhanced for loop
 * - Selection and string comparison
 */
 
public class FilterManager {
    
    //Filters opportunities by location
    //@param - master, location
    //@return - ArrayList containing matching opportunities
    public ArrayList<Opportunity> filterByLocation(ArrayList<Opportunity> master, String location) {
        ArrayList<Opportunity> results = new ArrayList<Opportunity>();
        for (Opportunity opp : master) {
            if (opp.getLocation().equalsIgnoreCase(location)) {
                results.add(opp);
            }
        }
        return results;
        
        
    }
    
  //Filters opportunities by location
    //@param - master, date
    //@return - ArrayList containing matching opportunities
    public ArrayList<Opportunity> filterByDate(ArrayList<Opportunity> master, String date) {
        ArrayList<Opportunity> results = new ArrayList<Opportunity>();
        for (Opportunity opp : master) {
            if (opp.getDate().equals(date)) {
                results.add(opp);
            }
        }
        return results;
    }
    
//Filters opportunities by location
    //@param - master, orgName
    //@return - ArrayList containing matching opportunities
     public ArrayList<Opportunity> filterByOrganization(ArrayList<Opportunity> master, String orgName) {
         ArrayList<Opportunity> results = new ArrayList<Opportunity>();
         for (Opportunity opp : master) {
             if (opp.getOrganization().equalsIgnoreCase(orgName)) {
                 results.add(opp);
             }
         }
         return results;
     }
}
