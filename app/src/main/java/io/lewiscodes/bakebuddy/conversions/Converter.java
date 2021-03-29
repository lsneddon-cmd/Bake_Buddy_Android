package io.lewiscodes.bakebuddy.conversions;

import java.text.DecimalFormat;

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

    public String formattedResult() {
        double gramAsDouble = getGramResultAsDouble();
        String gramRes = new DecimalFormat("#.00").format(gramAsDouble);
        StringBuilder result = new StringBuilder();
        result.append(ingredient.toString());
        result.append("\n\t");
        result.append(amountToConvert);
        result.append(" ");
        result.append(unit.toString());
        if (amountToConvert > 1.0) result.append("s");
        result.append("\n\t");
        result.append(gramRes);
        result.append(" gram");
        if (gramAsDouble > 1.0) result.append("s");

        return result.toString();
    }
    
    private double getGramResultAsDouble() {
        return isImperial ? convertImperialToGram() : convertUsLegalToGram();
    }

    private double convertUsLegalToGram() {
        return ingredient.getWeightRatio() * unit.getUsLegalVolumeRate() * amountToConvert;
    }

    private double convertImperialToGram() {
        return ingredient.getWeightRatio() * unit.getImperialVolumeRate() * amountToConvert;
    }
}
