package fr.eletutour.components.progress;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * A custom component that represents a progress bar with a label.
 * The label can display the percentage or custom text.
 */
@Tag("div")
public class ProgressBarWithLabel extends VerticalLayout {

    private final Div progressBar = new Div();
    private final Div progressLabel = new Div();

    private double progress = 0.0;

    /**
     * Default constructor with 0% initial progress.
     */
    public ProgressBarWithLabel() {
        setWidthFull();
        setSpacing(false);
        setPadding(false);

        // Style for the progress bar
        progressBar.getStyle().set("height", "24px");
        progressBar.getStyle().set("transition", "width 0.3s ease, background-color 0.3s ease");

        // Style for the label
        progressLabel.getStyle().set("margin-top", "8px");
        progressLabel.getStyle().set("text-align", "center");
        progressLabel.getStyle().set("font-weight", "bold");
        progressLabel.getStyle().set("color", "#000"); // Text color inside the progress bar

        add(progressBar, progressLabel);

        updateProgress();
    }

    /**
     * Sets the progress value and updates the progress bar.
     *
     * @param progress The progress value (0.0 to 1.0).
     */
    public void setProgress(double progress) {
        this.progress = Math.max(0, Math.min(progress, 1)); // Ensure progress is between 0 and 1
        updateProgress();
    }

    /**
     * Sets a custom label inside the progress bar.
     *
     * @param label The label to display.
     */
    public void setLabel(String label) {
        progressLabel.setText(label);
    }

    /**
     * Gets the current progress value.
     *
     * @return The current progress value (0.0 to 1.0).
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Updates the visual appearance of the progress bar and label.
     */
    private void updateProgress() {
        progressBar.getStyle().set("width", (progress * 100) + "%");
        progressBar.getStyle().set("background-color", getColorForProgress(progress));

        if (progressLabel.getText().isEmpty() || progressLabel.getText().endsWith("%")) {
            progressLabel.setText((int) (progress * 100) + "%");
        }
    }

    /**
     * Determines the color of the progress bar based on the current progress value.
     *
     * @param progress The current progress value (0.0 to 1.0).
     * @return The color as a string (e.g., "green", "yellow", "red").
     */
    private String getColorForProgress(double progress) {
        if (progress < 0.33) {
            return "#f44336";
        } else if (progress < 0.66) {
            return "#ffeb3b";
        } else {
            return "#4caf50";
        }
    }
}
