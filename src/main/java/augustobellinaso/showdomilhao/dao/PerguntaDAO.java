package augustobellinaso.showdomilhao.dao;

import augustobellinaso.showdomilhao.connection.ConnectionFactory;
import augustobellinaso.showdomilhao.model.Pergunta;
import augustobellinaso.showdomilhao.util.LogUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PerguntaDAO {

    private static final String QUERY_ADICIONAR_PERGUNTA = "INSERT INTO perguntas (id, nivel, enunciado, alternativa1," +
            "alternativa2, alternative3, resposta) VALUES ($next_id, ?, ?, ?, ?, ?, ?)";
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
            JOptionPane.showMessageDialog(new JFrame(), "Pergunta adicionada com sucesso!", "Processo concluído", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            LogUtil.getLogger(PerguntaDAO.class).error(e.getCause().toString());
        }

    }
}
