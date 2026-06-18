public class UserAccount {
    
    //Instance variables
    private String username;
    private String password;
    private VolunteerProfile profile;
    
    //Constructs a new user account and automatically creates a matching
    // volunteer profile for the user.
    public UserAccount(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.profile = new VolunteerProfile(username);
    }
    
    // gets the user name for this account
    public String getUsername()
    {
        return username;
    }
    
    // gets the volunteer profile that belongs to the account
    public VolunteerProfile getProfile()
    {
        return profile;
    }
    
    //Checks whether a given name matches this account's
    //username uses equalsIgnorecase() so that 
    //captialization does not matter
    public boolean matchesUsername(String name)
    {
        return username.equalsIgnoreCase(name);
    }
    
    // Checks whether a given password matches this account's
    //password. Passwords are case-sensitive, so equals() is used here.
    public boolean checkPassword(String pw)
    {
        return password.equals(pw);
    }
}
