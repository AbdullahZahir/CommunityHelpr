import java.util.ArrayList;
/**
 * Volunteer class is representative of an actual volunteer for our
 * class. We use inheritance, as a volunteer is a person. We
 * extend person onto volunteer, and thus, reuse getName.
 * 
 * Volunteer adds more details, like username, total service hours,
 * and opportunities completed. 
 */
 
 
public class Volunteer extends Person {
    //Private instance variables, superclass with name
    private String username;
    private double totalHours;
    private ArrayList<Opportunity> completed;
    
    //Constructs a new volunteer object
    //@param name , username
    public Volunteer(String name, String username) {
        super(name);
        this.username = username;
        this.totalHours = 0.0;
        this.completed = new ArrayList<Opportunity>();
    }
    
    //Overrides person so volunteer can establish its own role
    //Citation: https://www.geeksforgeeks.org/java/overriding-in-java/
    @Override
    public String getRole() {
        return "Volunteer";
    }
    
    //Connects username to volunteer, returns username
    public String getUsername() {
        return username;
    }
    
    
    //Gets total hours volunteered, returns totalHours
    public double getTotalHours() {
        return totalHours;
    }
    
    //Logs the hours added onto a volunteer person profile
    //@param hours
    //returns true if added, false if not
    public boolean logHours(double hours) {
        if (hours > 0) {
            totalHours = totalHours + hours;
            System.out.println(getName() + " logged " + hours + " hours. New total: " + totalHours);
            return true;
        }
        else {
            System.out.println("Error: hours must be greater than 0.");
            return false;
        }
    }
    //Records that a volunteer completed the opportunity
    //@param opp, hours
    public void completeOpportunity(Opportunity opp, double hours) {
        completed.add(opp);
        logHours(hours);
    }
    
    //Returns the list of opportunities completed by volunteer
    public ArrayList<Opportunity> getCompletedOpportunities() {
        return completed;
    }
    
    //Returns amount of opportunities completed
    public int getCompletedCount() {
        return completed.size();
    }
    
    
    //Creates a public profile for the volunteer with their service hours, opportunities, etc.
    public void displayVolunteer() {
        System.out.println(super.toString() + " (" + username + ") ");
        System.out.println("Total Service Hours: " + totalHours);
        System.out.println("Completed Opportunities:");
        if (completed.size() == 0) {
            System.out.println("(none completed yet)");
            
        }
        else {
            for (Opportunity opp : completed) {
                System.out.println(" - " + opp.getTitle() + " (" + opp.getOrganization() + ") ");
            }
        }
    }
}
