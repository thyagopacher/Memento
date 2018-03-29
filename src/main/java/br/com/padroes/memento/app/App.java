package br.com.padroes.memento.app;

import br.com.padroes.memento.blog.modelo.UltimoEstado;
import br.com.padroes.memento.blog.modelo.Publicacao;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	private UltimoEstado ultimoEstado = new UltimoEstado();

	private Publicacao publicacao = new Publicacao();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		final Label labelTitulo = new Label("Titulo: ");
		final TextField entrataTitulo = new TextField();
		entrataTitulo.textProperty().addListener((observable, oldValue, newValue) -> {
			publicacao.setTitulo(newValue);
		});
		
		final Label labelConteudo = new Label("Conteúdo: ");
		final TextArea entradaTexto = new TextArea();
		entradaTexto.textProperty().addListener((observable, oldValue, newValue) -> {
			publicacao.setConteudo(newValue);
		});
		
		final VBox conteudoPub = new VBox();
		conteudoPub.getChildren().addAll(labelTitulo, entrataTitulo, labelConteudo, entradaTexto);

		final Group group = new Group();
		group.getChildren().add(conteudoPub);

		final Button bSalvar = new Button("Salvar");
		bSalvar.setMinWidth(300);
		bSalvar.setOnAction(a -> this.salvarEstado());
		final Button bVoltar = new Button("Voltar");
		bVoltar.setMinWidth(300);
		bVoltar.setOnAction(a -> this.retornarEstado(entrataTitulo, entradaTexto));

		final HBox menu = new HBox();
		menu.setMinWidth(600);
		menu.setMinHeight(30);
		menu.setMaxHeight(30);
		menu.getChildren().addAll(bVoltar, bSalvar);

		final BorderPane painelPrincipal = new BorderPane();
		painelPrincipal.setCenter(group);
		painelPrincipal.setBottom(menu);

		Scene scene = new Scene(painelPrincipal, 600, 300);
		stage.setTitle("Armazenador de Estados");
		stage.setScene(scene);
		stage.show();
	}

	public void retornarEstado(TextField entrataTitulo, TextArea entradaTexto) {
		if (ultimoEstado.getMemento() == null) {
			return;
		}

		entrataTitulo.setText(ultimoEstado.getMemento().getTitulo());
		entradaTexto.setText(ultimoEstado.getMemento().getConteudo());
	}

	public void salvarEstado() {
		ultimoEstado.setMemento(this.publicacao.criarMemento());
	}

}
