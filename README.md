# MP0485 Book Inventory Management System

A Java-based book inventory management application with a graphical user interface built using Swing. The system allows users to manage a collection of books with persistent storage.

## Project Overview

This project implements a complete book inventory management system featuring:
- Object-oriented design with a `Book` class
- HashMap-based inventory storage using ISBN as keys
- Graphical interface using JSwing
- Text file persistence for data storage
- Full CRUD operations (Create, Read, Update, Delete)

---

### Phase 1: Core Classes

#### Issue #1 — Create the `Book` class
 Create a `Book` class with the following attributes:
- `title` (String)
- `authors` (ArrayList<String>)
- `price` (double)
- `stockQuantity` (int)

Implement getters, setters, and a constructor with all attributes.

---

#### Issue #2 — Override `equals()` and `hashCode()`
 Override the `equals()` and `hashCode()` methods in the `Book` class.

**Important:** The comparison must be based solely on the `title` attribute.

---

####  Issue #3 — Create the inventory `HashMap`
In the `main` method, declare and initialize a `HashMap<String, Book>` called `bookInventory`, where:
- **Key:** ISBN (String)
- **Value:** Book object

---

### Phase 2: Data Persistence

#### Issue #4 — Text file persistence
Implement reading and writing of the inventory to a plain text file that acts as internal memory.

**Acceptance Criteria:**
- On startup, if the file exists, load the inventory from it
- On exit (option 4), serialize the inventory to the file
- If the file does not exist on startup, begin with an empty inventory

---

### Phase 3: User Interface & Operations

#### Issue #5 — Main menu with JSwing
Implement the graphical interface using JSwing, displaying a menu with the following options:
1. Add book
2. Update book
3. Delete book
4. Exit

---

#### Issue #6 — Feature: Add book
**Type:** Feature  
**Dependencies:** #1, #2, #3, #5  
**Description:** Implement the "Add book" menu option with comprehensive input validation.

**Workflow:**
1. Prompt the user for: title, authors, price, and stock quantity
2. Use `equals()` and `hashCode()` to check if the book already exists in `bookInventory`
3. If it exists → display: "Book already exists"
4. If not → create a new `Book` object and add it to `bookInventory`

**Validation Requirements:**

- **Empty Fields Validation**  
  Display error if any required field is empty
  
  ![Empty Fields](https://github.com/user-attachments/assets/ab3dc078-192e-40a1-a0e0-7ab688e70b3e)
  

- **Numeric Fields Validation**  
  Ensure price and stock quantity are valid numbers (not text)
  
  ![Numeric Fields](https://github.com/user-attachments/assets/b546db56-4458-410c-a2c3-f09df2acf114)


- **Price Validation**  
  Reject prices below 0
  
  ![Price Validation](https://github.com/user-attachments/assets/1b29c702-627e-4a4e-be41-b0121b2b45c6)
  

- **Multiple Authors Support**  
  Allow books with more than one author (stored in ArrayList)
  
  ![Multiple Authors](https://github.com/user-attachments/assets/38222514-98e5-4bc1-88ae-ffc7c14aeb5a)
  

- **Duplicate Book Prevention**  
  Display "Book already exists" if title already in inventory
  
  ![Book Already Exists](https://github.com/user-attachments/assets/b65c54c0-6881-414b-9530-5a3bf2cdbb81)
  

**File Persistence Format:**

Books are stored in `book.txt` with the following structure:
```
ISBN;Title;Author1,Author2,Author3;Price;StockQuantity
```

Example file content:
```
978-3-16-148410-0;The Great Gatsby;F. Scott Fitzgerald;12.99;5
978-0-06-112008-4;To Kill a Mockingbird;Harper Lee;14.99;3
978-0-7432-7356-5;1984;George Orwell;13.99;8
```

![File Format Example 1](https://github.com/user-attachments/assets/21693cac-8f0e-4b37-bda3-0c42233122a9)
![File Format Example 2](https://github.com/user-attachments/assets/e7adbdc0-f3e5-4b07-9f1b-7ed5b0235e72)

---

#### Issue #7 — Feature: Update book
Implement the "Update book" option with comprehensive input validation.

**Workflow:**
1. Prompt the user for the title of the book to update
2. If the book exists in `bookInventory`:
   - Ask for the new price and stock quantity
   - Update the values
3. If not found → display: "Book not found"

**Validation Requirements:**

- **Empty Fields Validation**  
  Display error if title, price, or stock quantity fields are empty
  
  ![Empty Fields](https://github.com/user-attachments/assets/4ab54095-8960-46b0-9e72-6031e5f191e6)
  

- **Price Below 1 Validation**  
  Reject prices less than 1 (must be positive)
  
  ![Price Below 1](https://github.com/user-attachments/assets/e4fee10c-11fc-4e62-831c-47f01e77e4b3)
  

- **Price Not Numeric Validation**  
  Ensure price is a valid number, not text
  
  ![Price Not Numeric](https://github.com/user-attachments/assets/dd4ee202-0896-4998-ab64-7b339ec0c657)
  

- **Non-Existing Book Update**  
  Display "Book not found" if book title doesn't exist in inventory
  
  ![Update Non-Existing Book](https://github.com/user-attachments/assets/a5687bd7-5c13-4bb2-8eee-ae25e587b4d7)
  

- **Successful Update Example**  
  When a book is successfully updated, the file and inventory are updated
  
  ![Update Existing Book - Before](https://github.com/user-attachments/assets/a89e0fc2-ef42-4e7d-9152-abec9dbd571c)
  ![Update Dialog](https://github.com/user-attachments/assets/def8112a-6256-44bf-b78e-f50c8b1af723)
  ![Update Existing Book - After](https://github.com/user-attachments/assets/f8b73b6c-8171-4a18-ba99-300c25a34f34)

---

#### Issue #8 — Feature: Delete book
Implement the "Delete book" option with input validation.

**Workflow:**
1. Prompt the user for the title of the book to delete
2. If the book exists → remove it from `bookInventory`
3. If not found → display: "Book not found"

**Validation Requirements:**

- **Empty Field Validation**  
  Display error if the title field is empty
  
  ![Empty Field](https://github.com/user-attachments/assets/55cd505c-1e8e-4dd5-ae28-8c342ea8054d)
  

- **Non-Existing Book Deletion**  
  Display "Book not found" if book title doesn't exist in inventory
  
  ![Delete Non-Existing Book](https://github.com/user-attachments/assets/3c52d630-f8f0-46e8-9f0a-17f3eacd1bb5)
  

- **Successful Deletion Example**  
  When a book is successfully deleted, it's removed from inventory and file is updated
  
  ![Delete Book - Before](https://github.com/user-attachments/assets/64a712aa-3ad3-4ffb-bec1-e6bcd9c6db68)
  
  ![Delete Dialog](https://github.com/user-attachments/assets/9dcf7c27-557d-4f22-b283-56c18b0f8075)
  
  ![Delete Book - After](https://github.com/user-attachments/assets/d3ce78af-d41d-467e-806c-c6df14ff855c)

---

#### Issue #9 — Feature: Exit and save
Implement the "Exit" option.

**Workflow:**
1. When selected, save the full contents of `bookInventory` to the text file
2. Close the application

---
