# 🎭 Theatrical Players Refactoring Kata

This project is a Java implementation of the **Theatrical Players Refactoring Kata**, completed as part of my university coursework.  
The main goal was to apply principles of **refactoring**, **object-oriented design**, and **separation of concerns** to produce clean, testable, and maintainable code.

---

## 📋 Learning Objectives

- Refactor a tightly coupled initial codebase
- Apply SOLID principles
- Introduce meaningful business abstractions (e.g., `Play`, `Invoice`, `Performance`)
- Improve readability and testability

---

## 🧪 Tests

For this project, I chose **not to include additional unit tests**, as all computed values are reflected in the generated `.txt` and `.html` files.  
These outputs serve as **approval tests** and make it intuitive to spot incorrect values in case of errors.

✅ Test coverage includes:
- Generating a `.txt` statement with and without discounts
- Generating a `.html` statement with and without discounts

---

## 🧱 Project Structure

### `Play` and its subclasses

- `Play` is an **abstract class** representing a generic play.
- Two concrete subclasses were created:
  - `Tragedy`
  - `Comedy`

Each subclass contains its own rules for calculating price and credits, following the **Open/Closed Principle** and encapsulating type-specific logic.

---

### `Customer`

The `Customer` class models a customer with the following fields:
- `name`
- `id`
- `creditBalance`

It is used to associate multiple performances with a single customer.

---

### `Invoice` & `Performance`

These classes represent:
- An **invoice** containing several performances (`Invoice`)
- An individual **performance** entry (`Performance`)

They also contain methods for calculating key values (price, volume credits, etc.).

---

### `InvoiceData` & `PerformanceData`

These are simple **data transfer objects (DTOs)** used to:
- Store processed information
- Pass data cleanly to output rendering components

---

### `StatementPrinter`

This class is responsible for **generating the final reports**, either:
- As plain text (`.txt`)
- As HTML (`.html`)

It takes pre-calculated data and handles formatting and display logic.

---

## 📄 License

This project is under the MIT license. See the [LICENSE](LICENSE) file for more information.

---

## 👤 Author

Mark Ballereau  
[LinkedIn](https://www.linkedin.com/in/markblre) | [GitHub](https://github.com/markblre)
