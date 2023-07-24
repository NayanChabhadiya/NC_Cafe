package entity;

import entity.Item;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-19T12:39:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile ListAttribute<Category, Item> itemList;
    public static volatile SingularAttribute<Category, String> categoryName;
    public static volatile SingularAttribute<Category, Integer> categoryId;

}