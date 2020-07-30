package com.idn.whatsappclone.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.idn.whatsappclone.R
import com.idn.whatsappclone.adapters.SectionPagerAdapter
import com.idn.whatsappclone.fragments.ChatsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Deklarasikan pada MainActivity
    private val firebaseDb = FirebaseFirestore.getInstance()
    private val firebaseAuth = FirebaseAuth.getInstance()
    private var mSectionPagerAdapter: SectionPagerAdapter? = null

    private val chatsFragment = ChatsFragment()

    companion object {
        const val PARAM_NAME = "name"
        const val PARAM_PHONE = "phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Taruh di onCreate Main Activity

//        chatsFragment.setFailureCallbackListener(this)

        setSupportActionBar(toolbar)
        mSectionPagerAdapter = SectionPagerAdapter(
            supportFragmentManager
        )

        container.adapter = mSectionPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
//        resizeTabs()
        tabs.getTabAt(1)?.select()

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> fab.hide()
                    1 -> fab.show()
                    2 -> fab.hide()
                }
            }

        })

        fab.setOnClickListener {
            //            onNewChat()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_logout->onLogout()
            R.id.action_profile->onProfile()
        }
        return super.onOptionsItemSelected(item)
    }



    private fun onLogout() {
        firebaseAuth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()    }

    private fun onProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }
}
