package com.gridness.assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.gridness.assignment.adapters.SpinnerAdapter;
import com.gridness.assignment.models.Category;
import com.gridness.assignment.models.Expense;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"},
        d2 = {"Lcom/gridness/assignment/AddExpense;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "categoriesMap", "", "", "Lcom/gridness/assignment/models/Category;", "getCategoriesMap", "()Ljava/util/Map;", "selectedCategoryID", "getSelectedCategoryID", "()Ljava/lang/String;", "setSelectedCategoryID", "(Ljava/lang/String;)V", "addNewExpense", "", "checkFields", "", "discardChanges", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class AddExpense extends AppCompatActivity {
    @NotNull
    private final Map categoriesMap = (Map)(new LinkedHashMap());
    @NotNull
    private String selectedCategoryID = "";

    @NotNull
    public final Map getCategoriesMap() {
        return this.categoriesMap;
    }

    @NotNull
    public final String getSelectedCategoryID() {
        return this.selectedCategoryID;
    }

    public final void setSelectedCategoryID(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.selectedCategoryID = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActionBar var10000 = this.getSupportActionBar();
        if (var10000 != null) {
            var10000.hide();
        }

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_add_expense);
        final Spinner spinner = (Spinner)this.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((OnItemSelectedListener)(new OnItemSelectedListener() {
            public void onItemSelected(@Nullable AdapterView p0, @Nullable View view, int position, long p3) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
                String categoryName = ((TextView)view).getText().toString();
                Map $this$forEach$iv = AddExpense.this.getCategoriesMap();
                AddExpense var8 = AddExpense.this;
                //boolean $i$f$forEach = false;
                Iterator var10 = $this$forEach$iv.entrySet().iterator();

                while(var10.hasNext()) {
                    Entry element$iv = (Entry)var10.next();
                    //boolean var13 = false;
                    if (Intrinsics.areEqual(((Category)element$iv.getValue()).getCategoryName(), categoryName)) {
                        var8.setSelectedCategoryID((String)element$iv.getKey());
                    }
                }

            }

            public void onNothingSelected(@Nullable AdapterView p0) {
                String var2 = "Not yet implemented";
                throw new NotImplementedError("An operation is not implemented: " + var2);
            }
        }));
        ReferenceProvider.INSTANCE.getBaseReference().child("categories").addListenerForSingleValueEvent((ValueEventListener)(new ValueEventListener() {
            public void onDataChange(@NotNull DataSnapshot snapshot) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                Iterator var2 = snapshot.getChildren().iterator();

                while(var2.hasNext()) {
                    DataSnapshot child = (DataSnapshot)var2.next();
                    Object var10000 = child.getValue(Category.class);
                    Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type com.gridness.assignment.models.Category");
                    Category categoryChild = (Category)var10000;
                    Map var5 = AddExpense.this.getCategoriesMap();
                    String var10001 = child.getKey();
                    Intrinsics.checkNotNull(var10001);
                    var5.put(var10001, categoryChild);
                }

                SpinnerAdapter adapter = new SpinnerAdapter((Context)AddExpense.this, 17367049, AddExpenseKt.access$toStringList(AddExpense.this.getCategoriesMap()));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter((android.widget.SpinnerAdapter)adapter);
            }

            public void onCancelled(@NotNull DatabaseError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                String var2 = "Not yet implemented";
                throw new NotImplementedError("An operation is not implemented: " + var2);
            }
        }));
        View var8 = this.findViewById(R.id.addFamilyMemberButton);
        Intrinsics.checkNotNullExpressionValue(var8, "findViewById(R.id.addFamilyMemberButton)");
        Button addFamilyMemberButton = (Button)var8;
        addFamilyMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewExpense();
            }
        });
        //addFamilyMemberButton.setOnClickListener(AddExpense::onCreate$lambda-0);
        var8 = this.findViewById(R.id.discardChangesButton);
        Intrinsics.checkNotNullExpressionValue(var8, "findViewById(R.id.discardChangesButton)");
        Button discardChangesButton = (Button)var8;
        discardChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                discardChanges();
            }
        });
        //discardChangesButton.setOnClickListener(AddExpense::onCreate$lambda-1);
        var8 = this.findViewById(R.id.familyButton);
        Intrinsics.checkNotNullExpressionValue(var8, "findViewById(R.id.familyButton)");
        ImageButton familyButton = (ImageButton)var8;
        familyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFamilyScreen();
            }
        });
        //familyButton.setOnClickListener(AddExpense::onCreate$lambda-2);
        var8 = this.findViewById(R.id.spendingButton);
        Intrinsics.checkNotNullExpressionValue(var8, "findViewById(R.id.spendingButton)");
        ImageButton spendingButton = (ImageButton)var8;
        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToExpensesScreen();
            }
        });
        //spendingButton.setOnClickListener(AddExpense::onCreate$lambda-3);
        var8 = this.findViewById(R.id.categoriesButton);
        Intrinsics.checkNotNullExpressionValue(var8, "findViewById(R.id.categoriesButton)");
        ImageButton categoriesButton = (ImageButton)var8;
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCategoriesScreen();
            }
        });
        //categoriesButton.setOnClickListener(AddExpense::onCreate$lambda-4);
    }

    private final void addNewExpense() {
        if (!this.checkFields()) {
            Toast.makeText(this.getApplicationContext(), (CharSequence)"Поля не могут быть пустыми", 0).show();
        } else {
            String expenseName = ((EditText)this.findViewById(R.id.familyMemberName)).getText().toString();
            String categoryID = this.selectedCategoryID;
            String salary = ((EditText)this.findViewById(R.id.salary)).getText().toString();
            Expense expense = new Expense(expenseName, categoryID, salary, (Category)null, 8, (DefaultConstructorMarker)null);
            ReferenceProvider.INSTANCE.getBaseReference().child("expenses").push().setValue(expense);
            this.startActivity(new Intent((Context)this, Expenses.class));
            this.finish();
        }
    }

    private final boolean checkFields() {
        Editable expenseName = ((EditText)this.findViewById(R.id.familyMemberName)).getText();
        Editable salary = ((EditText)this.findViewById(R.id.salary)).getText();
        Intrinsics.checkNotNullExpressionValue(expenseName, "expenseName");
        if (((CharSequence)expenseName).length() != 0) {
            if (expenseName.equals("")) {
                Intrinsics.checkNotNullExpressionValue(salary, "salary");
                if (((CharSequence)salary).length() == 0) {
                    return false;
                }
            }

            if (!salary.equals("")) {
                return true;
            }
        }

        return false;
    }

    private final void discardChanges() {
        Intent intent = new Intent((Context)this, Expenses.class);
        this.startActivity(intent);
        this.finish();
    }

    private final void goToFamilyScreen() {
        Intent intent = new Intent((Context)this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private final void goToExpensesScreen() {
        Intent intent = new Intent((Context)this, Expenses.class);
        startActivity(intent);
        finish();
    }

    private final void goToCategoriesScreen() {
        Intent intent = new Intent((Context)this, Categories.class);
        startActivity(intent);
        finish();
    }

    private static final void onCreate$lambda_0/* $FF was: onCreate$lambda-0*/(AddExpense this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.addNewExpense();
    }

    private static final void onCreate$lambda_1/* $FF was: onCreate$lambda-1*/(AddExpense this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.discardChanges();
    }

    private static final void onCreate$lambda_2/* $FF was: onCreate$lambda-2*/(AddExpense this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, MainActivity.class);
        this$0.startActivity(intent);
    }

    private static final void onCreate$lambda_3/* $FF was: onCreate$lambda-3*/(AddExpense this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Expenses.class);
        this$0.startActivity(intent);
    }

    private static final void onCreate$lambda_4/* $FF was: onCreate$lambda-4*/(AddExpense this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Categories.class);
        this$0.startActivity(intent);
    }
}
