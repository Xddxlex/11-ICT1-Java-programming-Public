public class CurrencyConverter {
    public static void main(String[] args) {
        // Simple currency conversion example
        
        double Amount = 20000.9;// Amount in PHP 
        double ExchangeRate =  57.27; //Assuming this is the current exchange rate as of August 4, 2025 Time: 7:11 PM
        double ConvertedAmount =ExchangeRate * Amount ; // Convert USD to PHP
        double Convertedamount = Amount / ExchangeRate; // Convert PHP to USD

        boolean isUSD = false ; // true: if converting to USD to PHP, false if converting to PHP to USD 
        if (isUSD) {
            System.out.println("Converted amount in PHP: " + " ₱ " + ConvertedAmount);
        } else {
            System.out.println("Converted amount in USD: "  + " $ " + Convertedamount );
        }
        System.out.println(      );
        // Assuming you want to display both conversions
        // Display the conversion result
        System.out.println("Amount in PHP: " + Amount);
        System.out.println("Exchange Rate: " + ExchangeRate);
        
    }

 }
