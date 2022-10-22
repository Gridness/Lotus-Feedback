package com.gridness.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import com.gridness.assignment.models.FamilyMember

class AddFamilyMember : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_family_member)

        val addFamilyMemberButton: Button = findViewById(R.id.addFamilyMemberButton)
        addFamilyMemberButton.setOnClickListener {
            addNewMember()
        }

        val discardChangesButton: Button = findViewById(R.id.discardChangesButton)
        discardChangesButton.setOnClickListener {
            discardChanges()
        }

        val familyButton: ImageButton = findViewById(R.id.familyButton)
        familyButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val spendingButton: ImageButton = findViewById(R.id.spendingButton)
        spendingButton.setOnClickListener {
            val intent = Intent(this, Expenses::class.java)
            startActivity(intent)
            finish()
        }

        val categoriesButton: ImageButton = findViewById(R.id.categoriesButton)
        categoriesButton.setOnClickListener {
            val intent = Intent(this, Categories::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun addNewMember() {
        if (!checkFields()) {
            Toast.makeText(applicationContext, "Поля не могут быть пустыми", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val familyMemberName = findViewById<EditText>(R.id.familyMemberName).text.toString()
        val salary = findViewById<EditText>(R.id.salary).text.toString()
        val familyMember = FamilyMember(familyMemberName, salary + "р")
        ReferenceProvider
            .getBaseReference()
            .child("family")
            .push()
            .setValue(familyMember)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun checkFields(): Boolean {
        val memberName: TextView = findViewById(R.id.familyMemberName)
        val salary: TextView = findViewById(R.id.salary)

        if (memberName.text.equals("") && salary.text.equals("") || memberName.text.isEmpty() && salary.text.isEmpty()) {
            return false
        }

        return true
    }

    private fun discardChanges() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}