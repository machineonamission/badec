package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"},
   d2 = {"Lcom/blueair/core/model/DataTrend;", "", "code", "", "<init>", "(I)V", "getCode", "()I", "Companion", "HistoricalTrend", "LatestTrend", "RealTimeTrend", "Lcom/blueair/core/model/DataTrend$HistoricalTrend;", "Lcom/blueair/core/model/DataTrend$LatestTrend;", "Lcom/blueair/core/model/DataTrend$RealTimeTrend;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DataTrend {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int HISTORICAL_TREND_CODE = 0;
   public static final int LATEST_TREND_CODE = 1;
   public static final int REAL_TIME_TREND_CODE = 2;
   private final int code;

   private DataTrend(int var1) {
      this.code = var1;
   }

   // $FF: synthetic method
   public DataTrend(int var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final int getCode() {
      return this.code;
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/DataTrend$Companion;", "", "<init>", "()V", "HISTORICAL_TREND_CODE", "", "LATEST_TREND_CODE", "REAL_TIME_TREND_CODE", "core_otherRelease"},
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
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DataTrend$HistoricalTrend;", "Lcom/blueair/core/model/DataTrend;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HistoricalTrend extends DataTrend {
      public static final HistoricalTrend INSTANCE = new HistoricalTrend();

      private HistoricalTrend() {
         super(0, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DataTrend$LatestTrend;", "Lcom/blueair/core/model/DataTrend;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LatestTrend extends DataTrend {
      public static final LatestTrend INSTANCE = new LatestTrend();

      private LatestTrend() {
         super(1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DataTrend$RealTimeTrend;", "Lcom/blueair/core/model/DataTrend;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class RealTimeTrend extends DataTrend {
      public static final RealTimeTrend INSTANCE = new RealTimeTrend();

      private RealTimeTrend() {
         super(2, (DefaultConstructorMarker)null);
      }
   }
}
