/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import br.edu.ifsul.modelo.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexv
 */
@Stateless
public class ClienteDAO implements Serializable{
 
    private List<Cliente> lista;
    @PersistenceContext(unitName = "ServicoClienteCorreioPU")
    private EntityManager em;

    public ClienteDAO() {
       
    }

    public Cliente inserir(Cliente obj) {
        obj.setId(null);
        em.persist(obj);
        return obj;
    }

    public Cliente alterar(Cliente obj) {
        em.merge(obj);
        return obj;
    }

    public boolean remover(Integer id) {
        try {
            Cliente obj = em.find(Cliente.class, id);
            em.remove(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Cliente> getLista() {
        return em.createQuery("from Cliente order by id").getResultList();
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

}
