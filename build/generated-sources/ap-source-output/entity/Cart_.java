package entity;

import entity.Item;
import entity.Ordered;
import entity.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-19T12:39:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, Item> itemId;
    public static volatile SingularAttribute<Cart, Integer> cartId;
    public static volatile SingularAttribute<Cart, Integer> qty;
    public static volatile SingularAttribute<Cart, Users> userId;
    public static volatile ListAttribute<Cart, Ordered> orderedList;

}