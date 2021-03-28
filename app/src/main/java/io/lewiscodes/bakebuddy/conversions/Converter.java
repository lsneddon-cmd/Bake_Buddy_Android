package io.lewiscodes.bakebuddy.conversions;

public class Converter {
    private final Ingredient ingredient;
    private final Unit unit;
    private final boolean isImperial;
    private final double amountToConvert;

    public Converter(Ingredient ingredient, Unit unit, boolean isImperial, double amountToConvert) {
        this.ingredient = ingredient;
        this.unit = unit;
        this.isImperial = isImperial;
        this.amountToConvert = amountToConvert;
    }
    
    public double getGramResultAsDouble() {
        return isImperial ? convertImperialToGram() : convertUsLegalToGram();
    }

    private double convertUsLegalToGram() {
        return ingredient.getWeightRatio() * unit.getUsLegalVolumeRate() * amountToConvert;
    }

    private double convertImperialToGram() {
        return ingredient.getWeightRatio() * unit.getImperialVolumeRate() * amountToConvert;
    }
}
