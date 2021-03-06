/**
 * @author Luan Bukowitz Beluzzo
 *
 */
package br.com.padroes.memento.blog.modelo;

public class Publicacao {
	
	private String titulo;

	private String conteudo;

	public PontoNoTempo criarMemento() {
		return new PontoNoTempo(titulo, conteudo);
	}

	public void setMemento(PontoNoTempo memento) {
		this.titulo = memento.getTitulo();
		this.conteudo = memento.getConteudo();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
