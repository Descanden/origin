package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Tess extends Application {

    private String pembeli;
    private String jamPenayangan;
    private String film;
    private Set<Integer> kursiRandomTerisi = new HashSet<>();
    private Set<Integer> kursiPilihanUser = new HashSet<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplikasi Pemesanan Tiket Bioskop");

        // Layout GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Nama Pembeli
        TextField pembeliField = new TextField();
        pembeliField.setPromptText("Nama Pembeli");
        gridPane.add(new Label("Nama Pembeli:"), 0, 0);
        gridPane.add(pembeliField, 1, 0);

        // Jam Penayangan
        ComboBox<String> jamPenayanganComboBox = new ComboBox<>();
        jamPenayanganComboBox.getItems().addAll("12:00", "15:00", "18:00", "21:00");
        jamPenayanganComboBox.setPromptText("Pilih");
        gridPane.add(new Label("Jam Penayangan:"), 0, 1);
        gridPane.add(jamPenayanganComboBox, 1, 1);

        // Nama Film
        ComboBox<String> filmComboBox = new ComboBox<>();
        filmComboBox.getItems().addAll("Kimi No Nawa", "Spiderman Home Coming", "Spirited Away");
        filmComboBox.setPromptText("Pilih");
        gridPane.add(new Label("Nama Film:"), 0, 2);
        gridPane.add(filmComboBox, 1, 2);

        // Tombol Lihat Kursi Tersedia
        Button lihatKursiButton = new Button("Lihat Kursi Tersedia");
        gridPane.add(lihatKursiButton, 1, 3);

        // Event Handler untuk Tombol Lihat Kursi Tersedia
        lihatKursiButton.setOnAction(event -> {
            try {
                validateInput(pembeliField, jamPenayanganComboBox, filmComboBox); // Validasi bahwa semua input telah diisi
                pembeli = pembeliField.getText();
                jamPenayangan = jamPenayanganComboBox.getValue();
                film = filmComboBox.getValue();

                // Generate kursi terisi secara acak
                generateRandomSeats();

                // Tampilkan Scene Pemilihan Kursi
                showSeatSelection(primaryStage);
            } catch (InputValidationException e) {
                // Tangkap pengecualian dan tampilkan pesan kesalahan menggunakan Alert
                showAlert("Error", e.getMessage());
            }
        });

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Fungsi untuk menampilkan Scene Pemilihan Kursi
    private void showSeatSelection(Stage primaryStage) {
        GridPane seatGridPane = new GridPane();
        seatGridPane.setPadding(new Insets(20, 20, 20, 20));
        seatGridPane.setVgap(10);
        seatGridPane.setHgap(10);

        // Create CheckBox controls for each seat
        int rowCount = 0;
        int colCount = 0;

        for (int i = 1; i <= 80; i++) {
            CheckBox checkBox = new CheckBox("Kursi " + i);

            // Jika kursi terisi secara acak, set disable dan selected
            if (kursiRandomTerisi.contains(i)) {
                checkBox.setDisable(true);
                checkBox.setSelected(true);
            }

            seatGridPane.add(checkBox, colCount, rowCount);

            // Event Handler untuk pemilihan kursi
            int kursiNumber = i;
            checkBox.setOnAction(event -> {
                if (!checkBox.isDisabled()) { // Kursi yang terisi secara acak tidak dapat dibatalkan
                    if (checkBox.isSelected()) {
                        kursiPilihanUser.add(kursiNumber);
                    } else {
                        kursiPilihanUser.remove(Integer.valueOf(kursiNumber));
                    }
                }
            });

            colCount++;
            if (colCount == 20) {
                colCount = 0;
                rowCount++;
            }
        }

        // Tombol Pesan
        Button pesanButton = new Button("Pesan");
        seatGridPane.add(pesanButton, 10, rowCount + 1);

        // Event Handler untuk Tombol Pesan
        pesanButton.setOnAction(event -> showNota(primaryStage));

        Scene seatSelectionScene = new Scene(seatGridPane, 600, 400);
        primaryStage.setScene(seatSelectionScene);
    }

    // Fungsi untuk menampilkan Nota
    private void showNota(Stage primaryStage) {
        StringBuilder nota = new StringBuilder();
        nota.append("===== Nota Pemesanan =====\n");
        nota.append("Nama Pembeli: ").append(pembeli).append("\n");
        nota.append("Jam Penayangan: ").append(jamPenayangan).append("\n");
        nota.append("Nama Film: ").append(film).append("\n");
        nota.append("Kursi Terpilih: ");

        // Cetak nomor kursi yang dipilih oleh pengguna
        for (int kursi : kursiPilihanUser) {
            nota.append("Kursi ").append(kursi).append(" ");
        }

        TextArea notaTextArea = new TextArea(nota.toString());
        notaTextArea.setEditable(false);

        // Tampilkan nota dalam dialog
        Dialog<String> notaDialog = new Dialog<>();
        notaDialog.setTitle("Nota Pemesanan");
        notaDialog.setHeaderText(null);
        notaDialog.getDialogPane().setContent(notaTextArea);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        notaDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        notaDialog.showAndWait();

        // Kembali ke Scene utama
        start(primaryStage);
    }

    // Fungsi untuk menghasilkan kursi terisi secara acak
    private void generateRandomSeats() {
        kursiRandomTerisi.clear();
        Random random = new Random();

        // Menentukan jumlah kursi terisi secara acak (sekitar 3/4 dari total kursi)
        int jumlahKursiTerisi = (int) (80 * 0.75);

        // Menentukan kursi terisi secara acak
        for (int i = 0; i < jumlahKursiTerisi; i++) {
            int kursiNumber = random.nextInt(80) + 1;
            kursiRandomTerisi.add(kursiNumber);
        }
    }

    // Fungsi untuk validasi input
    private void validateInput(TextField pembeliField, ComboBox<String> jamPenayanganComboBox, ComboBox<String> filmComboBox) throws InputValidationException {
        if (pembeliField.getText().isEmpty() || jamPenayanganComboBox.getValue() == null || filmComboBox.getValue() == null) {
            throw new InputValidationException("Mohon lengkapi semua informasi sebelum melihat kursi tersedia.");
        }
    }

    // Exception untuk validasi input
    private static class InputValidationException extends Exception {
        public InputValidationException(String message) {
            super(message);
        }
    }

    // Fungsi untuk menampilkan alert
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
