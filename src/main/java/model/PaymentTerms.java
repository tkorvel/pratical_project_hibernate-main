package model;

import javax.persistence.*;

@Entity
@Table(name = "payment_terms")
public class PaymentTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int paymentTermsId;

    @Column(name = "name")
    private String paymentTermsName;

    @Column(name = "description")
    private String paymentTermsDescription;

    public int getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(int paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public String getPaymentTermsName() {
        return paymentTermsName;
    }

    public void setPaymentTermsName(String paymentTermsName) {
        this.paymentTermsName = paymentTermsName;
    }

    public String getPaymentTermsDescription() {
        return paymentTermsDescription;
    }

    public void setPaymentTermsDescription(String paymentTermsDescription) {
        this.paymentTermsDescription = paymentTermsDescription;
    }

    @Override
    public String toString() {
        return "PaymentTerms{" +
                "paymentTermsId=" + paymentTermsId +
                ", paymentTermsName='" + paymentTermsName + '\'' +
                ", paymentTermsDescription='" + paymentTermsDescription + '\'' +
                '}';
    }
}
