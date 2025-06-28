# Gym Membership Management System 💪

A Java-based application built using Object-Oriented Programming concepts and Java Swing. It helps gym staff manage regular and premium members through an intuitive graphical user interface.

---

## 🧱 Architecture Overview

### 🧬 `GymMember` (Abstract Class)
A foundational blueprint for all types of gym members. Contains:
- 👤 Name, Member ID, Gender, Date of Birth
- 🧾 Common behaviors like calculating fees or tracking attendance  
Being abstract, it ensures consistency across member types but isn’t instantiated directly.

### 🔹 `RegularMember` (Subclass)
Represents standard gym-goers who pay the base fee and receive basic access.
- 🏋️ Access to standard equipment
- 🚫 No premium classes or personal trainers
- 🪪 Instance created for every regular membership registration

### 🔸 `PremiumMember` (Subclass)
Offers enhanced benefits for members who pay extra.
- 🧑‍🏫 Access to personal trainers and group classes
- 🎁 Possible discounts on products or services
- 💼 Includes additional attributes or methods exclusive to premium users

---

## 🖥️ `GymGUI` – Graphical User Interface
Built using **Java Swing**, it’s the interactive part of the system for gym staff. Allows:
- ➕ Adding new members (Regular or Premium)
- ✏️ Editing or updating member info
- 🗑️ Removing members
- 📄 Viewing member details through clean and organized windows

No need to navigate confusing text files — the GUI handles everything behind the scenes!

---

## 🔄 How It All Comes Together
1. Staff opens the GUI and enters a new member’s info.
2. Based on membership type, either a `RegularMember` or `PremiumMember` object is created.
3. All member objects are stored and managed within the system.
4. The abstract `GymMember` ensures a consistent structure for all member records.
5. The system is scalable — easily extendable for new membership types in the future.

---

## 🛠️ Technologies Used
- Java (OOP Concepts: Inheritance, Polymorphism, Abstraction)
- Java Swing (GUI Design)
- BlueJ

---
