package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public  TempSummaryStatistics(double avTem, double dev, double min, double max) {
        avgTemp = avTem;
        devTemp = dev;
        minTemp = min;
        maxTemp = max;
    }

    @Override
    public String toString() {
        return "TempSummaryStatistics{" +
                "avgTemp=" + avgTemp +
                ", devTemp=" + devTemp +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
