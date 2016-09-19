buildscript {
    extra["kotlinVersion"] = "1.1-M01"

    repositories {
        jcenter()
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

apply {
    plugin("kotlin")
    plugin<ApplicationPlugin>()

    from("chat.gradle.kts")
    from("answer.gradle.kts")
}

configure<ApplicationPluginConvention> {
    mainClassName = "net.gouline.gradlekt.DemoKt"
}

repositories {
    jcenter()
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
}

dependencies {
    compile(kotlinModule("stdlib-jre8"))
}

fun kotlinModule(module: String) = "org.jetbrains.kotlin:kotlin-$module:${extra["kotlinVersion"]}"