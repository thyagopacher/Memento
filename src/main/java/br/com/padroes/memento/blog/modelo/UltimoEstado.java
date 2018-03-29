/**
 * @author Luan Bukowitz Beluzzo
 *
 */
package br.com.padroes.memento.blog.modelo;

public class UltimoEstado {

	private PontoNoTempo memento;

	public PontoNoTempo getMemento() {
		return memento;
	}

	public void setMemento(PontoNoTempo memento) {
		this.memento = memento;
	}

}
