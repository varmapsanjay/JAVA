import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        // Exchange rates (1 USD to other currencies)
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.78);
        exchangeRates.put("INR", 83.0);
        exchangeRates.put("JPY", 150.5);
    }

    public static double convertCurrency(String from, String to, double amount) {
        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }
        double amountInUSD = amount / exchangeRates.get(from);
        return amountInUSD * exchangeRates.get(to);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Currencies: " + exchangeRates.keySet());
        System.out.print("Enter source currency (e.g., USD, EUR): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., INR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}