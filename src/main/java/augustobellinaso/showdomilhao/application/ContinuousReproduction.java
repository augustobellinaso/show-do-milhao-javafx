package augustobellinaso.showdomilhao.application;

import augustobellinaso.showdomilhao.util.LogUtil;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ContinuousReproduction extends Thread{

    private String fileMusic;
    private boolean loop;

    public ContinuousReproduction(String fileMusic, boolean loop) {
        this.fileMusic = fileMusic;
        this.loop = loop;
    }

    @Override
    public void run() {
        try {
            do {
                new Player(new BufferedInputStream(new FileInputStream(fileMusic))).play();
            } while (loop);
        } catch (Exception e) {
            LogUtil.getLogger(ContinuousReproduction.class).error(e.getCause().toString());
        }

    }
}
