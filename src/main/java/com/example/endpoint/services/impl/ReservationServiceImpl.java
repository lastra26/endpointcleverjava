package com.example.endpoint.services.impl;

import com.example.endpoint.entities.Reservation;
import com.example.endpoint.entities.Restaurant;
import com.example.endpoint.entities.Turn;
import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.exceptions.InternalServerErrorException;
import com.example.endpoint.exceptions.NotFoundException;
import com.example.endpoint.jsons.CreateReservationRest;
import com.example.endpoint.jsons.ReservationRest;
import com.example.endpoint.jsons.RestaurantRest;
import com.example.endpoint.jsons.TurnRest;
import com.example.endpoint.repositories.ReservationRepository;
import com.example.endpoint.repositories.RestaurantRepository;
import com.example.endpoint.repositories.TurnRepository;
import com.example.endpoint.services.ReservationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    public static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationRest getReservation(Long reservationId) throws BookingException {
        return null;
    }

    @Override
    public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

        final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
                .orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "NOT FOUND"));

        final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
                .orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT FOUND"));

        String locator = generateLocator(restaurantId, createReservationRest);
        //se declara para luego pasarlo
        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson().toString());
        reservation.setDate(createReservationRest.getDate());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turn.getName());

        //aqui se guardan los datos
        try{
            reservationRepository.save(reservation);
        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return locator;
    }

    @Override
    public List<ReservationRest> getReservation() throws BookingException {
            final List<Reservation> reservationsEntity = reservationRepository.findAll();
            return reservationsEntity.stream().map(service -> modelMapper.map(service,ReservationRest.class))
                    .collect(Collectors.toList());
    }

    private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
            throws BookingException {
        return restaurantId.getName() + createReservationRest.getTurnId();
    }



}
