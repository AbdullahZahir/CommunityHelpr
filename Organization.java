import java.util.ArrayList;
/**Organization represents any organization in need of volunteers,
 * such as clubs, companies, etc. Each organization can keep a list of
 * opportunities available.
 * 
 * AP CSA Concepts
 * - instance variables
 * - ArrayList
 * - Selection
 * 
 */
public class Organization {
    //Private instance variables
    private String name;
    private ArrayList<Opportunity> opportunities;
    
    public Organization(String name) {
        this.name = name;
        this.opportunities = new ArrayList<Opportunity>();
    }
    //Gets name of organization
    public String getName() {
        return name;
    }
    // Returns list of opportunities available
    public ArrayList<Opportunity> getOpportunities() {
        return opportunities;
    }
    //Allows people to add opportunities
    public void addOpportunity(Opportunity opp) {
        opportunities.add(opp);
        System.out.println("Added \"" + opp.getTitle() + "\" to " + name + ".");
    }
    //Allows people to remove opportunities from list
    public boolean removeOpportunity(Opportunity opp) {
        //Cited: https://www.geeksforgeeks.org/java/java-string-contains-method-example/
        if (opportunities.contains(opp)) {
            opportunities.remove(opp);
            System.out.println("Removed \"" + opp.getTitle() + "\" from " + name + ".");
            return true;
        }
        else {
            System.out.println("Error: opportunity not listed under " + name + ".");
            return false;
        }
    }
}    
