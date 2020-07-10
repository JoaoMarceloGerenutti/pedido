package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private OrderStatus statusPedido;
	
	private Client cliente;
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date momento, OrderStatus statusPedido, Client cliente) {
		super();
		this.momento = momento;
		this.statusPedido = statusPedido;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrderStatus getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(OrderStatus statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Client getCliente() {
		return cliente;
	}

	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public double total() {
		double soma = 0.0;
		for (OrderItem orderItem : itens) {
			soma += orderItem.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do pedido: ");
		sb.append(statusPedido + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do pedido:\n");
		for (OrderItem item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Preço total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}
