package com.gridness.assignment.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"},
        d2 = {"Lcom/gridness/assignment/adapters/SpinnerAdapter;", "Landroid/widget/ArrayAdapter;", "", "mContext", "Landroid/content/Context;", "textResourceID", "", "list", "", "(Landroid/content/Context;ILjava/util/List;)V", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "app_debug"}
)
public final class SpinnerAdapter extends ArrayAdapter {
    @NotNull
    private final Context mContext;
    private final int textResourceID;
    @NotNull
    private final List list;

    public SpinnerAdapter(@NotNull Context mContext, int textResourceID, @NotNull List list) {
        super(mContext, textResourceID, list);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(list, "list");
        this.mContext = mContext;
        this.textResourceID = textResourceID;
        this.list = list;
    }

    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View newView = convertView;
        if (convertView == null) {
            newView = View.inflate(this.mContext, this.textResourceID, (ViewGroup) null);
        }

        Intrinsics.checkNotNull(newView, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) newView).setText((CharSequence) this.list.get(position));
        return newView;
    }
}
