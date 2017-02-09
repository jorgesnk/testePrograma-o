package br.com.jorge.clientes.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.jorge.clientes.dao.DAO;
import br.com.jorge.clientes.modelo.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {
	
	Cliente cliente= new Cliente();
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public void salva(){
		
		new DAO<Cliente>(Cliente.class).adiciona(this.cliente);
		this.cliente= new Cliente();
		
	}
	
	public List<Cliente>getClientes(){
		return new DAO<Cliente>(Cliente.class).listaTodos();
	}
	
	public void remove(Cliente cliente){
		System.out.println(cliente.getId()+" teste");
		new DAO<Cliente>(Cliente.class).remove(cliente);
		
	}
	
	public void carrega(Cliente cliente){
		this.cliente=cliente;
	}
	
	public void altera(){
		new DAO<Cliente>(Cliente.class).atualiza(this.cliente);
		this.cliente=new Cliente();
	}
	
	public String lista() {
        return "lista?faces-redirect=true";
    }
	public String cadastro() {
        return "cadastro?faces-redirect=true";
    }
	
	
}
