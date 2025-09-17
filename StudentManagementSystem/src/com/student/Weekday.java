package com.student;

public enum Weekday  {
    MONDAY("First day", 1),
    TUESDAY("Second day", 2),
    WEDNESDAY("Third day", 3),
    THURSDAY("Fourth day", 4),
    FRIDAY("Fifth day", 5),
    SATURDAY("Sixth day", 6),
    SUNDAY("Seventh day", 7);

	private final String description;
    private final int numericValue;

    // Constructor
     Weekday(String description, int numericValue) {
        this.description = description;
        this.numericValue = numericValue;
    }

    // Getter methods
    public String getDescription() {
        return description;
    }

    public int getNumericValue() {
        return numericValue;
    }
}
