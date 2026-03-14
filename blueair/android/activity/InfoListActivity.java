package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.adapter.InfoListItem;
import com.blueair.android.adapter.SimpleInfoItem;
import com.blueair.android.databinding.ActivityInfoListBinding;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.auth.AuthService;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.UserInfoCollectionGroup;
import com.blueair.core.util.LinkUtils;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002"},
   d2 = {"Lcom/blueair/android/activity/InfoListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityInfoListBinding;", "viewModel", "Lcom/blueair/android/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "Lcom/blueair/android/adapter/SimpleInfoItem;", "getFastAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "fastAdapter$delegate", "infoType", "Lcom/blueair/android/activity/InfoListActivity$InfoType;", "getInfoType", "()Lcom/blueair/android/activity/InfoListActivity$InfoType;", "setInfoType", "(Lcom/blueair/android/activity/InfoListActivity$InfoType;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "initAdapter", "loadInfoListByType", "", "Lcom/blueair/android/adapter/InfoListItem;", "Companion", "InfoType", "app_otherRelease", "authService", "Lcom/blueair/auth/AuthService;"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class InfoListActivity extends BaseActivity {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property0((PropertyReference0)(new PropertyReference0Impl(InfoListActivity.class, "authService", "<v#0>", 0)))};
   public static final int $stable = 8;
   public static final String ARG_INFO_TYPE = "info_type";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityInfoListBinding binding;
   private final Lazy fastAdapter$delegate;
   private InfoType infoType;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$LdOyRgJai4CvusP5Iqwf42kCHKE(InfoListActivity var0, View var1) {
      configure$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$ljIRYNHRBZlyhXiB7tv2VXB_C0I/* $FF was: $r8$lambda$ljIRYNHRBZlyhXiB7tv2VXB-C0I*/(InfoListActivity var0, View var1, IAdapter var2, SimpleInfoItem var3, int var4) {
      return configure$lambda$3(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static FastAdapter $r8$lambda$zvU5DjfhFTLOsW1W_rrm8pxgKe4(InfoListActivity var0) {
      return fastAdapter_delegate$lambda$0(var0);
   }

   public InfoListActivity() {
      ComponentActivity var2 = (ComponentActivity)this;
      Function0 var1 = new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var1, new Function0((Function0)null, var2) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
      this.fastAdapter$delegate = LazyKt.lazy(new InfoListActivity$$ExternalSyntheticLambda0(this));
      this.infoType = InfoListActivity.InfoType.POLICIES;
   }

   private static final void configure$lambda$2(InfoListActivity var0, View var1) {
      var0.finish();
   }

   private static final boolean configure$lambda$3(InfoListActivity var0, View var1, IAdapter var2, SimpleInfoItem var3, int var4) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "item");
      InfoListItem var6 = var3.getInfoItem();
      if (Intrinsics.areEqual(var6, InfoListItem.Companion.getPOLICY_TERMS())) {
         InfoActivity.Companion var5 = InfoActivity.Companion;
         Activity var9 = (Activity)var0;
         String var7 = LinkUtils.INSTANCE.getPrivacyLinkFromCountryCode(var0.getViewModel().getCountry());
         String var11 = var0.getString(R.string.privacy_and_terms);
         Intrinsics.checkNotNullExpressionValue(var11, "getString(...)");
         var0.startActivity(var5.gotoWebView(var9, var7, var11));
      } else if (Intrinsics.areEqual(var6, InfoListItem.Companion.getUSER_INFO_COLLECTIONS())) {
         Companion.launch((Context)var0, InfoListActivity.InfoType.USER_INFO_GROUPS);
      } else if (Intrinsics.areEqual(var6, InfoListItem.Companion.getSHARED_THIRD_PARTIES())) {
         InfoActivity.Companion var10 = InfoActivity.Companion;
         Activity var12 = (Activity)var0;
         String var13 = LinkUtils.INSTANCE.getSharedSdkInfoLink(var0.getViewModel().getCountry());
         String var8 = var0.getString(R.string.infomation_shared_with_third_parties);
         Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
         var0.startActivity(var10.gotoWebView(var12, var13, var8));
      } else {
         InfoDetailActivity.Companion.launch((Context)var0, var6.getId());
      }

      return true;
   }

   private static final FastAdapter fastAdapter_delegate$lambda$0(InfoListActivity var0) {
      return var0.initAdapter();
   }

   private final FastAdapter getFastAdapter() {
      return (FastAdapter)this.fastAdapter$delegate.getValue();
   }

   private final HomeViewModel getViewModel() {
      return (HomeViewModel)this.viewModel$delegate.getValue();
   }

   private final FastAdapter initAdapter() {
      ItemAdapter var2 = new ItemAdapter();
      Iterable var3 = (Iterable)this.loadInfoListByType();
      Collection var1 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         var1.add(new SimpleInfoItem((InfoListItem)var4.next()));
      }

      var2.add((List)var1);
      return FastAdapter.Companion.with((IAdapter)var2);
   }

   private final List loadInfoListByType() {
      InfoType var2 = this.infoType;
      int var1 = InfoListActivity.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var1 != 1) {
         if (var1 == 2) {
            DIAware var3 = this;
            JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
            }).getSuperType());
            Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy var8 = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, AuthService.class)), (Object)null).provideDelegate((Object)null, $$delegatedProperties[0]);
            UserInfoCollectionsManager.INSTANCE.initializeCollections(loadInfoListByType$lambda$5(var8).getUsername(), (Context)this);
            Iterable var9 = (Iterable)UserInfoCollectionsManager.INSTANCE.getCollections();
            Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var9, 10)));

            for(UserInfoCollectionGroup var10 : var9) {
               String var6 = var10.getId();
               String var12 = var10.getName().getValue();
               String var11 = var12;
               if (var12 == null) {
                  var11 = "/";
               }

               var4.add(new InfoListItem(var6, var11));
            }

            return (List)var4;
         } else {
            throw new NoWhenBranchMatchedException();
         }
      } else {
         return BuildEnvironment.INSTANCE.isChina() ? CollectionsKt.listOf(new InfoListItem[]{InfoListItem.Companion.getPOLICY_TERMS(), InfoListItem.Companion.getUSER_INFO_COLLECTIONS(), InfoListItem.Companion.getSHARED_THIRD_PARTIES()}) : CollectionsKt.listOf(InfoListItem.Companion.getPOLICY_TERMS());
      }
   }

   private static final AuthService loadInfoListByType$lambda$5(Lazy var0) {
      return (AuthService)var0.getValue();
   }

   public final void configure() {
      Intent var1 = this.getIntent();
      if (var1 != null) {
         Serializable var4 = var1.getSerializableExtra("info_type");
         if (var4 instanceof InfoType) {
            this.infoType = (InfoType)var4;
         }
      }

      ActivityInfoListBinding var3 = this.binding;
      Object var2 = null;
      ActivityInfoListBinding var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.tvTitle.setText(this.infoType.getScreenTitle());
      var3 = this.binding;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.btnBack.setOnClickListener(new InfoListActivity$$ExternalSyntheticLambda1(this));
      var5 = this.binding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = (ActivityInfoListBinding)var2;
      }

      var5.srvList.getRecyclerView().setAdapter((RecyclerView.Adapter)this.getFastAdapter());
      this.getFastAdapter().setOnClickListener(new InfoListActivity$$ExternalSyntheticLambda2(this));
   }

   public final InfoType getInfoType() {
      return this.infoType;
   }

   protected String getScreenName() {
      return this.infoType.getScreenName();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ViewDataBinding var2 = DataBindingUtil.setContentView((Activity)this, com.blueair.android.R.layout.activity_info_list);
      Intrinsics.checkNotNullExpressionValue(var2, "setContentView(...)");
      this.binding = (ActivityInfoListBinding)var2;
      BaseLokaliseActivity.setStatusBarColor$default(this, this.getColor(R.color.light_sliver), (Boolean)null, 2, (Object)null);
      this.configure();
   }

   public final void setInfoType(InfoType var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.infoType = var1;
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/android/activity/InfoListActivity$Companion;", "", "<init>", "()V", "ARG_INFO_TYPE", "", "launch", "", "context", "Landroid/content/Context;", "infoType", "Lcom/blueair/android/activity/InfoListActivity$InfoType;", "app_otherRelease"},
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

      public final void launch(Context var1, InfoType var2) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "infoType");
         Intent var3 = new Intent(var1, InfoListActivity.class);
         if (!(var1 instanceof Activity)) {
            var3.addFlags(268435456);
         }

         var3.putExtra("info_type", (Serializable)var2);
         var1.startActivity(var3);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"},
      d2 = {"Lcom/blueair/android/activity/InfoListActivity$InfoType;", "", "screenName", "", "screenTitle", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getScreenName", "()Ljava/lang/String;", "getScreenTitle", "()I", "POLICIES", "USER_INFO_GROUPS", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum InfoType {
      private static final EnumEntries $ENTRIES;
      private static final InfoType[] $VALUES;
      POLICIES("side_menu_policy", R.string.action_policies),
      USER_INFO_GROUPS("side_menu_policy_user_info_groups", R.string.collected_personal_infomation);

      private final String screenName;
      private final int screenTitle;

      // $FF: synthetic method
      private static final InfoType[] $values() {
         return new InfoType[]{POLICIES, USER_INFO_GROUPS};
      }

      static {
         InfoType[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      private InfoType(String var3, int var4) {
         this.screenName = var3;
         this.screenTitle = var4;
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }

      public final String getScreenName() {
         return this.screenName;
      }

      public final int getScreenTitle() {
         return this.screenTitle;
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
         int[] var0 = new int[InfoListActivity.InfoType.values().length];

         try {
            var0[InfoListActivity.InfoType.POLICIES.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[InfoListActivity.InfoType.USER_INFO_GROUPS.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
