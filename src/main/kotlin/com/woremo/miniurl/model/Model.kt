package com.woremo.miniurl.model

data class UrlModel(val id: Int, val urlString: String)

data class shortUrl(val id: Int, val urlString: String, val urlHash: String, val shortUrl: String)


data class UrlUpdateReq(val newUrlString: String?, val urlHash: String?)