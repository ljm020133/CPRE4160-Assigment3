import java.util.List;

/**
 * Processes a list of SensorReading objects and calculates the average
 * of square roots of non-negative values. Demonstrates loop fusion (code jamming).
 */
public class SensorDataProcessor {
    /**
     * Calculates average of square roots of valid sensor readings (value >= 0).
     * Fuses filtering and computation in a single loop for efficiency.
     * @param readings list of SensorReading objects
     * @return average of sqrt values
     */
    public double calculate(List<SensorReading> readings) {
        double sum = 0;
        int count = 0;

        for (SensorReading r : readings) {
            double val = r.getValue();
            if (val >= 0) {
                sum += Math.sqrt(val); // Do computation inline
                count++;               // Track valid entries
            }
        }

        // Return average if at least one valid reading exists
        return count > 0 ? sum / count : 0;
    }
}
