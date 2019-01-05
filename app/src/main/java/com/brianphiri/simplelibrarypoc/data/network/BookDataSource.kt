package com.brianphiri.simplelibrarypoc.data.network

import android.accounts.NetworkErrorException
import androidx.lifecycle.LiveData
import com.brianphiri.simplelibrarypoc.data.model.Book

class BookDataSource(private val bookApiService: BookApiService) {

    fun getBook() : LiveData<List<Book>>{
        return bookApiService.getBooks()
    }

    fun postBook(book: Array<out Book>){
        try {
            bookApiService.postBook(book)
        }catch (e: NetworkErrorException){
            // TODO : HANDLE THIS
        }
    }
}