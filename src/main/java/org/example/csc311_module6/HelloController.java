package org.example.csc311_module6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Label lblDoB;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblZipCode;

    @FXML
    private TextField tfDoB;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfZipCode;

    String regCheck;
    Pattern p;
    Boolean firstNameCheck;
    Boolean lastNameCheck;
    Boolean zipCodeCheck;
    Boolean dobCheck;
    Boolean emailCheck;


    //Initializes the focusing property to each text field. Also checks validity.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnAdd.setDisable(true);
        //tfFirstName = new TextField();
        tfFirstName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                regCheck = tfFirstName.getText();
                //Allows all lower and upper case letters. 2 min, 25 max.
                p = Pattern.compile("[a-zA-Z]{2,25}");
                Matcher m = p.matcher(regCheck);
                if(m.matches()){
                    lblFirstName.setText("First Name is Valid");
                    firstNameCheck = true;
                    //Checks all booleans for button allowing.
                    if(firstNameCheck&lastNameCheck&zipCodeCheck&dobCheck&emailCheck){
                        btnAdd.setDisable(false);
                    }
                } else {
                    lblFirstName.setText("First Name is not Valid");
                    firstNameCheck = false;
                    //Disables if is false.
                    btnAdd.setDisable(true);
                }
            } else {

            }
        });

        tfLastName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                regCheck = tfLastName.getText();
                //Same as first name.
                p = Pattern.compile("[a-zA-Z]{2,25}");
                Matcher m = p.matcher(regCheck);
                if(m.matches()){
                    lblLastName.setText("Last Name is Valid");
                    lastNameCheck = true;
                    if(firstNameCheck&lastNameCheck&zipCodeCheck&dobCheck&emailCheck){
                        btnAdd.setDisable(false);
                    }
                } else {
                    lblLastName.setText("Last Name is not Valid");
                    lastNameCheck = false;
                    btnAdd.setDisable(true);
                }
            } else {

            }
        });

        tfDoB.focusedProperty().addListener((observable, oldValue, newValue) -> {
           if (!newValue) {
               regCheck = tfDoB.getText();
               //Checks multiple patterns such as for month: either 1 digit 1-9 OR 2 digits 10-12.
               p = Pattern.compile("^(0[1-9]|1[0-2])/([0][1-9]|[12][0-9]|3[01])/([0-9]{4})$");
               Matcher m = p.matcher(regCheck);
               if(m.matches()){
                   lblDoB.setText("DoB is Valid");
                   dobCheck = true;
                   if(firstNameCheck&lastNameCheck&zipCodeCheck&dobCheck&emailCheck){
                       btnAdd.setDisable(false);
                   }
               } else {
                   lblDoB.setText("DoB is not Valid");
                   dobCheck = false;
                   btnAdd.setDisable(true);
               }
           }  else {

           }
        });

        tfEmail.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                regCheck = tfEmail.getText();
                //Allows an word or character using the shortcut. the dot and hyphen allow thomas.szostak etc. matches domain etc.
                p = Pattern.compile("^[\\w.-]+@farmingdale\\.edu$");
                Matcher m = p.matcher(regCheck);
                if(m.matches()){
                    lblEmail.setText("Email is Valid");
                    emailCheck = true;
                    if(firstNameCheck&lastNameCheck&zipCodeCheck&dobCheck&emailCheck){
                        btnAdd.setDisable(false);
                    }
                } else {
                    lblEmail.setText("Email is not Valid");
                    emailCheck = false;
                    btnAdd.setDisable(true);
                }
            }  else {

            }
        });

        tfZipCode.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                regCheck = tfZipCode.getText();
                //Allows 5  digits.
                p = Pattern.compile("^\\d{5}$");
                Matcher m = p.matcher(regCheck);
                if(m.matches()){
                    lblZipCode.setText("Zip Code is Valid");
                    zipCodeCheck = true;
                    if(firstNameCheck&lastNameCheck&zipCodeCheck&dobCheck&emailCheck){
                        btnAdd.setDisable(false);
                    }
                } else {
                    lblZipCode.setText("Zip Code is not Valid");
                    zipCodeCheck = false;
                    btnAdd.setDisable(true);
                }
            }  else {

            }
        });

    }


    @FXML
    void NewUI(ActionEvent event) throws IOException {
        HelloApplication.setRoot("secondUI");
    }

}
