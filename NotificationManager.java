import java.util.ArrayList;

public class NotificationManager {
    // instance variable
    private ArrayList<String> notifications;
    
    // NotificationManager contructer which has an emoty notification list.
    public NotificationManager()
    {
        this.notifications = new ArrayList<String>();
    }
    
    //Creates and stores a registration confirmation message, then prints it.
    public void sendRegistrationConfirmation(String username, Opportunity opp)
    {
        String message = "Hi " + username + ", you are confirmed for " 
                + opp.getTitle() + " on " + opp.getDate() + ".";
        notifications.add(message);
        System.out.println(message);
    }
    
    // Adds a custom notifcation message to the list
    public void addNotification(String message)
    {
        notifications.add(message);
    }
    
    /**
     * This will display every notification the user has
     * If the user has no notifications at all, a clear message
     * will be shown instead nothing
    */
    public void displayNotifications()
    {
        if (notifications.size() == 0)
        {
            System.out.println("No notifications available");
        }
        else
        {
            for (String message : notifications)
            {
                System.out.println("- " + message);
            }
        }
    }
   
}
