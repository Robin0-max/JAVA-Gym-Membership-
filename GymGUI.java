import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;

public class GymGUI {
    private ArrayList<GymMember> members = new ArrayList<GymMember>();
    private JFrame frame;
    private JPanel panel;
    private JTextField idField, nameField, locationField, phoneField, emailField, referralField, paidAmountField, removalReasonField, trainerField;
    private JRadioButton maleRadio, femaleRadio;
    private JComboBox<String> dobYearComboBox, dobMonthComboBox, dobDayComboBox;
    private JComboBox<String> msYearComboBox, msMonthComboBox, msDayComboBox;
    private JComboBox<String> PlanComboBox;
    private JTextField regularPriceField, premiumChargeField, discountAmountField;
    private JTextArea resultRegularArea, resultPremiumArea;
    private JButton calculateDiscountButton, addRegularButton, addPremiumButton, activateButton, deactivateButton, 
            markAttendanceButton, revertRegularButton, upgradeButton, payDueButton, revertPremiumButton, clearButton, displayRegularButton, displayPremiumButton;
    private JButton saveToFileButton, readFromFileButton;

    public GymGUI() {
      // Frame 
        frame = new JFrame("GYM");
        frame.setSize(950, 925); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Panel
        panel = new JPanel();
        panel.setLayout(null); 
        panel.setPreferredSize(new Dimension(950, 1200));
        panel.setBackground(new Color(250, 250, 250));

        JScrollPane mainScrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScrollPane.setBounds(0, 0, 950, 900); 
        frame.add(mainScrollPane);

        // ID and Name
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(40, 20, 100, 30);
        panel.add(idLabel);
        idField = new JTextField();
        idField.setBounds(150, 20, 180, 30);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(390, 20, 100, 30);
        panel.add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(500, 20, 230, 30);
        panel.add(nameField);

        // Location and Phone
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(40, 65, 100, 30);
        panel.add(locationLabel);
        locationField = new JTextField();
        locationField.setBounds(150, 65, 180, 30);
        panel.add(locationField);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(390, 65, 100, 30);
        panel.add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(500, 65, 230, 30);
        panel.add(phoneField);

        // Email and Referral Source
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(40, 110, 100, 30);
        panel.add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(150, 110, 180, 30);
        panel.add(emailField);

        JLabel referralLabel = new JLabel("Referral Source");
        referralLabel.setBounds(390, 110, 110, 30);
        panel.add(referralLabel);
        referralField = new JTextField();
        referralField.setBounds(510, 110, 220, 30);
        panel.add(referralField);

        // Paid Amount and Removal Reason
        JLabel paidLabel = new JLabel("Paid Amount");
        paidLabel.setBounds(40, 155, 100, 30);
        panel.add(paidLabel);
        paidAmountField = new JTextField();

        paidAmountField.setBounds(150, 155, 180, 30);
        panel.add(paidAmountField);

        JLabel removalLabel = new JLabel("Removal Reason");
        removalLabel.setBounds(390, 155, 110, 30);
        panel.add(removalLabel);
        removalReasonField = new JTextField();
        removalReasonField.setBounds(510, 155, 220, 30);
        panel.add(removalReasonField);

        // Trainer's Name and Gender
        JLabel trainerLabel = new JLabel("Trainer's Name");
        trainerLabel.setBounds(40, 200, 110, 30);
        panel.add(trainerLabel);
        trainerField = new JTextField();
        trainerField.setBounds(150, 200, 180, 30);
        panel.add(trainerField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(390, 200, 60, 30);
        panel.add(genderLabel);
        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(460, 200, 70, 30);
        panel.add(maleRadio);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(540, 200, 90, 30);
        panel.add(femaleRadio);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // DOB
        JLabel dobLabel = new JLabel("DOB");
        dobLabel.setBounds(40, 245, 40, 30);
        panel.add(dobLabel);
        dobYearComboBox = new JComboBox<>(new String[]{"2025", "2024", "2023"});
        dobYearComboBox.setBounds(90, 245, 70, 30);
        panel.add(dobYearComboBox);
        dobMonthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar"});
        dobMonthComboBox.setBounds(170, 245, 70, 30);
        panel.add(dobMonthComboBox);
        dobDayComboBox = new JComboBox<>(new String[]{"1", "2", "3"});
        dobDayComboBox.setBounds(250, 245, 70, 30);
        panel.add(dobDayComboBox);

        // Membership Start Date
        JLabel msLabel = new JLabel("Membership Start Date");
        msLabel.setBounds(390, 245, 170, 30);
        panel.add(msLabel);
        msYearComboBox = new JComboBox<>(new String[]{"2025", "2024", "2023"});
        msYearComboBox.setBounds(560, 245, 70, 30);
        panel.add(msYearComboBox);
        msMonthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar"});
        msMonthComboBox.setBounds(640, 245, 70, 30);
        panel.add(msMonthComboBox);
        msDayComboBox = new JComboBox<>(new String[]{"1", "2", "3"});
        msDayComboBox.setBounds(720, 245, 70, 30);
        panel.add(msDayComboBox);

        // Plan
        JLabel planLabel = new JLabel("Plan");
        planLabel.setBounds(40, 290, 50, 30);
        panel.add(planLabel);
        PlanComboBox = new JComboBox<>(new String[]{"Basic","Standard","Deluxe"});
        PlanComboBox.setBounds(100, 290, 130, 30);
        panel.add(PlanComboBox);

        // Prices (single row, spaced out)
        JLabel regularPriceLabel = new JLabel("Regular Plan Price:");
        regularPriceLabel.setBounds(40, 335, 130, 30);
        panel.add(regularPriceLabel);
        regularPriceField = new JTextField("6500");
        regularPriceField.setBounds(170, 335, 90, 30);
        regularPriceField.setEditable(false);
        panel.add(regularPriceField);

        JLabel premiumChargeLabel = new JLabel("Premium Plan Charge:");
        premiumChargeLabel.setBounds(270, 335, 160, 30);
        panel.add(premiumChargeLabel);
        premiumChargeField = new JTextField("50000");
        premiumChargeField.setBounds(430, 335, 110, 30);
        premiumChargeField.setEditable(false);
        panel.add(premiumChargeField);

        JLabel discountLabel = new JLabel("Discount Amount:");
        discountLabel.setBounds(550, 335, 110, 30);
        panel.add(discountLabel);
        discountAmountField = new JTextField("0%");
        discountAmountField.setBounds(660, 335, 70, 30);
        discountAmountField.setEditable(false);
        panel.add(discountAmountField);

        // Buttons
        addRegularButton = new JButton("Add Regular Member");
        addRegularButton.setBounds(40, 390, 210, 38);
        panel.add(addRegularButton);

        addPremiumButton = new JButton("Add Premium Member");
        addPremiumButton.setBounds(280, 390, 210, 38);
        panel.add(addPremiumButton);

        activateButton = new JButton("Activate Membership");
        activateButton.setBounds(520, 390, 210, 38);
        panel.add(activateButton);

        deactivateButton = new JButton("Deactivate Membership");
        deactivateButton.setBounds(40, 440, 210, 38);
        panel.add(deactivateButton);

        markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(280, 440, 210, 38);
        panel.add(markAttendanceButton);

        revertRegularButton = new JButton("Revert Regular Member");
        revertRegularButton.setBounds(520, 440, 210, 38);
        panel.add(revertRegularButton);

        calculateDiscountButton = new JButton("Calculate Discount");
        calculateDiscountButton.setBounds(40, 490, 210, 38);
        panel.add(calculateDiscountButton);

        upgradeButton = new JButton("Upgrade Plan");
        upgradeButton.setBounds(280, 490, 210, 38);
        panel.add(upgradeButton);

        payDueButton = new JButton("Pay Due Amount");
        payDueButton.setBounds(520, 490, 210, 38);
        panel.add(payDueButton);

        revertPremiumButton = new JButton("Revert Premium Member");
        revertPremiumButton.setBounds(40, 540, 210, 38);
        panel.add(revertPremiumButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(280, 540, 210, 38);
        panel.add(clearButton);

        saveToFileButton = new JButton("Save to File");
        saveToFileButton.setBounds(520, 540, 210, 38);
        panel.add(saveToFileButton);

        readFromFileButton = new JButton("Read from File");
        readFromFileButton.setBounds(740, 540, 120, 38);
        panel.add(readFromFileButton);

        // Output areas (wider, aligned, left/right)
        JLabel regularLabel = new JLabel("Regular Members Output:");
        regularLabel.setBounds(40, 600, 200, 30);
        panel.add(regularLabel);
        resultRegularArea = new JTextArea();
        resultRegularArea.setLineWrap(true);
        resultRegularArea.setWrapStyleWord(true);
        resultRegularArea.setEditable(false);
        JScrollPane regularScrollPane = new JScrollPane(resultRegularArea);
        regularScrollPane.setBounds(40, 630, 370, 160);
        panel.add(regularScrollPane);

        JLabel premiumLabel = new JLabel("Premium Members Output:");
        premiumLabel.setBounds(440, 600, 200, 30);
        panel.add(premiumLabel);
        resultPremiumArea = new JTextArea();
        resultPremiumArea.setLineWrap(true);
        resultPremiumArea.setWrapStyleWord(true);
        resultPremiumArea.setEditable(false);
        JScrollPane premiumScrollPane = new JScrollPane(resultPremiumArea);
        premiumScrollPane.setBounds(440, 630, 370, 160);
        panel.add(premiumScrollPane);

        displayRegularButton = new JButton("Display Regular Members");
        displayRegularButton.setBounds(40, 810, 250, 38);
        panel.add(displayRegularButton);

        displayPremiumButton = new JButton("Display Premium Members");
        displayPremiumButton.setBounds(440, 810, 250, 38);
        panel.add(displayPremiumButton);
        
        // =============== ACTION LISTENERS =============== //
        
        addRegularButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        // Check if any required fields are empty
        if (
            isEmpty(idField) ||
            isEmpty(nameField) ||
            isEmpty(locationField) ||
            isEmpty(phoneField) ||
            isEmpty(emailField) ||
            isEmpty(referralField) ||
            (!maleRadio.isSelected() && !femaleRadio.isSelected())
        ) {
            JOptionPane.showMessageDialog(frame, "Please fill in all required fields and select gender.");
            return;
        }
        // Proceed with adding Regular Member if all validations pass
        try {
            int id = Integer.parseInt(idField.getText());
            boolean idExists = false;

            // Check if ID already exists
            for (GymMember m : members) {
                if (m.getId() == id) {
                    idExists = true;
                    break;
                }
            }

            if (idExists) {
                JOptionPane.showMessageDialog(frame, "ID already exists!");
                return;
            }

            // Determine gender
            String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Unknown";

            // Get DOB and Membership Start Date
            String dob = dobYearComboBox.getSelectedItem() + "-" + dobMonthComboBox.getSelectedItem() + "-" + dobDayComboBox.getSelectedItem();
            String startDate = msYearComboBox.getSelectedItem() + "-" + msMonthComboBox.getSelectedItem() + "-" + msDayComboBox.getSelectedItem();

            // Create and add new RegularMember
            RegularMember newMember = new RegularMember(
                id,
                nameField.getText(),
                locationField.getText(),
                phoneField.getText(),
                emailField.getText(),
                gender,
                dob,
                startDate,
                referralField.getText()
            );

            members.add(newMember);
            resultRegularArea.append("Added Regular Member: " + id + "\n");

        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Please enter a number for ID!");
        }
    }
});

        addPremiumButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        // Check if any required fields are empty
        if (
            isEmpty(idField) ||
            isEmpty(nameField) ||
            isEmpty(locationField) ||
            isEmpty(phoneField) ||
            isEmpty(emailField) ||
            isEmpty(referralField) ||
            isEmpty(trainerField) ||
            (!maleRadio.isSelected() && !femaleRadio.isSelected())
        ) {
            JOptionPane.showMessageDialog(frame, "Please fill in all required fields and select gender.");
            return;
        }
        // Proceed with adding Premium Member if all validations pass
        try {
            int id = Integer.parseInt(idField.getText());
            boolean idExists = false;

            // Check if ID already exists
            for (GymMember m : members) {
                if (m.getId() == id) {
                    idExists = true;
                    break;
                }
            }

            if (idExists) {
                JOptionPane.showMessageDialog(frame, "ID already exists!");
                return;
            }

            // Determine gender
            String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Unknown";

            // Get DOB and Membership Start Date
            String dob = dobYearComboBox.getSelectedItem() + "-" + dobMonthComboBox.getSelectedItem() + "-" + dobDayComboBox.getSelectedItem();
            String startDate = msYearComboBox.getSelectedItem() + "-" + msMonthComboBox.getSelectedItem() + "-" + msDayComboBox.getSelectedItem();

            // Create and add new PremiumMember
            PremiumMember newMember = new PremiumMember(
                id,
                nameField.getText(),
                locationField.getText(),
                phoneField.getText(),
                emailField.getText(),
                gender,
                dob,
                startDate,
                trainerField.getText()
            );

            members.add(newMember);
            resultPremiumArea.append("Added Premium Member: " + id + "\n");

        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Please enter a number for ID!");
        }
    }
});

