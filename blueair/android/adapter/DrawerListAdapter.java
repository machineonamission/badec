package com.blueair.android.adapter;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.viewholder.DrawerViewHolder;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/android/adapter/DrawerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/DrawerViewHolder;", "menu", "Landroid/view/Menu;", "itemSelectedListener", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "<init>", "(Landroid/view/Menu;Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;)V", "visibleMenuItems", "Ljava/util/ArrayList;", "Landroid/view/MenuItem;", "Lkotlin/collections/ArrayList;", "updateDrawer", "", "updateMenu", "id", "", "visible", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DrawerListAdapter extends RecyclerView.Adapter {
   public static final int $stable = 8;
   private NavigationView.OnNavigationItemSelectedListener itemSelectedListener;
   private Menu menu;
   private ArrayList visibleMenuItems;

   // $FF: synthetic method
   public static void $r8$lambda$ncSpwpfw_5bgq83LJOpiLjZYwY0/* $FF was: $r8$lambda$ncSpwpfw-5bgq83LJOpiLjZYwY0*/(DrawerListAdapter var0, MenuItem var1, View var2) {
      onBindViewHolder$lambda$3$lambda$2(var0, var1, var2);
   }

   public DrawerListAdapter(Menu var1, NavigationView.OnNavigationItemSelectedListener var2) {
      Intrinsics.checkNotNullParameter(var1, "menu");
      Intrinsics.checkNotNullParameter(var2, "itemSelectedListener");
      super();
      this.menu = var1;
      this.itemSelectedListener = var2;
      this.visibleMenuItems = new ArrayList();
   }

   private static final void onBindViewHolder$lambda$3$lambda$2(DrawerListAdapter var0, MenuItem var1, View var2) {
      var0.itemSelectedListener.onNavigationItemSelected(var1);
   }

   public int getItemCount() {
      return this.visibleMenuItems.size();
   }

   public void onBindViewHolder(DrawerViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      MenuItem var3 = (MenuItem)CollectionsKt.getOrNull((List)this.visibleMenuItems, var2);
      if (var3 != null) {
         var1.update(var3);
         var1.itemView.setOnClickListener(new DrawerListAdapter$$ExternalSyntheticLambda0(this, var3));
      }

   }

   public DrawerViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DrawerViewHolder.Companion.newInstance(var1);
   }

   public final void updateDrawer() {
      ArrayList var5 = new ArrayList();
      Menu var3 = this.menu;
      int var2 = var3.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         MenuItem var4 = var3.getItem(var1);
         if (var4.isVisible()) {
            var5.add(var4);
         }
      }

      this.visibleMenuItems = var5;
      this.notifyDataSetChanged();
   }

   public final void updateMenu(int var1, boolean var2) {
      MenuItem var3 = this.menu.findItem(var1);
      if (var3 != null) {
         var3.setVisible(var2);
         this.updateDrawer();
      }

   }
}
