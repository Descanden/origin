package UAS;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        BioskopTicketApp.setRoot("secondary");
    }
}