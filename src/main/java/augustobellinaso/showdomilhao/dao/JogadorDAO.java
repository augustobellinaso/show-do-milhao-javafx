package augustobellinaso.showdomilhao.dao;

import augustobellinaso.showdomilhao.connection.ConnectionFactory;
import augustobellinaso.showdomilhao.model.Jogador;
import augustobellinaso.showdomilhao.util.LogUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {

    private Connection connection;

    private static final String QUERY_INSERT = "INSERT INTO jogador (id, nome, pontuacao) VALUES ($next_id, ? , ?)";
    private static final String QUERY_UPDATE = "UPDATE jogador SET nome = ?, pontuacao = ? WHERE id = ?";
    private static final String QUERY_ZERAR_RANKING = "DELETE FROM jogador";
    private static final String QUERY_CONSULTAR_TODOS = "SELECT * FROM jogador";
    private static final String QUERY_LISTAR_RANKING = "SELECT * FROM jogador ORDER BY pontuacao DESC LIMIT 10";


    public JogadorDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public boolean adicionar(Jogador jogador) {

        try (PreparedStatement statement = connection.prepareStatement(QUERY_INSERT)) {
            statement.setString(2, jogador.getNome());
            statement.setInt(3, jogador.getPontuacao());
            statement.executeUpdate();
            connection.commit();
            return true;

        } catch (Exception e) {
            LogUtil.getLogger(JogadorDAO.class).error(e.getCause().toString());
            return false;
        }
    }

    public void atualizar(Jogador jogador) {
        try (PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE)) {
            statement.setString(1, jogador.getNome());
            statement.setInt(2, jogador.getPontuacao());
            statement.setInt(3, jogador.getId());
            statement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            LogUtil.getLogger(JogadorDAO.class).error(e.getCause().toString());
        }
    }

    private List<Jogador> buscar(String sql) {
        List<Jogador> jogadores = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Jogador jogador = new Jogador();
                    jogador.setId(resultSet.getInt("id"));
                    jogador.setNome(resultSet.getString("nome"));
                    jogador.setLinha(resultSet.getRow());
                    jogador.setPontuacao(resultSet.getInt("pontuacao"));
                    jogadores.add(jogador);
                }
            }

        } catch (Exception e) {
            LogUtil.getLogger(JogadorDAO.class).error(e.getCause().toString());
        }
        return jogadores;
    }

    public List<Jogador> listar() {
        return buscar(QUERY_CONSULTAR_TODOS);
    }

    public List<Jogador> listarRanking() {
        return buscar(QUERY_LISTAR_RANKING);
    }

    public void zerarRanking() {
        try (PreparedStatement statement = connection.prepareStatement(QUERY_ZERAR_RANKING)) {
            statement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            LogUtil.getLogger(JogadorDAO.class).error(e.getCause().toString());
        }
    }
}
