package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.viewcore.R;
import com.blueair.viewcore.adapter.DropDownListAdapter;
import com.blueair.viewcore.utils.MaxCountLayoutManager;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.DialogX.IMPL_MODE;
import com.kongzue.dialogx.dialogs.PopNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJh\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ+\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020\u00182\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lcom/blueair/viewcore/dialog/DialogUtils;", "", "<init>", "()V", "permissionHints", "", "Lcom/kongzue/dialogx/dialogs/PopNotification;", "statusBarHeight", "", "init", "", "context", "Landroid/content/Context;", "showDropDownList", "anchorView", "Landroid/view/View;", "items", "", "", "width", "dx", "dy", "maxVisibleCount", "headFirstItem", "", "onItemSelectedListener", "Lkotlin/Function2;", "showRequestPermissionHint", "titleRes", "messageRes", "getStatusBarHeight", "immersiveStatusBar", "dialog", "Landroid/app/Dialog;", "fullScreen", "lightMode", "(Landroid/app/Dialog;ZLjava/lang/Boolean;)V", "hideRequestPermissionHints", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DialogUtils {
   public static final DialogUtils INSTANCE = new DialogUtils();
   private static final List permissionHints = (List)(new ArrayList());
   private static int statusBarHeight = 35;

   // $FF: synthetic method
   public static Unit $r8$lambda$9nx0ibpY99FFh_cRlG4Dler24IU/* $FF was: $r8$lambda$9nx0ibpY99FFh-cRlG4Dler24IU*/(PopupWindow var0, Function2 var1, int var2, String var3) {
      return showDropDownList$lambda$2(var0, var1, var2, var3);
   }

   private DialogUtils() {
   }

   // $FF: synthetic method
   public static void immersiveStatusBar$default(DialogUtils var0, Dialog var1, boolean var2, Boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      var0.immersiveStatusBar(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void showDropDownList$default(DialogUtils var0, View var1, List var2, int var3, int var4, int var5, int var6, boolean var7, Function2 var8, int var9, Object var10) {
      if ((var9 & 4) != 0) {
         var3 = var1.getWidth();
      }

      if ((var9 & 8) != 0) {
         var4 = 0;
      }

      if ((var9 & 16) != 0) {
         var5 = 0;
      }

      if ((var9 & 32) != 0) {
         var6 = 0;
      }

      if ((var9 & 64) != 0) {
         var7 = false;
      }

      var0.showDropDownList(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   private static final Unit showDropDownList$lambda$2(PopupWindow var0, Function2 var1, int var2, String var3) {
      Intrinsics.checkNotNullParameter(var3, "item");
      var0.dismiss();
      var1.invoke(var2, var3);
      return Unit.INSTANCE;
   }

   public final int getStatusBarHeight(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Resources var3 = var1.getResources();
      int var2 = var3.getIdentifier("status_bar_height", "dimen", "android");
      return var2 > 0 ? var3.getDimensionPixelSize(var2) : (int)TypedValue.applyDimension(1, 24.0F, var3.getDisplayMetrics());
   }

   public final void hideRequestPermissionHints() {
      Iterator var1 = ((Iterable)permissionHints).iterator();

      while(var1.hasNext()) {
         ((PopNotification)var1.next()).dismiss();
      }

      permissionHints.clear();
   }

   public final void immersiveStatusBar(Dialog var1, boolean var2, Boolean var3) {
      if (var1 != null) {
         Window var7 = var1.getWindow();
         if (var7 != null) {
            var7.setStatusBarColor(0);
            var7.addFlags(Integer.MIN_VALUE);
            int var5 = var7.getDecorView().getSystemUiVisibility();
            int var4 = var5;
            if (var2) {
               var5 |= 1280;
               var4 = var5;
               if (VERSION.SDK_INT >= 28) {
                  WindowManager.LayoutParams var6 = var7.getAttributes();
                  BlueairApp$$ExternalSyntheticApiModelOutline0.m((WindowManager.LayoutParams)var6, 1);
                  var7.setAttributes(var6);
                  var4 = var5;
               }
            }

            var5 = var4;
            if (var3 != null) {
               if (var3) {
                  var4 |= 8192;
               } else {
                  var4 &= -8193;
               }

               var5 = var4;
            }

            var7.getDecorView().setSystemUiVisibility(var5);
         }
      }

   }

   public final void init(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      DialogX.init(var1);
      Resources var3 = var1.getResources();
      int var2 = var3.getIdentifier("status_bar_height", "dimen", "android");
      if (var2 > 0) {
         statusBarHeight = var3.getDimensionPixelSize(var2) / 2;
      }

   }

   public final void showDropDownList(View var1, List var2, int var3, int var4, int var5, int var6, boolean var7, Function2 var8) {
      Intrinsics.checkNotNullParameter(var1, "anchorView");
      Intrinsics.checkNotNullParameter(var2, "items");
      Intrinsics.checkNotNullParameter(var8, "onItemSelectedListener");
      View var9 = LayoutInflater.from(var1.getContext()).inflate(R.layout.drop_down_list, (ViewGroup)null);
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type com.blueair.viewcore.view.ShadowedRecyclerViewLayout");
      ShadowedRecyclerViewLayout var12 = (ShadowedRecyclerViewLayout)var9;
      if (var6 > 0) {
         RecyclerView var10 = var12.getRecyclerView();
         MaxCountLayoutManager var11 = new MaxCountLayoutManager(var1.getContext());
         var11.setMaxCount(var6);
         var10.setLayoutManager((RecyclerView.LayoutManager)var11);
      }

      PopupWindow var13 = new PopupWindow((View)var12, var3, -2);
      var13.setFocusable(true);
      var12.getRecyclerView().removeItemDecorationAt(0);
      var12.getRecyclerView().setAdapter(new DropDownListAdapter(var7, var2, new DialogUtils$$ExternalSyntheticLambda1(var13, var8)));
      var13.showAsDropDown(var1, var4, var5);
   }

   public final PopNotification showRequestPermissionHint(int var1, int var2) {
      if (!Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.CHINESE.getLanguage())) {
         return null;
      } else {
         PopNotification var3 = PopNotification.build();
         if (var1 != 0) {
            var3.setTitle((CharSequence)PopNotification.getApplicationContext().getString(var1));
         }

         if (var2 != 0) {
            var3.setMessage(var2);
         }

         List var4 = permissionHints;
         Intrinsics.checkNotNull(var3);
         var4.add(var3);
         return var3.setDialogImplMode(IMPL_MODE.DIALOG_FRAGMENT).noAutoDismiss().setMarginTop(statusBarHeight).show();
      }
   }
}
