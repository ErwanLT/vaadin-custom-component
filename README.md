# vaadin-custom-component
## Rating Components
### Star rating
The StarRating component is a highly configurable star rating system for Vaadin applications. It allows users to select a rating by clicking on stars. This component is designed to be flexible with options to set the number of stars, star size, colors, and the initial rating.
#### Features
* **Star Rating**: Select a rating by clicking on the stars.
* **Flexible Configuration**: Customize the number of stars, star size, colors, and initial rating.
* **Dynamic Updates**: Stars update based on the current rating.

#### Usages
##### Creating the Component
```java
// Create a StarRating component with default settings
StarRating starRating = new StarRating();

// Create a StarRating component with 10 stars, 40px size, and custom colors
StarRating customStarRating = new StarRating(10, "40px", "blue", "lightgray");

// Create a StarRating component with an initial rating of 3 stars
StarRating initialRating = new StarRating(5, "32px", "gold", "gray", 3.0);
```

##### Configuring the Component
You can customize the component's properties after creation:
```java
StarRating starRating = new StarRating();

// Change the color of the active stars
starRating.setActiveColor("red");

// Change the color of the inactive stars
starRating.setInactiveColor("lightgray");

// Change the size of the stars
starRating.setStarSize("24px");

// Change the total number of stars
starRating.setTotalStars(7);
```
