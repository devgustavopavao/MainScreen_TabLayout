package com.devgusta.tablayoutlogin


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.devgusta.tablayoutlogin.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initTab()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)

        val item = menu!!.findItem(R.id.menu_pesquisa)
        binding.searchView.setMenuItem(item)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_pesquisa){

        }
        return super.onOptionsItemSelected(item)

    }
   private fun initTab(){
      val tab_adapter = ViewPagerAdapter(this)

       binding.viewpager.adapter = tab_adapter
       tab_adapter.addFragment(UserFragment(),"Para você")
       tab_adapter.addFragment(CompaniFragment(),"Para Empresas")
       binding.viewpager.offscreenPageLimit = tab_adapter.itemCount

       TabLayoutMediator(binding.tablayout,binding.viewpager){ tab,position ->
           tab.text = tab_adapter.getTitle(position)
       }.attach()
   }

}