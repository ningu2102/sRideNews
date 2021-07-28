package com.example.newsforsride.repository

import com.example.newsforsride.api.RetrofitInstance
import com.example.newsforsride.db.ArticleDatabase
import com.example.newsforsride.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchquery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchquery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticles(article: Article) = db.getArticleDao().deleteArticle(article)

}