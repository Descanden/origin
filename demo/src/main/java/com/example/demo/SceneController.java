package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class SceneController {
    // Scene 1 - Login Controller
    @FXML private TextField adminUsername;
    @FXML private PasswordField adminPassword;
    @FXML private TextField customerUsername;
    @FXML private PasswordField customerPassword;
    @FXML private TabPane loginTabs;

    @FXML
    private void adminLoginHandler(ActionEvent event) {
        // Admin login logic here
    }

    @FXML
    private void customerLoginHandler(ActionEvent event) {
        // Customer login logic here
    }

    // Scene 2 - Admin Controller
    @FXML private TextField movieTitleInput;
    @FXML private TextField movieGenreInput;
    @FXML private TextField movieDurationInput;
    @FXML private TextField movieDateInput;
    @FXML private Label displayMovieTitle;
    @FXML private Label displayMovieGenre;
    @FXML private Label displayMovieDuration;
    @FXML private Label displayMovieDate;
    @FXML private ListView<String> customerReservations;
    @FXML private TabPane adminFunctionalities;

    @FXML
    private void insertMovieHandler(ActionEvent event) {
        // Insert movie logic here
    }

    @FXML
    private void updateMovieHandler(ActionEvent event) {
        // Update movie logic here
    }

    @FXML
    private void deleteMovieHandler(ActionEvent event) {
        // Delete movie logic here
    }

    // Scene 3 - Customer Controller
    @FXML private ListView<String> availableMoviesCustomer;
    @FXML private ListView<String> bookedMoviesCustomer;
    @FXML private Label selectedSeatsLabel;
    @FXML private TabPane customerFunctionalities;

    @FXML
    private void chooseSeatsHandler(ActionEvent event) {
        // Choose seats logic here
    }

    @FXML
    private void purchaseTicketHandler(ActionEvent event) {
        // Purchase ticket logic here
    }

    @FXML
    private void cancelBookingCustomerHandler(ActionEvent event) {
        // Cancel booking logic here
    }

    @FXML
    private void rescheduleBookingCustomerHandler(ActionEvent event) {
        // Reschedule booking logic here
    }
}