/**
 * Activates a member's account by ID:
 * - Searches members list
 * - Updates status and displays confirmation
 */
 activateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            int id = Integer.parseInt(idField.getText());
            for (GymMember m : members) {
                if (m.getId() == id) {
                    m.activateMembership();
                    if (m instanceof RegularMember) {
                        resultRegularArea.append("Activated: " + id + "\n");
                    } else if (m instanceof PremiumMember) {
                        resultPremiumArea.append("Activated: " + id + "\n");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Member not found!");
        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format!");
        }
    }
});

/**
 * Deactivates a member's account by ID:
 * - Verifies active status
 * - Updates status across member types
 */ 
deactivateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            int id = Integer.parseInt(idField.getText());
            for (GymMember m : members) {
                if (m.getId() == id) {
                    m.deactivateMembership();
                    if (m instanceof RegularMember) {
                        resultRegularArea.append("Deactivated: " + id + "\n");
                    } else if (m instanceof PremiumMember) {
                        resultPremiumArea.append("Deactivated: " + id + "\n");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Member not found!");
        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format!");
        }
    }
});
        
/**
 * Records attendance and awards loyalty points:
 * - Regular members: 5 points
 * - Premium members: 10 points
 * - Checks active status first
 */
markAttendanceButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            int id = Integer.parseInt(idField.getText());
            for (GymMember m : members) {
                if (m.getId() == id) {
                    if (!m.isActiveStatus()) {
                        JOptionPane.showMessageDialog(frame, "Cannot mark attendance. Member is not active!");
                        return;
                    }
                    m.markAttendance();
                    if (m instanceof RegularMember) {
                        resultRegularArea.append("Attendance marked for Member ID: " + id + "\n");
                    } else if (m instanceof PremiumMember) {
                        resultPremiumArea.append("Attendance marked for Member ID: " + id + "\n");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Member not found!");
        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format!");
        }
    }
});

