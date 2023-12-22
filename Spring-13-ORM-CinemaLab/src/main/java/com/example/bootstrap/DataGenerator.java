package com.example.bootstrap;


import com.example.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataGenerator implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;

    public DataGenerator(AccountRepository accountRepository, CinemaRepository cinemaRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(accountRepository.listAllAdminAccounts());
        System.out.println(cinemaRepository.listDistinctCinemasBySponsoredName());
        System.out.println(movieRepository.fetchAllMovieNames());
        System.out.println(movieCinemaRepository.countByCinemaId(4L));
        System.out.println(movieCinemaRepository.findAllMovieCinemaByLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.findAllByUserAccount(4L));
        System.out.println(ticketRepository.findAllByDateRange(LocalDateTime.now().minusDays(25), LocalDateTime.now()));
        System.out.println(ticketRepository.findAllTicketUserNameOrNameOrMovieNameContain("it"));

    }

}
