package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public ChoiceBox choiceBox;
    public TextField messageTextField;
    public TextField keyTextField;
    public Button encryptButton;
    public Button decryptButton;
    public Label headerLabel;
    public Label encryptedLabel;

    FeistelCipher feistelCipher;

    @FXML
    private void initialize() {

        feistelCipher = new FeistelCipher(16);

        encryptButton.setOnMouseClicked(mouseEvent -> handleEncryptButton());
        decryptButton.setOnMouseClicked(mouseEvent -> handleDecryptedButton());
    }

    private void handleEncryptButton() {
        String functionOperator = choiceBox.getValue().toString();
        String message = messageTextField.getText();
        String InitialKey = keyTextField.getText();
        String encryptedMessage = "";

        feistelCipher.setInitialKey(Integer.parseInt(InitialKey, 2));
        feistelCipher.setFunctionOperator(functionOperator);
        encryptedMessage = feistelCipher.encrypt(message);

        showEncryptedMessage(encryptedMessage);
    }

    private void handleDecryptedButton() {
        String encryptedMessage = encryptedLabel.getText();
        String decryptedMessage = "";

        decryptedMessage = feistelCipher.decrypt(encryptedMessage);

        showDecryptedMessage(decryptedMessage);
    }


    private void showEncryptedMessage(String encryptedMessage) {
        headerLabel.setVisible(true);
        encryptedLabel.setText(encryptedMessage);
        messageTextField.clear();
    }

    private void showDecryptedMessage(String decryptedMessage) {
        headerLabel.setVisible(false);
        messageTextField.setText(decryptedMessage);
        encryptedLabel.setText("");
    }

}
