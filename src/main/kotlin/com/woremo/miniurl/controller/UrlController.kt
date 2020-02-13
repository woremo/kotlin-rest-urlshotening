package com.woremo.miniurl.controller

import com.woremo.miniurl.model.UrlModel
import com.woremo.miniurl.model.Url
import com.woremo.miniurl.model.UrlReqBody
import com.woremo.miniurl.repo.UrlRepository
import com.woremo.miniurl.service.UrlShorteningService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.result.view.RedirectView
import reactor.core.publisher.Flux
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/api")
class UrlController{


    @Autowired
    lateinit var urlShorteningService: UrlShorteningService

    @Autowired
    lateinit var urlRepository: UrlRepository


    //get all urls
    @GetMapping("/urls")
    fun getAllUrls(): MutableIterable<Url> = urlRepository.findAll()


    //create a short url
    @PostMapping("/url/shorten")
    fun createShortUrl(@RequestBody url: UrlReqBody) : ResponseEntity<Url>{

        var urlHash = urlShorteningService.generateUrlHash()
        var shortUrl = urlShorteningService.SERVER_NAME_API.plus(urlHash)
        var newUrl : Url? = url.originalUrl?.let { Url(it,urlHash,shortUrl) }
        var savedUrl: Url? = null

        if (newUrl != null) {
            savedUrl = urlRepository.save(newUrl)
        }

        return ResponseEntity(savedUrl, HttpStatus.CREATED)

    }

    @GetMapping("/{urlHash}")
    fun returnOriginalUrl(@PathVariable("urlHash") urlHash: String ) = urlRepository.findByUrlHash(urlHash)


    //reasolve a short url


    //update a short url


    //delete a short url




//    @GetMapping("/get/{urlHash}")
//    fun getUrl(@PathVariable("urlHash") urlHash: String)= urlShorteningService.getShortUrl(urlHash)
//
//    @GetMapping("/{urlHash}")
//    fun goToUrl(@PathVariable("urlHash") urlHash: String): Flux<String> {
//
//        val urlString  = urlShorteningService.getShortUrl(urlHash).map { it.urlString }
//
//        return urlString
//
//    }

}