package springboot.application.filmatory.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Transactional
public abstract class BaseDao<T> {

    @PersistenceContext
    protected EntityManager em;

    private final Class<T> type;

    BaseDao(Class<T> type) {
        this.type = type;
    }

    public void persist(T entity) {
        Objects.requireNonNull(entity);
        try {
            em.persist(entity);
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        }
    }

    public void persist(Collection<T> entities) {
        Objects.requireNonNull(entities);
        if (entities.isEmpty()) {
            return;
        }
        try {
            entities.forEach(this::persist);
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        }
    }

    public T update(T entity) {
        Objects.requireNonNull(entity, "You are trying to update a null object!");
        try {
            return em.merge(entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public void remove(T entity) {
        Objects.requireNonNull(entity);
        try {
            final T toRemove = em.merge(entity);
            if (toRemove != null) {
                em.remove(toRemove);
            }
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        }
    }

    public boolean exists(Integer id) {
        return id != null && em.find(type, id) != null;
    }

    public T find(Integer id) {
        Objects.requireNonNull(id);
        return em.find(type, id);
    }

    public List<T> findAll() {
        try {
            return em.createQuery("SELECT e FROM " + type.getSimpleName() + " e", type).getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Could not select from db");
        }
    }
}