/**
 * Calculates 10% discount for Premium Members:
 * - Only applies if full payment was made
 * - Displays in discount field
 */
calculateDiscountButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            if (idField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!");
                return;
            }
            int id = Integer.parseInt(idField.getText());
            for (GymMember m : members) {
                if (m.getId() == id && m instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) m;
                    if (!pm.isActiveStatus()) {
                        JOptionPane.showMessageDialog(frame, "Discount cannot be applied! Member is inactive.");
                        return;
                    }
                    double discount = pm.calculateDiscount();
                    if (pm.isFullPayment()) {
                        discountAmountField.setText(discount + "");
                         resultPremiumArea.append("Discount for Member " + id + ": " + discount + "\n");
                    } else {
                        discountAmountField.setText("0%");
                         resultPremiumArea.append("To get a discount, make full payment first.\n");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Premium Member not found!");
        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format! Please enter a valid number.");
        }
    }
});

/**
 * Handles plan upgrades for Regular Members:
 * - Validates payment amount
 * - Checks attendance eligibility
 * - Updates plan and price
 */
upgradeButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            if (idField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!");
                return;
            }
            int id = Integer.parseInt(idField.getText());
            String newPlan = (String) PlanComboBox.getSelectedItem();

            for (GymMember m : members) {
                if (m.getId() == id) {
                    if (!m.isActiveStatus()) {
                        JOptionPane.showMessageDialog(frame, "Only active members can upgrade plans.");
                        return;
                    }
                    if (m instanceof RegularMember) {
                        String input = JOptionPane.showInputDialog(frame, "Enter payment amount for plan upgrade:");
                        if (input == null || input.equals("")) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid amount!");
                            return;
                        }
                        double payment = Double.parseDouble(input);
                        String result = ((RegularMember) m).upgradePlan(newPlan, payment);
                        resultRegularArea.append(result + "\n");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Only Regular Members can upgrade plans.");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Member ID not found!");
        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID or payment amount!");
        }
    }
});

