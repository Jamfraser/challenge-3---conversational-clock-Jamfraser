module com.example.challenge3conversationalclockjamfraser {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.challenge3conversationalclockjamfraser to javafx.fxml;
    exports com.example.challenge3conversationalclockjamfraser;
}