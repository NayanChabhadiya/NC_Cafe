package entity;

import entity.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-19T12:39:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Integer> feedbackId;
    public static volatile SingularAttribute<Feedback, Integer> cafeRatting;
    public static volatile SingularAttribute<Feedback, String> message;
    public static volatile SingularAttribute<Feedback, Users> userId;

}