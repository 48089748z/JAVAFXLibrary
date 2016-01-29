package sample;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by 48089748z on 20/01/16.
 */
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (HibernateException one)
        {
            System.err.println("Error en la SessionFactory: " + one);
            throw new ExceptionInInitializerError(one);
        }
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
