package entities;

public class Individual extends TaxPayer{

    private Double healthExpenditures;

    // CONSTRUCTORS

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    // GETTERS AND SETTERS

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    // METHODS

    @Override
    public Double tax() {
        double taxPayer = 0.00;
        if(this.getAnualIncome() < 20000.00) {
            if(this.getHealthExpenditures() > 0.00) {
                taxPayer = (getAnualIncome() * 0.15) - (getHealthExpenditures() * 0.50);
            } else {
                taxPayer = getAnualIncome() * 0.15;
            }
        } else {
            if(this.getHealthExpenditures() > 0.00) {
                taxPayer = (getAnualIncome() * 0.25) - (getHealthExpenditures() * 0.50);
            } else {
                taxPayer = getAnualIncome() * 0.25;
            }
        }
        return taxPayer;
    }

}
