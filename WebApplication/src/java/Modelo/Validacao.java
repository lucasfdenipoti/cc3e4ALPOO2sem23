package Modelo;

public class Validacao {
    public Double n1; 
    public Double n2;
    public String mensagem;
    
    public void validarNumeros(String num1, String num2){
        this.mensagem = "";
        try {
            this.n1 = Double.parseDouble(num1);
            this.n2 = Double.parseDouble(num2);
        } catch (Exception e) {
            this.mensagem = "Digite um número válido";
        }
    }
}
