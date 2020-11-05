package sample.model;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CasinoGame {

    private final Pane pane;
    private final Text text1 = new Text();
    private final Text text2 = new Text();
    private final Text text3 = new Text();
    private Button stop;

    private Timer timer1;
    private Timer timer2;
    private Timer timer3;
    private int int1;
    private int int2;
    private int int3;

    public CasinoGame(Pane pane) {
        this.pane = pane;
        initView();
        newGame();
    }

    private void initView(){
        stop = new Button();
        stop.setLayoutX(300);
        stop.setLayoutY(150);

        pane.getChildren().clear();
        pane.setPrefWidth(600);
        pane.setPrefHeight(200);
        pane.getChildren().addAll(text1, text2, text3, stop);

        text1.setFont(new Font(100));
        text1.setFill(Color.RED);
        text1.setTextAlignment(TextAlignment.JUSTIFY);
        text1.setWrappingWidth(200);
        text1.setLayoutX(0);
        text1.setLayoutY(100);

        text2.setFont(new Font(100));
        text2.setFill(Color.RED);
        text2.setTextAlignment(TextAlignment.JUSTIFY);
        text2.setWrappingWidth(200);
        text2.setLayoutX(pane.getPrefWidth() / 2 - text2.getWrappingWidth() / 2);
        text2.setLayoutY(100);

        text3.setFont(new Font(100));
        text3.setFill(Color.RED);
        text3.setTextAlignment(TextAlignment.JUSTIFY);
        text3.setWrappingWidth(200);
        text3.setLayoutX(pane.getPrefWidth() - text3.getWrappingWidth());
        text3.setLayoutY(100);
    }

    private void newGame() {
        stop.setText("Остановить первую цифру");
        stop.setOnMouseClicked(e1 -> {
            timer1.cancel();
            stop.setText("Остановить вторую цифру");
            stop.setOnMouseClicked(e2 -> {
                stop.setText("Остановить третью цифру");
                timer2.cancel();
                stop.setOnMouseClicked(e3 -> {
                    timer3.cancel();
                    if (text1.getText().equals(text2.getText()) && text2.getText().equals(text3.getText()))
                        stop.setText("Вы выиграли. Начать заново");
                    else
                        stop.setText("Вы проиграли. Начать заново");
                    stop.setOnMouseClicked(e4 -> newGame());
                });
            });
        });

        Random random = new Random();
        int1 = random.nextInt(9) + 1;
        int2 = random.nextInt(9) + 1;
        int3 = random.nextInt(9) + 1;

        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if (int1 < 9)
                    int1++;
                else
                    int1 = 0;
                Platform.runLater(() -> text1.setText(int1 + ""));
            }
        };
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                if (int2 < 9)
                    int2++;
                else
                    int2 = 0;
                Platform.runLater(()->text2.setText(int2 + ""));
            }
        };
        TimerTask timerTask3 = new TimerTask() {
            @Override
            public void run() {
                if (int3 < 9)
                    int3++;
                else
                    int3 = 0;
                Platform.runLater(()->text3.setText(int3 + ""));
            }
        };

        timer1 = new Timer("timer1");
        timer1.schedule(timerTask1, 0, 150);

        timer2 = new Timer("timer2");
        timer2.schedule(timerTask2, 0, 150);

        timer3 = new Timer("timer3");
        timer3.schedule(timerTask3, 0, 150);
    }
}
