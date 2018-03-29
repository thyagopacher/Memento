/**
 * @author Luan Bukowitz Beluzzo
 *
 */
package br.com.padroes.memento.blog.modelo;

public class PontoNoTempo {

	private String titulo;

	private String conteudo;

	public PontoNoTempo(String titulo, String conteudo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
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
