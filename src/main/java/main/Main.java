package main;

import dao.EventoDAO;
import entities.Evento;
import entities.TipoEvento;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EventoDAO dao = new EventoDAO();

        Evento evento = new Evento(1L, "Concerto Rock", LocalDate.of(2025, 6, 20), "Concerto dal vivo", TipoEvento.PUBBLICO, 1000);

        // Salvo l'evento
        dao.save(evento);

        // Recupero e stampo
        Evento trovato = dao.getById(1L);
        System.out.println("Evento trovato: " + trovato.getTitolo());

        // Cancello l'evento
        dao.delete(1L);

        dao.close();
    }
}

