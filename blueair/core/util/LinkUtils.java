package com.blueair.core.util;

import com.blueair.core.model.IpConfig;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¨\u0006\u000f"},
   d2 = {"Lcom/blueair/core/util/LinkUtils;", "", "<init>", "()V", "getLink", "", "name", "countryCode", "getVisitBlueairLinkFromCountryCode", "getPrivacyLinkFromCountryCode", "getTermsLink", "getSharedSdkInfoLink", "getConnectionTroubleShootingLink", "getSupportLink", "getBlueairStoreLink", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LinkUtils {
   public static final LinkUtils INSTANCE = new LinkUtils();

   private LinkUtils() {
   }

   private final String getLink(String var1, String var2) {
      IpConfig var3 = (IpConfig)SkuConfigurationManager.INSTANCE.getWebLinks().get(var1);
      if (var3 != null) {
         String var4 = var3.getValue(var2);
         if (var4 != null) {
            return var4;
         }
      }

      return "";
   }

   public final String getBlueairStoreLink(String var1) {
      return this.getLink("blueair_store", var1);
   }

   public final String getConnectionTroubleShootingLink(String var1) {
      return this.getLink("troubleshooting_onboarding", var1);
   }

   public final String getPrivacyLinkFromCountryCode(String var1) {
      return this.getLink("privacy", var1);
   }

   public final String getSharedSdkInfoLink(String var1) {
      return this.getLink("shared_sdk_info", var1);
   }

   public final String getSupportLink(String var1) {
      return this.getLink("customer_support", var1);
   }

   public final String getTermsLink(String var1) {
      return this.getLink("terms", var1);
   }

   public final String getVisitBlueairLinkFromCountryCode(String var1) {
      return this.getLink("visit_blueair", var1);
   }
}