/**
 * Processes partial/full payments for Premium Members:
 * - Tracks remaining balance
 * - Updates payment status
 */
 payDueButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            if (idField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!");
                return;
            }
            int id = Integer.parseInt(idField.getText());

            // Directly prompt for payment amount and parse
            String input = JOptionPane.showInputDialog(frame, "Enter amount to pay:");
            if (input == null || input.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount!");
                return;
            }
            double amount = Double.parseDouble(input);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "Please enter a positive amount!");
                return;
            }

            for (int i = 0; i < members.size(); i++) {
                if (members.get(i).getId() == id && members.get(i) instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) members.get(i);
                    String result = pm.payDueAmount(amount);

                    resultPremiumArea.append(result + "\n");
                    paidAmountField.setText(String.valueOf(pm.getPaidAmount()));
                    double remaining = pm.getPremiumCharge() - pm.getPaidAmount();
                    resultPremiumArea.append("Remaining To Be Paid: " + remaining + "\n");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Premium Member not found!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid ID or amount! Enter a valid number.");
        }
    }
});

/**
 * Resets Regular Member to default state:
 * - Clears attendance and points
 * - Logs removal reason
 */
 revertRegularButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            int id = Integer.parseInt(idField.getText());
            String removalReason = removalReasonField.getText();
            boolean removed = false;

            for (int i = 0; i < members.size(); i++) {
                GymMember m = members.get(i);
                if (m.getId() == id && m instanceof RegularMember) {
                    ((RegularMember)m).revertRegularMember(removalReason);
                    members.remove(i); // Remove from ArrayList
                   resultRegularArea.append("Reverted Regular Member: " + id + "\nReason: " + removalReason + "\n");
                    resultRegularArea.setText("");
                    JOptionPane.showMessageDialog(frame, 
                        "Regular Member with ID " + id + " has been successfully reverted.\nReason: " + removalReason,
                        "Member Reverted", 
                        JOptionPane.INFORMATION_MESSAGE);
                    removed = true;
                    break;
                }
            }

            if (!removed) {
                JOptionPane.showMessageDialog(frame, "Regular Member not found!");
            }
        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format!");
        }
    }
});

/**
 * Resets Premium Member to default state:
 * - Clears trainer assignment
 * - Resets payment status
 */
revertPremiumButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try {
            int id = Integer.parseInt(idField.getText()); 
            boolean removed = false;
            String removalReason = removalReasonField.getText();
            for (int i = 0; i < members.size(); i++) {
                GymMember m = members.get(i);
                if (m.getId() == id && m instanceof PremiumMember) {
                    ((PremiumMember)m).revertPremiumMember();
                    members.remove(i); // Remove from ArrayList
                    resultPremiumArea.append("Reverted Premium Member: " + id + "\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Premium Member with ID " + id + " has been successfully reverted.\nReason: " + removalReason,
                        "Member Reverted", 
                        JOptionPane.INFORMATION_MESSAGE);
                    removed = true;
                    resultPremiumArea.setText("");
                    break;
                }
            }

            if (!removed) {
                JOptionPane.showMessageDialog(frame, "Premium Member not found!");
            }
        } catch (NumberFormatException y) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format!");
        }
    }
});

