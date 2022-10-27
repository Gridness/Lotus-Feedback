package com.gridness.assignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.gridness.assignment.adapters.FamilyMembersAdapter;
import com.gridness.assignment.models.FamilyMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0015¨\u0006\u0007"},
        d2 = {"Lcom/gridness/assignment/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class MainActivity extends AppCompatActivity {
    @SuppressLint({"ResourceType", "SetTextI18n"})
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActionBar var10000 = this.getSupportActionBar();
        if (var10000 != null) {
            var10000.hide();
        }

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("AppData", 0);
        String deviceID = sharedPreferences.getString("deviceID", (String)null);
        if (deviceID == null) {
            UUID newID = UUID.randomUUID();
            Editor var5 = sharedPreferences.edit();
            //boolean var7 = false;
            var5.putString("deviceID", newID.toString());
            var5.apply();
            deviceID = newID.toString();
        }

        ReferenceProvider.INSTANCE.setDeviceID(deviceID);
        View var14 = this.findViewById(R.id.addFamilyMemberButton);
        Intrinsics.checkNotNullExpressionValue(var14, "findViewById(R.id.addFamilyMemberButton)");
        Button addFamilyMemberButton = (Button)var14;
        addFamilyMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAdd();
            }
        });
        //addFamilyMemberButton.setOnClickListener(MainActivity::onCreate$lambda-1);
        var14 = this.findViewById(R.id.familyButton);
        Intrinsics.checkNotNullExpressionValue(var14, "findViewById(R.id.familyButton)");
        ImageButton familyButton = (ImageButton)var14;
        familyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFamilyScreen();
            }
        });
        //familyButton.setOnClickListener(MainActivity::onCreate$lambda-2);
        var14 = this.findViewById(R.id.spendingButton);
        Intrinsics.checkNotNullExpressionValue(var14, "findViewById(R.id.spendingButton)");
        ImageButton spendingButton = (ImageButton)var14;
        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToExpensesScreen();
            }
        });
        //spendingButton.setOnClickListener(MainActivity::onCreate$lambda-3);
        var14 = this.findViewById(R.id.categoriesButton);
        Intrinsics.checkNotNullExpressionValue(var14, "findViewById(R.id.categoriesButton)");
        ImageButton categoriesButton = (ImageButton)var14;
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCategoriesScreen();
            }
        });
        //categoriesButton.setOnClickListener(MainActivity::onCreate$lambda-4);
        RecyclerView recyclerView = (RecyclerView)this.findViewById(R.id.familyMemers);
        LinearLayoutManager layoutManager = new LinearLayoutManager((Context)this);
        recyclerView.setLayoutManager((LayoutManager)layoutManager);
        final FamilyMembersAdapter adapter = new FamilyMembersAdapter();
        recyclerView.setAdapter((Adapter)adapter);
        ReferenceProvider.INSTANCE.getBaseReference().child("family").addListenerForSingleValueEvent((ValueEventListener)(new ValueEventListener() {
            public void onDataChange(@NotNull DataSnapshot snapshot) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                List familyMemberList = (List)(new ArrayList());
                Iterator var3 = snapshot.getChildren().iterator();

                while(var3.hasNext()) {
                    DataSnapshot child = (DataSnapshot)var3.next();
                    Object var10001 = child.getValue(FamilyMember.class);
                    Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type com.gridness.assignment.models.FamilyMember");
                    familyMemberList.add((FamilyMember)var10001);
                }

                adapter.setFamilyMemberList(familyMemberList);
            }

            public void onCancelled(@NotNull DatabaseError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                String var2 = "Not yet implemented";
                throw new NotImplementedError("An operation is not implemented: " + var2);
            }
        }));
    }

    private final void goAdd() {
        Intent intent = new Intent((Context)this, AddFamilyMember.class);
        startActivity(intent);
        finish();
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

    private static final void onCreate$lambda_1/* $FF was: onCreate$lambda-1*/(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, AddFamilyMember.class);
        this$0.startActivity(intent);
    }

    private static final void onCreate$lambda_2/* $FF was: onCreate$lambda-2*/(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, MainActivity.class);
        this$0.startActivity(intent);
    }

    private static final void onCreate$lambda_3/* $FF was: onCreate$lambda-3*/(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Expenses.class);
        this$0.startActivity(intent);
    }

    private static final void onCreate$lambda_4/* $FF was: onCreate$lambda-4*/(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Categories.class);
        this$0.startActivity(intent);
    }
}
