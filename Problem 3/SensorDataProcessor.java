import java.util.List;

public class SensorDataProcessor {
    public double calculate(List<SensorReading> readings) {
        double sum = 0;
        int count = 0;
        for (SensorReading r : readings) {
            double val = r.getValue();
            if (val >= 0) {
                sum += Math.sqrt(val);
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }
}
