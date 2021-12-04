package ua.edu.ucu.tempseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class TemperatureSeriesAnalysis {
    double[] temperatures;
    double mean;

    public TemperatureSeriesAnalysis() {
         temperatures = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        double[] checkTemps = new double[temperatureSeries.length];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < -273) {
                throw new InputMismatchException();
            } else {
                checkTemps[i] = temperatureSeries[i];
            }
        temperatures = checkTemps;
        }
    }

    public double average() {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException();
        } else {
            double sum = 0;
            for (double temp : temperatures) {
                sum += temp;
            }
            double length = temperatures.length;
            double mean = sum / length;
            this.mean = mean;
            return mean;
        }
    }

    public double deviation() {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException();
        } else {
            double differenceSum = 0;
            for (double temp : temperatures) {
                differenceSum += Math.pow((temp - mean), 2);
            }
            double length = temperatures.length;
            double standartDeviation = Math.sqrt(differenceSum / length);
            return standartDeviation;
        }
    }

    public double min() {
        double min = temperatures[0];
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < min) {
                min = temperatures[i];
            }
        }
        return min;
    }

    public double max() {
        double max = temperatures[0];
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] > max) {
                max = temperatures[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestDoudle = temperatures[0];
        double minDiff = Math.abs((closestDoudle - tempValue));
        for (int i = 1; i < temperatures.length; i++) {
            if (Math.abs((temperatures[i] - tempValue)) < minDiff) {
                minDiff = Math.abs(temperatures[i] - tempValue);
                closestDoudle = temperatures[i];
            }
        }
        return closestDoudle;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException();}

        double[] lessTemperatures = new double[temperatures.length];
        int j = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < tempValue) {
                lessTemperatures[j] = temperatures[i];
                j += 1;
            }
        }
//        lessTemperatures = Arrays.copyOfRange(lessTemperatures, 0, j);
        return lessTemperatures;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException();}
        double[] biggerTemperatures = new double[temperatures.length];

        int j = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] > tempValue) {
                biggerTemperatures[j] = temperatures[i];
                j += 1;
            }
        }
//        biggerTemperatures = Arrays.copyOfRange(biggerTemperatures, 0, j);
        return biggerTemperatures;
    }

    class TempSummaryStatistics {
        public TempSummaryStatistics(double avTem, double dev, double min, double max) {
            final double avgTemp = avTem;
            final double devTemp = dev;
            final double minTemp = min;
            final double maxTemp = max;
        }
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double av = this.average();
        double dev = this.deviation();
        double min = this.min();
        double max = this.max();
        return new TempSummaryStatistics(av, dev, min, max);
    }

//    public double addTemps(double... temps) {
//        int j = 0;
//        for (int i = 0; i < temperatures.length; i++) {
//            if (temperatures[i] == null) {
//                 temperatures[i] = temps[j];
//                 j += 1;
//            }
//        }
//        if (j < temps.length) {
//            double[] newTemperatures = new double[temperatures.length * 2];
//            System.arraycopy(temperatures, 0, newTemperatures, 0, temperatures.length);
//            temperatures = newTemperatures;
//        }
//        double sum = 0;
//        for (int i = 0; i < temperatures.length; i++) {
//            if (temperatures[i] != null) {
//                sum += temperatures[i];
//            }
//        }
//        return sum;
//    }
}
