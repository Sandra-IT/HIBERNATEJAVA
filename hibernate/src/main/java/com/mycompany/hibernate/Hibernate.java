package com.mycompany.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            transaction = session.beginTransaction();

            // Crear una instancia de la entidad Usuario
            Usuario usuario = new Usuario("luisa", "123");

            // Guardar la entidad en la base de datos
            session.save(usuario);

            // Commit de la transacción
            transaction.commit();

            System.out.println("Usuario guardado con éxito");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar el SessionFactory al final del programa
            HibernateUtil.shutdown();
        }
    }
}

 
       
