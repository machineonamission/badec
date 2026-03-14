package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.Pollutant;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.outdoor.databinding.HolderSavedLocationBinding;
import com.blueair.outdoor.ui.dialog.LocationEditNameDialogFragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.OutdoorUiUtils;
import com.blueair.viewcore.view.AllQualityStatusView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0092\u0001\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001f2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0013\u0018\u00010#2*\b\u0002\u0010$\u001a$\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u0013\u0018\u00010%J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010(\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010\u0018\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "binding", "Lcom/blueair/outdoor/databinding/HolderSavedLocationBinding;", "getBinding", "()Lcom/blueair/outdoor/databinding/HolderSavedLocationBinding;", "configureAs", "", "type", "Lcom/blueair/outdoor/ui/adapters/LocationView$TYPE;", "showAssignProduct", "", "bind", "data", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "mapType", "", "isSaveEnabled", "onSaveClicked", "Lkotlin/Function2;", "Lcom/blueair/core/model/TrackedLocation;", "Lcom/blueair/core/model/AqiData;", "onDeleteClicked", "Lkotlin/Function1;", "onAssignClicked", "Lkotlin/Function3;", "", "Lcom/blueair/core/model/Device;", "location", "pollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "devices", "TYPE", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationView extends ConstraintLayout {
   private final HolderSavedLocationBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$380OT29IX1YpDAxCHp1MT1q5N44(View var0) {
      bind$lambda$5(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5EmLDD7WCmECr054GJl9g_Himds(LocationView var0, LocationItem var1, TYPE var2, String var3, boolean var4, boolean var5, Function2 var6, Function1 var7, Function3 var8, View var9) {
      bind$lambda$4(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Tv_M4zFNU8ZDRvCfzr9ZlDByE5E/* $FF was: $r8$lambda$Tv-M4zFNU8ZDRvCfzr9ZlDByE5E*/(LocationItem var0, boolean var1, Function3 var2, Function2 var3, LocationView var4, View var5) {
      bind$lambda$7(var0, var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ZsUCwUy4C47gCI6YQMpFDgnoWpY(LocationItem var0, Function1 var1, View var2) {
      bind$lambda$9(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$s9Hj98vmOhrAKS2mokLL75s0AIk(TYPE var0, LocationView var1, LocationItem var2, String var3, boolean var4, boolean var5, Function2 var6, Function1 var7, Function3 var8, String var9) {
      return bind$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   // $FF: synthetic method
   public static void $r8$lambda$u0QWXPjBEZVvIY1lpLqhgX9U0Kw(LocationItem var0, Function3 var1, View var2) {
      bind$lambda$13(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ujasvXeua2XMmfZK0N17mO6Qsos(LocationItem var0, Function3 var1, View var2) {
      bind$lambda$11(var0, var1, var2);
   }

   public LocationView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      HolderSavedLocationBinding var2 = HolderSavedLocationBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
      this.binding = var2;
   }

   public LocationView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      HolderSavedLocationBinding var3 = HolderSavedLocationBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
   }

   public LocationView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      HolderSavedLocationBinding var4 = HolderSavedLocationBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
   }

   public LocationView(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3, var4);
      HolderSavedLocationBinding var5 = HolderSavedLocationBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
   }

   private final void bind(OutdoorPollutants var1) {
      this.binding.qualityContainers.bind(var1);
      AllQualityStatusView var6 = this.binding.qualityContainers;
      Intrinsics.checkNotNullExpressionValue(var6, "qualityContainers");
      ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
      Pollutant var7 = var1.getAqi();
      if (var7 != null) {
         Double var8 = var7.getConcentration();
         if (var8 != null) {
            double var2 = ((Number)var8).doubleValue();
            this.binding.aqiValue.setText((CharSequence)this.getResources().getString(R.string.saved_location_aqi, new Object[]{(int)var2}));
            int var4 = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition((float)var2, PollutantType.AQI.INSTANCE);
            if (var4 < 0) {
               Timber.Forest var9 = Timber.Forest;
               StringBuilder var11 = new StringBuilder("bind: rangePos ");
               var11.append(var4);
               var11.append(" for value ");
               var11.append(var2);
               var11.append(" is not found");
               var9.w(var11.toString(), new Object[0]);
               var4 = OutdoorAirRatingRanges.INSTANCE.getMaxPollutantRangePosition(PollutantType.AQI.INSTANCE);
            }

            int var5 = this.getResources().getColor(((Number)OutdoorUiUtils.INSTANCE.getAqiSeverityColorsNew().get(var4)).intValue(), (Resources.Theme)null);
            String var10 = this.getResources().getStringArray(R.array.severity_strings)[var4];
            this.binding.aqiSeverity.setText((CharSequence)var10);
            this.binding.aqiIcon.setBackgroundTintList(ColorStateList.valueOf(var5));
         }
      }

   }

   private final void bind(TrackedLocation var1, String var2) {
      ConstraintLayout var5 = this.binding.addressContainer;
      Intrinsics.checkNotNullExpressionValue(var5, "addressContainer");
      ViewExtensionsKt.show$default((View)var5, false, 1, (Object)null);
      this.binding.primaryText.setText((CharSequence)var1.getLocationName());
      TextView var6 = this.binding.secondaryText;
      String var3 = var1.getCityName();
      CharSequence var4;
      if (var3 != null) {
         var4 = (CharSequence)var3;
      } else {
         var4 = (CharSequence)var1.getCountryName();
      }

      var6.setText(var4);
   }

   private final void bind(List var1) {
      TextView var2 = this.binding.assignProduct;
      Intrinsics.checkNotNullExpressionValue(var2, "assignProduct");
      ViewExtensionsKt.hide((View)var2);
      var2 = this.binding.assignedProducts;
      Intrinsics.checkNotNullExpressionValue(var2, "assignedProducts");
      ViewExtensionsKt.hide((View)var2);
   }

   // $FF: synthetic method
   public static void bind$default(LocationView var0, LocationItem var1, String var2, TYPE var3, boolean var4, boolean var5, Function2 var6, Function1 var7, Function3 var8, int var9, Object var10) {
      if ((var9 & 32) != 0) {
         var6 = null;
      }

      if ((var9 & 64) != 0) {
         var7 = null;
      }

      if ((var9 & 128) != 0) {
         var8 = null;
      }

      var0.bind(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   private static final void bind$lambda$11(LocationItem var0, Function3 var1, View var2) {
      if (var0 != null) {
         TrackedLocation var3 = var0.getLocation();
         if (var3 != null && var1 != null) {
            var1.invoke(var3, var0.getAssignedDevices(), (Object)null);
         }
      }

   }

   private static final void bind$lambda$13(LocationItem var0, Function3 var1, View var2) {
      if (var0 != null) {
         TrackedLocation var3 = var0.getLocation();
         if (var3 != null && var1 != null) {
            var1.invoke(var3, var0.getAssignedDevices(), (Object)null);
         }
      }

   }

   private static final void bind$lambda$4(LocationView var0, LocationItem var1, TYPE var2, String var3, boolean var4, boolean var5, Function2 var6, Function1 var7, Function3 var8, View var9) {
      Context var13 = var0.binding.primaryText.getContext();
      FragmentActivity var14;
      if (var13 instanceof FragmentActivity) {
         var14 = (FragmentActivity)var13;
      } else {
         var14 = null;
      }

      if (var14 != null) {
         FragmentManager var11 = var14.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var11, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("LocationEditNameDialogFragment", "getSimpleName(...)");
         if (!(var11.findFragmentByTag("LocationEditNameDialogFragment") instanceof LocationEditNameDialogFragment) && !var11.isStateSaved()) {
            LocationEditNameDialogFragment.Companion var12 = LocationEditNameDialogFragment.Companion;
            String var10 = var1.getLocation().getLocationName();
            String var15 = var10;
            if (var10 == null) {
               var15 = "";
            }

            LocationEditNameDialogFragment var16 = var12.newInstance(var15);
            var16.setOnSaveListener(new LocationView$$ExternalSyntheticLambda6(var2, var0, var1, var3, var4, var5, var6, var7, var8));
            ((DialogFragment)var16).show(var11, "LocationEditNameDialogFragment");
         }
      }

   }

   private static final Unit bind$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(TYPE var0, LocationView var1, LocationItem var2, String var3, boolean var4, boolean var5, Function2 var6, Function1 var7, Function3 var8, String var9) {
      Intrinsics.checkNotNullParameter(var9, "text");
      if (var0 == LocationView.TYPE.ADD_LOCATION) {
         var1.bind(LocationItem.copy$default(var2, TrackedLocation.copy$default(var2.getLocation(), (String)null, (double)0.0F, (double)0.0F, var9, (String)null, (String)null, (String)null, (String)null, (String)null, 503, (Object)null), (AqiData)null, (List)null, 6, (Object)null), var3, var0, var4, var5, var6, var7, var8);
      } else if (var6 != null) {
         var6.invoke(TrackedLocation.copy$default(var2.getLocation(), (String)null, (double)0.0F, (double)0.0F, var9, (String)null, (String)null, (String)null, (String)null, (String)null, 503, (Object)null), var2.getAqiData());
      }

      return Unit.INSTANCE;
   }

   private static final void bind$lambda$5(View var0) {
   }

   private static final void bind$lambda$7(LocationItem var0, boolean var1, Function3 var2, Function2 var3, LocationView var4, View var5) {
      if (var0 != null) {
         if (var1) {
            if (var2 != null) {
               FrameLayout var6 = var4.binding.progressBar;
               Intrinsics.checkNotNullExpressionValue(var6, "progressBar");
               ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
               var2.invoke(var0.getLocation(), CollectionsKt.emptyList(), var0.getAqiData());
               return;
            }
         } else if (var3 != null) {
            var3.invoke(var0.getLocation(), var0.getAqiData());
         }
      }

   }

   private static final void bind$lambda$9(LocationItem var0, Function1 var1, View var2) {
      if (var0 != null) {
         TrackedLocation var3 = var0.getLocation();
         if (var3 != null && var1 != null) {
            var1.invoke(var3);
         }
      }

   }

   private final void configureAs(TYPE var1, boolean var2) {
      FrameLayout var4 = this.binding.progressBar;
      Intrinsics.checkNotNullExpressionValue(var4, "progressBar");
      ViewExtensionsKt.hide((View)var4);
      int var3 = LocationView.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               if (var3 != 4) {
                  if (var3 != 5) {
                     throw new NoWhenBranchMatchedException();
                  }

                  ConstraintLayout var5 = this.binding.noDataContainer;
                  Intrinsics.checkNotNullExpressionValue(var5, "noDataContainer");
                  ViewExtensionsKt.show$default((View)var5, false, 1, (Object)null);
                  var5 = this.binding.addressContainer;
                  Intrinsics.checkNotNullExpressionValue(var5, "addressContainer");
                  ViewExtensionsKt.hide((View)var5);
                  AllQualityStatusView var7 = this.binding.qualityContainers;
                  Intrinsics.checkNotNullExpressionValue(var7, "qualityContainers");
                  ViewExtensionsKt.hide((View)var7);
                  var7 = this.binding.assignContainer;
                  Intrinsics.checkNotNullExpressionValue(var7, "assignContainer");
                  ViewExtensionsKt.hide((View)var7);
                  var7 = this.binding.saveContainer;
                  Intrinsics.checkNotNullExpressionValue(var7, "saveContainer");
                  ViewExtensionsKt.hide((View)var7);
               } else {
                  ConstraintLayout var10 = this.binding.noDataContainer;
                  Intrinsics.checkNotNullExpressionValue(var10, "noDataContainer");
                  ViewExtensionsKt.hide((View)var10);
                  var10 = this.binding.addressContainer;
                  Intrinsics.checkNotNullExpressionValue(var10, "addressContainer");
                  ViewExtensionsKt.show$default((View)var10, false, 1, (Object)null);
                  AllQualityStatusView var12 = this.binding.qualityContainers;
                  Intrinsics.checkNotNullExpressionValue(var12, "qualityContainers");
                  ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
                  var12 = this.binding.assignContainer;
                  Intrinsics.checkNotNullExpressionValue(var12, "assignContainer");
                  ViewExtensionsKt.hide((View)var12);
                  var12 = this.binding.saveContainer;
                  Intrinsics.checkNotNullExpressionValue(var12, "saveContainer");
                  ViewExtensionsKt.hide((View)var12);
               }
            } else {
               ConstraintLayout var15 = this.binding.noDataContainer;
               Intrinsics.checkNotNullExpressionValue(var15, "noDataContainer");
               ViewExtensionsKt.hide((View)var15);
               var15 = this.binding.addressContainer;
               Intrinsics.checkNotNullExpressionValue(var15, "addressContainer");
               ViewExtensionsKt.show$default((View)var15, false, 1, (Object)null);
               AllQualityStatusView var17 = this.binding.qualityContainers;
               Intrinsics.checkNotNullExpressionValue(var17, "qualityContainers");
               ViewExtensionsKt.show$default((View)var17, false, 1, (Object)null);
               var17 = this.binding.assignContainer;
               Intrinsics.checkNotNullExpressionValue(var17, "assignContainer");
               ViewExtensionsKt.hide((View)var17);
               var17 = this.binding.saveContainer;
               Intrinsics.checkNotNullExpressionValue(var17, "saveContainer");
               ViewExtensionsKt.show$default((View)var17, false, 1, (Object)null);
            }
         } else {
            ConstraintLayout var20 = this.binding.noDataContainer;
            Intrinsics.checkNotNullExpressionValue(var20, "noDataContainer");
            ViewExtensionsKt.hide((View)var20);
            var20 = this.binding.addressContainer;
            Intrinsics.checkNotNullExpressionValue(var20, "addressContainer");
            ViewExtensionsKt.show$default((View)var20, false, 1, (Object)null);
            AllQualityStatusView var22 = this.binding.qualityContainers;
            Intrinsics.checkNotNullExpressionValue(var22, "qualityContainers");
            ViewExtensionsKt.show$default((View)var22, false, 1, (Object)null);
            var22 = this.binding.assignContainer;
            Intrinsics.checkNotNullExpressionValue(var22, "assignContainer");
            ViewExtensionsKt.show((View)var22, var2 ^ true);
            var22 = this.binding.saveContainer;
            Intrinsics.checkNotNullExpressionValue(var22, "saveContainer");
            ViewExtensionsKt.show((View)var22, var2);
         }
      } else {
         ConstraintLayout var25 = this.binding.noDataContainer;
         Intrinsics.checkNotNullExpressionValue(var25, "noDataContainer");
         ViewExtensionsKt.hide((View)var25);
         var25 = this.binding.addressContainer;
         Intrinsics.checkNotNullExpressionValue(var25, "addressContainer");
         ViewExtensionsKt.show$default((View)var25, false, 1, (Object)null);
         AllQualityStatusView var27 = this.binding.qualityContainers;
         Intrinsics.checkNotNullExpressionValue(var27, "qualityContainers");
         ViewExtensionsKt.show$default((View)var27, false, 1, (Object)null);
         var27 = this.binding.assignContainer;
         Intrinsics.checkNotNullExpressionValue(var27, "assignContainer");
         ViewExtensionsKt.show$default((View)var27, false, 1, (Object)null);
         var27 = this.binding.saveContainer;
         Intrinsics.checkNotNullExpressionValue(var27, "saveContainer");
         ViewExtensionsKt.hide((View)var27);
      }

      Button var30 = this.binding.saveBtn;
      if (var2) {
         var3 = R.string.outdoor_assign_popup_title;
      } else {
         var3 = R.string.button_save;
      }

      var30.setText(var3);
   }

   public final void bind(LocationItem var1, String var2, TYPE var3, boolean var4, boolean var5, Function2 var6, Function1 var7, Function3 var8) {
      Intrinsics.checkNotNullParameter(var2, "mapType");
      Intrinsics.checkNotNullParameter(var3, "type");
      this.configureAs(var3, var4);
      if (SetsKt.setOf(new TYPE[]{LocationView.TYPE.ADD_LOCATION, LocationView.TYPE.SAVED_LOCATION}).contains(var3) && var1 != null) {
         this.binding.primaryText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_edit2, 0);
         this.binding.primaryText.setOnClickListener(new LocationView$$ExternalSyntheticLambda0(this, var1, var3, var2, var5, var4, var6, var7, var8));
      } else {
         this.binding.primaryText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
         this.binding.primaryText.setOnClickListener(new LocationView$$ExternalSyntheticLambda1());
      }

      this.binding.saveBtn.setOnClickListener(new LocationView$$ExternalSyntheticLambda2(var1, var4, var8, var6, this));
      this.binding.delete.setOnClickListener(new LocationView$$ExternalSyntheticLambda3(var1, var7));
      this.binding.assignProduct.setOnClickListener(new LocationView$$ExternalSyntheticLambda4(var1, var8));
      this.binding.assignedProducts.setOnClickListener(new LocationView$$ExternalSyntheticLambda5(var1, var8));
      if (var1 != null) {
         this.bind(var1.getLocation(), var2);
         OutdoorPollutants var14 = var1.getAqiData().getPollutants();
         if (var14 != null) {
            this.bind(var14);
         }

         this.bind(var1.getAssignedDevices());
      }

      int var9 = LocationView.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      if (var9 != 3) {
         if (var9 == 5) {
            FrameLayout var13 = this.binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(var13, "progressBar");
            ViewExtensionsKt.hide((View)var13);
         }
      } else if (var1 == null) {
         FrameLayout var12 = this.binding.progressBar;
         Intrinsics.checkNotNullExpressionValue(var12, "progressBar");
         ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
      } else {
         FrameLayout var10 = this.binding.progressBar;
         Intrinsics.checkNotNullExpressionValue(var10, "progressBar");
         ViewExtensionsKt.hide((View)var10);
         ConstraintLayout var11 = this.binding.saveContainer;
         Intrinsics.checkNotNullExpressionValue(var11, "saveContainer");
         ViewExtensionsKt.show((View)var11, var5);
      }
   }

   public final HolderSavedLocationBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"},
      d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationView$TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "ASSIGNED", "SAVED_LOCATION", "ADD_LOCATION", "CURRENT_LOCATION", "NO_DATA", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum TYPE {
      private static final EnumEntries $ENTRIES;
      private static final TYPE[] $VALUES;
      ADD_LOCATION,
      ASSIGNED,
      CURRENT_LOCATION,
      NO_DATA,
      SAVED_LOCATION;

      // $FF: synthetic method
      private static final TYPE[] $values() {
         return new TYPE[]{ASSIGNED, SAVED_LOCATION, ADD_LOCATION, CURRENT_LOCATION, NO_DATA};
      }

      static {
         TYPE[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[LocationView.TYPE.values().length];

         try {
            var0[LocationView.TYPE.ASSIGNED.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[LocationView.TYPE.SAVED_LOCATION.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[LocationView.TYPE.ADD_LOCATION.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[LocationView.TYPE.CURRENT_LOCATION.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[LocationView.TYPE.NO_DATA.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
