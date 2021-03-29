package io.lewiscodes.bakebuddy.conversions;

public enum Unit {
    CUP("Cup",284, 240.131),
    TEASPOON("Teaspoon",5, 5),
    TABLESPOON("TableSpoon",17.7582, 14.7868),
    FLUID_DRAM("Fluid Dram",3.696691, 3.696691),
    FLUID_OZ("Fluid Ounce",28.4131, 29.57344);

    private String name;
    private final double imperialVolumeRate;
    private final double usLegalVolumeRate;

    Unit(String name, double imperialVolumeRate, double usLegalVolumeRate) {
        this.name = name;
        this.imperialVolumeRate = imperialVolumeRate;
        this.usLegalVolumeRate = usLegalVolumeRate;
    }

    public String getName() {
        return name;
    }

    public double getImperialVolumeRate() {
        return imperialVolumeRate;
    }

    public double getUsLegalVolumeRate() {
        return usLegalVolumeRate;
    }
}
