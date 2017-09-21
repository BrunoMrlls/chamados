package br.com.chamadosweb.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.chamadosweb.padrao.BaseControl;
import br.com.chamadosweb.service.VersaoServiceLocal;
import br.com.chamadosweb.service.model.Versao;

/**
*
* @author Renan Celso
*/
@ManagedBean(name = "versaoHistoricoControl")
@ViewScoped
public class VersaoHistoricoControl extends BaseControl {
		
	private static final long serialVersionUID = 247721924473601895L;
	
	@EJB
	private VersaoServiceLocal versaoService;
	
	private List<Versao> listaVersoes;
	
	private Versao versaoFiltro;
	
	private Versao versaoIncluir;
	
	private boolean mostrarLista;

	@PostConstruct
	public void init() {		
		listaVersoes = new ArrayList<Versao>();		
		listaVersoes = versaoService.consultarVersoes(versaoFiltro);	
		mostrarLista = true;
	}
		
	public String iniciarInclusaoNovaVersao() {		
		mostrarLista = false;		
		versaoIncluir = new Versao();		
		return null;
	}
	
	public String incluirNovaVersao() {		
		try {
			versaoService.atualizar(versaoIncluir);				
			addInfoMessage("Versão "+versaoIncluir.getNrVersao()+" cadastrada com sucesso.");		
			voltar();					
		} catch(Exception e){
			addInfoMessage("Erro ao cadastrar Versão");
			log.error(e);			
		}
		return null;
	}
	
	public String voltar() {		
		listaVersoes = new ArrayList<Versao>();		
		listaVersoes = versaoService.consultarVersoes(versaoFiltro);		
		mostrarLista = true;
		versaoIncluir = new Versao();
		return null;
	}

	public List<Versao> getListaVersoes() {
		return listaVersoes;
	}

	public void setListaVersoes(List<Versao> listaVersoes) {
		this.listaVersoes = listaVersoes;
	}

	public Versao getVersaoFiltro() {
		return versaoFiltro;
	}

	public void setVersaoFiltro(Versao versaoFiltro) {
		this.versaoFiltro = versaoFiltro;
	}

	public boolean isMostrarLista() {
		return mostrarLista;
	}

	public void setMostrarLista(boolean mostrarLista) {
		this.mostrarLista = mostrarLista;
	}

	public Versao getVersaoIncluir() {
		return versaoIncluir;
	}

	public void setVersaoIncluir(Versao versaoIncluir) {
		this.versaoIncluir = versaoIncluir;
	}				
	
}
