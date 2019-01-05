package com.brianphiri.simplelibrarypoc.data.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.brianphiri.simplelibrarypoc.data.model.Book
import com.brianphiri.simplelibrarypoc.data.network.BookDataSource

class BookRepository internal constructor(application: Application){
    private lateinit var bookDataSource : BookDataSource

    fun getBooks() : LiveData<List<Book>>{
        return bookDataSource.getBook()
    }

    fun postBook(book: Book){
        InsertAsycTask(bookDataSource).execute(book)
    }

    private class InsertAsycTask internal constructor(private val bookAsycTaskService: BookDataSource) :
        AsyncTask<Book, Void, Void>() {
        override fun doInBackground(vararg book: Book): Void? {
            bookAsycTaskService.postBook(book)
            return null
        }

    }

}