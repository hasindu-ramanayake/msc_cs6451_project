package org.example.customer;

public class BusinessCustomerClass extends CustomerBaseClass{

    private String companyName;

    public BusinessCustomerClass() {
        //not used by now
    }

    public String getCompanyName() {
        return "companyName";
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
