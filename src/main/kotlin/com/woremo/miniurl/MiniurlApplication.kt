package com.woremo.miniurl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class MiniurlApplication

fun main(args: Array<String>) {
	runApplication<MiniurlApplication>(*args)
}
