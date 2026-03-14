package com.blueair.antifake.adapter;

import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"},
   d2 = {"Lcom/blueair/antifake/adapter/ScanInfoType;", "", "image", "", "title", "info", "<init>", "(Ljava/lang/String;IIII)V", "getImage", "()I", "getTitle", "getInfo", "CORRECT", "REPEAT", "INVALID", "UNRECOG", "WICK", "FILTER", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum ScanInfoType {
   private static final EnumEntries $ENTRIES;
   private static final ScanInfoType[] $VALUES;
   CORRECT(R.drawable.ic_scan_result_correct, R.string.scan_result_correct, R.string.scan_result_correct_hint),
   FILTER(R.drawable.instruction_scan_filter, R.string.filter_verification, R.string.filter_verification_hint),
   INVALID(R.drawable.ic_scan_result_invalid, R.string.scan_result_invalid, R.string.scan_result_invalid_hint),
   REPEAT(R.drawable.ic_scan_result_repeat, R.string.scan_result_repeat, R.string.scan_result_repeat_hint),
   UNRECOG(R.drawable.ic_scan_result_unrecognizable, R.string.scan_result_unrecognizable, R.string.scan_result_unrecognizable_hint),
   WICK(R.drawable.instruction_scan_filter, R.string.wick_verification, R.string.wick_verification_hint);

   private final int image;
   private final int info;
   private final int title;

   // $FF: synthetic method
   private static final ScanInfoType[] $values() {
      return new ScanInfoType[]{CORRECT, REPEAT, INVALID, UNRECOG, WICK, FILTER};
   }

   static {
      ScanInfoType[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private ScanInfoType(int var3, int var4, int var5) {
      this.image = var3;
      this.title = var4;
      this.info = var5;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getImage() {
      return this.image;
   }

   public final int getInfo() {
      return this.info;
   }

   public final int getTitle() {
      return this.title;
   }
}
