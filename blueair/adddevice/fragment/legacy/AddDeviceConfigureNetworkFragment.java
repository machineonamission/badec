package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.NetworkStateReceiver;
import com.blueair.adddevice.databinding.FragmentAddDeviceConfigureNetworkBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceConfigureNetworkClassicBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import io.flatcircle.connectivityhelper.NetUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006!"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "mDeviceConfigurationMode", "", "getMDeviceConfigurationMode$annotations", "mWifiNetworkSSID", "", "mNetworkStateReceiver", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment$NetworkBroadcastReceiver;", "hasEnteredText", "", "binding", "Landroidx/viewbinding/ViewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onResume", "onPause", "updateNextButtonState", "NetworkBroadcastReceiver", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceConfigureNetworkFragment extends AddDeviceBaseFragment {
   private static final String ARG_DEVICE_CONFIGURATION_MODE = "mDeviceConfigurationMode";
   private static final String ARG_WIFI_NETWORK_PASSWORD = "mWifiNetworkPassword";
   private static final String ARG_WIFI_NETWORK_SSID = "mWifiNetworkSSID";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private boolean hasEnteredText;
   private int mDeviceConfigurationMode;
   private NetworkBroadcastReceiver mNetworkStateReceiver = new NetworkBroadcastReceiver();
   private String mWifiNetworkSSID;

   // $FF: synthetic method
   public static void $r8$lambda$Ictav3NOt9sRKwqw_XtN0i38nos/* $FF was: $r8$lambda$Ictav3NOt9sRKwqw-XtN0i38nos*/(AddDeviceConfigureNetworkFragment var0, EditText var1, TextInputLayout var2, TextView var3, View var4) {
      onCreateView$lambda$1(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   private static void getMDeviceConfigurationMode$annotations() {
   }

   private static final void onCreateView$lambda$1(AddDeviceConfigureNetworkFragment var0, EditText var1, TextInputLayout var2, TextView var3, View var4) {
      if (var0.getDeviceModelType() == 3 && var1.getText().length() < 8) {
         var2.setEndIconMode(1);
         var2.setEndIconMode(0);
         var1.requestFocus();
         var1.setError((CharSequence)var0.getString(R.string.error_wifi_password_validation));
      } else {
         String var14 = NetUtil.INSTANCE.getActiveWifiSSID((Context)var0.getActivity());
         String var6 = NetUtil.INSTANCE.getActiveWifiBSSID((Context)var0.getActivity());
         String var5 = DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(var0.getDeviceModelType());
         Timber.Forest var7 = Timber.Forest;
         StringBuilder var12 = new StringBuilder("connectedWifiSSID: ");
         var12.append(var14);
         var12.append(", requiredManualWiFiSSID: ");
         var12.append(var5);
         var7.d(var12.toString(), new Object[0]);
         if (var0.mDeviceConfigurationMode == 0 && var14 != null && !Intrinsics.areEqual(var14, var5)) {
            var0.getAddService().setNetworkInfo(var6, var3.getText().toString(), var1.getText().toString());
         } else {
            String var13 = var5;
            if (var14 != null) {
               var13 = var5;
               if (Intrinsics.areEqual(var14, "WiredSSID")) {
                  var13 = var14;
               }
            }

            if (var14 != null && Intrinsics.areEqual(var14, var13)) {
               var0.getAddService().setNetworkInfo(var6, var3.getText().toString(), var1.getText().toString());
            } else {
               StringCompanionObject var9 = StringCompanionObject.INSTANCE;
               String var10 = var0.getString(R.string.add_device_wrong_network);
               Intrinsics.checkNotNullExpressionValue(var10, "getString(...)");
               var10 = String.format(var10, Arrays.copyOf(new Object[]{var13}, 1));
               Intrinsics.checkNotNullExpressionValue(var10, "format(...)");
               FragmentActivity var8 = var0.getActivity();
               if (var8 != null) {
                  ViewUtils.INSTANCE.showError((Activity)var8, var10);
               }

            }
         }
      }
   }

   private final void updateNextButtonState() {
      Timber.Forest var4 = Timber.Forest;
      boolean var3 = false;
      var4.d("updateNextButtonState()", new Object[0]);
      View var7 = this.getView();
      if (var7 != null) {
         View var5 = var7.findViewById(com.blueair.adddevice.R.id.editTextSSID);
         Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type android.widget.TextView");
         TextView var10 = (TextView)var5;
         View var6 = var7.findViewById(com.blueair.adddevice.R.id.editTextPassword);
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type android.widget.EditText");
         EditText var11 = (EditText)var6;
         boolean var2;
         if (((CharSequence)var10.getText().toString()).length() == 0) {
            if (this.hasEnteredText) {
               var10.setError((CharSequence)this.getString(R.string.both_step3_no_ssid));
            }

            var2 = false;
         } else {
            var2 = true;
         }

         if (((CharSequence)var11.getText().toString()).length() == 0) {
            if (this.hasEnteredText && this.getDeviceModelType() != 3) {
               var11.setError((CharSequence)this.getString(R.string.both_step3_no_password));
            }

            var2 = false;
         }

         if (!NetUtil.INSTANCE.isWifiConnected((Context)this.getActivity())) {
            var2 = var3;
         }

         var7 = var7.findViewById(com.blueair.adddevice.R.id.buttonNext);
         Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type android.widget.Button");
         Button var9 = (Button)var7;
         var9.setEnabled(var2);
         if (this.getDeviceModelType() == 3) {
            int var1;
            if (var2) {
               var1 = R.color.marineblue;
            } else {
               var1 = R.color.greyblue;
            }

            var9.setBackgroundColor(ResourcesCompat.getColor(this.getResources(), var1, (Resources.Theme)null));
         }
      }

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

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      Bundle var2 = this.getArguments();
      if (var2 != null) {
         this.mDeviceConfigurationMode = var2.getInt(ARG_DEVICE_CONFIGURATION_MODE);
         String var3 = ARG_WIFI_NETWORK_SSID;
         if (!Intrinsics.areEqual(var2.getString(var3), "<unknown ssid>")) {
            this.mWifiNetworkSSID = var2.getString(var3);
         }
      }

      this.hasEnteredText = false;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      ViewBinding var9;
      if (this.getDeviceModelType() == 3) {
         FragmentAddDeviceConfigureNetworkClassicBinding var8 = FragmentAddDeviceConfigureNetworkClassicBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var8);
         var9 = var8;
      } else {
         FragmentAddDeviceConfigureNetworkBinding var10 = FragmentAddDeviceConfigureNetworkBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var10);
         var9 = var10;
      }

      this.binding = var9;
      Object var25 = null;
      ViewBinding var20 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var20 = null;
      }

      TextView var11 = (TextView)var20.getRoot().findViewById(com.blueair.adddevice.R.id.textAddDeviceSubtitle);
      int var4 = this.getDeviceModelType();
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 == 3) {
               var11.setText(R.string.add_device_network_subtitle_classic);
            }
         } else {
            var11.setText(R.string.add_device_network_subtitle_sense);
         }
      } else {
         var11.setText(R.string.add_device_network_subtitle_aware);
      }

      var20 = this.binding;
      ViewBinding var12 = var20;
      if (var20 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      TextView var5 = (TextView)var12.getRoot().findViewById(com.blueair.adddevice.R.id.editTextSSID);
      String var13 = this.mWifiNetworkSSID;
      if (var13 != null) {
         var13 = StringsKt.trim((CharSequence)var13).toString();
      } else {
         var13 = null;
      }

      var5.setText((CharSequence)var13);
      var20 = this.binding;
      ViewBinding var15 = var20;
      if (var20 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var15 = null;
      }

      TextInputLayout var6 = (TextInputLayout)var15.getRoot().findViewById(com.blueair.adddevice.R.id.passwordViewContainer);
      var20 = this.binding;
      var15 = var20;
      if (var20 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var15 = null;
      }

      EditText var7 = (EditText)var15.getRoot().findViewById(com.blueair.adddevice.R.id.editTextPassword);
      var7.addTextChangedListener(new TextWatcher(this, var6) {
         final TextInputLayout $passwordViewContainer;
         final AddDeviceConfigureNetworkFragment this$0;

         {
            this.this$0 = var1;
            this.$passwordViewContainer = var2;
         }

         public void afterTextChanged(Editable var1) {
            Intrinsics.checkNotNullParameter(var1, "s");
            if (((CharSequence)var1).length() > 0) {
               this.this$0.hasEnteredText = true;
            }

            this.this$0.getAddService().setWifiPassword(var1.toString());
            if (this.$passwordViewContainer.getEndIconMode() != 1 && this.this$0.getDeviceModelType() == 3) {
               this.$passwordViewContainer.setEndIconMode(1);
            }

            this.this$0.updateNextButtonState();
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
            Intrinsics.checkNotNullParameter(var1, "s");
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
            Intrinsics.checkNotNullParameter(var1, "s");
         }
      });
      var7.setText((CharSequence)this.getAddService().getWifiPassword());
      var20 = this.binding;
      var15 = var20;
      if (var20 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var15 = null;
      }

      ((Button)var15.getRoot().findViewById(com.blueair.adddevice.R.id.buttonNext)).setOnClickListener(new AddDeviceConfigureNetworkFragment$$ExternalSyntheticLambda0(this, var7, var6, var5));
      var15 = this.binding;
      if (var15 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var15 = (ViewBinding)var25;
      }

      View var19 = var15.getRoot();
      Intrinsics.checkNotNullExpressionValue(var19, "getRoot(...)");
      return var19;
   }

   public void onPause() {
      super.onPause();
      NetworkStateReceiver.unregisterReceiver(this.getContext(), this.mNetworkStateReceiver);
   }

   public void onResume() {
      super.onResume();
      FragmentActivity var1 = this.getActivity();
      if (var1 != null && this.getDeviceModelType() == 3) {
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(R.string.connect));
         }
      }

      NetworkStateReceiver.registerReceiver(this.getContext(), this.mNetworkStateReceiver);
   }

   public void onStart() {
      super.onStart();
      this.updateNextButtonState();
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0013"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment$Companion;", "", "<init>", "()V", "ARG_DEVICE_CONFIGURATION_MODE", "", "getARG_DEVICE_CONFIGURATION_MODE", "()Ljava/lang/String;", "ARG_WIFI_NETWORK_SSID", "getARG_WIFI_NETWORK_SSID", "ARG_WIFI_NETWORK_PASSWORD", "getARG_WIFI_NETWORK_PASSWORD", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment;", "deviceModelType", "", "deviceConfigurationMode", "wifiNetworkSSID", "wifiNetworkPassword", "adddevice_otherRelease"},
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

      public final String getARG_DEVICE_CONFIGURATION_MODE() {
         return AddDeviceConfigureNetworkFragment.ARG_DEVICE_CONFIGURATION_MODE;
      }

      public final String getARG_WIFI_NETWORK_PASSWORD() {
         return AddDeviceConfigureNetworkFragment.ARG_WIFI_NETWORK_PASSWORD;
      }

      public final String getARG_WIFI_NETWORK_SSID() {
         return AddDeviceConfigureNetworkFragment.ARG_WIFI_NETWORK_SSID;
      }

      public final AddDeviceConfigureNetworkFragment newInstance(int var1, int var2, String var3, String var4) {
         Intrinsics.checkNotNullParameter(var3, "wifiNetworkSSID");
         Intrinsics.checkNotNullParameter(var4, "wifiNetworkPassword");
         AddDeviceConfigureNetworkFragment var5 = new AddDeviceConfigureNetworkFragment();
         Bundle var6 = new Bundle();
         var6.putInt("deviceModelType", var1);
         var6.putInt(this.getARG_DEVICE_CONFIGURATION_MODE(), var2);
         var6.putString(this.getARG_WIFI_NETWORK_SSID(), var3);
         var6.putString(this.getARG_WIFI_NETWORK_PASSWORD(), var4);
         var5.setArguments(var6);
         return var5;
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment$NetworkBroadcastReceiver;", "Lcom/blueair/adddevice/NetworkStateReceiver;", "<init>", "(Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment;)V", "connected", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isConnected", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public final class NetworkBroadcastReceiver extends NetworkStateReceiver {
      final AddDeviceConfigureNetworkFragment this$0;

      public NetworkBroadcastReceiver() {
         this.this$0 = AddDeviceConfigureNetworkFragment.this;
      }

      protected void connected(Context var1, Intent var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "intent");
         super.connected(var1, var2, var3);
         this.this$0.updateNextButtonState();
      }
   }
}
