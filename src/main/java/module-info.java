module com.example.library_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;  // Java Naming and Directory Interface (JNDI) API.


    opens com.example.library_management_system to javafx.fxml;
    exports com.example.library_management_system;
    opens com.example.library_management_system.controllers to javafx.fxml;
}