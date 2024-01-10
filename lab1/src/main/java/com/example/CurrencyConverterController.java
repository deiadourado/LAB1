package com.example;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Controller class for the Currency Converter application.
 */
public class CurrencyConverterController {

    @FXML
    private TextField AmountToConvert;

    @FXML
    private TextField resultConverted;

    @FXML
    private ComboBox<String> sourceCurrencyComboBox;

    @FXML
    private ComboBox<String> targetCurrencyComboBox;

    @FXML
    private Button convertButton;

    /**
     * Initializes the controller, populating source and target currency ComboBoxes.
     */
    @FXML
    private void initialize(){
        // Create an ObservableList of source currencies and populate the source currency ComboBox
        // Populate target currency ComboBox with "CAD" and "BRL"
        // The list can be expanded based on application requirements
        ObservableList<String> sourceCurrencies = FXCollections.observableArrayList("CAD", "BRL"); 
        sourceCurrencyComboBox.setItems(sourceCurrencies);

        // Populate target currenyc ComboBox
        ObservableList<String> targetCurrencies = FXCollections.observableArrayList("CAD", "BRL");
        targetCurrencyComboBox.setItems(targetCurrencies);
    }

    /**
     * Handles the conversion when the convert button is clicked.
     */
    @FXML
    private void handleConvertButton() {
        // Retrieve the input amount and selected currencies
        double amount = Double.parseDouble(AmountToConvert.getText());
        String sourceCurrency = sourceCurrencyComboBox.getValue();
        String targetCurrency = targetCurrencyComboBox.getValue();

        // Calculate the conversion rate and update the result
        double conversionRate = getConversionRate(sourceCurrency, targetCurrency);
        double convertedAmount = amount * conversionRate;

        resultConverted.setText(String.format("%.2f %s = %.2f %s", amount, sourceCurrency, convertedAmount, targetCurrency));
    }

    /**
     * Returns the conversion rate between source and target currencies.
     * @param sourceCurrency Source currency code.
     * @param targetCurrency Target currency code.
     * @return Conversion rate.
     */
    private double getConversionRate(String sourceCurrency, String targetCurrency) {
        if (sourceCurrency.equals("BRL") && targetCurrency.equals("CAD")) {
            return 0.27;
        } else if (sourceCurrency.equals("CAD") && targetCurrency.equals("BRL")) {
            return 3.66;
        }
        return 1.0;
    }
}
