package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite os dados do cliente!");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		
		System.out.print("Email: ");
		String emailCliente = sc.nextLine();
		
		System.out.print("Data de nascimento (DD/MM/AAAA): ");
		Date nascimentoCliente = sdf.parse(sc.next());
		sc.nextLine();
		Client cliente = new Client(nomeCliente, emailCliente, nascimentoCliente);
		System.out.println("-------------------------------------------");
		
		System.out.println("Digite os dados do pedido!");
		System.out.print("Status: ");
		OrderStatus statusPedido = OrderStatus.valueOf(sc.nextLine());
		
		Order pedido = new Order(new Date(), statusPedido, cliente);
		
		System.out.print("Quantos items tem o pedido? ");
		int quantidadeItens = sc.nextInt();
		
		for (int i=1; i<=quantidadeItens; i++) {
			sc.nextLine();
			System.out.println("-------------------------------------------");
			System.out.println("Digite as informações do produto #" + i);
			
			System.out.print("Nome do produto: ");
			String nomeProduto = sc.nextLine();
			
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			
			System.out.print("Quantidade: ");
			int quantidadeProduto = sc.nextInt();
			
			Product produto = new Product(nomeProduto, precoProduto);
			
			OrderItem pedidoItem = new OrderItem(quantidadeProduto, precoProduto, produto);
			
			pedido.addItem(pedidoItem);
		}
		System.out.println("-------------------------------------------");
		
		System.out.println("INFORMAÇÕES DO PEDIDO");
		System.out.println(pedido);
		
		sc.close();
	}

}
