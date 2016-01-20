package sample;
/**
 * Created by 48089748z on 20/01/16.
 */
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO
{
    private static String DRIVER = "org.postgresql.Driver";
    private static String DBNAME = "jdbc:postgresql://172.31.104.78/hibernatedb,uri2,uri2";
    private Session session;
    private Transaction transaction;

    public void saveBook(Llibre llibre) throws HibernateException
    {
        try
        {
            start();
            session.save(llibre);
            transaction.commit();
        }
        catch (HibernateException one)
        {
            transaction.rollback();
            throw new HibernateException("Error guardando Libro", one);
        }
        finally {session.close();}
    }
    public void saveMember(Soci soci) throws HibernateException
    {
        try
        {
            start();
            session.save(soci);
            transaction.commit();
        }
        catch (HibernateException one)
        {
            transaction.rollback();
            throw new HibernateException("Error guardando Socio", one);
        }
        finally {session.close();}
    }
    public void saveLoan(Prestec prestec) throws HibernateException
    {
        try
        {
            start();
            session.save(prestec);
            transaction.commit();
        }
        catch (HibernateException one)
        {
            transaction.rollback();
            throw new HibernateException("Error guardando Socio", one);
        }
        finally {session.close();}
    }
    public ArrayList<Llibre> getBooks()
    {
        String select = "FROM Llibre ";
        Query query = session.createQuery(select);
        ArrayList<Llibre> results = (ArrayList<Llibre>) query.list();
        return results;
    }
    public ArrayList<Soci> getMembers()
    {
        String select = "FROM Soci ";
        Query query = session.createQuery(select);
        ArrayList<Soci> results = (ArrayList<Soci>) query.list();
        return results;

    }
    public ArrayList<Prestec> getLoans()
    {
        String select = "FROM Prestec ";
        Query query = session.createQuery(select);
        ArrayList<Prestec> results = (ArrayList<Prestec>) query.list();
        return results;

    }

    /*
    public Llibre getBook(long id) throws HibernateException
    {
        Llibre contacto = null;
        try
        {
            start();
            contacto = session.get(Llibre.class, id);
        }
        finally {session.close();}

        return contacto;
    }*/

    private void start() throws HibernateException
    {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
}
