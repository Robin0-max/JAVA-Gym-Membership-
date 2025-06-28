/**
 * Represents a regular gym member, extending the base GymMember class.
 * Includes features like attendance tracking, plan upgrades, and referral sources.
 */
public class RegularMember extends GymMember {
    // =============== REGULAR MEMBER-SPECIFIC FIELDS =============== //
    private final int attendanceLimit;       // Max attendance before upgrade eligibility
    private boolean isEligibleForUpgrade;   // Flag for plan upgrade eligibility
    private String removalreason;           // Reason for membership termination (if any)
    private String referralSource;          // How the member was referred (e.g., "Facebook")
    private String plan;                    // Current membership plan ("basic"/"standard"/"deluxe")
    private double price;                   // Current plan price

    // =============== CONSTRUCTOR =============== //
    /**
     * Initializes a RegularMember with default values for basic plan.
     */
    RegularMember(int id, String name, String location, String phone, String email, 
                 String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30;          // Hardcoded attendance threshold
        this.isEligibleForUpgrade = false;  // Initially ineligible for upgrades
        this.removalreason = "";            // Empty until membership is terminated
        this.referralSource = referralSource;
        this.plan = "basic";               // Default plan
        this.price = 6500;                  // Default price (Rs. 6500)
    }

    // =============== GETTER METHODS =============== //
    /** Returns the attendance limit (30 sessions) */
    public int getAttendanceLimit() { return attendanceLimit; }

    /** Checks if member is eligible for plan upgrade */
    public boolean isEligibleForUpgrade() { return isEligibleForUpgrade; }

    /** Returns the reason for membership termination (if any) */
    public String getRemovalReason() { return removalreason; }

    /** Returns how the member was referred to the gym */
    public String getReferralSource() { return referralSource; }

    /** Returns the current membership plan ("basic"/"standard"/"deluxe") */
    public String getPlan() { return plan; }

    /** Returns the current plan price */
    public double getPrice() { return price; }

    // =============== OVERRIDDEN METHODS =============== //
    /**
     * Deactivates membership if active, otherwise shows warning.
     */
    @Override
    public void deactivateMembership() {
        if (this.activeStatus) {
            this.activeStatus = false;
        } else {
            System.out.println("Membership is already deactivated.");
        }
    }

    /**
     * Records attendance and awards loyalty points (5 per session).
     * Marks upgrade eligibility if attendance reaches the limit.
     */
    @Override
    public void markAttendance() {
        if (this.activeStatus) {
            this.attendance++;
            this.loyaltyPoints += 5;
            System.out.println("Attendance registered for " + this.name);
            if (this.attendance >= this.attendanceLimit) {
                this.isEligibleForUpgrade = true;
            }
        } else {
            System.out.println("Cannot register attendance. Membership is inactive.");
        }
    }

    // =============== PLAN MANAGEMENT METHODS =============== //
    /**
     * Returns the price of a specified plan.
     * @param plan  Plan name ("basic"/"standard"/"deluxe")
     * @return Price (Rs.) or -1 for invalid plans
     */
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":   return 6500;
            case "standard": return 12500;
            case "deluxe":   return 18500;
            default:         return -1;  // Invalid plan indicator
        }
    }

    /**
     * Upgrades membership plan if eligibility and payment criteria are met.
     * @param newPlan   Target plan ("standard"/"deluxe")
     * @param payment   Amount paid by member
     * @return Upgrade status message
     */
    public String upgradePlan(String newPlan, double payment) {
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Invalid plan selected.";
        }
        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "Already subscribed to this plan.";
        }
        if (getAttendance() < attendanceLimit) {
            return "Not eligible for upgrade. Attend more sessions to be eligible.";
        }
        if (payment < newPrice) {
            return "Insufficient payment. Please pay at least Rs. " + newPrice;
        }
        // Successful upgrade
        this.plan = newPlan;
        this.price = newPrice;
        this.isEligibleForUpgrade = true;
        return "Plan upgraded to " + newPlan + " successfully! Price: " + newPrice;
    }

    // =============== MEMBER RESET METHOD =============== //
    /**
     * Resets member to default basic plan and clears upgrade eligibility.
     * @param removalReason  Reason for reset (e.g., "Payment failure")
     */
    public void revertRegularMember(String removalReason) {
        super.resetMember();  // Resets attendance, loyaltyPoints, activeStatus
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalreason = removalReason; 
    }

    // =============== DISPLAY METHOD =============== //
    /**
     * Displays all member details including plan-specific info.
     * Shows removal reason if applicable.
     */
    @Override
    public void display() {
        super.display();  // Shows base GymMember attributes
        System.out.println("Plan: " + this.plan);
        System.out.println("Price: " + this.price);
        if (!this.removalreason.isEmpty()) { 
            System.out.println("Removal reason: " + this.removalreason);
        }
    }
}