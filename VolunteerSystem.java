import java.util.ArrayList;


public class VolunteerSystem {
    
    private ArrayList<Opportunity> opportunities;
    private ArrayList<UserAccount> accounts;
    private FilterManager filterManager;
    private NotificationManager notificationManager;
    
    /**
     *Constructs a VolunteerSystem with empty lists and its helper manager  
     */
    public VolunteerSystem()
    {
        this.opportunities = new ArrayList<Opportunity>();
        this.accounts = new ArrayList<UserAccount>();
        this.filterManager = new FilterManager();
        this.notificationManager = new NotificationManager();
    }
    
    /**
     *Adds one opportunity to the master list  
     * @param opp the opportunity to add to the whole system
     */
    public void addOpportunity(Opportunity opp)
    {
        opportunities.add(opp);
    }
    
    /**
     *Loads every opportunity from an organization into the master list  
     * @param org the organization whose opportunities should be loaded
     */
    public void loadOrganization(Organization org)
    {
        for (Opportunity opp : org.getOpportunities())
        {
            opportunities.add(opp);
        }
    }
    
    /**
     *Loads every opportunity from an organization into the master list  
     * @param org the organization whose opportunities should be loaded
     */
     public ArrayList<Opportunity> getOpportunites()
     {
         return opportunities;
     }
     
     /**
     *Loads every opportunity from an organization into the master list  
     * @param org the organization whose opportunities should be loaded
     */
     public NotificationManager getNotificationManager()
     {
         return notificationManager;
     }
     
     /**
     *Prints every opportunity in the system. If the list is empty, a clear   
     * message is shown instead of a blank screen
     */
     public void browseOpportunities()
     {
         if (opportunities.size() == 0)
         {
             System.out.println("No oppotunities currently available");
         }
         else
         {
             for (Opportunity opp : opportunities)
             {
                 System.out.println(opp);
             }
         }
     }
     
     /**
     *Searches opportunites by location and prints the results. If nothing
     * matches, a "no match" message is shown
     * @param location the location to search for
     */
     public void searchByLocation(String location)
     {
         ArrayList<Opportunity> results = filterManager.filterByLocation(opportunities, location);
         printResults(results);
     }
     
     /**
     * Searches opportunities by date and prints the results
     * @param date the date to search for
     */
     public void searchByDate(String date)
     {
         ArrayList<Opportunity> results = filterManager.filterByDate(opportunities, date);
         printResults(results);
     }
     
     /**
     * Searches opportunities by organization and print the results
     * @param orgName the organization name to search for
     */
     public void searchByOrganization(String orgName)
     {
         ArrayList<Opportunity> results = filterManager.filterByOrganization(opportunities, orgName);
         printResults(results);
     }
     
     /**
     * Helper method that prints a list of search results, or a "no match"
     * message if the list is empty
     * @param results the filtered list of opportunities to print
     */
     private void printResults(ArrayList<Opportunity> results)
     {
         if (results.size() == 0)
         {
             System.out.println("No matching opportunities found");
         }
         else
         {
             for (Opportunity opp : results)
             {
                 System.out.println(opp);
             }
         }
     }
     
     /**
     * Creates a new account if the username is not already. A linear
     * search checks every existing account firt
     * 
     * @param username the desired username
     * @param password the desired password
     * @return the new UserAccount, or null if the username was already taken
     */
     public UserAccount createAccount(String username, String password)
     {
         for (UserAccount acct : accounts)
         {
             if (acct.matchesUsername(username))
             {
                 System.out.println("Error: username \"" + username + "\" already exists.");
                 return null;
             }
         }
         UserAccount newAccount = new UserAccount(username, password);
         accounts.add(newAccount);
         System.out.println("Account created for " + username + ".");
         return newAccount;
     }
     
     /**
     * Attempts to log a user in. It searches for the username(not case sensitive)
     * and then checks the password
     * 
     * @param username the username being entered
     * @param password the password being entered
     * @return true if the username exists and the password is correct
     */
     public boolean login(String username, String password)
     {
         for (UserAccount acct : accounts)
         {
             if (acct.matchesUsername(username))
             {
                 if(acct.checkPassword(password))
                 {
                     return true;
                 }
                 else
                 {
                     return false;
                 }
             }
            
         }
         
         System.out.println("Username not found.");
         return false;
     }
     
     /**
     * Finds and returns the account that matches a username (not case sensitive)
     * 
     * @param username the username to look up
     * @return the matching UserAccount, or null if none exists
     */
     public UserAccount getAccount(String username)
     {
         for (UserAccount acct : accounts)
         {
             if (acct.matchesUsername(username))
             {
                 return acct;
             }
         }
         return null;
     }
     
      /**
     * Registers a user for an opportunity. If spots are available, one spot is
     * removed, the event is saved to the user's profule, and a confirmation is
     * sent. If the event is full, registration is blocked and an "Event Fill"
     * message is shown (this fixes the full-event bug found in testing).
     * 
     * @param account the username signing up
     * @param opp the opportunity to register for
     * @return true if registration succeeded, false if the event was full
     */
     public boolean registerVolunteer(UserAccount account, Opportunity opp)
     {
         if (opp.getAvailableSpots() > 0)
         {
             opp.reduceSpot();
             account.getProfile().addRegistered(opp);
             notificationManager.sendRegistrationConfirmation(account.getUsername(), opp);
             return true;
         }
         else
         {
             System.out.println("Event Full: \"" + opp.getTitle() + "\" had no spots remaining.");
             return false;
         }
     }
     
}
