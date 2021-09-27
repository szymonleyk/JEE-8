package pl.szymonleyk.jee8.repository;

import pl.szymonleyk.jee8.entity.Adres;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class AdresRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Adres getById(int id) {
        return entityManager.find(Adres.class, id);
    }

    @Transactional
    public void save(Adres adres1) {
        entityManager.persist(adres1);
    }

    @Transactional
    public void remove(int id) {
        Adres adres = entityManager.find(Adres.class, id);
        entityManager.remove(adres);
    }

    public List<Adres> getAll() {
        TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a", Adres.class);
        List<Adres> addresses = query.getResultList();

        return addresses;
    }

    public List<Adres> findByStreet(String street) {


        // łączenie stringów
        // TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a WHERE a.ulica = '"+street+"'", Adres.class);

        // parametry indeksowe
//        TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a WHERE a.ulica = ?1 OR a.nrDomu = ?2", Adres.class);
//        query.setParameter(1, street);
//        query.setParameter(2, "5");

        // parametry nazwane
        TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a WHERE a.ulica = :ulica OR a.nrDomu = :nrDomu", Adres.class);
        query.setParameter("ulica", street);
        query.setParameter("nrDomu", "5");

        List<Adres> addresses = query.getResultList();

        return addresses;
    }

    @Transactional
    public void removeByStreet(String street) {
        Query query = entityManager.createQuery("DELETE FROM Adres a WHERE a.ulica = :ulica");
        query.setParameter("ulica", street);
        query.executeUpdate();
    }
}
