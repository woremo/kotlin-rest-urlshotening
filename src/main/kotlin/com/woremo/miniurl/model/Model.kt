package com.woremo.miniurl.model

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


data class UrlModel(val id: Int, val urlString: String)

@Entity(name="urls")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Url(

        var originalUrl: String,
        var urlHash: String,
        var shortUrl: String,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int = 0
//        @CreationTimestamp
//        val created: Date,
//        @UpdateTimestamp
//        var modified: Date
       )


data class UrlReqBody(val originalUrl: String?, val urlHash: String?)