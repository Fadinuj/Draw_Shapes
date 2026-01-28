# 🎨 Java Geometric Shape Editor

A robust **Object-Oriented** drawing application developed in Java. This project provides a graphical interface for creating, manipulating, and managing complex 2D geometric shapes, demonstrating advanced software engineering principles.

## 🌟 Features

### 📐 Geometric Shapes
Supports a wide variety of primitives implementing a shared `GeoShape` interface:
* **Circles** (2D radius & center)
* **Polygons** (Arbitrary number of vertices)
* **Triangles** & **Rectangles**
* **Segments** & **Points**

### 🛠️ Operations & Algorithms
* **Manipulation:** Move, Copy, Rotate (around a pivot), and Scale (Resize) shapes.
* **Persistence:** Save and Load current canvas state to/from text files.
* **Sorting:** Advanced sorting algorithms using `Comparator` (sort by Area, Perimeter, or Tag).
* **Geometric Logic:** Algorithms for "Point-in-Polygon", intersection checks, area and perimeter calculations.

### 💻 Graphical User Interface (GUI)
* Built on top of `StdDraw`.
* Interactive mouse events (Draw, Select, Drag).
* Dynamic canvas with double-buffering for smooth rendering.

## 🏗️ Architecture & Design

The project follows strict **OOP principles**:
* **Interfaces:** `GeoShape` defines the contract for all geometric objects, ensuring polymorphism.
* **Design Patterns:** Uses **Singleton Pattern** for the main GUI controller (`Ex2` class) to manage the application state.
* **Collections:** efficient management of shape layers using `ArrayList` within a custom `ShapeCollection` class.

## 🧪 Testing
Includes a comprehensive **JUnit 5** test suite verifying:
* Geometric accuracy (Area/Perimeter calculations).
* Logical correctness (Contains/Intersect methods).
* Data integrity (Save/Load consistency).

## 🚀 How to Run
1.  Clone the repository:
    ```bash
    git clone [https://github.com/Fadinuj/Java-Geometric-Shape-Editor.git](https://github.com/Fadinuj/Java-Geometric-Shape-Editor.git)
    ```
2.  Open the project in **IntelliJ IDEA** or **Eclipse**.
3.  Run the `Ex2_main.java` file to launch the GUI.
4.  **Usage:**
    * Select a shape type from the menu.
    * Click on the canvas to draw.
    * Right-click to complete a Polygon/Triangle.
