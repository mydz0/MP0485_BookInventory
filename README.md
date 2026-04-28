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

## Features & Implementation Tasks

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

#### Issue #3 — Create the inventory `HashMap`
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
Implement the "Add book" menu option.

**Workflow:**
1. Prompt the user for: title, price, and stock quantity
2. Use `equals()` and `hashCode()` to check if the book already exists in `bookInventory`
3. If it exists → display: "Book already exists"
4. If not → create a new `Book` object and add it to `bookInventory`

---

#### Issue #7 — Feature: Update book
Implement the "Update book" option.

**Workflow:**
1. Prompt the user for the title of the book to update
2. If the book exists in `bookInventory`:
   - Ask for the new price and stock quantity
   - Update the values
3. If not found → display: "Book not found"

---

#### Issue #8 — Feature: Delete book
**Type:** Feature  
**Dependencies:** #1, #3, #5  
**Description:** Implement the "Delete book" option.

**Workflow:**
1. Prompt the user for the title of the book to delete
2. If the book exists → remove it from `bookInventory`
3. If not found → display: "Book not found"

---

#### Issue #9 — Feature: Exit and save
Implement the "Exit" option.

**Workflow:**
1. When selected, save the full contents of `bookInventory` to the text file
2. Close the application

---

Sequence to build the project efficiently:

1. Create the `Book` class
2. Override `equals()` and `hashCode()`
3. Create the inventory `HashMap`
4. Implement text file persistence
5. Build the JSwing menu interface
6. Implement "Add book" feature
7. Implement "Update book" feature
8. Implement "Delete book" feature
9. Implement "Exit and save" feature
