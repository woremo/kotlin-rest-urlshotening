package com.woremo.miniurl.service


import org.springframework.stereotype.Service
import org.apache.commons.lang3.RandomStringUtils


@Service
class UrlShorteningService{

    val STRING_LENGTH = 10
    val SERVER_NAME = "http://localhost:8080/"
    val SERVER_NAME_API = "http://localhost:8080/api/"


    fun generateUrlHash(): String{
        val randomString = RandomStringUtils.randomAlphanumeric(STRING_LENGTH);

        return randomString

    }




}