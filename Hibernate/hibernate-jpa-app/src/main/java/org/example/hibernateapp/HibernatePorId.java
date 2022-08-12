package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.hibernateapp.entity.Cliente;
import org.example.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente c where c.id=?1", Cliente.class);
        System.out.println("Ingrese el id del pago ");
        Long id = s.nextLong(); s.nextLine();
        query.setParameter(1, id);
        query.setMaxResults(1);
        Cliente c = (Cliente) query.getSingleResult();
        System.out.println(c);
        em.close();
    }
}
