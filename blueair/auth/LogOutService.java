package com.blueair.auth;

import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DirectDI;
import org.kodein.di.DirectDIAware;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"},
   d2 = {"Lcom/blueair/auth/LogOutService;", "", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Lcom/blueair/core/service/AnalyticsService;)V", "logOutableList", "", "Lcom/blueair/auth/LogOutable;", "registerLogOutable", "", "logOutable", "logOutRegistered", "reason", "Lcom/blueair/auth/LogoutReason;", "Companion", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LogOutService {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final AnalyticsService analyticsService;
   private final List logOutableList;

   public LogOutService(AnalyticsService var1) {
      Intrinsics.checkNotNullParameter(var1, "analyticsService");
      super();
      this.analyticsService = var1;
      this.logOutableList = (List)(new ArrayList());
   }

   public final void logOutRegistered(LogoutReason var1) {
      Intrinsics.checkNotNullParameter(var1, "reason");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("logOutRegistered: size = ");
      var3.append(this.logOutableList.size());
      var2.d(var3.toString(), new Object[0]);
      this.analyticsService.event(new AnalyticEvent.LogoutEvent(var1.getValue()));

      for(LogOutable var7 : (Iterable)this.logOutableList) {
         try {
            Timber.Forest var9 = Timber.Forest;
            StringBuilder var10 = new StringBuilder();
            var10.append("logOut ");
            var10.append(var7);
            var9.d(var10.toString(), new Object[0]);
            var7.logOut();
         } catch (Exception var5) {
            StringBuilder var4 = new StringBuilder();
            var4.append(var7);
            var4.append(", message: ");
            var4.append(var5.getLocalizedMessage());
            String var8 = var4.toString();
            Timber.Forest.e((Throwable)var5, var8, new Object[0]);
            this.analyticsService.event(new AnalyticEvent.BugEvent.LogoutFail(var8));
         }
      }

   }

   public final void registerLogOutable(LogOutable var1) {
      Intrinsics.checkNotNullParameter(var1, "logOutable");
      this.logOutableList.add(var1);
      List var2 = this.logOutableList;
      if (var2.size() > 1) {
         CollectionsKt.sortWith(var2, new Comparator() {
            public final int compare(Object var1, Object var2) {
               return ComparisonsKt.compareValues((Comparable)(LogOutable)var1 instanceof AuthService, (Comparable)(LogOutable)var2 instanceof AuthService);
            }
         });
      }

   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/auth/LogOutService$Companion;", "", "<init>", "()V", "registerLogOutable", "", "diBinding", "Lorg/kodein/di/bindings/NoArgBindingDI;", "logOutable", "Lcom/blueair/auth/LogOutable;", "auth_otherRelease"},
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

      public final void registerLogOutable(NoArgBindingDI var1, LogOutable var2) {
         Intrinsics.checkNotNullParameter(var1, "diBinding");
         Intrinsics.checkNotNullParameter(var2, "logOutable");
         DirectDI var3 = ((DirectDIAware)var1).getDirectDI();
         JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         ((LogOutService)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, LogOutService.class)), (Object)null)).registerLogOutable(var2);
      }
   }
}
