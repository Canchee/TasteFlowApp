# Taste Flow

Welcome to the README file of Taste Flow! This document will provide you with an overview of the app's features, technologies used, and instructions for building and running the project. 

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Unit Tests](#unit-tests)
- [Architecture](#architecture)

## Introduction

Taste Flow is a sophisticated Android application that leverages modern Android development practices to provide users with a seamless experience. The app is built using the MVVM architectural pattern along with the principles of Clean Architecture to ensure separation of concerns and maintainability.

## Features

Taste Flow offers a range of features to enhance your recipe discovery and exploration journey:

1. **Recipe Browsing and Filtering**
   - Browse a diverse collection of recipes with ease.
   - Utilize the Search Bar to filter recipes based on your preferences.

2. **Recipe Details**
   - View detailed information about each recipe, including:
     - Recipe name
     - Preparation time
     - Serving size
     - Difficulty level

3. **Step-by-Step Instructions**
   - Access clear and concise step-by-step instructions for preparing each dish.
   - Ensure accurate and successful recipe execution.

4. **High-Quality Images**
   - Experience the culinary delights through high-quality images of each recipe.

5. **Origins and History**
   - Explore the origins and history of select recipes.
   - Gain insights into the cultural and geographical backgrounds of dishes.

6. **Interactive Maps**
   - Interact with interactive maps to visualize the origin of specific recipes.
   - Discover the geographical roots of dishes and their significance.

7. **Seamless Navigation**
   - Navigate between different sections of the app effortlessly.
   - Enjoy a user-friendly and intuitive navigation experience.

8. **Search Functionality**
   - Utilize the search functionality to quickly find recipes that match your preferences.
   - Enter relevant keywords to filter the list of available recipes.

## Technologies Used

Taste Flow utilizes a powerful stack of technologies, libraries, and architectural patterns to ensure a robust and efficient development process:

- **Kotlin**: The primary programming language for Android development.
- **Coroutines**: For asynchronous and concurrent programming.
- **Flow**: To handle reactive data streams and asynchronous operations.
- **Room**: A robust SQLite abstraction library for database management.
- **Hilt**: For dependency injection and managing app-wide components.
- **Jetpack Compose**: Modern Android UI toolkit for building native UI.
- **Navigation Component**: For handling in-app navigation.
- **Retrofit**: For making network requests and API integration.
- **Coil**: An image loading library for efficient image loading.
- **Google Maps API**: For integrating maps and location-based services.
- **MVVM (Model-View-ViewModel)**: An architectural pattern for clean separation of concerns.
- **Clean Architecture**: A design principle that emphasizes separation of layers.
- **Unit Tests**: Ensuring code correctness through comprehensive unit testing.
- **MockK**: A mocking library for unit testing

## Getting Started

### Prerequisites

Before you proceed, make sure you have the following installed:

- Android Studio (with Kotlin support)
- Android SDK
- Git

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Canchee/TasteFlowApp.git

2. Open Android Studio and select "Open an existing Android Studio project."
3. Navigate to the directory where you cloned the repository and select it.

### Usage

Taste Flow is designed to make discovering and exploring recipes a seamless experience. Here's how you can make the most of the app's features:

1. **Browsing Recipes**

   The main screen of Taste Flow displays a list of recipes. This list can be filtered using the SearchBar located at the top of the screen. As you type your search query, the app dynamically updates the list to show recipes that match your search criteria.

   ![image](https://github.com/Canchee/TasteFlowApp/assets/68764622/af40a90f-a2e0-4866-9f9a-dc8a2a43adf3)

   Each recipe card shows an image along with important information such as the recipe's name, preparation time, serving size, and difficulty level.

2. **Viewing Recipe Details**

   When you find a recipe that interests you, click on it to view its details. The Recipe Detail screen provides a comprehensive overview of the recipe. You'll see a high-quality image of the dish, a list of ingredients required, and step-by-step instructions on how to prepare the dish.

   ![image](https://github.com/Canchee/TasteFlowApp/assets/68764622/61e33b48-beff-4ed5-b732-2a493bdc3e48)

3. **Exploring Recipe Origins**

   For an immersive experience, some recipes come with an interesting backstory about their origins. On the Recipe Detail screen, you'll find a location icon in the top-right corner. Clicking this icon takes you to a map that shows the origin of the recipe.

  ![image](https://github.com/Canchee/TasteFlowApp/assets/68764622/985ad773-6a36-4100-9117-f91ecbfa979e)

   The map screen not only displays the location but also provides a brief historical overview of the recipe's origins.

4. **Navigation**

   Navigating between screens is intuitive. On both the Recipe Detail screen and the Map screen, there's a back button in the top-left corner. This allows you to seamlessly move back to the previous screen and continue exploring.

5. **Internet Connectivity**

   To ensure you have the best experience, Taste Flow requires an active internet connection. In case you're offline, a message will appear on the main screen, indicating that the app needs an internet connection to function properly.

6. **Search Functionality**

   Use the SearchBar on the main screen to quickly find recipes that match your interests. Type keywords related to the dish you're looking for, and Taste Flow will instantly filter the list to display relevant recipes.

Taste Flow is designed to be intuitive, created to explore various recipes and their origins.


### Unit Tests

Taste Flow is tested to ensure the reliability and stability of the codebase. The app contains unit tests for various components, including ViewModels and  UseCases. To run the unit tests:

1. Open Android Studio.
2. Go to the project's root directory.
3. Run the tests using the testing framework integrated into Android Studio.

### Architecture

Taste Flow follows the MVVM (Model-View-ViewModel) architectural pattern along with Clean Architecture principles. This separation of concerns ensures maintainability, testability, and scalability of the app. The different layers include:

- **Presentation (ui)**: Contains UI-related components such as ViewModels and UI-related logic.
- **Domain (domain)**: Holds the business logic and UseCases of the app.
- **Data (data)**: Manages the data sources, repositories, and interactions with external services.
- **Core (core)**: Provides shared functionality and utilities across the app.
- **Dependency Injection (di)**: Contains the Modules for Room and Retrofit.


