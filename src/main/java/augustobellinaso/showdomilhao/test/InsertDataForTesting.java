package augustobellinaso.showdomilhao.test;

import augustobellinaso.showdomilhao.dao.PerguntaDAO;
import augustobellinaso.showdomilhao.model.Pergunta;

public class InsertDataForTesting {

    private static PerguntaDAO perguntaDAO = new PerguntaDAO();

    public static void main(String[] args) {
        Pergunta p = new Pergunta();
        p.setNivel("Fácil");
        p.setEnunciado("Pergunta 1");
        p.setAlternativa1("Alternativa 1");
        p.setAlternativa2("Alternativa 2");
        p.setAlternativa3("Alternativa 3");
        p.setResposta("Resposta");

        perguntaDAO.adicionar(p);

    }
}
