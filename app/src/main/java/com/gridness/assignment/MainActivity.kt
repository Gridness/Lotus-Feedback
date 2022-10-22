package com.gridness.assignment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.gridness.assignment.adapters.CategoryAdapter
import com.gridness.assignment.adapters.FamilyMembersAdapter
import com.gridness.assignment.models.Category
import com.gridness.assignment.models.FamilyMember
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("AppData", MODE_PRIVATE)
        var deviceID = sharedPreferences.getString("deviceID", null)
        if (deviceID == null) {
            val newID = UUID.randomUUID()
            sharedPreferences.edit().apply {
                putString("deviceID", newID.toString())
                apply()
            }
            deviceID = newID.toString()
        }

        ReferenceProvider.setDeviceID(deviceID)

        val addFamilyMemberButton: Button = findViewById(R.id.addFamilyMemberButton)
        addFamilyMemberButton.setOnClickListener {
            val intent = Intent(this, AddFamilyMember::class.java)
            startActivity(intent)
        }

        val familyButton: ImageButton = findViewById(R.id.familyButton)
        familyButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val spendingButton: ImageButton = findViewById(R.id.spendingButton)
        spendingButton.setOnClickListener {
            val intent = Intent(this, Expenses::class.java)
            startActivity(intent)
        }

        val categoriesButton: ImageButton = findViewById(R.id.categoriesButton)
        categoriesButton.setOnClickListener {
            val intent = Intent(this, Categories::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.familyMemers)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = FamilyMembersAdapter()
        recyclerView.adapter = adapter
        ReferenceProvider
            .getBaseReference()
            .child("family")
            .addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val familyMemberList = mutableListOf<FamilyMember>()
                    for(child in snapshot.children) {
                        familyMemberList.add(child.getValue(FamilyMember::class.java) as FamilyMember)
                    }
                    adapter.setFamilyMemberList(familyMemberList)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }
}