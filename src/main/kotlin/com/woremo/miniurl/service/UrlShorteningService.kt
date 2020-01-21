package com.woremo.miniurl.service

import com.woremo.miniurl.model.UrlModel
import com.woremo.miniurl.model.shortUrl
import org.springframework.stereotype.Service
import org.apache.commons.lang3.RandomStringUtils
import reactor.core.publisher.toFlux

@Service
class UrlShorteningService{

    val STRING_LENGTH = 10
    val MINI_URL_PREFIX = "http://localhost/"

    companion object {

        val urlModelDb = mutableMapOf(1 to shortUrl(12, "http://blog.bytecode.tech/inversion-of-control-vs-dependency-injection/","1234hash", "http://localhost/".plus("1234hash")  ))

    }

    fun generateUrlHash(): String{
        val randomString = RandomStringUtils.randomAlphanumeric(STRING_LENGTH);

        return randomString

    }

    fun createShortUrl(url: UrlModel, urlHash: String): String {

        val shortUrl: shortUrl = shortUrl(url.id,url.urlString,urlHash, MINI_URL_PREFIX.plus(urlHash))

        urlModelDb[url.id] = shortUrl

        return urlModelDb[url.id]!!.urlHash

    }


    fun getShortUrl(hash: String) = urlModelDb.values.toFlux().filter { it.shortUrl == hash}





}