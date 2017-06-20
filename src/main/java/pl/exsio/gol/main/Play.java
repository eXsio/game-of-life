package pl.exsio.gol.main;

import pl.exsio.gol.model.Cell;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Play extends Thread {

    private volatile boolean stopped = false;
    private Cell[][] Grid;
    private int neighbors;
    private Main m;

    Play(Cell[][] Grid, Main m) {

        this.Grid = Grid;
        neighbors = 0;
        this.m = m;

    }

    void stopTheGame() {
        this.stopped = true;
    }

    @Override
    public void run() {
        Cell[][] tick = new Cell[Grid.length][Grid[0].length];
        for (int i = 0; i < Grid.length; i++)
            for (int j = 0; j < tick[i].length; j++)
                tick[i][j] = new Cell();

        while (!stopped) {
            for (int i = 0; i < Grid.length; i++) {
                for (int j = 0; j < Grid[i].length; j++) {
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && y >= 0 && x < Grid.length && y < Grid[0].length)
                                if (Grid[x][y].isPopulated() && (x != i || y != j)) {
                                    neighbors++;
                                }
                        }
                    }

                    if (Grid[i][j].isPopulated()) {
                        if (neighbors <= 1 || neighbors >= 4) tick[i][j].setPopulated(false);
                        else if (neighbors == 2 || neighbors == 3) tick[i][j].setPopulated(true);
                    } else if (!Grid[i][j].isPopulated()) {
                        if (neighbors == 3) tick[i][j].setPopulated(true);
                    }
                    neighbors = 0;
                }
            }

            for (int i = 0; i < Grid.length; i++) {
                for (int j = 0; j < Grid[i].length; j++) {
                    Grid[i][j].setPopulated(tick[i][j].isPopulated());
                }
            }
            try {
                Play.sleep(Integer.parseInt(m.delay.getValue().toString()));
            } catch (InterruptedException ex) {
                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
            }
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    m.gen.setText(Integer.toString(Integer.parseInt(m.gen.getText()) + 1));
                    return null;
                }
            }.execute();

        }

    }

}
