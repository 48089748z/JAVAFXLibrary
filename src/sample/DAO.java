package sample;
/**
 * Created by 48089748z on 20/01/16.
 */
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Select;

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
        start();
        Query query = session.createQuery("FROM Llibre ");
        return (ArrayList<Llibre>) query.list();
    }
    public ArrayList<Soci> getMembers()
    {
        start();
        Query query = session.createQuery("FROM Soci ");
        return (ArrayList<Soci>) query.list();
    }
    public ArrayList<Prestec> getLoans()
    {
        start();
        Query query = session.createQuery("FROM Prestec ");
        return (ArrayList<Prestec>) query.list();
    }
    private void start() throws HibernateException
    {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
}