/**
 * Displays all Regular Member details:
 * - Shows comprehensive profile
 * - Formats output clearly
 */
displayRegularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultRegularArea.setText(""); // Only clear regular area
                boolean found = false;
                for (GymMember m : members) {
                    if (m instanceof RegularMember) {
                        found = true;
                        resultRegularArea.append("ID: " + m.getId() + "\n");
                        resultRegularArea.append("Name: " + m.getName() + "\n");
                        resultRegularArea.append("Location: " + m.getLocation() + "\n");
                        resultRegularArea.append("Phone: " + m.getPhone() + "\n");
                        resultRegularArea.append("Email: " + m.getEmail() + "\n");
                        resultRegularArea.append("Gender: " + m.getGender() + "\n");
                        resultRegularArea.append("Date of Birth: " + m.getDOB() + "\n");
                        resultRegularArea.append("Membership Start Date: " + m.getMembershipStartDate() + "\n");
                        resultRegularArea.append("Attendance: " + m.getAttendance() + "\n");
                        resultRegularArea.append("Loyalty Points: " + m.getLoyaltyPoints() + "\n");
                        resultRegularArea.append("Active Status: " + (m.isActiveStatus() ? "Active" : "Inactive") + "\n");
                        RegularMember rm = (RegularMember) m;
                        resultRegularArea.append("Plan: " + rm.getPlan() + "\n");
                        resultRegularArea.append("Price: " + rm.getPrice() + "\n");
                        if (!rm.getRemovalReason().isEmpty()) {
                            resultRegularArea.append("Removal Reason: " + rm.getRemovalReason() + "\n");
                        }
                        resultRegularArea.append("-------------------------\n");
                    }
                }
                if (!found) resultRegularArea.append("No Regular Members found.\n");
            }
});

/**
 * Displays all Premium Member details:
 * - Includes payment information
 * - Shows discount eligibility
 */
displayPremiumButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
                resultPremiumArea.setText(""); // Only clear premium area
                boolean found = false;
                for (GymMember m : members) {
                    if (m instanceof PremiumMember) {
                        found = true;
                        resultPremiumArea.append("ID: " + m.getId() + "\n");
                        resultPremiumArea.append("Name: " + m.getName() + "\n");
                        resultPremiumArea.append("Location: " + m.getLocation() + "\n");
                        resultPremiumArea.append("Phone: " + m.getPhone() + "\n");
                        resultPremiumArea.append("Email: " + m.getEmail() + "\n");
                        resultPremiumArea.append("Gender: " + m.getGender() + "\n");
                        resultPremiumArea.append("Date of Birth: " + m.getDOB() + "\n");
                        resultPremiumArea.append("Membership Start Date: " + m.getMembershipStartDate() + "\n");
                        resultPremiumArea.append("Attendance: " + m.getAttendance() + "\n");
                        resultPremiumArea.append("Loyalty Points: " + m.getLoyaltyPoints() + "\n");
                        resultPremiumArea.append("Active Status: " + (m.isActiveStatus() ? "Active" : "Inactive") + "\n");
                        PremiumMember pm = (PremiumMember) m;
                        resultPremiumArea.append("Personal Trainer: " + pm.getPersonalTrainer() + "\n");
                        resultPremiumArea.append("Paid Amount: " + pm.getPaidAmount() + "\n");
                        resultPremiumArea.append("Full Payment: " + (pm.isFullPayment() ? "Yes" : "No") + "\n");
                        double remaining = pm.getPremiumCharge() - pm.getPaidAmount();
                        resultPremiumArea.append("Remaining To Be Paid: " + remaining + "\n");
                        if (pm.isFullPayment()) resultPremiumArea.append("Discount Amount: " + pm.getDiscountAmount() + "\n");
                        resultPremiumArea.append("-------------------------\n");
                    }
                }
                if (!found) resultPremiumArea.append("No Premium Members found.\n");
    }
});

