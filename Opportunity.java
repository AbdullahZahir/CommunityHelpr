/**
 * Opportunity class represents a single opportunity available for
 * community service. Each opportunity stores all of its data, in order to
 * facilitate searching processes. 
 * 
 */
public class Opportunity {
    //Private instance variables
    private String title;
    private String location;
    private String date;
    private String organization;
    private int availableSpots; 
    
    //Constructs a new opportunity
    //@paramm title, location, date, organization, availableSpots
    public Opportunity(String title, String location, String date, String organization, int availableSpots) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.organization = organization;
        this.availableSpots = availableSpots;
    }
    
    //Returns title
    public String getTitle() {
        return title;
    }
    
    //Returns location
    public String getLocation() {
        return location;
    }
    
    //Returns date
    public String getDate() {
        return date;
    }
    
    //returns organization
    public String getOrganization() {
        return organization;
    }
    
    //Returns available spots
    public int getAvailableSpots() {
        return availableSpots;
    }
    
    //Reduces spot availability of an opportunity
    public boolean reduceSpot() {
        if (availableSpots > 0) {
            availableSpots = availableSpots - 1;
            return true;
        }
        else {
            return false;
        }
    }
    
    //Creates a description of the opportunity
    public String toString() {
        return title + " | " + organization + " | " + location + " | " + date + " | Spots Left: " + availableSpots;  
    }
}
