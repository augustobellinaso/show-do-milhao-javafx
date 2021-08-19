package augustobellinaso.showdomilhao.application;

import augustobellinaso.showdomilhao.util.LogUtil;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class JLayer extends Thread {

    private File mp3;

    public void tocar(File mp3) {
        this.mp3 = mp3;
    }

    @Override
    public void run() {

        try {
            try(FileInputStream fileInputStream = new FileInputStream(mp3)) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                Player player = new Player(bufferedInputStream);
                player.play();
                if (player.isComplete()) {
                    player.close();
                }
            }

        } catch (Exception e) {
            LogUtil.getLogger(JLayer.class).error(e.getCause().toString());

        }
    }
}
