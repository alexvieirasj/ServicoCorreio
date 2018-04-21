/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.servicos;

import br.edu.ifsul.ejb.ClienteDAO;
import br.edu.ifsul.modelo.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author alexv
 */
@WebService
public class ServicoCliente {
    
    @EJB    
    private ClienteDAO dao;
    
    public ServicoCliente(){
        
    }
    
    @WebMethod
    public List<Cliente> listaPessoas(){
        return dao.getLista();
    }
    
    @WebMethod
    public Cliente inserir(@WebParam(name = "cliente")
            @XmlElement(required = true) Cliente obj){
        return dao.inserir(obj);
    }
    
    @WebMethod
    public Cliente alterar(@WebParam(name = "cliente")
            @XmlElement(required = true) Cliente obj){
        return dao.alterar(obj);
    }
    
    @WebMethod
    public boolean remover(@WebParam(name = "id")
            @XmlElement(required = true) Integer id){
        return dao.remover(id);
    }

}

