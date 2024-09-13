package org.example.csc311_loan1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        //These are all my Labels, TextFields, and Buttons
        Label interestRate = new Label("Annual Interest Rate:");
        TextField textRate = new TextField();

        Label numberOfYears = new Label("Number of Years:");
        TextField textYears = new TextField();

        Label loanAmount = new Label("Loan Amount:");
        TextField textLoan = new TextField();

        Label monthlyPayment = new Label("Monthly Payment:");
        TextField monthly = new TextField();
        monthly.setEditable(false);

        Label toalPayment = new Label("Total Payment:");
        TextField total = new TextField();
        total.setEditable(false);

        Button calculate = new Button("Calculate");

        //After the button is clicked these actions will occur
        calculate.setOnAction(e -> {

            double rate = Double.parseDouble(textRate.getText());
            int years = Integer.parseInt(textYears.getText());
            double loan = Double.parseDouble(textLoan.getText());

            double monthlyInterestRate = rate / 1200;
            double payment = loan * monthlyInterestRate /
                    (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
            double totalPayment = payment * years * 12;

            monthly.setText(String.format("$%.1f", payment));
            total.setText(String.format("$%.1f", totalPayment));
        });

        //This sets the layout for the application
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(interestRate, 0, 0);
        gridPane.add(textRate, 1, 0);
        gridPane.add(numberOfYears, 0, 1);
        gridPane.add(textYears, 1, 1);
        gridPane.add(loanAmount, 0, 2);
        gridPane.add(textLoan, 1, 2);
        gridPane.add(monthlyPayment, 0, 3);
        gridPane.add(monthly, 1, 3);
        gridPane.add(toalPayment, 0, 4);
        gridPane.add(total, 1, 4);
        gridPane.add(calculate, 1, 5);

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
