package augustobellinaso.showdomilhao.util;

public class RegrasUtil {

    private RegrasUtil(){}

    private static final String REGRAS = "Ao selecionar a opção JOGAR, será necessário preencher"
            + " o campo de nome (para que depois seja mostrado no ranking de jogadores)\n\n"
            + "O jogo começa com o jogador respondendo a uma pergunta. Cada "
            + "pergunta deve conter um enunciado e 4 alternativas, sendo apenas "
            + "uma correta, e um nível (Fácil, Normal ou Difícil). \n\nA cada rodada a "
            + "pergunta terá um valor caso o jogador acerte a questão, um valor caso\n"
            + "o jogador erre a questão e um outro valor caso o jogador decida parar.\n\n"
            + "Caso o jogador acerte a pergunta, o jogo continua com a próxima "
            + "pergunta, caso o jogador pare, erre ou acerte a questão de 1 Milhão, o "
            + "jogo finaliza. \n\nAssim que um jogo finalizar, a pontuação do jogador "
            + "é salva junto ao nome e a pontuação adquirida para ser mostrado "
            + "posteriormente no ranking, somente se estiver entre os 10 primeiros.\n\n"
            + "O jogador pode ter direito a 3 tipos de ajuda:\n\n" + "- Pulo\n" + "- Cartas\n"
            + "- Universitários\n\n" + "Durante todo o jogo o jogador tem direito a 3 pulos, 1 ajuda das cartas e "
            + "1 ajuda aos universitários.\n\n" + "O pulo serve para trocar a pergunta feita ao usuário.\n\n"
            + "Na ajuda das cartas o jogador escolhe no escuro uma de quatro cartas, "
            + "as cartas são enumeradas de 0 a 3, a carta que o jogador escolher irá "
            + "determinar quantas respostas erradas não aparecerão nas escolhas.\n\n"
            + "Na ajuda aos universitários, o jogo mostra o palpite de 3 universitários. "
            + "\n\nAtenção: na pergunta de 1 Milhão de Reais o jogador não tem direito a " + "nenhuma ajuda!\n\n"
            + "O Jogo deverá conter 16 turnos de perguntas e respostas com os " + "seguintes valores:\n\n"
            + "1 - Pergunta R$1.000 para acerto, R$0,00 parar e R$0,00 se errar.\n\n"
            + "2 - Pergunta R$2.000 para acerto, R$1.000 parar e R$500 se errar.\n\n"
            + "3 - Pergunta R$3.000 para acerto, R$2.000 parar e R$1.000 se errar.\n\n"
            + "4 - Pergunta R$4.000 para acerto, R$3.000 parar e R$1.500 se errar.\n\n"
            + "5 - Pergunta R$5.000 para acerto, R$4.000 parar e R$2.000 se errar.\n\n"
            + "6 - Pergunta R$10.000 para acerto, R$5.000 parar e R$2.500 se errar.\n\n"
            + "7 - Pergunta R$20.000 para acerto, R$10.000 parar e R$5.000 se errar.\n\n"
            + "8 - Pergunta R$30.000 para acerto, R$20.000 parar e R$10.000 se errar.\n\n"
            + "9 - Pertunga R$40.000 para acerto, R$30.000 parar e R$15.000 se errar.\n\n"
            + "10 - Pergunta R$50.000 para acerto, R$40.000 parar e R$20.000 se errar.\n\n"
            + "11 - Pergunta R$100.000 para acerto, R$50.000 parar e R$25.000 se errar.\n\n"
            + "12 - Pergunta R$200.000 para acerto, R$100.000 parar e R$50.000 se errar.\n\n"
            + "13 - Pergunta R$300.000 para acerto, R$200.000 parar e R$100.000 se errar.\n\n"
            + "14 - Pergunta R$400.000 para acerto, R$300.000 parar e R$150.000 se errar.\n\n"
            + "15 - Pergunta R$500.000 para acerto, R$400.000 parar e R$200.000 se errar.\n\n"
            + "16 - Pergunta R$1.000.000 para acerto, R$500.000 para e R$0,00 se errar.";

    public static String getRegras() {
        return REGRAS;
    }
}
