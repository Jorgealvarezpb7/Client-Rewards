module com.jorgealvarezpb7.client_rewards_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.jorgealvarezpb7.client_rewards_app to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app;

    opens com.jorgealvarezpb7.client_rewards_app.Controllers to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app.Controllers;

    opens com.jorgealvarezpb7.client_rewards_app.Services to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app.Services;

    opens com.jorgealvarezpb7.client_rewards_app.Models to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app.Models;

    opens com.jorgealvarezpb7.client_rewards_app.Utilities.Validator to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app.Utilities.Validator;

    opens com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations to javafx.fxml;
    exports com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;
}
