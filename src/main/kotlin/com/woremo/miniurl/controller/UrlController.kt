package com.woremo.miniurl.controller

import com.woremo.miniurl.model.UrlModel
import com.woremo.miniurl.model.shortUrl
import com.woremo.miniurl.service.UrlShorteningService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.result.view.RedirectView
import reactor.core.publisher.Flux
import reactor.core.publisher.toMono

@RestController
class UrlController{


    @Autowired
    lateinit var urlShorteningService: UrlShorteningService

    @GetMapping("/get/{urlHash}")
    fun getUrl(@PathVariable("urlHash") urlHash: String)= urlShorteningService.getShortUrl(urlHash)

    @GetMapping("/{urlHash}")
    fun goToUrl(@PathVariable("urlHash") urlHash: String): Flux<String> {

        val urlString  = urlShorteningService.getShortUrl(urlHash).map { it.urlString }

        return urlString

    }


    @PostMapping("/shorten")
    fun shortenUrl(@RequestBody url: UrlModel) : ResponseEntity<String>{

        var urlHash = urlShorteningService.generateUrlHash()


        var hash = urlShorteningService.createShortUrl(url, urlHash)

        return ResponseEntity(hash, HttpStatus.CREATED)

    }

}