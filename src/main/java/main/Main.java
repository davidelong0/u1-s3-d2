package main;

import dao.EventoDAO;
import dao.PersonaDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;

import entities.Evento;
import entities.Persona;
import entities.Location;
import entities.Partecipazione;
import entities.TipoEvento;
import entities.StatoPartecipazione;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creo le DAO
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        try {
            // Creo una persona e la salvo
            Persona persona = new Persona();
            persona.setNome("Mario");
            persona.setCognome("Rossi");
            // imposta altri campi di Persona se necessari
            personaDAO.save(persona);

            // Creo una location e la salvo
            Location location = new Location();
            location.setNome("Arena di Verona");
            location.setIndirizzo("Piazza Bra, Verona");
            // imposta altri campi di Location se necessari
            locationDAO.save(location);

            // Creo un evento collegato alla location
            Evento evento = new Evento();
            evento.setTitolo("Concerto Rock");
            evento.setDataEvento(LocalDate.of(2025, 6, 20));
            evento.setDescrizione("Concerto dal vivo");
            evento.setTipoEvento(TipoEvento.PUBBLICO);
            evento.setNumeroMassimoPartecipanti(1000);
            evento.setLocation(location);
            eventoDAO.save(evento);

            // Creo una partecipazione collegata alla persona e all'evento
            Partecipazione partecipazione = new Partecipazione();
            partecipazione.setEvento(evento);
            partecipazione.setPersona(persona);
            partecipazione.setStato(StatoPartecipazione.CONFERMATA);
            partecipazioneDAO.save(partecipazione);

            // Recupero e stampo l'evento per conferma
            Evento trovato = eventoDAO.getById(evento.getId());
            System.out.println("Evento trovato: " + trovato.getTitolo());

        } finally {
            // Chiudo tutte le DAO per liberare risorse (chiude anche EntityManagerFactory)
            partecipazioneDAO.close();
            eventoDAO.close();
            personaDAO.close();
            locationDAO.close();
        }
    }
}

