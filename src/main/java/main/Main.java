package main;

import dao.EventoDAO;
import dao.PersonaDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;

import entities.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        try {
            // --- ENTITÀ DI BASE ---
            Persona persona = new Persona();
            persona.setNome("Mario");
            persona.setCognome("Rossi");
            persona.setEmail("mario.rossi@example.com");
            persona.setDataDiNascita(LocalDate.of(1980, 1, 15));
            persona.setSesso(Sesso.M);
            personaDAO.save(persona);
            System.out.println("Persona salvata: " + persona);

            Location location = new Location();
            location.setNome("Arena di Verona");
            location.setIndirizzo("Piazza Bra");
            location.setCitta("Verona");
            locationDAO.save(location);
            System.out.println("Location salvata: " + location);

            Evento evento = new Evento();
            evento.setTitolo("Concerto Rock");
            evento.setDataEvento(LocalDate.of(2025, 6, 20));
            evento.setDescrizione("Concerto dal vivo");
            evento.setTipoEvento(TipoEvento.PUBBLICO);
            evento.setNumeroMassimoPartecipanti(1000);
            evento.setLocation(location);
            eventoDAO.save(evento);
            System.out.println("Evento salvato: " + evento);

            Partecipazione partecipazione = new Partecipazione();
            partecipazione.setEvento(evento);
            partecipazione.setPersona(persona);
            partecipazione.setStato(StatoPartecipazione.CONFERMATA);
            partecipazioneDAO.save(partecipazione);
            System.out.println("Partecipazione salvata: " + partecipazione);

            // --- ESTENSIONI E QUERIES ---

            // Concerti
            Concerto c1 = new Concerto("Concerto Classico", LocalDate.of(2025, 5, 10), "Mozart Night", TipoEvento.PUBBLICO, 500, GenereConcerto.CLASSICO, true);
            Concerto c2 = new Concerto("Concerto Pop", LocalDate.of(2025, 5, 15), "Pop Hits", TipoEvento.PRIVATO, 300, GenereConcerto.POP, false);
            eventoDAO.save(c1);
            eventoDAO.save(c2);

            System.out.println("\n Concerti in streaming:");
            eventoDAO.getConcertiInStreaming(true).forEach(System.out::println);

            System.out.println("\n Concerti di genere POP:");
            eventoDAO.getConcertiPerGenere(GenereConcerto.POP).forEach(System.out::println);

            // Partite di calcio
            PartitaDiCalcio p1 = new PartitaDiCalcio("Derby", LocalDate.of(2025, 6, 1), "Partita accesa", TipoEvento.PUBBLICO, 20000,
                    "Milan", "Inter", "Milan", 2, 1);
            PartitaDiCalcio p2 = new PartitaDiCalcio("Ritorno", LocalDate.of(2025, 6, 15), "Sfida finale", TipoEvento.PUBBLICO, 20000,
                    "Inter", "Milan", "Milan", 0, 1);
            eventoDAO.save(p1);
            eventoDAO.save(p2);

            System.out.println("\n Partite vinte in casa:");
            eventoDAO.getPartiteVinteInCasa().forEach(System.out::println);

            System.out.println("\n️ Partite vinte in trasferta:");
            eventoDAO.getPartiteVinteInTrasferta().forEach(System.out::println);

        } finally {
            partecipazioneDAO.close();
            eventoDAO.close();
            personaDAO.close();
            locationDAO.close();
        }
    }
}

