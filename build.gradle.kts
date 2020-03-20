plugins {
    id("groovy")
    kotlin("jvm") version "1.3.70"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://repo.jenkins-ci.org/releases/") }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:3.0.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testImplementation("com.lesfurets:jenkins-pipeline-unit:1.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

sourceSets["test"].withConvention(GroovySourceSet::class)  {
    groovy.srcDir("pipelineTests/groovy")
}

sourceSets["main"].withConvention(GroovySourceSet::class)  {
    groovy.srcDir("src")
}
