package com.gridness.assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.gridness.assignment.models.Category;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"},
        d2 = {"Lcom/gridness/assignment/AddCategory;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addNewCategory", "", "checkFields", "", "discardChanges", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class AddCategory extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActionBar var10000 = this.getSupportActionBar();
        if (var10000 != null) {
            var10000.hide();
        }

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_add_category);
        View var7 = this.findViewById(R.id.addFamilyMemberButton);
        Intrinsics.checkNotNullExpressionValue(var7, "findViewById(R.id.addFamilyMemberButton)");
        Button addFamilyMemberButton = (Button)var7;
        addFamilyMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewCategory();
            }
        });
        //addFamilyMemberButton.setOnClickListener(AddCategory::onCreate$lambda_0);
        var7 = this.findViewById(R.id.discardChangesButton);
        Intrinsics.checkNotNullExpressionValue(var7, "findViewById(R.id.discardChangesButton)");
        Button discardChangesButton = (Button)var7;
        discardChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                discardChanges();
            }
        });
        //discardChangesButton.setOnClickListener(AddCategory::onCreate$lambda_1);
        var7 = this.findViewById(R.id.familyButton);
        Intrinsics.checkNotNullExpressionValue(var7, "findViewById(R.id.familyButton)");
        ImageButton familyButton = (ImageButton)var7;
        familyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFamilyScreen();
            }
        });
        //familyButton.setOnClickListener(AddCategory::onCreate$lambda_2);
        var7 = this.findViewById(R.id.spendingButton);
        Intrinsics.checkNotNullExpressionValue(var7, "findViewById(R.id.spendingButton)");
        ImageButton spendingButton = (ImageButton)var7;
        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToExpensesScreen();
            }
        });
        //spendingButton.setOnClickListener(AddCategory::onCreate$lambda_3);
        var7 = this.findViewById(R.id.categoriesButton);
        Intrinsics.checkNotNullExpressionValue(var7, "findViewById(R.id.categoriesButton)");
        ImageButton categoriesButton = (ImageButton)var7;
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCategoriesScreen();
            }
        });
        //categoriesButton.setOnClickListener(AddCategory::onCreate$lambda_4);
    }

    private final void addNewCategory() {
        if (!this.checkFields()) {
            Toast.makeText(this.getApplicationContext(), (CharSequence)"Поле не может быть пустым", Toast.LENGTH_SHORT).show();
        } else {
            String categoryName = ((EditText)this.findViewById(R.id.familyMemberName)).getText().toString();
            String isIncome = ((CheckBox)this.findViewById(R.id.isIncome)).isChecked() ? "Доход" : "Расход";
            Category category = new Category(categoryName, isIncome);
            ReferenceProvider.INSTANCE.getBaseReference().child("categories").push().setValue(category);
            this.startActivity(new Intent((Context)this, Categories.class));
            this.finish();
        }
    }

    private final boolean checkFields() {
        Editable categoryName = ((EditText)this.findViewById(R.id.familyMemberName)).getText();
        Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
        return ((CharSequence)categoryName).length() != 0 && !categoryName.equals("");
    }

    private final void discardChanges() {
        Intent intent = new Intent((Context)this, Categories.class);
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

    private static final void onCreate$lambda_0/* $FF was: onCreate$lambda-0*/(AddCategory this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.addNewCategory();
    }

    private static final void onCreate$lambda_1/* $FF was: onCreate$lambda-1*/(AddCategory this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.discardChanges();
    }

    private static final void onCreate$lambda_2/* $FF was: onCreate$lambda-2*/(AddCategory this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, MainActivity.class);
        this$0.startActivity(intent);
        this$0.finish();
    }

    private static final void onCreate$lambda_3/* $FF was: onCreate$lambda-3*/(AddCategory this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Expenses.class);
        this$0.startActivity(intent);
        this$0.finish();
    }

    private static final void onCreate$lambda_4/* $FF was: onCreate$lambda-4*/(AddCategory this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Categories.class);
        this$0.startActivity(intent);
        this$0.finish();
    }
}
