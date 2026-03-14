package com.blueair.adddevice.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"},
   d2 = {"Lcom/blueair/adddevice/model/BluetoothConnectingState;", "", "code", "", "<init>", "(I)V", "getCode", "()I", "NotConnected", "Connecting", "Connected", "Lcom/blueair/adddevice/model/BluetoothConnectingState$Connected;", "Lcom/blueair/adddevice/model/BluetoothConnectingState$Connecting;", "Lcom/blueair/adddevice/model/BluetoothConnectingState$NotConnected;", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BluetoothConnectingState {
   private final int code;

   private BluetoothConnectingState(int var1) {
      this.code = var1;
   }

   // $FF: synthetic method
   public BluetoothConnectingState(int var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final int getCode() {
      return this.code;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/adddevice/model/BluetoothConnectingState$Connected;", "Lcom/blueair/adddevice/model/BluetoothConnectingState;", "<init>", "()V", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Connected extends BluetoothConnectingState {
      public static final Connected INSTANCE = new Connected();

      private Connected() {
         super(2, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/adddevice/model/BluetoothConnectingState$Connecting;", "Lcom/blueair/adddevice/model/BluetoothConnectingState;", "<init>", "()V", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Connecting extends BluetoothConnectingState {
      public static final Connecting INSTANCE = new Connecting();

      private Connecting() {
         super(1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/adddevice/model/BluetoothConnectingState$NotConnected;", "Lcom/blueair/adddevice/model/BluetoothConnectingState;", "<init>", "()V", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NotConnected extends BluetoothConnectingState {
      public static final NotConnected INSTANCE = new NotConnected();

      private NotConnected() {
         super(0, (DefaultConstructorMarker)null);
      }
   }
}
