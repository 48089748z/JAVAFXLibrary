package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class DAO
{
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
    public boolean deleteAllBooks()
    {
        try
        {
            start();
            session.createQuery("DELETE FROM Llibre").executeUpdate();
            session.close();
            return true;
        } catch (Exception one){return false;}
    }
    public boolean deleteAllMembers()
    {
        try
        {
            start();
            session.createQuery("DELETE FROM Soci").executeUpdate();
            session.close();
            return true;
        } catch (Exception one){return false;}
    }
    public boolean deleteAllLoans()
    {
        try
        {
            start();
            session.createQuery("DELETE FROM Prestec").executeUpdate();
            session.close();
            return true;
        } catch (Exception one){return false;}
    }
}