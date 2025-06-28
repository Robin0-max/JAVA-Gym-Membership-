/**
 * Represents a premium gym member with additional benefits like personal trainers
 * and payment plans, extending the base GymMember class.
 */
public class PremiumMember extends GymMember {
    // =============== PREMIUM MEMBER-SPECIFIC FIELDS =============== //
    private final double premiumCharge;    // Fixed premium membership fee (Rs. 50000)
    private String personalTrainer;       // Assigned trainer's name
    private boolean isFullPayment;       // Flag for full payment status
    private double paidAmount;           // Amount paid so far
    private double discountAmount;       // Eligible discount (10% if paid in full)

    // =============== CONSTRUCTOR =============== //
    /**
     * Initializes a PremiumMember with default payment status and premium benefits.
     */
    public PremiumMember(int id, String name, String location, String phone, String email,
                       String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;      // Fixed premium price
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;      // Payment starts as incomplete
        this.paidAmount = 0;            // No payment initially
        this.discountAmount = 0;        // No discount until full payment
    }

    // =============== ACCESSOR METHODS =============== //
    /** Returns the total premium membership charge (Rs. 50000) */
    public double getPremiumCharge() {
        return premiumCharge;
    }

    /** Returns the assigned personal trainer's name */
    public String getPersonalTrainer() {
        return personalTrainer;
    }

    /** Checks if full payment has been made */
    public boolean isFullPayment() {
        return isFullPayment;
    }

    /** Returns the amount paid so far */
    public double getPaidAmount() {
        return paidAmount;
    }

    /** Returns the discount amount (10% if paid in full) */
    public double getDiscountAmount() {
        return discountAmount;
    }

    // =============== OVERRIDDEN METHODS =============== //
    /**
     * Marks attendance and awards 10 loyalty points (double regular members).
     * Only works for active memberships.
     */
    @Override
    public void markAttendance() {
        if (this.activeStatus) {
            this.attendance++;
            this.loyaltyPoints += 10;  // Premium members earn double points
            System.out.println("Attendance marked for " + this.name);
        } else {
            System.out.println("Cannot mark attendance. Membership is inactive.");
        }
    }

    // =============== PAYMENT METHODS =============== //
    /**
     * Processes a payment toward the premium charge.
     * @param amount  Payment amount (Rs.)
     * @return Payment status message
     */
    public String payDueAmount(double amount) {
        if (isFullPayment) {
            String msg = "Payment already completed.";
            System.out.println(msg);
            return msg;
        }
        if ((paidAmount + amount) > premiumCharge) {
            String msg = "Payment exceeds total charge. Please enter a valid amount.";
            System.out.println(msg);
            return msg;
        }
        paidAmount += amount;
        isFullPayment = (paidAmount == premiumCharge);  // Auto-update payment status
        double remainingAmount = premiumCharge - paidAmount;
        String msg = "Payment accepted. Remaining amount to be paid: Rs. " + remainingAmount;
        System.out.println(msg);
        return msg;
    }

    /**
     * Calculates 10% discount if full payment was made.
     * @return Discount amount (Rs.)
     */
    public double calculateDiscount() {
        if (isFullPayment) {
            discountAmount = 0.10 * premiumCharge;  // 10% of total charge
            System.out.println("Discount applied: " + discountAmount);
        } else {
            discountAmount = 0;
            System.out.println("No discount applied (payment not complete).");
        }
        return discountAmount;
    }

    // =============== MEMBER RESET METHOD =============== //
    /**
     * Resets member to default state - clears trainer, payments, and discounts.
     * Inherits base reset functionality from GymMember.
     */
    public void revertPremiumMember() {
        super.resetMember();      // Resets attendance, loyaltyPoints, activeStatus
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    // =============== DISPLAY METHOD =============== //
    /**
     * Displays all member details including premium-specific information:
     * - Trainer assignment
     * - Payment status
     * - Remaining balance
     * - Discount (if applicable)
     */
    @Override
    public void display() {
        super.display();  // Shows base GymMember attributes
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment: " + (isFullPayment ? "Yes" : "No"));
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount to be Paid: " + remainingAmount);
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);  // Only show if paid in full
        }
    }
}