buildscript {
    extra["kotlinVersion"] = "1.0.3"

    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
    }
}

apply {
    plugin("kotlin")
    plugin<ApplicationPlugin>()

    from("chat.gradle.kts")
    from("answer.gradle.kts")
    from("copy.gradle.kts")
}

configure<ApplicationPluginConvention> {
    mainClassName = "net.gouline.gradlekt.DemoKt"
}

repositories {
    jcenter()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:${extra["kotlinVersion"]}")
}
