package com.blueair.antifake.adapter;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ViewKt;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.antifake.databinding.HolderSearchedDeviceBinding;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.MacAddressInfoDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0014\u0010\u001d\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0014\u0010!\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\"0\u001fJ\b\u0010#\u001a\u00020\u0011H\u0002R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"},
   d2 = {"Lcom/blueair/antifake/adapter/SearchedDeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/antifake/adapter/SearchedDeviceHolder;", "<init>", "()V", "acceptedSkus", "", "", "getAcceptedSkus", "()Ljava/util/Set;", "setAcceptedSkus", "(Ljava/util/Set;)V", "deviceList", "", "Lcom/blueair/antifake/adapter/SearchedDevice;", "onDeviceSelectedListener", "Lkotlin/Function1;", "", "setOnDeviceSelectedListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "updateOnboardedDevices", "devices", "", "Lcom/blueair/core/model/Device;", "updateBluetoothDevices", "Lcom/blueair/core/model/BluetoothDevice;", "sortList", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SearchedDeviceAdapter extends RecyclerView.Adapter {
   private Set acceptedSkus = SetsKt.emptySet();
   private final List deviceList = (List)(new ArrayList());
   private Function1 onDeviceSelectedListener;

   // $FF: synthetic method
   public static void $r8$lambda$NUveRHR8SXai6_mo3dPdBohMEGA(SearchedDevice var0, View var1) {
      onBindViewHolder$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kQsanA5_gkPAYr4vO1UtWCP0X90/* $FF was: $r8$lambda$kQsanA5-gkPAYr4vO1UtWCP0X90*/(SearchedDeviceAdapter var0, SearchedDevice var1, View var2) {
      onBindViewHolder$lambda$2(var0, var1, var2);
   }

   private static final int onBindViewHolder$getColor(SearchedDeviceHolder var0, int var1) {
      return var0.itemView.getContext().getColor(var1);
   }

   private static final void onBindViewHolder$lambda$2(SearchedDeviceAdapter var0, SearchedDevice var1, View var2) {
      Function1 var3 = var0.onDeviceSelectedListener;
      if (var3 != null) {
         var3.invoke(var1);
      }

   }

   private static final void onBindViewHolder$lambda$4(SearchedDevice var0, View var1) {
      Intrinsics.checkNotNull(var1);
      FragmentManager var4 = ViewKt.findFragment(var1).getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("MacAddressInfoDialogFragment", "getSimpleName(...)");
      if (!(var4.findFragmentByTag("MacAddressInfoDialogFragment") instanceof MacAddressInfoDialogFragment) && !var4.isStateSaved()) {
         MacAddressInfoDialogFragment.Companion var3;
         label17: {
            var3 = MacAddressInfoDialogFragment.Companion;
            Device var6 = var0.getDevice();
            if (var6 != null) {
               DeviceType var2 = var6.getType();
               var7 = var2;
               if (var2 != null) {
                  break label17;
               }
            }

            BluetoothDevice var5 = var0.getBluetoothDevice();
            if (var5 != null) {
               var7 = var5.getDeviceType();
            } else {
               var7 = null;
            }
         }

         ((DialogFragment)var3.newInstance(var7)).show(var4, "MacAddressInfoDialogFragment");
      }

   }

   private final void sortList() {
      List var1 = this.deviceList;
      if (var1.size() > 1) {
         CollectionsKt.sortWith(var1, new Comparator() {
            public final int compare(Object var1, Object var2) {
               var1 = var1;
               boolean var5 = var1.isOnline();
               byte var4 = 1;
               byte var3;
               if (var5) {
                  var3 = 0;
               } else if (var1.getDevice() != null) {
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               Comparable var7 = (Comparable)Integer.valueOf(var3);
               var2 = var2;
               if (var2.isOnline()) {
                  var3 = 0;
               } else if (var2.getDevice() != null) {
                  var3 = var4;
               } else {
                  var3 = 2;
               }

               return ComparisonsKt.compareValues(var7, (Comparable)Integer.valueOf(var3));
            }
         });
      }

   }

   public final Set getAcceptedSkus() {
      return this.acceptedSkus;
   }

   public int getItemCount() {
      return this.deviceList.size();
   }

   public void onBindViewHolder(SearchedDeviceHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      SearchedDevice var5 = (SearchedDevice)this.deviceList.get(var2);
      if (var5.isOnboarded()) {
         HasSKU var4 = var5.getDevice();
         Intrinsics.checkNotNull(var4);
         var4 = var4;
         HolderSearchedDeviceBinding var6 = var1.getBinding();
         TextView var7 = var6.modelName;
         DeviceType.Companion var9 = DeviceType.Companion;
         String var8 = var4.getSku();
         Intrinsics.checkNotNull(var8);
         var7.setText((CharSequence)var9.familyNameFromSku(var8));
         var6.deviceName.setText((CharSequence)var4.getName());
         AppCompatImageView var65 = var6.deviceImg;
         DeviceConfigProvider var68 = DeviceConfigProvider.INSTANCE;
         Device var49 = var4;
         DeviceImage var69 = var68.getDeviceImage(var49);
         if (var69 != null) {
            var2 = var69.getDevice();
         } else {
            var2 = 0;
         }

         var65.setImageResource(var2);
         if (var5.isOnline()) {
            if (var4 instanceof HasFanSpeed) {
               FilterLifeTime var50 = DeviceKt.getFilterLifeTime(var49);
               int var3 = var50.getFilterLife();
               var2 = DeviceConfigProvider.INSTANCE.getFilterStatusColor(var50);
               TextView var51 = var6.filterLeftValue;
               StringBuilder var66 = new StringBuilder();
               var66.append(var3);
               var66.append('%');
               var51.setText((CharSequence)var66.toString());
               var6.filterLeftValue.setTextColor(var2);
               var51 = var6.filterLeftLabel;
               Intrinsics.checkNotNullExpressionValue(var51, "filterLeftLabel");
               ViewExtensionsKt.show$default((View)var51, false, 1, (Object)null);
               var51 = var6.filterLeftValue;
               Intrinsics.checkNotNullExpressionValue(var51, "filterLeftValue");
               ViewExtensionsKt.show$default((View)var51, false, 1, (Object)null);
            } else {
               TextView var54 = var6.filterLeftLabel;
               Intrinsics.checkNotNullExpressionValue(var54, "filterLeftLabel");
               ViewExtensionsKt.hide((View)var54);
               var54 = var6.filterLeftValue;
               Intrinsics.checkNotNullExpressionValue(var54, "filterLeftValue");
               ViewExtensionsKt.hide((View)var54);
            }

            if (var4 instanceof HasWick) {
               var2 = ((HasWick)var4).getWickLifeLeft();
               TextView var15 = var6.wickLeftValue;
               StringBuilder var56 = new StringBuilder();
               var56.append(var2);
               var56.append('%');
               var15.setText((CharSequence)var56.toString());
               var6.wickLeftValue.setTextColor(DeviceConfigProvider.INSTANCE.getWickStatusColor(var2));
               var15 = var6.wickLeftLabel;
               Intrinsics.checkNotNullExpressionValue(var15, "wickLeftLabel");
               ViewExtensionsKt.show$default((View)var15, false, 1, (Object)null);
               var15 = var6.wickLeftValue;
               Intrinsics.checkNotNullExpressionValue(var15, "wickLeftValue");
               ViewExtensionsKt.show$default((View)var15, false, 1, (Object)null);
            } else {
               TextView var18 = var6.wickLeftLabel;
               Intrinsics.checkNotNullExpressionValue(var18, "wickLeftLabel");
               ViewExtensionsKt.hide((View)var18);
               var18 = var6.wickLeftValue;
               Intrinsics.checkNotNullExpressionValue(var18, "wickLeftValue");
               ViewExtensionsKt.hide((View)var18);
            }

            TextView var20 = var6.bluetoothStatus;
            Intrinsics.checkNotNullExpressionValue(var20, "bluetoothStatus");
            ViewExtensionsKt.hide((View)var20);
            var20 = var6.offlineLabel;
            Intrinsics.checkNotNullExpressionValue(var20, "offlineLabel");
            ViewExtensionsKt.hide((View)var20);
            var20 = var6.macLabel;
            Intrinsics.checkNotNullExpressionValue(var20, "macLabel");
            ViewExtensionsKt.hide((View)var20);
            var20 = var6.macNumber;
            Intrinsics.checkNotNullExpressionValue(var20, "macNumber");
            ViewExtensionsKt.hide((View)var20);
         } else if (var5.getBluetoothAvailable()) {
            TextView var24 = var6.filterLeftLabel;
            Intrinsics.checkNotNullExpressionValue(var24, "filterLeftLabel");
            ViewExtensionsKt.hide((View)var24);
            var24 = var6.filterLeftValue;
            Intrinsics.checkNotNullExpressionValue(var24, "filterLeftValue");
            ViewExtensionsKt.hide((View)var24);
            var24 = var6.wickLeftLabel;
            Intrinsics.checkNotNullExpressionValue(var24, "wickLeftLabel");
            ViewExtensionsKt.hide((View)var24);
            var24 = var6.wickLeftValue;
            Intrinsics.checkNotNullExpressionValue(var24, "wickLeftValue");
            ViewExtensionsKt.hide((View)var24);
            if (var5.isOnboarded()) {
               var24 = var6.offlineLabel;
               Intrinsics.checkNotNullExpressionValue(var24, "offlineLabel");
               ViewExtensionsKt.show$default((View)var24, false, 1, (Object)null);
               var24 = var6.macLabel;
               Intrinsics.checkNotNullExpressionValue(var24, "macLabel");
               ViewExtensionsKt.hide((View)var24);
               var24 = var6.macNumber;
               Intrinsics.checkNotNullExpressionValue(var24, "macNumber");
               ViewExtensionsKt.hide((View)var24);
            } else {
               var24 = var6.offlineLabel;
               Intrinsics.checkNotNullExpressionValue(var24, "offlineLabel");
               ViewExtensionsKt.hide((View)var24);
               var24 = var6.macLabel;
               Intrinsics.checkNotNullExpressionValue(var24, "macLabel");
               ViewExtensionsKt.show$default((View)var24, false, 1, (Object)null);
               TextView var57 = var6.macNumber;
               BluetoothDevice var33 = var5.getBluetoothDevice();
               String var34;
               if (var33 != null) {
                  var34 = var33.getWifiMac();
               } else {
                  var34 = null;
               }

               var57.setText((CharSequence)var34);
               TextView var35 = var6.macNumber;
               Intrinsics.checkNotNullExpressionValue(var35, "macNumber");
               ViewExtensionsKt.show$default((View)var35, false, 1, (Object)null);
            }

            var6.bluetoothStatus.setText(R.string.available);
            TextViewCompat.setCompoundDrawableTintList(var6.bluetoothStatus, ColorStateList.valueOf(onBindViewHolder$getColor(var1, R.color.colorPrimary)));
            var24 = var6.bluetoothStatus;
            Intrinsics.checkNotNullExpressionValue(var24, "bluetoothStatus");
            ViewExtensionsKt.show$default((View)var24, false, 1, (Object)null);
         } else {
            TextView var37 = var6.filterLeftLabel;
            Intrinsics.checkNotNullExpressionValue(var37, "filterLeftLabel");
            ViewExtensionsKt.hide((View)var37);
            var37 = var6.filterLeftValue;
            Intrinsics.checkNotNullExpressionValue(var37, "filterLeftValue");
            ViewExtensionsKt.hide((View)var37);
            var37 = var6.wickLeftLabel;
            Intrinsics.checkNotNullExpressionValue(var37, "wickLeftLabel");
            ViewExtensionsKt.hide((View)var37);
            var37 = var6.wickLeftValue;
            Intrinsics.checkNotNullExpressionValue(var37, "wickLeftValue");
            ViewExtensionsKt.hide((View)var37);
            var37 = var6.offlineLabel;
            Intrinsics.checkNotNullExpressionValue(var37, "offlineLabel");
            ViewExtensionsKt.show$default((View)var37, false, 1, (Object)null);
            var37 = var6.macLabel;
            Intrinsics.checkNotNullExpressionValue(var37, "macLabel");
            ViewExtensionsKt.hide((View)var37);
            var37 = var6.macNumber;
            Intrinsics.checkNotNullExpressionValue(var37, "macNumber");
            ViewExtensionsKt.hide((View)var37);
            var6.bluetoothStatus.setText(R.string.unavailable);
            TextViewCompat.setCompoundDrawableTintList(var6.bluetoothStatus, ColorStateList.valueOf(onBindViewHolder$getColor(var1, R.color.dark_grey)));
            var37 = var6.bluetoothStatus;
            Intrinsics.checkNotNullExpressionValue(var37, "bluetoothStatus");
            ViewExtensionsKt.show$default((View)var37, false, 1, (Object)null);
         }
      } else if (var5.getBluetoothAvailable()) {
         BluetoothDevice var47 = var5.getBluetoothDevice();
         Intrinsics.checkNotNull(var47);
         HolderSearchedDeviceBinding var45 = var1.getBinding();
         var45.modelName.setText((CharSequence)var47.getFamilyName());
         var45.deviceName.setText((CharSequence)var47.getModelName());
         AppCompatImageView var67 = var45.deviceImg;
         DeviceImage var58 = DeviceConfigProvider.INSTANCE.getDeviceImage(var47);
         if (var58 != null) {
            var2 = var58.getDevice();
         } else {
            var2 = 0;
         }

         var67.setImageResource(var2);
         TextView var59 = var45.filterLeftLabel;
         Intrinsics.checkNotNullExpressionValue(var59, "filterLeftLabel");
         ViewExtensionsKt.hide((View)var59);
         var59 = var45.filterLeftValue;
         Intrinsics.checkNotNullExpressionValue(var59, "filterLeftValue");
         ViewExtensionsKt.hide((View)var59);
         var59 = var45.wickLeftLabel;
         Intrinsics.checkNotNullExpressionValue(var59, "wickLeftLabel");
         ViewExtensionsKt.hide((View)var59);
         var59 = var45.wickLeftValue;
         Intrinsics.checkNotNullExpressionValue(var59, "wickLeftValue");
         ViewExtensionsKt.hide((View)var59);
         var59 = var45.offlineLabel;
         Intrinsics.checkNotNullExpressionValue(var59, "offlineLabel");
         ViewExtensionsKt.hide((View)var59);
         var59 = var45.macLabel;
         Intrinsics.checkNotNullExpressionValue(var59, "macLabel");
         ViewExtensionsKt.show$default((View)var59, false, 1, (Object)null);
         var45.macNumber.setText((CharSequence)var47.getWifiMac());
         TextView var48 = var45.macNumber;
         Intrinsics.checkNotNullExpressionValue(var48, "macNumber");
         ViewExtensionsKt.show$default((View)var48, false, 1, (Object)null);
         var45.bluetoothStatus.setText(R.string.available);
         TextViewCompat.setCompoundDrawableTintList(var45.bluetoothStatus, ColorStateList.valueOf(onBindViewHolder$getColor(var1, R.color.colorPrimary)));
         TextView var46 = var45.bluetoothStatus;
         Intrinsics.checkNotNullExpressionValue(var46, "bluetoothStatus");
         ViewExtensionsKt.show$default((View)var46, false, 1, (Object)null);
      }

      var1.itemView.setOnClickListener(new SearchedDeviceAdapter$$ExternalSyntheticLambda0(this, var5));
      var1.getBinding().macLabel.setOnClickListener(new SearchedDeviceAdapter$$ExternalSyntheticLambda1(var5));
   }

   public SearchedDeviceHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      HolderSearchedDeviceBinding var3 = HolderSearchedDeviceBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return new SearchedDeviceHolder(var3);
   }

   public final void setAcceptedSkus(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.acceptedSkus = var1;
   }

   public final void setOnDeviceSelectedListener(Function1 var1) {
      this.onDeviceSelectedListener = var1;
   }

   public final void updateBluetoothDevices(List var1) {
      Intrinsics.checkNotNullParameter(var1, "devices");
      Iterable var8 = (Iterable)var1;
      Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
      Iterator var13 = var8.iterator();

      while(var13.hasNext()) {
         var7.add(((BluetoothDevice)var13.next()).getWifiMac());
      }

      Set var9 = CollectionsKt.toSet((Iterable)((List)var7));
      Iterable var14 = (Iterable)this.deviceList;
      Collection var10 = (Collection)(new ArrayList());
      Iterator var11 = var14.iterator();

      while(true) {
         boolean var6 = var11.hasNext();
         Object var21 = null;
         if (!var6) {
            Iterator var16 = ((Iterable)((List)var10)).iterator();
            int var2 = 0;

            while(true) {
               var6 = var16.hasNext();
               byte var5 = -1;
               if (!var6) {
                  for(BluetoothDevice var25 : var8) {
                     if (this.acceptedSkus.contains(var25.getSku())) {
                        Iterator var26 = ((Iterable)this.deviceList).iterator();

                        do {
                           if (!var26.hasNext()) {
                              var17 = null;
                              break;
                           }

                           var17 = var26.next();
                           var29 = ((SearchedDevice)var17).getWifiMac();
                           var31 = var25.getWifiMac().toLowerCase(Locale.ROOT);
                           Intrinsics.checkNotNullExpressionValue(var31, "toLowerCase(...)");
                        } while(!Intrinsics.areEqual(var29, var31));

                        SearchedDevice var27 = (SearchedDevice)var17;
                        if (var27 == null || var27.getBluetoothDevice() == null) {
                           if (var27 == null) {
                              var2 = -1;
                           } else {
                              var2 = this.deviceList.indexOf(var27);
                           }

                           if (var2 >= 0) {
                              List var18 = this.deviceList;
                              Intrinsics.checkNotNull(var27);
                              var18.set(var2, SearchedDevice.copy$default(var27, (Device)null, var25, 1, (Object)null));
                           } else {
                              this.deviceList.add(new SearchedDevice((Device)null, var25));
                           }

                           var2 = 1;
                        }
                     }
                  }

                  if (var2) {
                     this.sortList();
                     this.notifyDataSetChanged();
                  }

                  return;
               }

               String var22 = (String)var16.next();
               if (!var9.contains(var22)) {
                  Iterator var33 = this.deviceList.iterator();
                  int var3 = 0;

                  int var4;
                  while(true) {
                     var4 = var5;
                     if (!var33.hasNext()) {
                        break;
                     }

                     String var30 = ((SearchedDevice)var33.next()).getWifiMac();
                     String var28 = var22.toLowerCase(Locale.ROOT);
                     Intrinsics.checkNotNullExpressionValue(var28, "toLowerCase(...)");
                     if (Intrinsics.areEqual(var30, var28)) {
                        var4 = var3;
                        break;
                     }

                     ++var3;
                  }

                  if (var4 >= 0) {
                     SearchedDevice var23 = (SearchedDevice)this.deviceList.get(var4);
                     if (var23.isOnboarded()) {
                        this.deviceList.set(var4, SearchedDevice.copy$default(var23, (Device)null, (BluetoothDevice)null, 1, (Object)null));
                     } else {
                        this.deviceList.remove(var4);
                     }

                     var2 = 1;
                  }
               }
            }
         }

         SearchedDevice var12 = (SearchedDevice)var11.next();
         String var15 = (String)var21;
         if (var12.getBluetoothAvailable()) {
            BluetoothDevice var32 = var12.getBluetoothDevice();
            var15 = (String)var21;
            if (var32 != null) {
               var15 = var32.getWifiMac();
            }
         }

         if (var15 != null) {
            var10.add(var15);
         }
      }
   }

   public final void updateOnboardedDevices(List var1) {
      Intrinsics.checkNotNullParameter(var1, "devices");
      Iterator var5 = ((Iterable)var1).iterator();
      int var2 = 0;

      while(var5.hasNext()) {
         Device var4 = (Device)var5.next();
         if (var4 instanceof HasSKU && CollectionsKt.contains((Iterable)this.acceptedSkus, ((HasSKU)var4).getSku())) {
            Iterator var3 = ((Iterable)this.deviceList).iterator();

            do {
               if (!var3.hasNext()) {
                  var7 = null;
                  break;
               }

               var7 = var3.next();
            } while(!Intrinsics.areEqual(((SearchedDevice)var7).getWifiMac(), var4.getMac()));

            SearchedDevice var6 = (SearchedDevice)var7;
            if (var6 != null && var6.getDevice() != null && var6.getDevice().getConnectivityStatusIndex() == var4.getConnectivityStatusIndex() && Intrinsics.areEqual(var6.getDevice().getName(), var4.getName())) {
               HasFanSpeed var8 = var6.getDevice();
               if (var8 instanceof HasFanSpeed) {
                  var8 = var8;
               } else {
                  var8 = null;
               }

               Integer var10;
               if (var8 != null) {
                  var10 = var8.getFilterLife();
               } else {
                  var10 = null;
               }

               HasFanSpeed var16;
               if (var4 instanceof HasFanSpeed) {
                  var16 = (HasFanSpeed)var4;
               } else {
                  var16 = null;
               }

               Integer var17;
               if (var16 != null) {
                  var17 = var16.getFilterLife();
               } else {
                  var17 = null;
               }

               if (Intrinsics.areEqual(var10, var17)) {
                  Device var11 = var6.getDevice();
                  HasWick var12;
                  if (var11 instanceof HasWick) {
                     var12 = (HasWick)var11;
                  } else {
                     var12 = null;
                  }

                  Integer var13;
                  if (var12 != null) {
                     var13 = var12.getWickUsage();
                  } else {
                     var13 = null;
                  }

                  HasWick var18;
                  if (var4 instanceof HasWick) {
                     var18 = (HasWick)var4;
                  } else {
                     var18 = null;
                  }

                  Integer var19;
                  if (var18 != null) {
                     var19 = var18.getWickUsage();
                  } else {
                     var19 = null;
                  }

                  if (Intrinsics.areEqual(var13, var19)) {
                     continue;
                  }
               }
            }

            if (var6 == null) {
               var2 = -1;
            } else {
               var2 = this.deviceList.indexOf(var6);
            }

            if (var2 >= 0) {
               var1 = this.deviceList;
               Intrinsics.checkNotNull(var6);
               var1.set(var2, SearchedDevice.copy$default(var6, var4, (BluetoothDevice)null, 2, (Object)null));
            } else {
               this.deviceList.add(new SearchedDevice(var4, (BluetoothDevice)null));
            }

            var2 = 1;
         }
      }

      if (var2) {
         this.sortList();
         this.notifyDataSetChanged();
      }

   }
}
