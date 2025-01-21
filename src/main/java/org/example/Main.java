package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventiPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Inizia una transazione
            em.getTransaction().begin();

            // Crea un nuovo oggetto Evento
            Evento evento = new Evento("Concerto", LocalDateTime.now(), "Concerto di musica rock", TipoEvento.PUBBLICO, 500);

            // Salva l'evento nel database
            em.persist(evento);

            // Esegui la transazione
            em.getTransaction().commit();
            System.out.println("Evento creato con successo!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Chiudi l'EntityManager
            em.close();
            emf.close();
    }
}}