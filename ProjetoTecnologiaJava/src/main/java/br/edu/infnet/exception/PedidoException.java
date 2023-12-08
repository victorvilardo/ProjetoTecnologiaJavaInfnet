package br.edu.infnet.exception;

public class PedidoException extends RuntimeException  {
    
    public PedidoException() {
        super("Não é possivel salvar este pedido!");
    }
    
}
