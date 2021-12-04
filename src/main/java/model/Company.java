package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", insertable = false, updatable = false)
    private int companyId;

    @Column(name = "registry_code")
    private int registryCode;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "credit_rating")
    private int creditRating;

    @Column(name = "date_of_register")
    private LocalDate dateOfRegister;

    @ManyToOne
    @JoinColumn(name = "payment_terms_id")
    private PaymentTerms paymentTerms;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getRegistryCode() {
        return registryCode;
    }

    public void setRegistryCode(int registryCode) {
        this.registryCode = registryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public LocalDate getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        this.dateOfRegister = this.dateOfRegister;
    }

    public PaymentTerms getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(PaymentTerms paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", registryCode=" + registryCode +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", creditRating=" + creditRating +
                ", dateOfRegister=" + dateOfRegister +
                ", paymentTerms=" + paymentTerms +
                ", address=" + address +
                '}';
    }
}

