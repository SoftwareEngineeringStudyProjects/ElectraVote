package ua.knu.csc.iss;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(getOptionId(), option.getOptionId()) && Objects.equals(getDescription(), option.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOptionId(), getDescription());
    }
}

