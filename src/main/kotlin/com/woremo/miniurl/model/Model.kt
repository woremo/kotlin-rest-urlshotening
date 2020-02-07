package com.woremo.miniurl.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


data class UrlModel(val id: Int, val urlString: String)

@Entity(name="urls")
data class Url(
        val originalUrl: String,
        val urlHash: String,
        val shortUrl: String,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0 )


data class UrlReqBody(val originalUrl: String?, val urlHash: String?)