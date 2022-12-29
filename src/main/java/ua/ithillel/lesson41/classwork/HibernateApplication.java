package ua.ithillel.lesson41.classwork;

import com.sun.tools.javac.Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson41.classwork.persistent.HibernateConfiguration;
import ua.ithillel.lesson41.classwork.persistent.entity.Country;
import ua.ithillel.lesson41.classwork.persistent.entity.Mainland;

public class HibernateApplication {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
        var sessionFactory = ctx.getBean(SessionFactory.class);

        // Transient
        var europe  = new Mainland();
        europe.setName("Europe");

        // Manager, Persistent
        var session = sessionFactory.openSession();
        session.persist(europe);

        // Detach
        session.detach(europe);
        session.close();

        // Manager, Persistent with the new session
        session = sessionFactory.openSession();
        session.persist(europe);
        session.flush();
        session.close();


        // removed
        session = sessionFactory.openSession();
        Mainland europeFromDb = session.get(Mainland.class, 1L);
        session.remove(europeFromDb);
        session.flush();
        session.close();

        // update
        session = sessionFactory.openSession();
        Mainland europeFromDb2 = session.get(Mainland.class, 1L);
        Country france = europeFromDb2.getCountries().get(0);
        france.setName("France Republic");
        session.merge(france);
        session.flush();
        session.close();
    }

}