/**
 * Clears input fields while preserving ID:
 * - Smart clearing based on member type
 * - Maintains context for continued operations
 */
clearButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        // Store id before clearing fields
        String idText = idField.getText();

        // Reset all text fields
        idField.setText("");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        referralField.setText("");
        removalReasonField.setText("");
        trainerField.setText("");
        genderGroup.clearSelection();

        // Clear only the appropriate area
        try {
            int id = Integer.parseInt(idText);
            for (GymMember m : members) {
                if (m.getId() == id) {
                    if (m instanceof RegularMember) {
                        resultRegularArea.setText("");
                    } else if (m instanceof PremiumMember) {
                        resultPremiumArea.setText("");
                    }
                    break;
                }
            }
        } catch (Exception e) {
            
        }
    }
});

/**
 * Saves all member data to file:
 * - Creates formatted text report
 * - Handles both member types
 */
saveToFileButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        try (PrintWriter writer = new PrintWriter("MemberDetails.txt")) {
            // Header as per assignment hint and screenshot
            writer.printf("%-5s %-15s %-15s %-15s %-25s %-20s %-15s %-15s %-10s %-10s %-10s %-15s %-15s %-15s %-15s\n",
                "ID", "Name", "Location", "Phone", "Email", "DOB", "Membership Start Date",
                "Plan", "Price", "Attendance", "Loyalty Points", "Active Status", "Full Payment", "Discount Amount", "Net Amount Paid");
            writer.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (GymMember m : members) {
                String plan = "Regular";
                String price = "6500";
                String fullPayment = "-";
                String discount = "-";
                String netAmountPaid = "-";
                
                if (m instanceof RegularMember) {
                    RegularMember rm = (RegularMember) m;
                    plan = rm.getPlan();
                    price = String.valueOf(rm.getPrice());
                    // For RegularMember, assume full payment always true after registration
                    fullPayment = "true";
                    // No discount or net amount tracking for regular
                } else if (m instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) m;
                    plan = "Premium";
                    price = "50000";
                    fullPayment = String.valueOf(pm.isFullPayment());
                    discount = pm.getDiscountAmount() == 0.0 ? "NA" : String.format("%.2f", pm.getDiscountAmount());
                    netAmountPaid = String.format("%.0f", pm.getPaidAmount());
                }
                
                writer.printf("%-5s %-15s %-15s %-15s %-25s %-20s %-15s %-15s %-10s %-10s %-10s %-15s %-15s %-15s %-15s\n",
                    m.getId(),
                    m.getName(),
                    m.getLocation(),
                    m.getPhone(),
                    m.getEmail(),
                    m.getDOB(),
                    m.getMembershipStartDate(),
                    plan,
                    price,
                    m.getAttendance(),
                    m.getLoyaltyPoints(),
                    m.isActiveStatus(),
                    fullPayment,
                    discount,
                    netAmountPaid
                );
            }
            JOptionPane.showMessageDialog(frame, "Data saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving file!");
        }
    }
});

/**
 * Reads and displays saved member data:
 * - Opens separate window
 * - Preserves original formatting
 */
readFromFileButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent x) {
        JFrame fileFrame = new JFrame("Member Details From File");
        JTextArea fileArea = new JTextArea();
        fileArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fileArea);

        fileFrame.setSize(600, 700);
        fileFrame.add(scrollPane);

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("MemberDetails.txt"))) {
            String line;
            fileArea.setText("");
            while ((line = reader.readLine()) != null) {
                fileArea.append(line + "\n");
            }
        } catch (java.io.FileNotFoundException y) {
            fileArea.setText("MemberDetails.txt not found!");
        } catch (java.io.IOException ex) {
            fileArea.setText("Error reading file: " + ex.getMessage());
        }

        fileFrame.setVisible(true);
    }
});
 
frame.setVisible(true);
}

    private boolean isEmpty(JTextField field) {
    return field.getText().isEmpty();
}
    //main method
public static void main(String[] args) {
        new GymGUI(); //object
}
}