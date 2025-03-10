package entities;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    // CONSTRUCOTRS

    public Company() {
        super();
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    // GETTERS AND SETTERS

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    // METHODS

    @Override
    public Double tax() {
        double taxPayer = 0.00;
        if(getNumberOfEmployees() == 0) {
            taxPayer = getAnualIncome() * 0.16;
        } else {
            taxPayer = getAnualIncome() * 0.14;
        }
        return taxPayer;
    }

}
