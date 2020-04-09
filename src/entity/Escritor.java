package entity;

public class Escritor{
	private int id;
	private Pessoa pessoa;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getPessoa(){
		return this.pessoa;
	}
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
}
