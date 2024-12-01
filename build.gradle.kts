plugins {
    application
    java
    id("org.openjfx.javafxplugin") version "0.0.14" // Add JavaFX plugin
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-controls:17.0.6")
    implementation("org.openjfx:javafx-fxml:17.0.6")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

javafx {
    version = "17.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("com.example.library_management_system.Main")
    mainModule.set("com.example.library_management_system") 
}

tasks.test {
    useJUnitPlatform()
}
