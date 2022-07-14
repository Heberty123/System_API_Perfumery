package Loja.Amelia.Exception;


public class ConflictCPFAlreadyExist extends RuntimeException{

    private String CPF;
    public ConflictCPFAlreadyExist(String CPF){
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }
}
