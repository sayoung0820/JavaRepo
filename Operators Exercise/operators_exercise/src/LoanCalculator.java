public class LoanCalculator {
    public static void main(String[] args) {
        // 1. Declare and assign variables
        double loanAmount = 25000.00;
        double annualInterestRate = 5.5;
        int loanTermYears = 5;
        double monthlyPayment;

        // 2. Calculate monthly payment using formula (Use assignment operators)
        monthlyPayment = (loanAmount * (annualInterestRate / 100)) / 12;

        // 3. Use assignment Operators
        loanAmount += 5000.00;
        annualInterestRate -= 1.0;
        loanTermYears ++;
        // recalculate monthly payment
        monthlyPayment = (loanAmount * annualInterestRate / 100) / 12;

        // 4. Compare new loan amounts (use comparison operators)
        // check if loan amount exceeds $30,000 & if monthly payment exceeds $500.00
        boolean isLoanAmountHigh =  loanAmount > 30000;
        boolean isMonthlyPaymentHigh = monthlyPayment > 500;

        // 5. Check if loan amount/monthly payment affordable (use logical operators)
        boolean isLoanAffordable = (monthlyPayment < 500) && (loanTermYears > 3);
        boolean isLoanExpensive =  (monthlyPayment > 700) || (annualInterestRate > 6);

        // 6. Print results
        System.out.println("Loan Amount: $" + loanAmount);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Loan Term Years: "  + loanTermYears);
        System.out.println("Monthly Payment: $" + monthlyPayment);
        System.out.println("Is Loan Amount High (> $30,000?) " + isLoanAmountHigh);
        System.out.println("Is Monthly Payment High (> $500.00?) " + isMonthlyPaymentHigh);
        System.out.println("Is Loan Affordable? " + isLoanAffordable);
        System.out.println("Is Loan Expensive? " + isLoanExpensive);












    }

}
