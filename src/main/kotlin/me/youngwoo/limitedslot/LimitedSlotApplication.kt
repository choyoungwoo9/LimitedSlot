package me.youngwoo.limitedslot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LimitedSlotApplication

fun main(args: Array<String>) {
    runApplication<LimitedSlotApplication>(*args)
}
