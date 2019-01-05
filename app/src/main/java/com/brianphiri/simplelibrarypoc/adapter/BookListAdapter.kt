package com.brianphiri.simplelibrarypoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brianphiri.simplelibrarypoc.R
import com.brianphiri.simplelibrarypoc.data.model.Book
import kotlinx.android.synthetic.main.list_item.view.*

class BookListAdapter(private val context: Context) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    private var bookList: List<Book> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = bookList[position]
        holder.bind(book)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(book: Book){
            itemView.tvAuthor.text = book.author
            itemView.tvBook.text = book.title
        }
    }
}