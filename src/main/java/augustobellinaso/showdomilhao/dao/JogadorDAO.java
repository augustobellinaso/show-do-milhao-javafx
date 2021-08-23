package augustobellinaso.showdomilhao.dao;

import augustobellinaso.showdomilhao.connection.ConnectionFactory;
import augustobellinaso.showdomilhao.model.Jogador;
import augustobellinaso.showdomilhao.util.LogUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JogadorDAO {

    private Connection connection;

    public JogadorDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public boolean adicionar(Jogador jogador) {
        try {
            String sql = "INSERT INTO jogador (id, nome, pontuacao) VALUES ($next_id, ? , ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(2, jogador.getNome());
                statement.setInt(3, jogador.getPontuacao());
                statement.executeUpdate();
                connection.commit();
                return true;
            }
        } catch (Exception e) {
            LogUtil.getLogger(JogadorDAO.class).error(e.getCause().toString());
            return false;
        }
    }
}
