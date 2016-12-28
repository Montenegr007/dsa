package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-24T15:40:53")
@StaticMetamodel(Contact.class)
public class Contact_ { 

    public static volatile SingularAttribute<Contact, Date> dateofbirth;
    public static volatile SingularAttribute<Contact, String> firstname;
    public static volatile SingularAttribute<Contact, String> comment;
    public static volatile SingularAttribute<Contact, Long> id;
    public static volatile SingularAttribute<Contact, String> source;
    public static volatile SingularAttribute<Contact, String> type;
    public static volatile SingularAttribute<Contact, String> lastname;

}