package by.it_academy.jd2.bookingFlights.dao.impl;

import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.entity.ViewFlightEntity;
import by.it_academy.jd2.bookingFlights.dao.factory.DaoFactoryHibernate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDaoHibernateImpl implements IFlightDao {
    @Override
    public Optional<ViewFlightEntity> getFlight(int id) {
        EntityManager em = DaoFactoryHibernate.getEntityManager();
        em.getTransaction().begin();
        ViewFlightEntity entity = em.find(ViewFlightEntity.class, id);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public List<ViewFlightEntity> getFlight() {
        EntityManager em = DaoFactoryHibernate.getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ViewFlightEntity> query = cb.createQuery(ViewFlightEntity.class);
        query.from(ViewFlightEntity.class);
        List<ViewFlightEntity> resultList = em.createQuery(query).getResultList();
        em.getTransaction().commit();
        return resultList;
    }

    @Override
    public List<ViewFlightEntity> getFlight(Integer page, Integer size) {
        EntityManager em = DaoFactoryHibernate.getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ViewFlightEntity> query = cb.createQuery(ViewFlightEntity.class);
        query.from(ViewFlightEntity.class);
        List<ViewFlightEntity> resultList = em.createQuery(query)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
        em.getTransaction().commit();
        return resultList;
    }

    @Override
    public List<ViewFlightEntity> getFlight(FlightFilterDTO filter) {
        EntityManager em = DaoFactoryHibernate.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ViewFlightEntity> query = cb.createQuery(ViewFlightEntity.class);
        Root<ViewFlightEntity> flight = query.from(ViewFlightEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getDepartureAirport() != null) {
            predicates.add(cb.equal(flight.get("departureAirport"), filter.getDepartureAirport()));
        }
        if (filter.getArrivalAirport() != null) {
            predicates.add(cb.equal(flight.get("arrivalAirport"), filter.getArrivalAirport()));
        }
        if (filter.getDepartureDateTo() != null) {
            predicates.add(cb.lessThanOrEqualTo(flight.get("departureDate"), filter.getDepartureDateTo()));
        }
        if (filter.getArrivalDateFrom() != null) {
            predicates.add(cb.greaterThanOrEqualTo(flight.get("arrivalDate"), filter.getArrivalDateFrom()));
        }


        query.where(predicates.toArray(new Predicate[0]));

        List<ViewFlightEntity> resultList = em.createQuery(query).getResultList();

        em.getTransaction().commit();
        return resultList;
    }
}
