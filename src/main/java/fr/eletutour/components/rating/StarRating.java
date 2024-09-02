package fr.eletutour.components.rating;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * A custom component that represents a star rating system.
 * Users can select a rating by clicking on stars. The component is highly configurable
 * with options to set the number of stars, size, colors, and initial rating.
 */
@Tag("div")
public class StarRating extends AbstractField<StarRating, Double> {

    // Constants for default values
    private static final int DEFAULT_TOTAL_STARS = 5;
    private static final String DEFAULT_STAR_SIZE = "32px";
    private static final String DEFAULT_ACTIVE_COLOR = "gold";
    private static final String DEFAULT_INACTIVE_COLOR = "gray";
    private static final double DEFAULT_INITIAL_RATING = 0.0;

    private final HorizontalLayout starLayout = new HorizontalLayout();
    private final Icon[] stars;
    private final int totalStars;
    private String activeColor;
    private String inactiveColor;
    private String starSize;

    /**
     * Default constructor with 5 stars, 32px size, gold active color, and gray inactive color.
     */
    public StarRating() {
        this(DEFAULT_TOTAL_STARS, DEFAULT_STAR_SIZE, DEFAULT_ACTIVE_COLOR, DEFAULT_INACTIVE_COLOR, DEFAULT_INITIAL_RATING);
    }

    /**
     * Constructor with a specified number of stars.
     *
     * @param totalStars The total number of stars.
     */
    public StarRating(int totalStars) {
        this(totalStars, DEFAULT_STAR_SIZE, DEFAULT_ACTIVE_COLOR, DEFAULT_INACTIVE_COLOR, DEFAULT_INITIAL_RATING);
    }

    /**
     * Constructor with a specified number of stars and their size.
     *
     * @param totalStars The total number of stars.
     * @param starSize The size of each star (e.g., "32px").
     */
    public StarRating(int totalStars, String starSize) {
        this(totalStars, starSize, DEFAULT_ACTIVE_COLOR, DEFAULT_INACTIVE_COLOR, DEFAULT_INITIAL_RATING);
    }

    /**
     * Constructor with specified number of stars, size, and initial rating.
     *
     * @param totalStars The total number of stars.
     * @param starSize The size of each star (e.g., "32px").
     * @param initialRating The initial rating to set.
     */
    public StarRating(int totalStars, String starSize, double initialRating) {
        this(totalStars, starSize, DEFAULT_ACTIVE_COLOR, DEFAULT_INACTIVE_COLOR, initialRating);
    }

    /**
     * Constructor with specified number of stars, size, and active/inactive colors.
     *
     * @param totalStars The total number of stars.
     * @param starSize The size of each star (e.g., "32px").
     * @param activeColor The color of active (filled) stars.
     * @param inactiveColor The color of inactive (empty) stars.
     */
    public StarRating(int totalStars, String starSize, String activeColor, String inactiveColor) {
        this(totalStars, starSize, activeColor, inactiveColor, DEFAULT_INITIAL_RATING);
    }

    /**
     * Constructor with full customization options.
     *
     * @param totalStars The total number of stars.
     * @param starSize The size of each star (e.g., "32px").
     * @param activeColor The color of active (filled) stars.
     * @param inactiveColor The color of inactive (empty) stars.
     * @param initialRating The initial rating to be set.
     */
    public StarRating(int totalStars, String starSize, String activeColor, String inactiveColor, Double initialRating) {
        super(initialRating);
        this.totalStars = totalStars;
        this.starSize = starSize;
        this.activeColor = activeColor;
        this.inactiveColor = inactiveColor;

        stars = new Icon[totalStars];
        configureStarLayout();
        setRating(initialRating);
    }

    /**
     * Configures the layout of the stars, setting up the size, color, and click listeners.
     */
    private void configureStarLayout() {
        starLayout.setSpacing(false);

        for (int i = 0; i < totalStars; i++) {
            stars[i] = VaadinIcon.STAR.create();
            stars[i].setSize(starSize);
            stars[i].setColor(inactiveColor);
            int index = i;
            stars[i].addClickListener(e -> setRating(index + 1.0));
            starLayout.add(stars[i]);
        }
    }

    /**
     * Updates the color of the stars based on the current rating value.
     */
    private void updateStars() {
        for (int i = 0; i < totalStars; i++) {
            if (i < getValue()) {
                stars[i].setColor(activeColor);
            } else {
                stars[i].setColor(inactiveColor);
            }
        }
    }

    /**
     * Sets the rating of the component and updates the visual representation.
     *
     * @param rating The rating to set.
     */
    public void setRating(double rating) {
        setModelValue(rating, true);
        updateStars();
    }

    @Override
    protected void setPresentationValue(Double rating) {
        updateStars();
    }

    /**
     * Returns the layout containing the stars, for external access.
     *
     * @return The layout containing the star icons.
     */
    public HorizontalLayout getStarLayout() {
        return starLayout;
    }

    /**
     * Sets the color of the active (filled) stars.
     *
     * @param activeColor The color to set for active stars.
     */
    public void setActiveColor(String activeColor) {
        this.activeColor = activeColor;
        updateStars();
    }

    /**
     * Sets the color of the inactive (empty) stars.
     *
     * @param inactiveColor The color to set for inactive stars.
     */
    public void setInactiveColor(String inactiveColor) {
        this.inactiveColor = inactiveColor;
        updateStars();
    }

    /**
     * Sets the size of the stars.
     *
     * @param starSize The size to set for the stars (e.g., "32px").
     */
    public void setStarSize(String starSize) {
        this.starSize = starSize;
        for (Icon star : stars) {
            star.setSize(starSize);
        }
    }

    /**
     * Configures the component with a new total number of stars.
     *
     * @param totalStars The new total number of stars.
     */
    public void setTotalStars(int totalStars) {
        starLayout.removeAll(); // Remove old stars
        configureStarLayout();  // Reconfigure with the new number of stars
    }

    /**
     * Returns the total number of stars.
     *
     * @return The total number of stars.
     */
    public int getTotalStars() {
        return totalStars;
    }

    /**
     * Returns the color of the active (filled) stars.
     *
     * @return The active color.
     */
    public String getActiveColor() {
        return activeColor;
    }

    /**
     * Returns the color of the inactive (empty) stars.
     *
     * @return The inactive color.
     */
    public String getInactiveColor() {
        return inactiveColor;
    }

    /**
     * Returns the size of the stars.
     *
     * @return The size of the stars.
     */
    public String getStarSize() {
        return starSize;
    }
}
