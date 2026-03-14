package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualConfigProgressBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualConfigProgressClassicBinding;
import com.blueair.viewcore.R;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigProgressFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getSpannableStringForDevice", "Landroid/text/SpannableString;", "deviceNetwork", "", "fullText", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceManualConfigProgressFragment extends AddDeviceProgressFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$bIPu5ZBipmkud4lr2B7JTwGNNcw() {
      onViewCreated$lambda$0();
   }

   private final SpannableString getSpannableStringForDevice(String var1, String var2) {
      CharSequence var6 = (CharSequence)var2;
      int var3 = StringsKt.indexOf$default(var6, var1, 0, false, 6, (Object)null);
      int var4 = var1.length();
      SpannableString var5 = new SpannableString(var6);
      var5.setSpan(new ForegroundColorSpan(this.getResources().getColor(R.color.yellow_jasmine)), var3, var4 + var3, 33);
      return var5;
   }

   private static final void onViewCreated$lambda$0() {
      Timber.Forest.d("manualPairDeviceAsync completed", new Object[0]);
   }

   public ConstraintLayout getRootView() {
      ViewBinding var2 = this.binding;
      ViewBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      View var3 = var1.getRoot();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
      return (ConstraintLayout)var3;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      boolean var4;
      if (this.getDeviceModelType() == 3) {
         var4 = true;
      } else {
         var4 = false;
      }

      ViewBinding var7;
      if (var4) {
         FragmentAddDeviceManualConfigProgressClassicBinding var6 = FragmentAddDeviceManualConfigProgressClassicBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var6);
         var7 = var6;
      } else {
         FragmentAddDeviceManualConfigProgressBinding var8 = FragmentAddDeviceManualConfigProgressBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var8);
         var7 = var8;
      }

      this.binding = var7;
      Object var17 = null;
      if (!var4) {
         ViewBinding var15 = var7;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var15 = null;
         }

         StringBuilder var5;
         label30: {
            var16 = (TextView)var15.getRoot().findViewById(com.blueair.adddevice.R.id.textAddDeviceSubtitle);
            var5 = new StringBuilder();
            Context var9 = this.getContext();
            if (var9 != null) {
               Resources var10 = var9.getResources();
               if (var10 != null) {
                  var11 = var10.getString(R.string.add_device_progress_manual);
                  break label30;
               }
            }

            var11 = null;
         }

         var5.append(var11);
         var5.append(' ');
         var5.append(DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(this.getDeviceModelType()));
         String var12 = var5.toString();
         var16.setText((CharSequence)this.getSpannableStringForDevice(DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(this.getDeviceModelType()), var12), BufferType.SPANNABLE);
      }

      var7 = this.binding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = (ViewBinding)var17;
      }

      View var14 = var7.getRoot();
      Intrinsics.checkNotNullExpressionValue(var14, "getRoot(...)");
      return var14;
   }

   public void onResume() {
      super.onResume();
      if (this.getDeviceModelType() == 3) {
         FragmentActivity var1 = this.getActivity();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(R.string.confirm));
         }

         this.hideLoading();
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      if (this.getAddService().getState().getDeviceInfo() == null) {
         this.getAsyncSubs().add(this.getAddService().manualPairDeviceAsync().subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe(new AddDeviceManualConfigProgressFragment$$ExternalSyntheticLambda0()));
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigProgressFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigProgressFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceManualConfigProgressFragment newInstance(int var1) {
         AddDeviceManualConfigProgressFragment var3 = new AddDeviceManualConfigProgressFragment();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
