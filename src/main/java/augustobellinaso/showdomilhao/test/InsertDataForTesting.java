package augustobellinaso.showdomilhao.test;

import augustobellinaso.showdomilhao.dao.PerguntaDAO;
import augustobellinaso.showdomilhao.model.Pergunta;

public class InsertDataForTesting {

    private static PerguntaDAO perguntaDAO = new PerguntaDAO();

    public static void main(String[] args) {
//        Pergunta p = new Pergunta();
//        p.setNivel("Fácil");
//        p.setEnunciado("Qual a cor do cavalo brando de napoleão");
//        p.setAlternativa1("Alternativa 1");
//        p.setAlternativa2("Alternativa 2");
//        p.setAlternativa3("Alternativa 3");
//        p.setResposta("branco");
//        p.setId(1);

        perguntaDAO.remover(1);

    }
}
