import java.util.ArrayList;

public class VolunteerProfile {
   //Instance variables
   private String username;
   private ArrayList<Opportunity> favorites;
   private ArrayList<Opportunity> registered;
   
   //Constructs a volunteer profile for a given user
   public VolunteerProfile(String username)
   {
       this.username = username;
       this.favorites = new ArrayList<Opportunity>();
       this.registered = new ArrayList<Opportunity>();
   }
   
   // gets the username that owns the profile
   public String getUsername()
   {
       return username;
   }
   
   
   /**
    * Adds an opportunity to the user's favorites list.
    * a linear search is used first to make sure the same ooporuntiy is not
    * added twice
    * 
    * 
    * 
   */
   public boolean addFavorite(Opportunity opp)
   {
       //Linear search to check for a duplicate before adding
       for (Opportunity current : favorites)
       {
           if (current == opp)
           {
               System.out.println("That opportunity is already in your favorites.");
               return false;
           }
       }
       favorites.add(opp);
       System.out.println("added to favorites: " + opp.getTitle());
       return true;
   }
   
   //Removes an ooportunity from the user's favorite list
   public boolean removeFavorite(Opportunity opp)
   {
       if (favorites.contains(opp))
       {
           favorites.remove(opp);
           System.out.println("Removed from favorites: " + opp.getTitle());
           return true;
       }
       else 
       {
           System.out.println("That opportunity was not in your favorites.");
           return false;
       }
   }
   
   //Records that the user has registered for an opportunity
   public void addRegistered(Opportunity opp)
   {
       registered.add(opp);
   }
   
   public ArrayList<Opportunity> getFavorites()
   {
       return favorites;
   }
   
   public ArrayList<Opportunity> getRegistered()
   {
       return registered;
   }
   
   //Prints the user's profile page: their favorites and registered events
   public void displayProfile()
   {
       System.out.println("Profile: " + username);
       
       System.out.println("Favorites:");
       if (favorites.size() == 0)
       {
           System.out.println("none saved yet");
       }
       else
       {
           for (Opportunity opp : favorites)
           {
               System.out.println("- " + opp);
           }
       }
       
       System.out.println("Registered Eevnts:");
       if (registered.size() == 0)
       {
           System.out.println("none registered yet");
       }
       else
       {
           for (Opportunity opp : registered)
           {
               System.out.println("- " + opp);
           }
       }
   }
}
