package com.blueair.adddevice.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.blueair.adddevice.activity.AddDeviceActivityLegacy;
import com.blueair.adddevice.databinding.FragmentBluetoothScanningBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import com.blueair.viewcore.view.ProgressBlockerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"},
   d2 = {"Lcom/blueair/adddevice/fragment/BluetoothScanningFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lcom/blueair/adddevice/databinding/FragmentBluetoothScanningBinding;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onPause", "onDestroy", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothScanningFragment extends Fragment implements ProgressFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentBluetoothScanningBinding binding;
   private ProgressBlockerView progressBlockerView;

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      FragmentBluetoothScanningBinding var2 = this.binding;
      FragmentBluetoothScanningBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.root;
      Intrinsics.checkNotNullExpressionValue(var3, "root");
      return var3;
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentBluetoothScanningBinding var6 = FragmentBluetoothScanningBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      FragmentBluetoothScanningBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ConstraintLayout var5 = var4.root;
      Intrinsics.checkNotNullExpressionValue(var5, "root");
      return (View)var5;
   }

   public void onDestroy() {
      super.onDestroy();
      this.clearProgressFragment();
   }

   public void onPause() {
      super.onPause();
      this.clearProgressFragment();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      String var4 = this.getString(R.string.action_click_here);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      StringBuilder var9 = new StringBuilder();
      var9.append(this.getString(R.string.hint_have_legacy_device));
      var9.append(' ');
      var9.append(var4);
      SpannableString var6 = new SpannableString((CharSequence)var9.toString());
      CharSequence var5 = (CharSequence)var6;
      int var3 = StringsKt.indexOf$default(var5, var4, 0, false, 6, (Object)null);
      Object var10 = null;
      if (var3 != -1) {
         var6.setSpan(Companion.buildLegacyClickableSpan(var1.getContext().getColor(R.color.colorPrimaryText)), var3, var4.length() + var3, 33);
         FragmentBluetoothScanningBinding var11 = this.binding;
         FragmentBluetoothScanningBinding var7 = var11;
         if (var11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = null;
         }

         var7.scanningSubtitle.setMovementMethod(LinkMovementMethod.getInstance());
      }

      FragmentBluetoothScanningBinding var8 = this.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (FragmentBluetoothScanningBinding)var10;
      }

      var8.scanningSubtitle.setText(var5);
   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/adddevice/fragment/BluetoothScanningFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/BluetoothScanningFragment;", "buildLegacyClickableSpan", "Landroid/text/style/ClickableSpan;", "linkColor", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final ClickableSpan buildLegacyClickableSpan(int var1) {
         return new NoUnderlineClickableSpan(var1) {
            final int $linkColor;

            {
               this.$linkColor = var1;
            }

            public void onClick(View var1) {
               Intrinsics.checkNotNullParameter(var1, "widget");
               Context var2 = var1.getContext();
               var2.startActivity(new Intent(var2, AddDeviceActivityLegacy.class));
            }

            public Integer providerLinkColor() {
               return this.$linkColor;
            }
         };
      }

      public final BluetoothScanningFragment newInstance() {
         return new BluetoothScanningFragment();
      }
   }
}
