package com.yukaida.fragmentpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yukaida.fragmentpractice.NewsContentActivity
import com.yukaida.fragmentpractice.R
import com.yukaida.fragmentpractice.bean.News
import kotlinx.android.synthetic.main.activity_news_content.*
import kotlinx.android.synthetic.main.new_content_frag.*
import kotlinx.android.synthetic.main.news_title_frag.*

/**
 * @author yukaida
 * @DATE 2020/12/10.
 */
class NewsTitleFragment:Fragment() {

    private var isTwoPane=false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane=activity?.findViewById<View>(R.id.newsContentLayout)!=null

        newsTitleRecyclerView.run {
            layoutManager=LinearLayoutManager(activity)
            adapter=NewsAdapter(getNews())
        }



    }

    private fun getNews(): List<News> {

        return ArrayList<News>().apply {
            for (i in 1..50) {
                add(News("This is news title $i",getRandomLengthString("This is news content $i.")))
            }
        }


    }

    private fun getRandomLengthString(s: String): String {
        val n=(1..20).random()
        return StringBuilder().run {
            repeat(n){
                append(s)
            }
            toString()
        }
    }

    inner class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

        inner class ViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
            val newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)).apply {
                itemView.setOnClickListener{
                    val news=newsList[adapterPosition]

                    if (isTwoPane) {
                        val fragment = newsContentFrag as NewsContentFragment
                        fragment.refresh(news.title, news.content)
                    } else {
                        NewsContentActivity.actionStart(parent.context, news.title, news.content)
                    }

                }
            }
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.newsTitle.text=newsList[position].title
        }

        override fun getItemCount(): Int {
            return newsList.size
        }

    }
}