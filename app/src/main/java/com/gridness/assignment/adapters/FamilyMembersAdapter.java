package com.gridness.assignment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.gridness.assignment.R;
import com.gridness.assignment.models.FamilyMember;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"},
        d2 = {"Lcom/gridness/assignment/adapters/FamilyMembersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gridness/assignment/adapters/FamilyMembersAdapter$FamilyMemberViewHolder;", "()V", "familyMemberList", "", "Lcom/gridness/assignment/models/FamilyMember;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setFamilyMemberList", "FamilyMemberViewHolder", "app_debug"}
)
public final class FamilyMembersAdapter extends Adapter {
    @NotNull
    private List familyMemberList = (List)(new ArrayList());

    @NotNull
    public FamilyMembersAdapter.FamilyMemberViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new FamilyMembersAdapter.FamilyMemberViewHolder(view);
    }

    public void onBindViewHolder(@NotNull FamilyMembersAdapter.FamilyMemberViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position, (FamilyMember)this.familyMemberList.get(position));
    }

    public int getItemCount() {
        return this.familyMemberList.size();
    }

    public final void setFamilyMemberList(@NotNull List familyMemberList) {
        Intrinsics.checkNotNullParameter(familyMemberList, "familyMemberList");
        this.familyMemberList = familyMemberList;
        this.notifyDataSetChanged();
    }

    // $FF: synthetic method
    // $FF: bridge method
    //public ViewHolder onCreateViewHolder(ViewGroup p0, int p1) {
    //    return (ViewHolder)this.onCreateViewHolder(p0, p1);
    //}

    // $FF: synthetic method
    // $FF: bridge method
    public void onBindViewHolder(ViewHolder p0, int p1) {
        this.onBindViewHolder((FamilyMembersAdapter.FamilyMemberViewHolder)p0, p1);
    }

    @Metadata(
            mv = {1, 7, 1},
            k = 1,
            xi = 48,
            d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"},
            d2 = {"Lcom/gridness/assignment/adapters/FamilyMembersAdapter$FamilyMemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "position", "", "familyMember", "Lcom/gridness/assignment/models/FamilyMember;", "app_debug"}
    )
    public static final class FamilyMemberViewHolder extends ViewHolder {
        @NotNull
        private final View itemView;

        public FamilyMemberViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.itemView = itemView;
        }

        public final void bind(int position, @NotNull FamilyMember familyMember) {
            Intrinsics.checkNotNullParameter(familyMember, "familyMember");
            if (position != 0) {
                this.itemView.findViewById(R.id.dividerTop).setVisibility(View.GONE);
            }

            ((TextView)this.itemView.findViewById(R.id.categoryNameItem)).setText((CharSequence)familyMember.getFamilyMemberName());
            ((TextView)this.itemView.findViewById(R.id.categoryTypeItem)).setText((CharSequence)familyMember.getIncome());
        }
    }
}
