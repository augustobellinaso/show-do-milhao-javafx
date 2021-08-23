package augustobellinaso.showdomilhao.test;

import augustobellinaso.showdomilhao.dao.JogadorDAO;
import augustobellinaso.showdomilhao.model.Jogador;

public class InsertDataForTesting {

    private static JogadorDAO jogadorDAO = new JogadorDAO();

    public static void main(String[] args) {
//        Jogador jogador = new Jogador();
//        jogador.setNome("Augusto");
//        jogador.setPontuacao(2);
//        System.out.println(jogadorDAO.adicionar(jogador));

        Jogador jogador = new Jogador();
        jogador.setId(1);
        jogador.setNome("Augusto Bellinaso");
        jogador.setPontuacao(1000);
        jogadorDAO.atualizar(jogador);
    }
}
