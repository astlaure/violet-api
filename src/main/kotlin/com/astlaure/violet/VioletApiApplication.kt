package com.astlaure.violet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VioletApiApplication

fun main(args: Array<String>) {
    runApplication<VioletApiApplication>(*args)
}
