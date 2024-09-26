package ua.knu.csc.iss;

public class Option {
    private String optionId; // Unique identifier for the option
    private String description; // Description of the option (e.g., candidate name or proposal title)

    // Constructor
    public Option(String optionId, String description) {
        this.optionId = optionId;
        this.description = description;
    }

    // Getters
    public String getOptionId() {
        return optionId;
    }

    public String getDescription() {
        return description;
    }
}

