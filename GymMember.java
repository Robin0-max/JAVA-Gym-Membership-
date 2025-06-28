/**
 * This is an abstract class representing a generic gym member.
 * It contains common attributes and methods that all gym members should have.
 */
public abstract class GymMember {
    // Member attributes with protected visibility for inheritance
    protected int id;                 // Unique identifier for the member
    protected String name;            // Member's full name
    protected String location;        // Member's address or location
    protected String phone;           // Member's contact number
    protected String email;           // Member's email address
    protected String gender;          // Member's gender
    protected String DOB;             // Member's date of birth
    protected String membershipStartDate; // Date when membership began
    protected int attendance;         // Number of times member attended
    protected double loyaltyPoints;   // Points earned through participation
    protected boolean activeStatus;   // Current membership status (active/inactive)
    
    /**
     * Constructor to initialize a new gym member with basic information.
     * 
     */
    GymMember(int id, String name, String location, String phone, String email, 
             String gender, String DOB, String membershipStartDate) {
        this.id = id; 
        this.name = name; 
        this.location = location; 
        this.phone = phone;
        this.email = email;
        this.gender = gender; 
        this.DOB = DOB; 
        this.membershipStartDate = membershipStartDate; 
        this.attendance = 0;          // Initialize attendance to 0
        this.loyaltyPoints = 0;       // Initialize loyalty points to 0
        this.activeStatus = false;     // New members start as inactive by default
    }
    
    // ========== ACCESSOR METHODS (GETTERS) ========== //
    
    /**
     * @return The member's unique ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return The member's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The member's location/address
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return The member's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return The member's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The member's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return The member's date of birth
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @return The membership start date
     */
    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    /**
     * @return Number of times member has attended
     */
    public int getAttendance() {
        return attendance;
    }

    /**
     * @return Current loyalty points balance
     */
    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * @return true if membership is active, false otherwise
     */
    public boolean isActiveStatus() {
        return activeStatus;
    }
    
    // ========== ABSTRACT METHODS ========== //
    
    /**
     * Abstract method to mark attendance for the gym member.
     * Must be implemented by concrete subclasses.
     */
    public abstract void markAttendance();
    
    // ========== MEMBERSHIP STATUS METHODS ========== //
    
    /**
     * Activates the member's membership.
     * Sets the activeStatus flag to true.
     */
    public void activateMembership() {
        this.activeStatus = true;
    }
    
    /**
     * Deactivates the member's membership if currently active.
     * Sets the activeStatus flag to false.
     */
    public void deactivateMembership() {
        if(this.activeStatus) {
            this.activeStatus = false;
        }
    }
    
    /**
     * Resets the member's status to default inactive state.
     * Clears attendance and loyalty points.
     */
    public void resetMember() {
        this.activeStatus = false; 
        this.attendance = 0; 
        this.loyaltyPoints = 0; 
    }
    
    // ========== DISPLAY METHOD ========== //
    
    /**
     * Displays all member information in a readable format.
     */
    public void display() {
        System.out.println("ID: " + this.id); 
        System.out.println("Name: " + this.name); 
        System.out.println("Location: " + this.location); 
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
        System.out.println("Gender: " + this.gender); 
        System.out.println("Date of Birth: " + this.DOB); 
        System.out.println("Membership Start Date: " + this.membershipStartDate); 
        System.out.println("Attendance: " + this.attendance); 
        System.out.println("Loyalty Points: " + this.loyaltyPoints); 
        System.out.println("Active Status: " + (this.activeStatus ? "Active" : "Inactive")); 
    }
}