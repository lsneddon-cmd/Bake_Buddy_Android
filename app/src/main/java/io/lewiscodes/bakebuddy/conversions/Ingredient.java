package io.lewiscodes.bakebuddy.conversions;

public enum Ingredient {
    FLOUR("flour", 0.42268),
    ALMOND_FLOUR("almond flour", 0.406),
    RICE_FLOUR("rice flour", 0.68),
    SUGAR("sugar", 0.8),
    BUTTER("butter", 0.955),
    COCOA("cocoa", 0.528);

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
