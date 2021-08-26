package augustobellinaso.showdomilhao.test;

import augustobellinaso.showdomilhao.dao.PerguntaDAO;
import augustobellinaso.showdomilhao.model.Pergunta;

public class InsertDataForTesting {

    private static PerguntaDAO perguntaDAO = new PerguntaDAO();

    public static void main(String[] args) {
//        Pergunta p = new Pergunta();
//        p.setNivel("Dificil");
//        p.setEnunciado("AAAA45");
//        p.setAlternativa1("Alternativa 1");
//        p.setAlternativa2("Alternativa 2");
//        p.setAlternativa3("Alternativa 3");
//        p.setResposta("branco");
//
//        perguntaDAO.adicionar(p);

        perguntaDAO.listar("","Fácil").forEach(x -> System.out.println(x));


    }
}
