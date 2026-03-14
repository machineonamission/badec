package com.blueair.outdoor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import com.blueair.outdoor.R;
import com.blueair.outdoor.ui.fragments.PlacesFragment;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
   d2 = {"Lcom/blueair/outdoor/ui/activity/SearchActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "searchCompleted", "data", "Landroid/content/Intent;", "searchCancelled", "Companion", "SearchType", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SearchActivity extends BaseActivity {
   public static final int AMAP_SEARCH_REQUEST = 103;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int GOOGLE_SEARCH_REQUEST = 101;
   public static final int MAPBOX_SEARCH_REQUEST = 102;
   public static final String SAVED_LOCATION_KEY = "savedloc";
   public static final String SEARCH_REQUEST_KEY = "place";
   public static final String SEARCH_REQUEST_TYPE_KEY = "request_code";
   private final String screenName = "outdoor_map_search";

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(R.layout.activity_search);
      SearchType var2;
      switch (this.getIntent().getIntExtra("request_code", 101)) {
         case 101:
            var2 = SearchActivity.SearchType.GOOGLE;
            break;
         case 102:
            var2 = SearchActivity.SearchType.MAPBOX;
            break;
         case 103:
            var2 = SearchActivity.SearchType.AMAP;
            break;
         default:
            var2 = SearchActivity.SearchType.GOOGLE;
      }

      PlacesFragment var3 = PlacesFragment.Companion.newInstance(var2);
      this.getSupportFragmentManager().beginTransaction().replace(R.id.container, var3).commit();
   }

   public final void searchCancelled() {
      this.setResult(0);
      this.finish();
   }

   public final void searchCompleted(Intent var1) {
      Intrinsics.checkNotNullParameter(var1, "data");
      this.setResult(-1, var1);
      this.finish();
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/outdoor/ui/activity/SearchActivity$Companion;", "", "<init>", "()V", "GOOGLE_SEARCH_REQUEST", "", "MAPBOX_SEARCH_REQUEST", "AMAP_SEARCH_REQUEST", "SEARCH_REQUEST_TYPE_KEY", "", "SEARCH_REQUEST_KEY", "SAVED_LOCATION_KEY", "outdoor_otherRelease"},
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

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/outdoor/ui/activity/SearchActivity$SearchType;", "", "<init>", "(Ljava/lang/String;I)V", "GOOGLE", "MAPBOX", "AMAP", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum SearchType {
      private static final EnumEntries $ENTRIES;
      private static final SearchType[] $VALUES;
      AMAP,
      GOOGLE,
      MAPBOX;

      // $FF: synthetic method
      private static final SearchType[] $values() {
         return new SearchType[]{GOOGLE, MAPBOX, AMAP};
      }

      static {
         SearchType[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }
}
