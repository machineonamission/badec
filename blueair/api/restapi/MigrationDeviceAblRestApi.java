package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\tÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/restapi/MigrationDeviceAblRestApi;", "", "isMigrationOtaRunning", "Lretrofit2/Response;", "Lcom/blueair/core/model/MigrationOtaResponse;", "deviceUuid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface MigrationDeviceAblRestApi {
   Companion Companion = MigrationDeviceAblRestApi.Companion.$$INSTANCE;
   String MIGRATION_OTA = "/v2/device/{uuid}/upgrading/legacy/";

   @GET("/v2/device/{uuid}/upgrading/legacy/")
   Object isMigrationOtaRunning(@Path("uuid") String var1, Continuation var2);

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/MigrationDeviceAblRestApi$Companion;", "", "<init>", "()V", "MIGRATION_OTA", "", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
      public static final String MIGRATION_OTA = "/v2/device/{uuid}/upgrading/legacy/";

      private Companion() {
      }
   }
}
