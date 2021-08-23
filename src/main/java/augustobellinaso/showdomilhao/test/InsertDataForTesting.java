package augustobellinaso.showdomilhao.test;

import augustobellinaso.showdomilhao.dao.JogadorDAO;
import augustobellinaso.showdomilhao.model.Jogador;

public class InsertDataForTesting {

    private static JogadorDAO jogadorDAO = new JogadorDAO();

    public static void main(String[] args) {
        jogadorDAO.zerarRanking();

    }
}
