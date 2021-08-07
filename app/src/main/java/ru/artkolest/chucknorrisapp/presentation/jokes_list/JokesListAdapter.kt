package ru.artkolest.chucknorrisapp.presentation.jokes_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_jokes.view.*
import ru.artkolest.chucknorrisapp.R
import ru.artkolest.chucknorrisapp.domain.model.Value

class JokesListAdapter(): RecyclerView.Adapter<JokesListAdapter.JokesViewHolder>() {

    private var jokes = ArrayList<Value>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(
            R.layout.item_jokes, parent, false)
        return JokesViewHolder(item)
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    fun setJoke(jokes: ArrayList<Value>){
        this.jokes.clear()
        this.jokes.addAll(jokes)
        this.notifyDataSetChanged()
    }

    fun getJokes() : ArrayList<Value>{
        return this.jokes
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    class JokesViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(joke: Value){
            itemView.tvJoke.text = joke.joke
        }
    }
}