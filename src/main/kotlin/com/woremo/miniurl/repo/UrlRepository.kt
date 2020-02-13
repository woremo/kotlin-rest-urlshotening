package com.woremo.miniurl.repo

import com.woremo.miniurl.model.Url
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository: CrudRepository<Url, Int>{

//  @Query("from Url url where url.urlHash = :status")
  fun findByUrlHash(@Param("status") urlHash: String) {

  }

//  @Query("")

//Ammotated queries
}