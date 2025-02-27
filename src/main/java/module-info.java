module com.jorgealvarezpb7.client_rewards_app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jorgealvarezpb7.client_rewards_app to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app;
    
    opens com.jorgealvarezpb7.client_rewards_app.Controllers to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app.Controllers;
}
