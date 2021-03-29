package io.lewiscodes.bakebuddy.conversions;

public enum Ingredient {
    FLOUR("Flour", 0.42268),
    ALMOND_FLOUR("Almond flour", 0.406),
    RICE_FLOUR("Rice flour", 0.68),
    SUGAR("Sugar", 0.8),
    BUTTER("Butter", 0.955),
    COCOA("Cocoa", 0.528);

    private final String name;
    private final double weightRatio;

    Ingredient(String name, double weightRatio) {
        this.name = name;
        this.weightRatio = weightRatio;
    }

    public String getName() {
        return name;
    }

    public double getWeightRatio() {
        return weightRatio;
    }
}
