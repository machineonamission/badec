package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.SimpleResourceBundle;
import com.blueair.core.model.UserForm;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.adapter.TroubleShootingItem;
import com.blueair.viewcore.databinding.DialogTroubleshootingBinding;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.EmptyViewModel;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItemList;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u00020-H\u0016J\b\u00106\u001a\u00020-H\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00108\u001a\u000209H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006;"},
   d2 = {"Lcom/blueair/viewcore/dialog/TroubleshootingDialog;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "itemAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/viewcore/adapter/TroubleShootingItem;", "actionType", "device", "Lcom/blueair/core/model/Device;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "setViewModel", "(Lcom/blueair/viewcore/viewmodel/EmptyViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "hydrateHeaderAndList", "", "binding", "Lcom/blueair/viewcore/databinding/DialogTroubleshootingBinding;", "setCantSeeHeaderSpan", "tvHeader", "Landroidx/appcompat/widget/AppCompatTextView;", "setFooterSpan", "tvFooter", "onStart", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TroubleshootingDialog extends BaseDialogFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(TroubleshootingDialog.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(TroubleshootingDialog.class, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(TroubleshootingDialog.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   public static final String ACTION_RETRY = "action_retry";
   public static final String ACTION_TYPE_BLUETOOTH_CANT_SEE = "action_type_bluetooth_cant_see";
   private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO = "action_type_bluetooth_connecting_auto";
   private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO_HUMIDITY = "action_type_bluetooth_connecting_auto_humidity";
   private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_FAN = "action_type_bluetooth_connecting_fan";
   private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_NORMAL = "action_type_bluetooth_connecting_normal";
   public static final String ACTION_TYPE_DEVICE_OFFLINE = "action_type_device_offline";
   public static final String ACTION_TYPE_WIFI_GUIDE = "action_type_wifi_guide";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String LINK_TOKEN_CUSTOMER_SUPPORT = "customer_support";
   public static final String REQUEST_KEY = "TroubleshootingDialog";
   private String actionType = "";
   private final Lazy authService$delegate;
   private Device device;
   private final Lazy deviceManager$delegate;
   private final ItemAdapter itemAdapter = new ItemAdapter();
   private final Lazy locationService$delegate;
   private final String screenName;
   public EmptyViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$JD6pTVa1gDhI0vYOqKN9ukm6p50(TroubleshootingDialog var0, View var1) {
      onCreateView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$PNOLAJh15osua6DWvxLQDHDoTbs(TroubleshootingDialog var0, View var1) {
      onCreateView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ryxAWLHynAoOqJUdR4Ti3I4Dg3w(TroubleshootingDialog var0, String var1, String var2) {
      return hydrateHeaderAndList$lambda$6(var0, var1, var2);
   }

   public TroubleshootingDialog() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null);
      KProperty[] var4 = $$delegatedProperties;
      this.authService$delegate = var3.provideDelegate(this, var4[0]);
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.deviceManager$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, DeviceManager.class)), (Object)null).provideDelegate(this, var4[1]);
      var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, LocationService.class)), (Object)null).provideDelegate(this, var4[2]);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final DeviceManager getDeviceManager() {
      return (DeviceManager)this.deviceManager$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final void hydrateHeaderAndList(DialogTroubleshootingBinding var1) {
      List var5;
      label59: {
         var5 = CollectionsKt.emptyList();
         String var6 = this.actionType;
         switch (var6.hashCode()) {
            case -1166068087:
               if (!var6.equals("action_type_bluetooth_connecting_auto_humidity")) {
                  break label59;
               }
               break;
            case -118147818:
               if (var6.equals("action_type_device_offline")) {
                  var1.tvHeader.setText((CharSequence)this.getString(R.string.troubleshooting_offline_header_msg));
                  List var9 = (List)CollectionsKt.arrayListOf(new SimpleResourceBundle[]{new SimpleResourceBundle(R.drawable.icon_internet, R.string.step_title_check_wifi_internet, R.string.step_content_check_wifi_internet, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_wifi_router, R.string.step_title_restart_router, R.string.step_content_restart_router, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.ic_wifi_4, R.string.step_title_prefer_band, R.string.step_content_prefer_band_v2, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_power_on, R.string.step_title_replug_device, R.string.step_content_replug_device, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_readd, R.string.step_title_readd_device, R.string.step_content_readd_device, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_latest_app, R.string.step_title_reinstall_app, R.string.step_content_reinstall_app, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_power_on, R.string.step_title_reset_device, R.string.step_content_reset_device, (String)null, (String)null, 24, (DefaultConstructorMarker)null)});
                  var5 = var9;
                  if (this.getLocationService().getRemoteConfig().getOfflineSupportEnabled()) {
                     ((ArrayList)var9).add(new SimpleResourceBundle(R.drawable.icon_customer_support, R.string.step_title_customer_support, R.string.step_content_customer_support, this.getString(R.string.action_click_here), "customer_support"));
                     var5 = var9;
                  }
               }
               break label59;
            case -95719570:
               if (var6.equals("action_type_wifi_guide")) {
                  var1.tvHeader.setText((CharSequence)this.getString(R.string.troubleshooting_wifi_header_msg));
                  var5 = (List)CollectionsKt.arrayListOf(new SimpleResourceBundle[]{new SimpleResourceBundle(R.drawable.icon_power_on, R.string.step_title_check_router_internet, R.string.wifi_troubleshooting_step_1, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.ic_wifi_4, R.string.step_title_prefer_band, R.string.step_content_prefer_band, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_internet, R.string.step_title_check_phone_internet, R.string.step_content_check_phone_internet, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_smartphone, R.string.step_title_connecting_hidden_wifi, R.string.step_content_connecting_hidden_wifi, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_vpn_services, R.string.step_title_deactivate_vpn, R.string.step_content_deactivate_vpn, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_wifi_router, R.string.step_title_close_to_router, R.string.step_content_close_to_router, (String)null, (String)null, 24, (DefaultConstructorMarker)null)});
               }
               break label59;
            case 118272197:
               if (var6.equals("action_type_bluetooth_cant_see")) {
                  AppCompatTextView var12 = var1.tvCantSeeMsg;
                  Intrinsics.checkNotNullExpressionValue(var12, "tvCantSeeMsg");
                  ((View)var12).setVisibility(0);
                  AppCompatTextView var8 = var1.tvHeader;
                  Intrinsics.checkNotNullExpressionValue(var8, "tvHeader");
                  this.setCantSeeHeaderSpan(var8);
                  var5 = (List)CollectionsKt.arrayListOf(new SimpleResourceBundle[]{new SimpleResourceBundle(R.drawable.icon_power_on, R.string.step_title_power_on_device, R.string.bt_troubleshooting_1_step, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_device_model, R.string.step_title_check_device_model, R.string.bt_troubleshooting_2_step, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_smartphone, R.string.step_title_check_close_enough, R.string.step_content_check_close_enough, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_latest_app, R.string.step_title_ensure_latest_app, R.string.step_content_ensure_latest_app, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_bluetooth_on, R.string.step_title_turn_on_bluetooth, R.string.step_content_turn_on_bluetooth, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_internet, R.string.step_title_check_phone_internet, R.string.step_content_check_phone_internet, (String)null, (String)null, 24, (DefaultConstructorMarker)null)});
               }
               break label59;
            case 384927145:
               if (!var6.equals("action_type_bluetooth_connecting_auto")) {
                  break label59;
               }
               break;
            case 914378337:
               if (var6.equals("action_type_bluetooth_connecting_normal")) {
                  var1.tvHeader.setText((CharSequence)this.getString(R.string.troubleshooting_bluetooth_header_msg));
                  var5 = (List)CollectionsKt.arrayListOf(new SimpleResourceBundle[]{new SimpleResourceBundle(R.drawable.icon_power_on, R.string.step_title_power_on_device, R.string.bt_troubleshooting_1_step, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_device_model, R.string.step_title_check_device_model, R.string.bt_troubleshooting_2_step, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_smartphone, R.string.step_title_check_close_enough, R.string.step_content_check_close_enough, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_latest_app, R.string.step_title_ensure_latest_app, R.string.step_content_ensure_latest_app, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_bluetooth_on, R.string.step_title_turn_on_bluetooth, R.string.step_content_turn_on_bluetooth, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_location_on, R.string.step_title_ensure_location_settings, R.string.step_content_ensure_location_settings, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_internet, R.string.step_title_check_phone_internet, R.string.step_content_check_phone_internet, (String)null, (String)null, 24, (DefaultConstructorMarker)null)});
               }
               break label59;
            case 982252505:
               if (!var6.equals("action_type_bluetooth_connecting_fan")) {
                  break label59;
               }
               break;
            default:
               break label59;
         }

         var1.tvHeader.setText((CharSequence)this.getString(R.string.troubleshooting_bluetooth_header_msg));
         SimpleResourceBundle var10 = new SimpleResourceBundle(R.drawable.icon_power_on, R.string.step_title_power_on_device, R.string.bt_troubleshooting_1_step, (String)null, (String)null, 24, (DefaultConstructorMarker)null);
         int var3 = R.drawable.ic_wifi_4;
         int var4 = R.string.step_title_ready_to_pair;
         String var13 = this.actionType;
         int var2;
         if (Intrinsics.areEqual(var13, "action_type_bluetooth_connecting_auto_humidity")) {
            var2 = R.string.wifi_connect_instruction_auto_humidity;
         } else if (Intrinsics.areEqual(var13, "action_type_bluetooth_connecting_fan")) {
            var2 = R.string.step_content_ready_to_pair_fan;
         } else {
            var2 = R.string.bt_troubleshooting_press_auto;
         }

         var5 = (List)CollectionsKt.arrayListOf(new SimpleResourceBundle[]{var10, new SimpleResourceBundle(var3, var4, var2, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_device_model, R.string.step_title_check_device_model, R.string.bt_troubleshooting_2_step, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_smartphone, R.string.step_title_check_close_enough, R.string.step_content_check_close_enough, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_latest_app, R.string.step_title_ensure_latest_app, R.string.step_content_ensure_latest_app, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_bluetooth_on, R.string.step_title_turn_on_bluetooth, R.string.step_content_turn_on_bluetooth, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_location_on, R.string.step_title_ensure_location_settings, R.string.step_content_ensure_location_settings, (String)null, (String)null, 24, (DefaultConstructorMarker)null), new SimpleResourceBundle(R.drawable.icon_internet, R.string.step_title_check_phone_internet, R.string.step_content_check_phone_internet, (String)null, (String)null, 24, (DefaultConstructorMarker)null)});
      }

      TroubleshootingDialog$$ExternalSyntheticLambda0 var11 = new TroubleshootingDialog$$ExternalSyntheticLambda0(this);
      IItemList var15 = this.itemAdapter.getItemList();
      Iterable var7 = (Iterable)var5;
      Collection var14 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));
      Iterator var16 = var7.iterator();

      while(var16.hasNext()) {
         var14.add(new TroubleShootingItem((SimpleResourceBundle)var16.next(), var11));
      }

      var15.setNewList((List)var14, false);
   }

   private static final Unit hydrateHeaderAndList$lambda$6(TroubleshootingDialog var0, String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      if (Intrinsics.areEqual(var2, "customer_support")) {
         Device var4 = var0.device;
         if (var4 != null) {
            LifecycleOwner var3 = var0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(var3, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var3), (CoroutineContext)null, (CoroutineStart)null, new Function2(var0, var4, (Continuation)null) {
               final Device $it;
               long J$0;
               Object L$0;
               Object L$1;
               Object L$2;
               Object L$3;
               Object L$4;
               Object L$5;
               int label;
               final TroubleshootingDialog this$0;

               {
                  this.this$0 = var1;
                  this.$it = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     Intent var16 = (Intent)this.L$5;
                     String var17 = (String)this.L$4;
                     var17 = (String)this.L$3;
                     var17 = (String)this.L$2;
                     UserForm var20 = (UserForm)this.L$1;
                     String var21 = (String)this.L$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     String var15 = this.this$0.getAuthService().getUsername();
                     long var3 = System.currentTimeMillis() / (long)1000;
                     String var6 = this.$it.getUid();
                     StringBuilder var7 = new StringBuilder();
                     var7.append(Build.BRAND);
                     var7.append(' ');
                     var7.append(Build.MODEL);
                     String var8 = var7.toString();
                     String var23 = VERSION.RELEASE;
                     Intrinsics.checkNotNullExpressionValue(var23, "RELEASE");
                     UserForm var22 = new UserForm(var6, var8, var23, "4.5.2", var3, "offline", (String)null, 64, (DefaultConstructorMarker)null);
                     StringBuilder var24 = new StringBuilder();
                     var24.append(this.this$0.getString(R.string.label_device_offline));
                     var24.append(" - ");
                     var24.append(var15);
                     var24.append(" - ");
                     var24.append(var3);
                     String var25 = var24.toString();
                     var8 = this.this$0.getString(R.string.troubleshooting_offline_email_content, new Object[]{String.valueOf(var3), var15, this.$it.getMac(), var22.getPhoneModel(), var22.getSystemVersion(), var22.getAppVersion()});
                     Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
                     StringBuilder var9 = new StringBuilder("mailto:info@blueair.com?subject=");
                     var9.append(Uri.encode(var25));
                     var9.append("&body=");
                     var9.append(Uri.encode(var8));
                     String var27 = var9.toString();
                     Intent var10 = new Intent("android.intent.action.SENDTO", Uri.parse(var27));

                     label43:
                     try {
                        this.this$0.startActivity(var10);
                     } finally {
                        break label43;
                     }

                     DeviceManager var11 = this.this$0.getDeviceManager();
                     Continuation var12 = (Continuation)this;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var15);
                     this.L$1 = SpillingKt.nullOutSpilledVariable(var22);
                     this.L$2 = SpillingKt.nullOutSpilledVariable(var25);
                     this.L$3 = SpillingKt.nullOutSpilledVariable(var8);
                     this.L$4 = SpillingKt.nullOutSpilledVariable(var27);
                     this.L$5 = SpillingKt.nullOutSpilledVariable(var10);
                     this.J$0 = var3;
                     this.label = 1;
                     if (var11.postUserForm(var22, var12) == var5) {
                        return var5;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$2(TroubleshootingDialog var0, View var1) {
      var0.dismissAllowingStateLoss();
   }

   private static final void onCreateView$lambda$4(TroubleshootingDialog var0, View var1) {
      var0.dismissAllowingStateLoss();
      FragmentKt.setFragmentResult((Fragment)var0, "TroubleshootingDialog", BundleKt.bundleOf(new Pair[]{TuplesKt.to("action_retry", true)}));
   }

   private final void setCantSeeHeaderSpan(AppCompatTextView var1) {
      String var4 = this.getString(R.string.action_click_here);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      StringBuilder var5 = new StringBuilder();
      var5.append(this.getString(R.string.hint_have_legacy_device));
      var5.append(' ');
      var5.append(var4);
      SpannableString var6 = new SpannableString((CharSequence)var5.toString());
      CharSequence var7 = (CharSequence)var6;
      int var2 = StringsKt.indexOf$default(var7, var4, 0, false, 6, (Object)null);
      int var3 = ContextCompat.getColor(var1.getContext(), R.color.colorPrimary);
      if (var2 > -1) {
         var6.setSpan(Companion.buildLegacyClickableSpan(var3), var2, var4.length() + var2, 33);
         var1.setMovementMethod(LinkMovementMethod.getInstance());
      }

      var1.setText(var7);
   }

   private final void setFooterSpan(AppCompatTextView var1) {
      String var4 = this.getString(R.string.customer_support_lowercase);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      SpannableString var3 = new SpannableString((CharSequence)this.getString(R.string.troubleshooting_support_msg, new Object[]{var4}));
      CharSequence var5 = (CharSequence)var3;
      int var2 = StringsKt.indexOf$default(var5, var4, 0, false, 6, (Object)null);
      if (var2 != -1) {
         var3.setSpan(Companion.buildSupportClickableSpan(ContextCompat.getColor(var1.getContext(), R.color.colorPrimary)), var2, var4.length() + var2, 33);
         var1.setMovementMethod(LinkMovementMethod.getInstance());
      }

      var1.setText(var5);
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public EmptyViewModel getViewModel() {
      EmptyViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var9 = this.getDialog();
      if (var9 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var10 = var9.getWindow();
         if (var10 != null) {
            var10.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var10.setWindowAnimations(R.style.dialog_animation);
         }
      }

      this.setViewModel((EmptyViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(EmptyViewModel.class)));
      DialogTroubleshootingBinding var4 = DialogTroubleshootingBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      var4.closeButton.setOnClickListener(new TroubleshootingDialog$$ExternalSyntheticLambda1(this));
      Bundle var6 = this.getArguments();
      if (var6 != null) {
         String var11 = var6.getString("action_type", this.actionType);
         Intrinsics.checkNotNullExpressionValue(var11, "getString(...)");
         this.actionType = var11;
         this.device = (Device)var6.getParcelable("device");
      }

      this.hydrateHeaderAndList(var4);
      var4.rvList.setAdapter((RecyclerView.Adapter)FastAdapter.Companion.with((IAdapter)this.itemAdapter));
      if (!Intrinsics.areEqual(this.actionType, "action_type_device_offline")) {
         AppCompatTextView var7 = var4.tvFooter;
         Intrinsics.checkNotNullExpressionValue(var7, "tvFooter");
         this.setFooterSpan(var7);
      } else {
         AppCompatTextView var8 = var4.tvFooter;
         Intrinsics.checkNotNullExpressionValue(var8, "tvFooter");
         ViewExtensionsKt.hide((View)var8);
      }

      var4.btnTryAgain.setOnClickListener(new TroubleshootingDialog$$ExternalSyntheticLambda2(this));
      LinearLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onPause() {
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            WindowManager.LayoutParams var3 = var2.getAttributes();
            if (var3 != null) {
               var3.windowAnimations = R.style.dialog_animation_exit_only;
            }
         }
      }

      super.onPause();
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.addFlags(Integer.MIN_VALUE);
            var2.getDecorView().setSystemUiVisibility(8448);
            var2.setStatusBarColor(0);
            DialogUtils.INSTANCE.immersiveStatusBar(this.getDialog(), false, true);
            var2.setLayout(-1, -1);
         }
      }

   }

   public void setViewModel(EmptyViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"},
      d2 = {"Lcom/blueair/viewcore/dialog/TroubleshootingDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ACTION_RETRY", "ACTION_TYPE_BLUETOOTH_CANT_SEE", "ACTION_TYPE_WIFI_GUIDE", "ACTION_TYPE_DEVICE_OFFLINE", "ACTION_TYPE_BLUETOOTH_CONNECTING_NORMAL", "ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO", "ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO_HUMIDITY", "ACTION_TYPE_BLUETOOTH_CONNECTING_FAN", "LINK_TOKEN_CUSTOMER_SUPPORT", "newInstanceForBluetooth", "Lcom/blueair/viewcore/dialog/TroubleshootingDialog;", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "newInstance", "actionType", "device", "Lcom/blueair/core/model/Device;", "buildSupportClickableSpan", "Landroid/text/style/ClickableSpan;", "linkColor", "", "buildLegacyClickableSpan", "viewcore_otherRelease"},
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

      // $FF: synthetic method
      public static TroubleshootingDialog newInstance$default(Companion var0, String var1, Device var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.newInstance(var1, var2);
      }

      public final ClickableSpan buildLegacyClickableSpan(int var1) {
         return new NoUnderlineClickableSpan(var1) {
            final int $linkColor;

            {
               this.$linkColor = var1;
            }

            public void onClick(View var1) {
               Intrinsics.checkNotNullParameter(var1, "widget");
               var1.getContext().startActivity(new Intent("blueair.action.adddevicelegacy"));
            }

            public Integer providerLinkColor() {
               return this.$linkColor;
            }
         };
      }

      public final ClickableSpan buildSupportClickableSpan(int var1) {
         return new NoUnderlineClickableSpan(var1) {
            final int $linkColor;

            {
               this.$linkColor = var1;
            }

            public void onClick(View var1) {
               Intrinsics.checkNotNullParameter(var1, "widget");
               Context var3 = var1.getContext();
               Actions var2 = Actions.INSTANCE;
               Intrinsics.checkNotNull(var3);
               var3.startActivity(var2.openTroubleShootIntent(var3));
            }

            public Integer providerLinkColor() {
               return this.$linkColor;
            }
         };
      }

      public final TroubleshootingDialog newInstance(String var1, Device var2) {
         Intrinsics.checkNotNullParameter(var1, "actionType");
         TroubleshootingDialog var3 = new TroubleshootingDialog();
         Bundle var4 = new Bundle();
         var4.putString("action_type", var1);
         var4.putParcelable("device", var2);
         var3.setArguments(var4);
         return var3;
      }

      public final TroubleshootingDialog newInstanceForBluetooth(BluetoothDevice var1) {
         String var2;
         if (var1 != null && var1.getButtonPressNeeded()) {
            if (var1.getHasNoAutoButton()) {
               var2 = "action_type_bluetooth_connecting_fan";
            } else if (var1.getUseWaterdropAuto()) {
               var2 = "action_type_bluetooth_connecting_auto_humidity";
            } else {
               var2 = "action_type_bluetooth_connecting_auto";
            }
         } else {
            var2 = "action_type_bluetooth_connecting_normal";
         }

         return newInstance$default(this, var2, (Device)null, 2, (Object)null);
      }
   }
}
