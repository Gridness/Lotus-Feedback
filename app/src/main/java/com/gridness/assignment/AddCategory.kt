package com.gridness.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import com.gridness.assignment.models.Category

class AddCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        val addFamilyMemberButton: Button = findViewById(R.id.addFamilyMemberButton)
        addFamilyMemberButton.setOnClickListener {
            addNewCategory()
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

    private fun addNewCategory() {
        if (!checkFields()) {
            Toast.makeText(applicationContext, "Поле не может быть пустым", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val categoryName = findViewById<EditText>(R.id.familyMemberName).text.toString()
        val isIncome = if (findViewById<CheckBox>(R.id.isIncome).isChecked) "Доход" else "Расход"
        val category = Category(categoryName, isIncome)
        ReferenceProvider.getBaseReference()
            .child("categories")
            .push()
            .setValue(category)

        startActivity(Intent(this, Categories::class.java))
        finish()
    }

    private fun checkFields(): Boolean {
        val categoryName = findViewById<EditText>(R.id.familyMemberName).text
        if (categoryName.isEmpty() || categoryName.equals("")) {
            return false
        }

        return true
    }

    private fun discardChanges() {
        val intent = Intent(this, Categories::class.java)
        startActivity(intent)
        finish()
    }
}