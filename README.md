# MyStore Automation Project

## 📝 Overview

This project automates key functionalities of the MyStore web application using **Selenium WebDriver** and **TestNG**. It includes user interactions such as logging in, filtering products by price, adding specific products (like *Sauce Labs Onesie*) to the cart, and logging out — all structured using the Page Object Model (POM) design pattern.

---

## 🛠️ Tech Stack Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven** (for build and dependency management)
- **Page Object Model (POM)** for clean structure and maintainability
- **Eclipse / IntelliJ** (recommended IDEs)

---

## ✅ Prerequisites

Before running the tests, ensure you have the following installed:

- Java JDK (8 or higher)
- Maven
- ChromeDriver (or any compatible WebDriver)
- IDE like Eclipse or IntelliJ
- Internet connection (to access the web app)

---

## 🚀 How to Run the Tests

1. **Clone or download** this repository.
2. **Open** the project in your preferred Java IDE.
3. Ensure all Maven dependencies are installed (use `mvn clean install` if needed).
4. Locate the `login.xml` , `orderProdut.xml` and `filterProduct.xml` TestNG suite file.
5. **Right-click** on `login.xml`, select: 1 TestNG Suite
