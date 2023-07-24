package entity;

import entity.Cart;
import entity.Category;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-19T12:39:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Integer> itemId;
    public static volatile SingularAttribute<Item, String> itemName;
    public static volatile SingularAttribute<Item, Integer> itemPrice;
    public static volatile SingularAttribute<Item, String> itemDescription;
    public static volatile SingularAttribute<Item, Category> categoryId;
    public static volatile ListAttribute<Item, Cart> cartList;
    public static volatile SingularAttribute<Item, String> itemImage;

}