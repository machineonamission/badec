package com.blueair.android.adapter;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.viewholder.DrawerViewHolder;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/android/adapter/DrawerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/DrawerViewHolder;", "menu", "Landroid/view/Menu;", "itemSelectedListener", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "<init>", "(Landroid/view/Menu;Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;)V", "visibleMenuItems", "Ljava/util/ArrayList;", "Landroid/view/MenuItem;", "Lkotlin/collections/ArrayList;", "updateDrawer", "", "updateMenu", "id", "", "visible", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DrawerListAdapter.kt */
public final class DrawerListAdapter extends RecyclerView.Adapter<DrawerViewHolder> {
    public static final int $stable = 8;
    private NavigationView.OnNavigationItemSelectedListener itemSelectedListener;
    private Menu menu;
    private ArrayList<MenuItem> visibleMenuItems = new ArrayList<>();

    public DrawerListAdapter(Menu menu2, NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        Intrinsics.checkNotNullParameter(menu2, "menu");
        Intrinsics.checkNotNullParameter(onNavigationItemSelectedListener, "itemSelectedListener");
        this.menu = menu2;
        this.itemSelectedListener = onNavigationItemSelectedListener;
    }

    public final void updateDrawer() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu2 = this.menu;
        int size = menu2.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu2.getItem(i);
            if (item.isVisible()) {
                arrayList.add(item);
            }
        }
        this.visibleMenuItems = arrayList;
        notifyDataSetChanged();
    }

    public final void updateMenu(int i, boolean z) {
        MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            findItem.setVisible(z);
            updateDrawer();
        }
    }

    public DrawerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DrawerViewHolder.Companion.newInstance(viewGroup);
    }

    public int getItemCount() {
        return this.visibleMenuItems.size();
    }

    public void onBindViewHolder(DrawerViewHolder drawerViewHolder, int i) {
        Intrinsics.checkNotNullParameter(drawerViewHolder, "holder");
        MenuItem menuItem = (MenuItem) CollectionsKt.getOrNull(this.visibleMenuItems, i);
        if (menuItem != null) {
            drawerViewHolder.update(menuItem);
            drawerViewHolder.itemView.setOnClickListener(new DrawerListAdapter$$ExternalSyntheticLambda0(this, menuItem));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(DrawerListAdapter drawerListAdapter, MenuItem menuItem, View view) {
        drawerListAdapter.itemSelectedListener.onNavigationItemSelected(menuItem);
    }
}
