= Gatling plugin for Gradle - Java demo project
=============================================



## Goals

1. Prepare docs for building blocks
2. Have env. specific execution steps
1. Run Load test
2. Run UI perf testing if possible
3. Use a sink such as grafana or influx db for real time time-series data
4. Reporting in Gradle


A simple showcase of a Gradle project using the Gatling plugin for Gradle. Refer to the plugin documentation
[on the Gatling website](https://gatling.io/docs/current/extensions/gradle_plugin/) for usage.

This project is written in Java, others are available for [Kotlin](https://github.com/gatling/gatling-gradle-plugin-demo-kotlin)
and [Scala](https://github.com/gatling/gatling-gradle-plugin-demo-scala).

It includes:

* Gradle Wrapper, so you don't need to install Gradle (a JDK must be installed and $JAVA_HOME configured)
* minimal `build.gradle` leveraging Gradle wrapper
* latest version of `io.gatling.gradle` plugin applied
* sample [Simulation](https://gatling.io/docs/gatling/reference/current/general/concepts/#simulation) class,
demonstrating sufficient Gatling functionality
* proper source file layout
