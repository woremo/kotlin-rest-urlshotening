package com.woremo.miniurl.repo

import com.woremo.miniurl.model.Url
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository: CrudRepository<Url, Int>{

  fun findByUrlHash(urlHash: String) {

  }

//  @Query("")

//Ammotated queries
}