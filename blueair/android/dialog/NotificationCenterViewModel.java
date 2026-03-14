package com.blueair.android.dialog;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.NotificationType;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001eH\u0002¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u001cJ\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00180\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00180\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\f¨\u0006("},
   d2 = {"Lcom/blueair/android/dialog/NotificationCenterViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_requesting", "Landroidx/lifecycle/MutableLiveData;", "", "requesting", "Landroidx/lifecycle/LiveData;", "getRequesting", "()Landroidx/lifecycle/LiveData;", "_fetchFailed", "fetchFailed", "getFetchFailed", "_notificationAllSettings", "Lcom/blueair/core/model/NotificationSetting;", "notificationAllSettings", "getNotificationAllSettings", "_notificationProductAlertSettings", "notificationProductAlertSettings", "getNotificationProductAlertSettings", "_notificationSettings", "", "notificationSettings", "getNotificationSettings", "launchRequest", "", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "fetchNotificationSettings", "postNotificationSetting", "setting", "updateNotificationSetting", "oldSetting", "newSetting", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationCenterViewModel extends BaseViewModel {
   public static final int $stable = 8;
   private final MutableLiveData _fetchFailed;
   private final MutableLiveData _notificationAllSettings;
   private final MutableLiveData _notificationProductAlertSettings;
   private final MutableLiveData _notificationSettings;
   private final MutableLiveData _requesting;
   private final LiveData fetchFailed;
   private final LiveData notificationAllSettings;
   private final LiveData notificationProductAlertSettings;
   private final LiveData notificationSettings;
   private final LiveData requesting;

   public NotificationCenterViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      Boolean var2 = false;
      MutableLiveData var3 = new MutableLiveData(var2);
      this._requesting = var3;
      this.requesting = (LiveData)var3;
      var3 = new MutableLiveData(var2);
      this._fetchFailed = var3;
      this.fetchFailed = (LiveData)var3;
      var3 = new MutableLiveData();
      this._notificationAllSettings = var3;
      this.notificationAllSettings = (LiveData)var3;
      var3 = new MutableLiveData();
      this._notificationProductAlertSettings = var3;
      this.notificationProductAlertSettings = (LiveData)var3;
      var3 = new MutableLiveData();
      this._notificationSettings = var3;
      this.notificationSettings = (LiveData)var3;
      this.fetchNotificationSettings();
   }

   private final void launchRequest(Function1 var1) {
      Object var2 = this.requesting.getValue();
      Boolean var3 = true;
      if (!Intrinsics.areEqual(var2, var3)) {
         this._requesting.setValue(var3);
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
            final Function1 $action;
            int label;
            final NotificationCenterViewModel this$0;

            {
               this.$action = var1;
               this.this$0 = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.$action, this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               label95: {
                  Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  Throwable var10000;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     label88:
                     try {
                        ResultKt.throwOnFailure(var1);
                        break label95;
                     } catch (Throwable var8) {
                        var10000 = var8;
                        boolean var10001 = false;
                        break label88;
                     }
                  } else {
                     label98: {
                        ResultKt.throwOnFailure(var1);

                        try {
                           Function1 var11 = this.$action;
                           this.label = 1;
                           var1 = var11.invoke(this);
                        } catch (Throwable var9) {
                           var10000 = var9;
                           boolean var13 = false;
                           break label98;
                        }

                        if (var1 == var3) {
                           return var3;
                        }
                        break label95;
                     }
                  }

                  Throwable var10 = var10000;
                  this.this$0._requesting.postValue(Boxing.boxBoolean(false));
                  throw var10;
               }

               this.this$0._requesting.postValue(Boxing.boxBoolean(false));
               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }
   }

   private final void postNotificationSetting(NotificationSetting var1) {
      String var3 = var1.getType();
      if (Intrinsics.areEqual(var3, NotificationType.ALL.getValue())) {
         this._notificationAllSettings.postValue(var1);
      } else if (Intrinsics.areEqual(var3, NotificationType.LEGACY_PRODUCT_ALERT.getValue())) {
         this._notificationProductAlertSettings.postValue(var1);
      } else {
         List var4 = (List)this._notificationSettings.getValue();
         List var5 = var4;
         if (var4 == null) {
            Iterable var8 = (Iterable)NotificationType.getEntries();
            Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
            Iterator var9 = var8.iterator();

            while(var9.hasNext()) {
               var6.add(new NotificationSetting(((NotificationType)var9.next()).getValue(), 1, (Integer)null, 4, (DefaultConstructorMarker)null));
            }

            var5 = (List)var6;
         }

         Iterator var10 = var5.iterator();
         int var2 = 0;

         while(true) {
            if (!var10.hasNext()) {
               var2 = -1;
               break;
            }

            if (Intrinsics.areEqual(((NotificationSetting)var10.next()).getType(), var1.getType())) {
               break;
            }

            ++var2;
         }

         if (var2 >= 0) {
            MutableLiveData var11 = this._notificationSettings;
            var5 = CollectionsKt.toMutableList((Collection)var5);
            var5.set(var2, var1);
            var11.postValue(var5);
         }

      }
   }

   public final void fetchNotificationSettings() {
      this.launchRequest(new Function1(this, (Continuation)null) {
         int label;
         final NotificationCenterViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Continuation var1) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var1));
         }

         public final Object invoke(Continuation var1) {
            return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.this$0.getDeviceManager();
               Continuation var3 = (Continuation)this;
               this.label = 1;
               Object var13 = var1.getNotificationSettings(var3);
               var1 = (DeviceManager)var13;
               if (var13 == var4) {
                  return var4;
               }
            }

            ApiResult var10 = (ApiResult)var1;
            if (var10.isSuccess()) {
               label55: {
                  this.this$0._fetchFailed.postValue(Boxing.boxBoolean(false));
                  List var11 = (List)var10.getOrNull();
                  if (var11 != null) {
                     List var14 = CollectionsKt.toMutableList((Collection)var11);
                     var12 = var14;
                     if (var14 != null) {
                        break label55;
                     }
                  }

                  var12 = (List)(new ArrayList());
               }

               List var5 = (List)(new ArrayList());
               Iterable var15 = (Iterable)NotificationType.getEntries();
               NotificationCenterViewModel var6 = this.this$0;

               for(NotificationType var8 : var15) {
                  Iterator var18 = ((Iterable)var12).iterator();

                  do {
                     if (!var18.hasNext()) {
                        var16 = null;
                        break;
                     }

                     var16 = var18.next();
                  } while(!Intrinsics.areEqual(((NotificationSetting)var16).getType(), var8.getValue()));

                  NotificationSetting var19 = (NotificationSetting)var16;
                  NotificationSetting var17 = var19;
                  if (var19 == null) {
                     var17 = new NotificationSetting(var8.getValue(), 1, (Integer)null, 4, (DefaultConstructorMarker)null);
                  }

                  String var20 = var17.getType();
                  if (Intrinsics.areEqual(var20, NotificationType.ALL.getValue())) {
                     var6._notificationAllSettings.postValue(var17);
                  } else if (Intrinsics.areEqual(var20, NotificationType.LEGACY_PRODUCT_ALERT.getValue())) {
                     var6._notificationProductAlertSettings.postValue(var17);
                  } else {
                     Boxing.boxBoolean(var5.add(var17));
                  }
               }

               this.this$0._notificationSettings.postValue(var5);
            } else {
               this.this$0._fetchFailed.postValue(Boxing.boxBoolean(true));
            }

            return Unit.INSTANCE;
         }
      });
   }

   public final LiveData getFetchFailed() {
      return this.fetchFailed;
   }

   public final LiveData getNotificationAllSettings() {
      return this.notificationAllSettings;
   }

   public final LiveData getNotificationProductAlertSettings() {
      return this.notificationProductAlertSettings;
   }

   public final LiveData getNotificationSettings() {
      return this.notificationSettings;
   }

   public final LiveData getRequesting() {
      return this.requesting;
   }

   public final void updateNotificationSetting(NotificationSetting var1, NotificationSetting var2) {
      Intrinsics.checkNotNullParameter(var1, "oldSetting");
      Intrinsics.checkNotNullParameter(var2, "newSetting");
      this.launchRequest(new Function1(this, var2, var1, (Continuation)null) {
         final NotificationSetting $newSetting;
         final NotificationSetting $oldSetting;
         int label;
         final NotificationCenterViewModel this$0;

         {
            this.this$0 = var1;
            this.$newSetting = var2;
            this.$oldSetting = var3;
         }

         public final Continuation create(Continuation var1) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$newSetting, this.$oldSetting, var1));
         }

         public final Object invoke(Continuation var1) {
            return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceManager var5 = this.this$0.getDeviceManager();
               NotificationSetting var3 = this.$newSetting;
               Continuation var6 = (Continuation)this;
               this.label = 1;
               var3 = (NotificationSetting)var5.updateNotificationSetting(var3, var6);
               var1 = var3;
               if (var3 == var4) {
                  return var4;
               }
            }

            if (((ApiResult)var1).isSuccess()) {
               this.this$0.postNotificationSetting(this.$newSetting);
            } else {
               this.this$0.postNotificationSetting(this.$oldSetting);
               this.this$0.showMessage(R.string.request_failed, ViewUtils.MessageType.ERROR.INSTANCE);
            }

            return Unit.INSTANCE;
         }
      });
   }
}
