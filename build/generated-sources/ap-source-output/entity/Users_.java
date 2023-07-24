package entity;

import entity.Cart;
import entity.Feedback;
import entity.Payment;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-19T12:39:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile SingularAttribute<Users, String> mobileNo;
    public static volatile SingularAttribute<Users, String> profileImage;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile ListAttribute<Users, Payment> paymentList;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> userRole;
    public static volatile ListAttribute<Users, Feedback> feedbackList;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile ListAttribute<Users, Cart> cartList;
    public static volatile SingularAttribute<Users, String> username;

}