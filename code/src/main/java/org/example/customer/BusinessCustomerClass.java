package org.example.customer;

import java.util.Date;
import java.util.List;

public class BusinessCustomerClass extends CustomerBaseClass{

    private String companyName;

    public BusinessCustomerClass() {

    }

    public String getCompanyName() {
        return "companyName";
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
