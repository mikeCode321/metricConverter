import java.util.List;
import java.util.Scanner;

public class MetricConverter {
    public Scanner scanner = new Scanner(System.in);

    private List<String> listOfUserMetric;

    private String usersMetricConversionQuery = "";

    public double getLbFromKg(double kG) {
        return kG * 2.2;
    }

    public double getMetersFromMiles(double miles) {
        return miles * 1609.344;
    }

    public double getMMFromIn(double in) {
        return in * 25.4;
    }

    public double getOuncesFromGrams(double grams) {
        return grams / 28.35;
    }

    public double computeMetricConversion(String metric, double num) {

        return switch (metric) {
            case "kg" -> getLbFromKg(num);
            case "miles" -> getMetersFromMiles(num);
            case "in" -> getMMFromIn(num);
            case "gram" -> getOuncesFromGrams(num);
            default -> -1.0;
        };
    }

    public void getListOfUserMetrics(String userInput) {
        listOfUserMetric = List.of(userInput.split(" "));
    }

    public String toString(double output) {
        return "" + listOfUserMetric.get(0) + " " + listOfUserMetric.get(1) + " " + listOfUserMetric.get(2) + " "
                + output + " " + listOfUserMetric.get(listOfUserMetric.size() - 1);
    }

    public String getUserInput() {
        System.out.println("\nPlease enter your metric conversion request: ");
        usersMetricConversionQuery = scanner.nextLine();
        return usersMetricConversionQuery;
    }

    public void outputResultOfConversion() {

        if (listOfUserMetric.size() == 4) {
            double output = computeMetricConversion(listOfUserMetric.get(1), Double.parseDouble(listOfUserMetric.get(0)));
            if (output != -1.0) {
                System.out.println("The answer is:\n" + toString(output));
            } else {
                System.out.println("NO RESULT --> Likely typo occurred");
            }
        } else {
            System.out.println("Most likely an invalid format was entered please try again - Format given: "
                    + usersMetricConversionQuery + " Format expected: XX kg = lb");
            usersMetricConversionQuery = scanner.nextLine();
        }

    }

    public static void main(String[] args) {
        MetricConverter metricConverter = new MetricConverter();

        System.out.println("Metric Converter Calculator\n\n\t\t Welcome!!\n\nPlease input your request in this format: XX kg = XX lb"
                + "\nEnter 'exit' to exit the program");

        do {
            String userInput = metricConverter.getUserInput();
            if (!userInput.equals("exit")) {
                metricConverter.getListOfUserMetrics(userInput);
                metricConverter.outputResultOfConversion();
            } else {
                break;
            }
        } while (true);

        System.out.println("Thank you for trying The Metric Calculator");
    }
}
