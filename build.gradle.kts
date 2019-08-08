plugins {
    java
}

group = "com.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile("ch.qos.logback", "logback-classic", "1.1.7")

    testCompile("org.junit.jupiter", "junit-jupiter-api", "5.5.1")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}