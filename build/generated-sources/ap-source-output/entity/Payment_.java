package entity;

import entity.Invoice;
import entity.Ordered;
import entity.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-19T12:39:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, String> mode;
    public static volatile ListAttribute<Payment, Invoice> invoiceList;
    public static volatile SingularAttribute<Payment, Ordered> orderId;
    public static volatile SingularAttribute<Payment, Integer> paymentId;
    public static volatile SingularAttribute<Payment, Users> userId;

}