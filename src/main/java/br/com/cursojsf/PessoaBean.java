package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	private List<Pessoa> pessoas = new ArrayList<>();
		
//	public String salvar() {
//		daoGeneric.salvar(pessoa);
//		pessoa = new Pessoa();
//		return "";
//	}
	
	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		carregarPessoas();
		return "";
	}
	
	public String novo() {
		pessoa = new Pessoa();
		return "";
	}
	
	public String remove() {		
		daoGeneric.removePorId(pessoa);
		pessoa = new Pessoa();
		carregarPessoas();
		return "";
	}	
	
	@PostConstruct
	public void carregarPessoas() {		
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() {		
		return pessoas;
	}
	
	
}
