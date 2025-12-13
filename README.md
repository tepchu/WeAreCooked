# WEARECOOKED - A Pizza Making Adventure

<div>

**A fast-paced cooperative cooking game inspired by Overcooked!**

Cook pizzas, manage orders, and avoid burning the kitchen down!

</div>

---

## 📋 Table of Contents

[About](#-about)
[Features](#-features)
[System Requirements](#-system-requirements)
[Installation](#-installation)
[How to Run](#-how-to-run)
[How to Play](#-how-to-play)
[Game Mechanics](#-game-mechanics)
[Controls](#-controls)
[Project Structure](#-project-structure)
[Technologies](#-technologies)
[Contributors](#-contributors)

---

## 🎮 About

**WEARECOOKED** is a cooking simulation game where you manage two chefs working together to fulfill pizza orders under
time pressure. Navigate through a kitchen filled with various stations, chop ingredients, assemble pizzas, bake them in
the oven, and serve them before time runs out!

The game features:

🧑‍🍳 **Dual Chef Control** - Switch between two chefs (Chef 1 and Chef 2)

🍕 **Multiple Pizza Recipes** - Pizza Margherita, Pizza Sosis, and Pizza Ayam

⏱️ **Time Management** - Complete orders before they expire

🎯 **Star Rating System** - Earn up to 3 stars per level

📦 **Multiple Levels** - 5 predefined levels with increasing difficulty

---

## ✨ Features

### Core Gameplay

- **Two Controllable Chefs** - Switch between chefs with the B key
- **Order Management System** - Dynamic order queue with timers
- **Progressive Difficulty** - Levels get harder with tighter time limits
- **Score System** - Earn rewards for completed orders, penalties for failures
- **Ingredient Processing** - Chop, assemble, and bake ingredients

### Advanced Mechanics

- **Command Pattern** - Undo/Redo functionality (Z/Y keys)
- **Dash Mechanic** - Quick movement with Shift+WASD (3-second cooldown)
- **Throw Mechanic** - Pass ingredients between chefs (SPACE key)
- **Station Interactions** - Cutting, cooking, washing, assembly, and more
- **Ingredient State Management** - RAW and CHOPPED states with validation
- **Automatic Plate Return** - Dirty plates return after 10 seconds

### Stations Available

🔪 **Cutting Station** - Chop raw ingredients (3 seconds)

🔥 **Cooking Station (Oven)** - Bake pizzas (12 seconds, burns after 24s)

🧺 **Assembly Station** - Combine ingredients on plates

🚰 **Washing Station** - Clean dirty plates (3 seconds)

📦 **Ingredient Storage** - Get raw ingredients (unlimited)

🍽️ **Plate Storage** - Get clean plates

🗑️ **Trash Station** - Discard mistakes

🔔 **Serving Counter** - Submit completed orders

---

## 💻 System Requirements

### Minimum Requirements

- **Operating System**: Windows 10/11, macOS 10.14+, or Linux (Ubuntu 20.04+)
- **Java Version**: JDK 17 or higher
- **RAM**: 2 GB minimum
- **Storage**: 100 MB available space
- **Display**: 800x600 resolution minimum

### Recommended

- **Java Version**: JDK 21
- **RAM**: 4 GB
- **Display**: 1920x1080 resolution

---

## 🚀 Installation

### Prerequisites

1. **Install Java Development Kit (JDK) 17+**

   **Windows:**
    - Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
      or [Adoptium](https://adoptium.net/)
    - Run the installer and follow the setup wizard
    - Add Java to PATH when prompted

   **macOS:**
   ```bash
   # Using Homebrew
   brew install openjdk@17
   ```

   **Linux (Ubuntu/Debian):**
   ```bash
   sudo apt update
   sudo apt install openjdk-17-jdk
   ```

2. **Verify Java Installation**
   ```bash
   java -version
   # Should show: java version "17.x.x" or higher
   ```

3. **Install Gradle (Optional - Project includes Gradle Wrapper)**

   The project includes `gradlew` (Unix) and `gradlew.bat` (Windows), so manual Gradle installation is not required.

### Download the Project

**Option 1: Clone with Git**

```bash
git clone https://github.com/tepchu/wearecooked.git
cd wearecooked
```

**Option 2: Download ZIP**

- Download the ZIP file from GitHub
- Extract to your desired location
- Navigate to the extracted folder

---

## 🎯 How to Run

### Using Gradle Wrapper (Recommended)

The project includes Gradle Wrapper, which automatically downloads the correct Gradle version.

**On Windows:**

```bash
# Navigate to project directory
cd wearecooked

# Run the game
gradlew.bat run
```

**On macOS/Linux:**

```bash
# Navigate to project directory
cd wearecooked

# Make gradlew executable (first time only)
chmod +x gradlew

# Run the game
./gradlew run
```

### Building the Project

**Build JAR file:**

```bash
# Windows
gradlew.bat build

# macOS/Linux
./gradlew build
```

The JAR file will be created in: `build/libs/wearecooked.jar`

**Run the JAR:**

```bash
java -jar build/libs/wearecooked.jar
```

### Cleaning Build Files

```bash
# Windows
gradlew.bat clean

# macOS/Linux
./gradlew clean
```

---

## 🎮 How to Play

### Game Objective

Complete as many pizza orders as possible within the time limit while avoiding failed orders. Earn 3 stars by reaching
the target score!

### Basic Workflow

1. **Get Ingredients** → Go to Ingredient Storage stations (I)
2. **Chop Ingredients** → Use Cutting Station (C) - 3 seconds per ingredient
3. **Get a Plate** → Go to Plate Storage (P)
4. **Assemble Pizza** → Add chopped ingredients to plate at Assembly Station (A)
5. **Bake Pizza** → Place in Oven (R) - 12 seconds to bake
6. **Serve** → Deliver at Serving Counter (S) before order expires

### Important Rules

#### Ingredient States

✅ **RAW ingredients** can be picked up from plates (to fix mistakes)

❌ **CHOPPED ingredients** are permanent once on a plate

✅ Can combine RAW with RAW or CHOPPED with CHOPPED

❌ **Cannot mix RAW and CHOPPED** on the same plate

❌ **Oven only accepts fully CHOPPED pizzas**

#### Pizza Requirements

All pizzas need **chopped ingredients**:

**Pizza Margherita**: Dough + Tomato + Cheese
**Pizza Sosis**: Dough + Tomato + Cheese + Sausage
**Pizza Ayam**: Dough + Tomato + Cheese + Chicken

#### Order System

- Orders appear in the top panel with timers
- Complete orders before time runs out
- Wrong orders = penalty (50% of reward)
- Expired orders = penalty (30% of reward)
- Failed orders count (max 5 failures = game over)

### Tips & Strategies

1. **Chop All Ingredients First** - Don't put raw ingredients on plates
2. **Use Both Chefs** - Press B to switch, work in parallel
3. **Dash for Speed** - Shift+WASD moves 3 tiles instantly (3s cooldown)
4. **Throw Ingredients** - Press SPACE to pass items between chefs
5. **Watch Oven Timer** - Pizza burns after 24 seconds total (12s to bake, 12s before burning)
6. **Check Order Timers** - Prioritize orders about to expire
7. **Use Undo/Redo** - Press Z to undo, Y to redo mistakes
8. **Wash Plates** - Dirty plates auto-return after 10 seconds, or wash manually

---

## 🎮 Controls

### Movement & Actions

| Key                 | Action                           |
|---------------------|----------------------------------|
| **W/A/S/D**         | Move chef (Up/Left/Down/Right)   |
| **Shift + W/A/S/D** | Dash 3 tiles (3-second cooldown) |
| **X**               | Interact with station            |
| **C**               | Pick up / Drop item              |
| **SPACE**           | Throw item (3 tiles range)       |
| **B**               | Switch between Chef 1 and Chef 2 |
| **Z**               | Undo last action                 |
| **Y**               | Redo action                      |
| **ESC**             | Pause menu                       |

### Station Interactions (Press X)

**At Ingredient Storage (I):**

- Pick up raw ingredients (unlimited)
- Place ingredients on station
- Assemble with plate

**At Cutting Station (C):**

- Place raw ingredient to chop (3 seconds)
- Pick up chopped ingredients
- Can interrupt and resume chopping

**At Assembly Station (A):**

- Place plate to add ingredients
- Pick up RAW ingredients from plate (fixes mistakes)
- Assemble multiple ingredients

**At Cooking Station/Oven (R):**

- Place pizza to bake (12 seconds)
- Remove baked pizza with clean plate
- Burns after 24 seconds total

**At Washing Station (W):**

- Wash side: Place dirty plates, interact to wash (3 seconds)
- Clean side: Pick up washed plates

**At Plate Storage (P):**

- Pick up clean plates
- Deposit dirty plates

**At Serving Counter (S):**

- Submit completed orders
- Validates against order queue

**At Trash Station (T):**

- Discard burned items
- Throw away mistakes

---

## 🎯 Game Mechanics

### Scoring System

**Rewards:**

- Pizza Margherita: $120
- Pizza Sosis: $150
- Pizza Ayam: $160

**Penalties:**

- Wrong dish served: -50% of order reward
- Order expired: -30% of order reward
- Max failed orders: 5 (game over)

**Star Ratings:**

- 1 Star: Reach 33% of target score
- 2 Stars: Reach 67% of target score
- 3 Stars: Reach 100% of target score (level cleared)

### Level Progression

| Level | Name            | Time | Target | Max Orders | Difficulty |
|-------|-----------------|------|--------|------------|------------|
| 1     | Tutorial        | 270s | $200   | 5          | Easy       |
| 2     | Getting Started | 270s | $350   | 5          | Easy       |
| 3     | Warming Up      | 255s | $500   | 5          | Medium     |
| 4     | Rush Hour       | 255s | $650   | 5          | Medium     |
| 5     | Master Chef     | 225s | $800   | 6          | Hard       |

### Station Timings

- **Cutting**: 3 seconds per ingredient
- **Washing**: 3 seconds per plate
- **Baking**: 12 seconds (burns at 24 seconds)
- **Plate Return**: 10 seconds after serving
- **Dash Cooldown**: 3 seconds

---

## 📁 Project Structure

```
wearecooked/
├── src/
│   └── main/
│       ├── java/
│       │   ├── controllers/          # Game controllers
│       │   │   ├── GameController.java
│       │   │   └── Stage.java
│       │   ├── game/                 # Main entry point
│       │   │   └── Main.java
│       │   ├── models/               # Game models
│       │   │   ├── command/          # Command Pattern
│       │   │   │   ├── ChefCommand.java
│       │   │   │   ├── CommandInvoker.java
│       │   │   │   ├── MoveCommand.java
│       │   │   │   ├── DashCommand.java
│       │   │   │   ├── ThrowCommand.java
│       │   │   │   ├── PickupDropCommand.java
│       │   │   │   ├── InteractCommand.java
│       │   │   │   └── SwitchChefCommand.java
│       │   │   ├── core/             # Core classes
│       │   │   │   ├── Direction.java
│       │   │   │   └── Position.java
│       │   │   ├── enums/            # Enumerations
│       │   │   │   ├── IngredientState.java
│       │   │   │   ├── IngredientType.java
│       │   │   │   └── StationType.java
│       │   │   ├── factory/          # Factory Pattern
│       │   │   │   └── IngredientFactory.java
│       │   │   ├── ingredients/      # Ingredient classes
│       │   │   │   ├── Cheese.java
│       │   │   │   ├── Chicken.java
│       │   │   │   ├── Dough.java
│       │   │   │   ├── Sausage.java
│       │   │   │   └── Tomato.java
│       │   │   ├── item/             # Item classes
│       │   │   │   ├── Dish.java
│       │   │   │   ├── GameObject.java
│       │   │   │   ├── Ingredient.java
│       │   │   │   ├── Item.java
│       │   │   │   ├── PizzaDish.java
│       │   │   │   ├── Preparable.java
│       │   │   │   └── kitchenutensils/
│       │   │   │       ├── CookingDevice.java
│       │   │   │       ├── KitchenUtensil.java
│       │   │   │       ├── Oven.java
│       │   │   │       └── Plate.java
│       │   │   ├── level/            # Level management
│       │   │   │   ├── Level.java
│       │   │   │   └── LevelManager.java
│       │   │   ├── map/              # Map system
│       │   │   │   ├── GameMap.java
│       │   │   │   ├── MapLoader.java
│       │   │   │   └── MapType.java
│       │   │   ├── order/            # Order system
│       │   │   │   ├── Order.java
│       │   │   │   ├── OrderManager.java
│       │   │   │   ├── OrderQueue.java
│       │   │   │   └── RecipeMatcher.java
│       │   │   ├── player/           # Player classes
│       │   │   │   ├── ChefPlayer.java
│       │   │   │   └── CurrentAction.java
│       │   │   ├── recipe/           # Recipe system
│       │   │   │   ├── Recipe.java
│       │   │   │   ├── RecipeIngredientRequirement.java
│       │   │   │   ├── PizzaMargheritaRecipe.java
│       │   │   │   ├── PizzaSosisRecipe.java
│       │   │   │   ├── PizzaAyamRecipe.java
│       │   │   │   └── PizzaRecipeFactory.java
│       │   │   └── station/          # Station classes
│       │   │       ├── Station.java
│       │   │       ├── AssemblyStation.java
│       │   │       ├── CookingStation.java
│       │   │       ├── CuttingStation.java
│       │   │       ├── IngredientStorage.java
│       │   │       ├── PlateStorage.java
│       │   │       ├── ServingCounter.java
│       │   │       ├── TrashStation.java
│       │   │       └── WashingStation.java
│       │   ├── utils/                # Utilities
│       │   │   └── ImageManager.java
│       │   └── views/                # JavaFX Views
│       │       ├── GameView.java
│       │       ├── LevelSelectView.java
│       │       ├── MainMenuView.java
│       │       └── ResultView.java
│       └── resources/
│           └── images/               # Game assets
│               ├── chef1/            # Chef 1 sprites
│               ├── chef2/            # Chef 2 sprites
│               ├── ingredients/      # Ingredient sprites
│               ├── menu/             # Menu images
│               ├── pizza/            # Pizza sprites
│               ├── results/          # Result screen images
│               ├── stations/         # Station sprites
│               └── utensils/         # Utensil sprites
├── build.gradle                      # Gradle build file
├── settings.gradle                   # Gradle settings
├── gradlew                           # Gradle wrapper (Unix)
├── gradlew.bat                       # Gradle wrapper (Windows)
└── README.md                         # This file
```

---

## 🛠️ Technologies

### Core

- **Java 17** - Programming language
- **JavaFX 17** - GUI framework
- **Gradle 8.5** - Build automation tool

### Libraries & Dependencies

```gradle
dependencies {
    implementation 'org.openjfx:javafx-controls:17.0.2'
    implementation 'org.openjfx:javafx-fxml:17.0.2'
    implementation 'org.openjfx:javafx-graphics:17.0.2'
}
```

### Build Configuration

- **JavaFX Plugin**: `org.openjfx.javafxplugin:0.0.13`
- **Java Toolchain**: JDK 17
- **Main Class**: `game.Main`

---

## 👥 Contributors

### Development Team

**Team Name**: Wearecooked Team

**Team Members**: 18224117, 18224118, 18224126, 18223132

**Project**: WEARECOOKED - Pizza Cooking Game

**Version**: 1.0

---

## 📝 License

This project is created for educational purposes.

---

## 🐛 Troubleshooting

### Common Issues

**1. "Java version not compatible"**

```bash
# Check Java version
java -version

# Should show 17 or higher
# If not, install JDK 17+
```

**2. "Gradle build failed"**

```bash
# Clean and rebuild
./gradlew clean build --refresh-dependencies
```

**3. "JavaFX not found"**

- Ensure JavaFX is included in build.gradle
- Check if JavaFX modules are specified in the build file

**4. "Game window doesn't open"**

- Check console for error messages
- Ensure graphics drivers are up to date
- Try running with `--add-opens` flags if needed

**5. "Images not loading"**

- Verify `src/main/resources/images/` directory exists
- Check console for "ImageManager" error messages
- Game will use fallback colors if images fail

### Getting Help

- Check the console output for detailed error messages
- Verify all dependencies are correctly installed
- Ensure you're using JDK 17 or higher

---

<div align="center">

**Enjoy cooking! Don't burn the pizza! 🍕🔥**

Made with ❤️ by Wearecooked Team

</div>