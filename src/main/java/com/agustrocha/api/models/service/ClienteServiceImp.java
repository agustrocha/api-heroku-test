package com.agustrocha.api.models.service;

import com.agustrocha.api.models.dao.IClienteDao;
import com.agustrocha.api.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clienteService")
public class ClienteServiceImp implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {
        return clienteDao.findOne(id);
    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        clienteDao.delete(id);
    }
}
