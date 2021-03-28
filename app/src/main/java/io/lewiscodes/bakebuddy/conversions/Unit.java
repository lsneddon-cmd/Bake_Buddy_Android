package io.lewiscodes.bakebuddy.conversions;

public enum Unit {
    CUP(284, 240.131),
    TEASPOON(5, 5),
    TABLESPOON(17.7582, 14.7868),
    FLUID_DRAM(3.696691, 3.696691),
    FLUID_OZ(28.4131, 29.57344);


    private final double imperialVolumeRate;
    private final double usLegalVolumeRate;

    Unit(double imperialVolumeRate, double usLegalVolumeRate) {
        this.imperialVolumeRate = imperialVolumeRate;
        this.usLegalVolumeRate = usLegalVolumeRate;
    }

    public double getImperialVolumeRate() {
        return imperialVolumeRate;
    }

    public double getUsLegalVolumeRate() {
        return usLegalVolumeRate;
    }
}
