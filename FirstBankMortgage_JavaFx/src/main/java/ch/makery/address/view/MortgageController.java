package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;


public class MortgageController {
	

	@FXML
	TextField txtIncome;
	@FXML
	TextField txtExpenses;
	@FXML
	TextField txtCreditScore;
	@FXML
	TextField txtHouseCost;
	@FXML
	ComboBox cmbTerm;
	@FXML
	Label MortgagePaymentLbl;
	


    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    	double income = Double.parseDouble(txtIncome.getText());
		double expenses = Double.parseDouble(txtExpenses.getText());
		int creditScore = Integer.parseInt(txtCreditScore.getText());
		double houseCost = Double.parseDouble(txtHouseCost.getText());
		
	
    }
    
    public int calculatePMT()
    {
  
    }

    public int calculatePayment(double income, double expenses, int creditScore, double houseCost) {
    	
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
   
}