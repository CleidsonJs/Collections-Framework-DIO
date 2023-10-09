package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item i : itemList){
            if (i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }
        itemList.removeAll(itensParaRemover);
    }
    public double calcularValorTotal() {
        double valorTotal = 0;
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;

        }

        public void exibirItens (){
            System.out.println(itemList);
        }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.adicionarItem("Caneta", 2.00, 5);
        carrinhoDeCompras.adicionarItem("Lápis", 1.00, 2);
        carrinhoDeCompras.adicionarItem("Caderno", 20, 1);
        carrinhoDeCompras.exibirItens();

        System.out.println("O valor total é de: " + carrinhoDeCompras.calcularValorTotal());


    }
    }
