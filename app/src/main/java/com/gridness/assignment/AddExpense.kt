package com.gridness.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.gridness.assignment.adapters.SpinnerAdapter
import com.gridness.assignment.models.Category
import com.gridness.assignment.models.Expense

class AddExpense : AppCompatActivity() {
    val categoriesMap = mutableMapOf<String, Category>()
    var selectedCategoryID = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                val categoryName = (view as TextView).text.toString()
                categoriesMap.forEach {
                    if(it.value.categoryName == categoryName) {
                        selectedCategoryID = it.key
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        ReferenceProvider
            .getBaseReference()
            .child("categories")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        val categoryChild = child.getValue(Category::class.java) as Category
                        categoriesMap.put(child.key!!, categoryChild)
                    }
                    val adapter = SpinnerAdapter(
                        this@AddExpense,
                        android.R.layout.simple_spinner_dropdown_item,
                        categoriesMap.toStringList()
                    )
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner.adapter = adapter
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        val addFamilyMemberButton: Button = findViewById(R.id.addFamilyMemberButton)
        addFamilyMemberButton.setOnClickListener {
            addNewExpense()
        }

        val discardChangesButton: Button = findViewById(R.id.discardChangesButton)
        discardChangesButton.setOnClickListener {
            discardChanges()
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
    }

    private fun addNewExpense() {
        if (!checkFields()) {
            Toast.makeText(applicationContext, "Поля не могут быть пустыми", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val expenseName = findViewById<EditText>(R.id.familyMemberName).text.toString()
        val categoryID = selectedCategoryID
        val salary = findViewById<EditText>(R.id.salary).text.toString()
        val expense = Expense(expenseName, categoryID, salary)
        ReferenceProvider
            .getBaseReference()
            .child("expenses")
            .push()
            .setValue(expense)

        startActivity(Intent(this, Expenses::class.java))
        finish()
    }

    private fun checkFields(): Boolean {
        val expenseName = findViewById<EditText>(R.id.familyMemberName).text
        val salary = findViewById<EditText>(R.id.salary).text
        if (expenseName.isEmpty() || expenseName.equals("") && salary.isEmpty() || salary.equals("")) {
            return false
        }

        return true
    }

    private fun discardChanges() {
        val intent = Intent(this, Expenses::class.java)
        startActivity(intent)
        finish()
    }
}

private fun MutableMap<String, Category>.toStringList(): MutableList<String> {
    val stringList = mutableListOf<String>()
    this.forEach { stringList.add(it.value.categoryName) }
    return stringList
}
