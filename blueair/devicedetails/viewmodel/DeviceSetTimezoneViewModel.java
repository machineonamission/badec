package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.Device;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.ResponseBody;

@Metadata(
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0&\u0012\u0006\u0012\u0004\u0018\u00010'0%H\u0002¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020#0,R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_requesting", "Landroidx/lifecycle/MutableLiveData;", "", "requesting", "Landroidx/lifecycle/LiveData;", "getRequesting", "()Landroidx/lifecycle/LiveData;", "fullTimezoneList", "", "Ljava/util/TimeZone;", "getFullTimezoneList", "()Ljava/util/List;", "_timezoneList", "timezoneList", "getTimezoneList", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "value", "", "searchText", "getSearchText", "()Ljava/lang/String;", "setSearchText", "(Ljava/lang/String;)V", "launchRequest", "", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "setDeviceTimezone", "timezone", "onSuccess", "Lkotlin/Function0;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSetTimezoneViewModel extends BaseViewModel {
   private final MutableLiveData _requesting;
   private final MutableLiveData _timezoneList;
   public Device device;
   private final List fullTimezoneList;
   private final LiveData requesting;
   private String searchText;
   private final LiveData timezoneList;

   public DeviceSetTimezoneViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      MutableLiveData var2 = new MutableLiveData(false);
      this._requesting = var2;
      this.requesting = (LiveData)var2;
      List var3 = TimezoneUtils.INSTANCE.getTimezoneList((Context)var1).getTimezones();
      this.fullTimezoneList = var3;
      MutableLiveData var4 = new MutableLiveData(var3);
      this._timezoneList = var4;
      this.timezoneList = (LiveData)var4;
      this.searchText = "";
   }

   private final void launchRequest(Function1 var1) {
      Object var2 = this.requesting.getValue();
      Boolean var3 = true;
      if (!Intrinsics.areEqual(var2, var3)) {
         this._requesting.setValue(var3);
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
            final Function1 $action;
            int label;
            final DeviceSetTimezoneViewModel this$0;

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

   public final Device getDevice() {
      Device var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public final List getFullTimezoneList() {
      return this.fullTimezoneList;
   }

   public final LiveData getRequesting() {
      return this.requesting;
   }

   public final String getSearchText() {
      return this.searchText;
   }

   public final LiveData getTimezoneList() {
      return this.timezoneList;
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public final void setDeviceTimezone(TimeZone var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "timezone");
      Intrinsics.checkNotNullParameter(var2, "onSuccess");
      this.launchRequest(new Function1(this, var1, var2, (Continuation)null) {
         final Function0 $onSuccess;
         final TimeZone $timezone;
         int label;
         final DeviceSetTimezoneViewModel this$0;

         {
            this.this$0 = var1;
            this.$timezone = var2;
            this.$onSuccess = var3;
         }

         public final Continuation create(Continuation var1) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$timezone, this.$onSuccess, var1));
         }

         public final Object invoke(Continuation var1) {
            return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4;
            label32: {
               var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        if (var2 != 3) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     ResultKt.throwOnFailure(var1);
                     break label32;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  var1 = this.this$0.getDeviceManager();
                  String var6 = this.this$0.getDevice().getUid();
                  TimeZone var3 = this.$timezone;
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  Object var10 = var1.setDeviceTimezone((String)var6, var3, (Context)null, var5);
                  var1 = (DeviceManager)var10;
                  if (var10 == var4) {
                     return var4;
                  }
               }

               ApiResult var11 = (ApiResult)var1;
               Function2 var8 = new Function2(this.$onSuccess, (Continuation)null) {
                  final Function0 $onSuccess;
                  int label;

                  {
                     this.$onSuccess = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$onSuccess, var2));
                  }

                  public final Object invoke(ResponseBody var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.$onSuccess.invoke();
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var14 = (Continuation)this;
               this.label = 2;
               Object var12 = ApiResultKt.onSuccess(var11, var8, var14);
               var1 = (DeviceManager)var12;
               if (var12 == var4) {
                  return var4;
               }
            }

            ApiResult var13 = (ApiResult)var1;
            Function2 var9 = new Function2(this.this$0, (Continuation)null) {
               int label;
               final DeviceSetTimezoneViewModel this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, var2));
               }

               public final Object invoke(Throwable var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     this.this$0.showMessage(R.string.request_failed, ViewUtils.MessageType.ERROR.INSTANCE);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var15 = (Continuation)this;
            this.label = 3;
            if (ApiResultKt.onFail(var13, var9, var15) == var4) {
               return var4;
            } else {
               return Unit.INSTANCE;
            }
         }
      });
   }

   public final void setSearchText(String var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.searchText, var1)) {
         this.searchText = var1;
         MutableLiveData var5 = this._timezoneList;
         List var12;
         if (((CharSequence)var1).length() == 0) {
            var12 = this.fullTimezoneList;
         } else {
            char[] var13 = var1.toCharArray();
            Intrinsics.checkNotNullExpressionValue(var13, "toCharArray(...)");
            Collection var6 = (Collection)(new ArrayList());

            for(char var2 : var13) {
               if (var2 != ' ') {
                  var6.add(var2);
               }
            }

            Regex var14 = new Regex(CollectionsKt.joinToString$default((Iterable)((List)var6), (CharSequence)".*", (CharSequence)".*", (CharSequence)".*", 0, (CharSequence)null, (Function1)null, 56, (Object)null), RegexOption.IGNORE_CASE);
            Iterable var7 = (Iterable)this.fullTimezoneList;
            var6 = (Collection)(new ArrayList());

            for(Object var8 : var7) {
               TimeZone var16 = (TimeZone)var8;
               String var9 = TimezoneUtils.INSTANCE.getDisplayName((Context)this.getApplication(), var16);
               StringBuilder var11 = new StringBuilder();
               var11.append(var9);
               var11.append(var16.getID());
               if (!var14.matches((CharSequence)var11.toString())) {
                  var11 = new StringBuilder();
                  var11.append(var16.getID());
                  var11.append(var9);
                  if (!var14.matches((CharSequence)var11.toString())) {
                     continue;
                  }
               }

               var6.add(var8);
            }

            var12 = (List)var6;
         }

         var5.setValue(var12);
      }
   }
}
