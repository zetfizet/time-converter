public class TimeConverter {
    // Fungsi konversi dari detik
    public static double convertFromSeconds(double value, String toUnit) {
        switch (toUnit) {
            case "Minutes":
                return value / 60;
            case "Hours":
                return value / 3600;
            case "Days":
                return value / 86400;
            case "Weeks":
                return value / 604800;
            case "Years":
                return value / 31536000;
            default:
                return value; // Detik ke detik
        }
    }

    // Fungsi konversi ke detik
    public static double convertToSeconds(double value, String fromUnit) {
        switch (fromUnit) {
            case "Minutes":
                return value * 60;
            case "Hours":
                return value * 3600;
            case "Days":
                return value * 86400;
            case "Weeks":
                return value * 604800;
            case "Years":
                return value * 31536000;
            default:
                return value; // Detik ke detik
        }
    }

    // Fungsi konversi antar unit
    public static double convert(double value, String fromUnit, String toUnit) {
        double valueInSeconds = convertToSeconds(value, fromUnit);
        return convertFromSeconds(valueInSeconds, toUnit);
    }
}
