package com.example.searchviewwithrecycler

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val arrayList = ArrayList<Model>()
    val displayList = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayList.add(Model("Cnn", "Canal de Noticia CNN", R.drawable.cnn))
        arrayList.add(Model("Globo", "Canal de Noticia Globo", R.drawable.globo))
        arrayList.add(Model("SBT", "Canal de Noticia SBT", R.drawable.sbt))
        arrayList.add(Model("Record", "Canal de Noticia Record", R.drawable.record))
        arrayList.add(Model("Band", "Canal de Noticia Band", R.drawable.band2))
        arrayList.add(Model("Cnn", "Canal de Noticia CNN", R.drawable.cnn))
        arrayList.add(Model("Globo", "Canal de Noticia Globo", R.drawable.globo))
        arrayList.add(Model("SBT", "Canal de Noticia SBT", R.drawable.sbt))
        arrayList.add(Model("Record", "Canal de Noticia Record", R.drawable.record))
        arrayList.add(Model("Band", "Canal de Noticia Band", R.drawable.band2))
        arrayList.add(Model("Cnn", "Canal de Noticia CNN", R.drawable.cnn))
        arrayList.add(Model("Globo", "Canal de Noticia Globo", R.drawable.globo))
        arrayList.add(Model("SBT", "Canal de Noticia SBT", R.drawable.sbt))
        arrayList.add(Model("Record", "Canal de Noticia Record", R.drawable.record))
        arrayList.add(Model("Band", "Canal de Noticia Band", R.drawable.band2))

        displayList.addAll(arrayList)

        val myAdapter = MyAdapter(displayList, this)

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = myAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem != null) {

            val searchView = menuItem.actionView as SearchView

            val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint= "Search..."

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()){
                            displayList.clear()
                        val search= newText.toLowerCase(Locale.getDefault())
                        arrayList.forEach{
                            if (it.title.toLowerCase(Locale.getDefault()).contains(search)){
                                displayList.add(it)
                            }
                        }

                        recyclerView_main.adapter!!.notifyDataSetChanged()
                    }

                    else{
                        displayList.clear()
                        displayList.addAll(arrayList)
                        recyclerView_main.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}