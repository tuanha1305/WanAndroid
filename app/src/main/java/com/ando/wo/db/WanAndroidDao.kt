package com.ando.wo.db

import androidx.room.*
import com.ando.wo.bean.WxArticleTabsEntity

/**
 * @author javakam
 * @date 2020/8/13  16:58
 */
@Dao
interface WanAndroidDao {

    //Article Tabs
    //BUG: https://stackoverflow.com/questions/48694449/error-with-room-dao-class-when-using-kotlin-coroutines

    @Query("select * from t_article_tabs order by tabId asc")
    suspend fun getAll(): List<WxArticleTabsEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(tab: WxArticleTabsEntity)

    @Query("select * from t_article_tabs where tabId in (:tabIds)")
    suspend fun loadAllByIds(tabIds: IntArray): List<WxArticleTabsEntity>?

    @Query("select * from t_article_tabs where tabName like :tabName limit 1")
    suspend fun findByName(tabName: String): WxArticleTabsEntity?

    @Query("delete from t_article_tabs")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(tab: WxArticleTabsEntity)


    //Article
//    @Query("select * from t_article_tabs order by tabId asc")
//    suspend fun getAll(): List<Article>?

}