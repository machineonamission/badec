package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.devicedetails.viewholder.LinkedDeviceHolder;
import com.blueair.viewcore.R;
import com.blueair.viewcore.viewholder.EmptyStateHolder;
import io.reactivex.subjects.PublishSubject;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020#H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010%\u001a\u00020#H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010!¨\u0006."},
   d2 = {"Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/adapter/LinkedDeviceSelectionAction;", "<init>", "(Lio/reactivex/subjects/PublishSubject;)V", "parentDevice", "Lcom/blueair/core/model/HasLinkingCapability;", "getParentDevice", "()Lcom/blueair/core/model/HasLinkingCapability;", "setParentDevice", "(Lcom/blueair/core/model/HasLinkingCapability;)V", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "getLinkedDevice", "()Lcom/blueair/core/model/DeviceAware;", "value", "", "awares", "getAwares", "()Ljava/util/List;", "setAwares", "(Ljava/util/List;)V", "hasEmptyState", "", "getHasEmptyState", "()Z", "nuAware", "selectedAware", "getSelectedAware", "setSelectedAware", "(Lcom/blueair/core/model/DeviceAware;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LinkedDevicesAdapter extends RecyclerView.Adapter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int TYPE_AWARE = 1;
   public static final int TYPE_EMPTY_STATE = 0;
   private List awares;
   private final PublishSubject deviceSelectedPublisher;
   private HasLinkingCapability parentDevice;
   private DeviceAware selectedAware;

   // $FF: synthetic method
   public static void $r8$lambda$MAlK5Mlp7_beKWjTnKxVaWFZ1_Q/* $FF was: $r8$lambda$MAlK5Mlp7_beKWjTnKxVaWFZ1-Q*/(LinkedDevicesAdapter var0, DeviceAware var1, View var2) {
      onBindViewHolder$lambda$7(var0, var1, var2);
   }

   public LinkedDevicesAdapter(PublishSubject var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceSelectedPublisher");
      super();
      this.deviceSelectedPublisher = var1;
      this.awares = CollectionsKt.emptyList();
   }

   private final boolean getHasEmptyState() {
      return this.awares.isEmpty();
   }

   private static final void onBindViewHolder$lambda$7(LinkedDevicesAdapter var0, DeviceAware var1, View var2) {
      HasLinkingCapability var3 = var0.parentDevice;
      if (var3 != null) {
         var0.deviceSelectedPublisher.onNext(new LinkedDeviceSelectionAction(var3, var1));
      }

   }

   public final List getAwares() {
      return this.awares;
   }

   public int getItemCount() {
      return this.getHasEmptyState() ? 1 : this.awares.size();
   }

   public int getItemViewType(int var1) {
      return this.getHasEmptyState() ^ 1;
   }

   public final DeviceAware getLinkedDevice() {
      Iterator var5 = ((Iterable)this.awares).iterator();

      Object var2;
      while(true) {
         boolean var1 = var5.hasNext();
         var2 = null;
         Object var4 = null;
         if (!var1) {
            break;
         }

         Object var3 = var5.next();
         String var6 = ((DeviceAware)var3).getUid();
         HasLinkingCapability var7 = this.parentDevice;
         String var8 = (String)var4;
         if (var7 != null) {
            var8 = var7.getLinkedToUid();
         }

         if (Intrinsics.areEqual(var6, var8)) {
            var2 = var3;
            break;
         }
      }

      return (DeviceAware)var2;
   }

   public final HasLinkingCapability getParentDevice() {
      return this.parentDevice;
   }

   public final DeviceAware getSelectedAware() {
      return this.selectedAware;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("Binding adapter at position ");
      var4.append(var2);
      var3.v(var4.toString(), new Object[0]);
      if (var1 instanceof LinkedDeviceHolder) {
         DeviceAware var5;
         String var6;
         LinkedDeviceHolder var7;
         label23: {
            var5 = (DeviceAware)this.awares.get(var2);
            var7 = (LinkedDeviceHolder)var1;
            var6 = var5.getName();
            DeviceAware var12 = this.selectedAware;
            var9 = null;
            DeviceAware var10;
            if (var12 != null) {
               if (var12 == null) {
                  break label23;
               }

               var10 = var12;
            } else {
               var12 = this.getLinkedDevice();
               if (var12 == null) {
                  break label23;
               }

               var10 = var12;
            }

            var9 = var10.getUid();
         }

         var7.update(var6, Intrinsics.areEqual(var9, var5.getUid()));
         var7.getClickView().setOnClickListener(new LinkedDevicesAdapter$$ExternalSyntheticLambda0(this, var5));
      }

      if (var1 instanceof EmptyStateHolder) {
         EmptyStateHolder var11 = (EmptyStateHolder)var1;
         String var8 = var1.itemView.getContext().getString(R.string.no_aware);
         Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
         var11.update(var8);
      }

   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      if (var2 != 0) {
         if (var2 == 1) {
            return LinkedDeviceHolder.Companion.newInstance(var1);
         } else {
            throw new RuntimeException("View Type does not exist.");
         }
      } else {
         return EmptyStateHolder.Companion.newInstance(var1);
      }
   }

   public final void setAwares(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.awares = CollectionsKt.sortedWith((Iterable)var1, new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((DeviceAware)var1).getName(), (Comparable)((DeviceAware)var2).getName());
         }
      });
      this.notifyDataSetChanged();
   }

   public final void setParentDevice(HasLinkingCapability var1) {
      this.parentDevice = var1;
   }

   public final void setSelectedAware(DeviceAware var1) {
      int var2;
      byte var3;
      label125: {
         DeviceAware var7 = this.selectedAware;
         this.selectedAware = var1;
         var3 = -1;
         int var4 = 0;
         var2 = 0;
         if (var7 == null) {
            String var5;
            if (var1 != null) {
               var5 = var1.getUid();
            } else {
               var5 = null;
            }

            HasLinkingCapability var6 = this.parentDevice;
            String var20;
            if (var6 != null) {
               var20 = var6.getLinkedToUid();
            } else {
               var20 = null;
            }

            if (Intrinsics.areEqual(var5, var20)) {
               break label125;
            }
         }

         if (!Intrinsics.areEqual(var1, var7)) {
            if (!Intrinsics.areEqual(var1, var7)) {
               if (var7 != null) {
                  Iterator var16 = this.awares.iterator();
                  var2 = 0;

                  while(true) {
                     if (!var16.hasNext()) {
                        var2 = -1;
                        break;
                     }

                     if (Intrinsics.areEqual(((DeviceAware)var16.next()).getUid(), var7.getUid())) {
                        break;
                     }

                     ++var2;
                  }

                  if (var2 >= 0) {
                     this.notifyItemChanged(var2);
                  }
               } else {
                  String var13;
                  if (var1 != null) {
                     var13 = var1.getUid();
                  } else {
                     var13 = null;
                  }

                  HasLinkingCapability var21 = this.parentDevice;
                  String var22;
                  if (var21 != null) {
                     var22 = var21.getLinkedToUid();
                  } else {
                     var22 = null;
                  }

                  if (!Intrinsics.areEqual(var13, var22)) {
                     Iterator var25 = this.awares.iterator();
                     var2 = 0;

                     while(true) {
                        if (!var25.hasNext()) {
                           var2 = -1;
                           break;
                        }

                        var22 = ((DeviceAware)var25.next()).getUid();
                        HasLinkingCapability var14 = this.parentDevice;
                        String var15;
                        if (var14 != null) {
                           var15 = var14.getLinkedToUid();
                        } else {
                           var15 = null;
                        }

                        if (Intrinsics.areEqual(var22, var15)) {
                           break;
                        }

                        ++var2;
                     }

                     if (var2 >= 0) {
                        this.notifyItemChanged(var2);
                     }
                  }
               }

               if (var1 != null) {
                  Iterator var17 = this.awares.iterator();
                  var2 = var4;

                  while(true) {
                     var4 = var3;
                     if (!var17.hasNext()) {
                        break;
                     }

                     if (Intrinsics.areEqual(((DeviceAware)var17.next()).getUid(), var1.getUid())) {
                        var4 = var2;
                        break;
                     }

                     ++var2;
                  }

                  if (var4 >= 0) {
                     this.notifyItemChanged(var4);
                  }

                  return;
               }
            }

            return;
         }
      }

      HasLinkingCapability var18 = this.parentDevice;
      if (var18 != null) {
         var18.setLinkedToUid((String)null);
      }

      this.selectedAware = null;
      Iterator var24 = this.awares.iterator();

      int var12;
      while(true) {
         var12 = var3;
         if (!var24.hasNext()) {
            break;
         }

         String var26 = ((DeviceAware)var24.next()).getUid();
         String var19;
         if (var1 != null) {
            var19 = var1.getUid();
         } else {
            var19 = null;
         }

         if (Intrinsics.areEqual(var26, var19)) {
            var12 = var2;
            break;
         }

         ++var2;
      }

      if (var12 >= 0) {
         this.notifyItemChanged(var12);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter$Companion;", "", "<init>", "()V", "TYPE_EMPTY_STATE", "", "TYPE_AWARE", "devicedetails_otherRelease"},
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
   }
}
