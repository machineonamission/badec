package com.blueair.android.fragment.integration;

import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"},
   d2 = {"Lcom/blueair/android/fragment/integration/Integration;", "", "integrationName", "", "devices", "", "Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "title", "", "summary", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;II)V", "getIntegrationName", "()Ljava/lang/String;", "getDevices", "()Ljava/util/List;", "getTitle", "()I", "getSummary", "AmazonAlexa", "AmazonAlexaOld", "Tmall", "GoogleAssistant", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum Integration {
   private static final EnumEntries $ENTRIES;
   private static final Integration[] $VALUES;
   AmazonAlexa("Amazon Alexa", CollectionsKt.emptyList(), R.string.amazon_alexa, R.string.amazon_alexa_summary),
   AmazonAlexaOld("Amazon Alexa for Old Generation", IntegrationKt.access$getAmazonAlexaSupportedDevices$p(), R.string.amazon_alexa_old, R.string.amazon_alexa_summary_old),
   GoogleAssistant("Google Assistant", CollectionsKt.emptyList(), R.string.gassistant, R.string.gassistant_summary),
   Tmall("Tmall Genie", IntegrationKt.access$getTmallSupportedDevices$p(), R.string.tmall_genie, R.string.tmall_genie_summary);

   private final List devices;
   private final String integrationName;
   private final int summary;
   private final int title;

   // $FF: synthetic method
   private static final Integration[] $values() {
      return new Integration[]{AmazonAlexa, AmazonAlexaOld, Tmall, GoogleAssistant};
   }

   static {
      Integration[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private Integration(String var3, List var4, int var5, int var6) {
      this.integrationName = var3;
      this.devices = var4;
      this.title = var5;
      this.summary = var6;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final List getDevices() {
      return this.devices;
   }

   public final String getIntegrationName() {
      return this.integrationName;
   }

   public final int getSummary() {
      return this.summary;
   }

   public final int getTitle() {
      return this.title;
   }
}
