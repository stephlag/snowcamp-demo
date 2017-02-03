package fr.ippon.snowcamp.demo.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.info.BuildProperties
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress

/**
 * Created by stephan on 03/02/17.
 */
@RestController
class InfoController    (@Value("\${spring.application.name}") private val appName: String,
                         @Value("\${server.port:-1}") private val serverPort: Int,
                         private val buildProperties: BuildProperties) {


    @RequestMapping("/whoami")
    fun whoami(): String {
        return "Group: " + buildProperties.group  + "<br>Artifact: " + buildProperties.artifact +"<br>Name: " + buildProperties.name + "<br>Version: " + buildProperties.version
    }

    @RequestMapping("/whereami")
    fun whereAmI(): String {
        return "I am " + appName.replace("-", " ").toUpperCase() + ", running on " + InetAddress.getLocalHost() + ", listening on port " + serverPort;
    }
}