public class Spam {
    private static String[][] termos = {
        {"voce ganhou", "10"},
        {"Cartão Chave De Segurança", "5"},
        {"seu cartao foi clonado", "8"},
        {"clique no link", "9"},
        {"confira o boleto", "3"},
        {"90% de desconto", "2"},
        {"Segurança", "4"},
        {"clique aqui para recompensa", "10"},
        {"chave", "6"},
        {"fraudes", "9"}
 };
    public static int Analisar(String texto){
        int pontuacao = 0;
        String textoLower = texto.toLowerCase();
        for(String[] termoPeso : termos){
            String termo = termoPeso[0].toLowerCase();
            int peso = Integer.parseInt(termoPeso[1]);
            if(textoLower.contains(termo)){
                 pontuacao += peso;
            }

        }
        return pontuacao;
    }
    public static String Pontos (int pontuacao){
        if (pontuacao > 70) {
            return "spam";
        } 
        else if (pontuacao > 30) {
            return "potencialmente suspeito";
        } 
        else if (pontuacao >= 5) {
            return "fracamente suspeito";
        } 
        else {
            return "não suspeito";
        }
    }
    
public static void main(String[] args){
    String caminho = "teste.txt";
    String texto = LeitorArquivo.lerArquivo(caminho);

    int pontuacao = Spam.Analisar(texto);
    String pontos = Spam.Pontos(pontuacao);
    
    System.out.println("Pontuação final: " + pontuacao);
    System.out.println("Classificação: " + pontos);

}

}
