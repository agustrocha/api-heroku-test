package com.agustrocha.api.models.dao;

import com.agustrocha.api.models.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("clienteDao")
public class ClienteDaoImp implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List findAll() {
        return em.createQuery("SELECT c from Cliente c").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id); //Este método busca dentro de la clase Cliente cualquier coincidencia con el id pasado por parámetro.
    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
        if (cliente.getId() != null && cliente.getId() > 0) {
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
