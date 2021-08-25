package augustobellinaso.showdomilhao.dao;

import augustobellinaso.showdomilhao.connection.ConnectionFactory;
import augustobellinaso.showdomilhao.model.Pergunta;
import augustobellinaso.showdomilhao.util.LogUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PerguntaDAO {

    private static final String QUERY_ADICIONAR_PERGUNTA = "INSERT INTO perguntas (id, nivel, enunciado, alternativa1," +
            "alternativa2, alternativa3, resposta) VALUES ($next_id, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_ATUALIZAR_PERGUNTA = "UPDATE perguntas SET nivel = ?, enunciado = ?, alternativa1 = ?, alternativa2 = ?, alternativa3 = ?, resposta = ? WHERE id = ?";
    private static final String QUERY_EXCLUIR_PERGUNTA = "DELETE FROM perguntas WHERE id = ?";
    private static final String OK = "Processo concluído";
    private static final int MESSAGE_TYPE = JOptionPane.INFORMATION_MESSAGE;

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
}
