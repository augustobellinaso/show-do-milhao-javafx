package augustobellinaso.showdomilhao.dao;

import augustobellinaso.showdomilhao.connection.ConnectionFactory;
import augustobellinaso.showdomilhao.model.Pergunta;
import augustobellinaso.showdomilhao.util.LogUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PerguntaDAO {

    private static final String QUERY_ADICIONAR_PERGUNTA = "INSERT INTO perguntas (id, nivel, enunciado, alternativa1," +
            "alternativa2, alternativa3, resposta) VALUES ($next_id, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_ATUALIZAR_PERGUNTA = "UPDATE perguntas SET nivel = ?, enunciado = ?, alternativa1 = ?, alternativa2 = ?, alternativa3 = ?, resposta = ? WHERE id = ?";
    private static final String QUERY_EXCLUIR_PERGUNTA = "DELETE FROM perguntas WHERE id = ?";
    private static final String OK = "Processo concluído";
    private static final int MESSAGE_TYPE = JOptionPane.INFORMATION_MESSAGE;
    private static final String QUERY_BUSCAR_TODAS = "SELECT * FROM perguntas";
    private static final String QUERY_BUSCAR_POR_NIVEL = "SELECT * FROM perguntas WHERE nivel = ?";

    private Connection connection;

    public PerguntaDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public void adicionar(Pergunta pergunta) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_ADICIONAR_PERGUNTA)) {
                statement.setString(2, pergunta.getNivel());
                statement.setString(3, pergunta.getEnunciado());
                statement.setString(4, pergunta.getAlternativa1());
                statement.setString(5, pergunta.getAlternativa2());
                statement.setString(6, pergunta.getAlternativa3());
                statement.setString(7, pergunta.getResposta());
                statement.executeUpdate();
                connection.commit();
            }
            JOptionPane.showMessageDialog(new JFrame(), "Pergunta adicionada com sucesso!", OK, MESSAGE_TYPE);

        } catch (Exception e) {
            LogUtil.getLogger(PerguntaDAO.class).error(e.getCause().toString());
        }
    }

    public void atualizar(Pergunta pergunta) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_ATUALIZAR_PERGUNTA)) {
                statement.setString(1, pergunta.getNivel());
                statement.setString(2, pergunta.getEnunciado());
                statement.setString(3, pergunta.getAlternativa1());
                statement.setString(4, pergunta.getAlternativa2());
                statement.setString(5, pergunta.getAlternativa3());
                statement.setString(6, pergunta.getResposta());
                statement.setInt(7, pergunta.getId());
                statement.executeUpdate();
                connection.commit();
            }
            JOptionPane.showMessageDialog(new JFrame(), "Alterações realizadas com sucesso!", OK, MESSAGE_TYPE);

        } catch (Exception e) {
            LogUtil.getLogger(PerguntaDAO.class).error(e.getCause().toString());
        }
    }

    public void remover(Integer idPergunta) {
        try {
            try(PreparedStatement statement = connection.prepareStatement(QUERY_EXCLUIR_PERGUNTA)) {
                statement.setInt(1, idPergunta);
                statement.executeUpdate();
                connection.commit();
                JOptionPane.showMessageDialog(new JFrame(), "Pergunta removida com sucesso!", OK, MESSAGE_TYPE);

            }
        } catch (Exception e) {
            LogUtil.getLogger(PerguntaDAO.class).error(e.getCause().toString());
        }
    }

    private List<Pergunta> buscar(String sql, String nivel) {
        List<Pergunta> perguntas = new ArrayList<>();
        try {
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                if (Objects.nonNull(nivel)) {
                    statement.setString(1, nivel);
                }
                try(ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Pergunta pergunta = new Pergunta();
                        pergunta.setId(resultSet.getInt("id"));
                        pergunta.setNivel(resultSet.getString("nivel"));
                        pergunta.setEnunciado(resultSet.getString("enunciado"));
                        pergunta.setAlternativa1(resultSet.getString("alternativa1"));
                        pergunta.setAlternativa2(resultSet.getString("alternativa2"));
                        pergunta.setAlternativa3(resultSet.getString("alternativa3"));
                        pergunta.setResposta(resultSet.getString("resposta"));
                        perguntas.add(pergunta);
                    }
                }
            }

        } catch (Exception e) {
            LogUtil.getLogger(PerguntaDAO.class).error(e.getCause().toString());
        }
        return perguntas;
    }

    public List<Pergunta> listar() {
        return buscar(QUERY_BUSCAR_TODAS, null);
    }

    public List<Pergunta> listar(String nivel) {
        return buscar(QUERY_BUSCAR_POR_NIVEL, nivel);
    }

    public List<Pergunta> listar(String idsPerguntasFeitas, String nivel) {
        String sql = "SELECT * FROM perguntas WHERE nivel = ? ORDER BY RANDOM() LIMIT 1";
        if (idsPerguntasFeitas.isEmpty()) {
            sql = "SELECT * FROM perguntas WHERE nivel = ? AND perguntas.id NOT IN " + idsPerguntasFeitas + " ORDER BY RANDOM() LIMIT 1";
        }
        return buscar(sql, nivel);
    }
}
