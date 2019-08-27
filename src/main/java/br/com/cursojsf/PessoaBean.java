package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;


@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	
	private Pessoa pessoa = new Pessoa(); 	
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	
	
//	public String salvar() {
//		daoGeneric.salvar(pessoa);
//		pessoa = new Pessoa();
//		return "";
//	}
	
	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		return "";
	}
	
	public String novo() {
		pessoa = new Pessoa();
		return "";
	}
	
	public String remove() {		
		daoGeneric.remove(pessoa);
		return "";
	}	
	

	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
