package entities;

public class OrderItem {

	private Integer quantidade;
	private Double preco;
	
	private Product produto;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantidade, Double preco, Product produto) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPreco() {
		return preco;
	}
	
	public Product getProduto() {
		return produto;
	}

	public double subTotal() {
		return quantidade * preco;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getProduto().getNome() + ", ");
		sb.append("$" + String.format("%.2f", preco) + ", ");
		sb.append("Quantidade: " + quantidade + ", ");
		sb.append("Subtotal: $" + String.format("%.2f", subTotal()));
		return sb.toString();
	}
	
	
}
