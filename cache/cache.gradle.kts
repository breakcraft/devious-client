/*
 * Copyright (c) 2019 Owain van Brakel <https://github.com/Owain94>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("com.github.hauner.jarTest") version "1.0.1"
}

description = "Cache"

dependencies {
    annotationProcessor("org.projectlombok:lombok:${ProjectVersions.lombokVersion}")

    api(project(":http-api"))

    compileOnly("org.projectlombok:lombok:${ProjectVersions.lombokVersion}")

    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("commons-cli:commons-cli:1.4")
    implementation("io.netty:netty-buffer:4.1.54.Final")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("org.antlr:antlr4-runtime:4.13.1")
    implementation("org.apache.commons:commons-compress:1.21")
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("net.java.dev.jna:jna:5.9.0")

    testAnnotationProcessor("org.projectlombok:lombok:${ProjectVersions.lombokVersion}")
    testCompileOnly("org.projectlombok:lombok:${ProjectVersions.lombokVersion}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("net.runelite.rs:cache:${ProjectVersions.cacheversion}")
}

tasks {
    processTestResources {
        val tokens = mapOf(
            "rs.version" to ProjectVersions.rsversion.toString(),
            "cache.version" to ProjectVersions.cacheversion.toString()
        )

        inputs.properties(tokens)

        filesMatching("cache.properties") {
            filter(ReplaceTokens::class, "tokens" to tokens)
            filteringCharset = "UTF-8"
        }
    }

    test {
        maxHeapSize = "2g" // Further reduce to limit memory footprint
        useJUnitPlatform()
    }
}
