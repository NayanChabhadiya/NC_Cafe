package entity;

import entity.Cart;
import entity.Payment;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-19T12:39:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Ordered.class)
public class Ordered_ { 

    public static volatile SingularAttribute<Ordered, String> totalPayment;
    public static volatile SingularAttribute<Ordered, Integer> orderId;
    public static volatile SingularAttribute<Ordered, Cart> cartId;
    public static volatile SingularAttribute<Ordered, String> orderDate;
    public static volatile ListAttribute<Ordered, Payment> paymentList;

}