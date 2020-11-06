package sample.controllers;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.models.ActionChain;
import sample.models.MainModel;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainController implements Initializable {

    public Label text1;
    public Label text2;
    public Label text3;
    public Button stopBtn;
    private final MainModel model = new MainModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newGame();
    }

    private void newGame(){
        stopBtn.setText("Остановить первую цифру");
        stopBtn.setOnMouseClicked(e1 -> {
            model.getTimer1().cancel();
            stopBtn.setText("Остановить вторую цифру");
            stopBtn.setOnMouseClicked(e2 -> {
                stopBtn.setText("Остановить третью цифру");
                model.getTimer2().cancel();
                stopBtn.setOnMouseClicked(e3 -> {
                    model.getTimer3().cancel();
                    if(new ActionChain().process(new int[]{model.getInt1(), model.getInt2(), model.getInt3()})){
                        stopBtn.setText("Вы выиграли. Начать заново");
                    }
                    else
                        stopBtn.setText("Вы проиграли. Начать заново");
                    stopBtn.setOnMouseClicked(e4 -> newGame());
                });
            });
        });

        Random random = new Random();
        model.setInt1(random.nextInt(9) + 1);
        model.setInt2(random.nextInt(9) + 1);
        model.setInt3(random.nextInt(9) + 1);

        restartTimers();
    }

    private void restartTimers(){
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if (model.getInt1() < 9)
                    model.setInt1(model.getInt1() + 1);
                else
                    model.setInt1(0);
                Platform.runLater(() -> text1.setText(model.getInt1() + ""));
            }
        };
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                if (model.getInt2() < 9)
                    model.setInt2(model.getInt2() + 1);
                else
                    model.setInt2(0);
                Platform.runLater(()->text2.setText(model.getInt2() + ""));
            }
        };
        TimerTask timerTask3 = new TimerTask() {
            @Override
            public void run() {
                if (model.getInt3() < 9)
                    model.setInt3(model.getInt3() + 1);
                else
                    model.setInt3(0);
                Platform.runLater(()->text3.setText(model.getInt3() + ""));
            }
        };

        model.setTimer1(new Timer("timer1"));
        model.getTimer1().schedule(timerTask1, 0, 150);

        model.setTimer2(new Timer("timer2"));
        model.getTimer2().schedule(timerTask2, 0, 150);

        model.setTimer3(new Timer("timer3"));
        model.getTimer3().schedule(timerTask3, 0, 150);
    }
}
