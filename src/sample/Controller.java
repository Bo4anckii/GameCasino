package sample;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import sample.model.CasinoGame;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CasinoGame game = new CasinoGame(pane);
    }
}
