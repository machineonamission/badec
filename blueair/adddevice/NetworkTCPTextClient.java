package com.blueair.adddevice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0003J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003J\b\u0010 \u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""},
   d2 = {"Lcom/blueair/adddevice/NetworkTCPTextClient;", "", "serverIP", "", "serverPort", "", "readTimeout", "<init>", "(Ljava/lang/String;II)V", "getServerIP", "()Ljava/lang/String;", "getServerPort", "()I", "getReadTimeout", "isConnected", "", "()Z", "setConnected", "(Z)V", "mSocket", "Ljava/net/Socket;", "mWriter", "Ljava/io/PrintWriter;", "mReader", "Ljava/io/BufferedReader;", "connect", "disconnect", "", "writeMessage", "message", "writeLine", "readMessage", "readLine", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NetworkTCPTextClient {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String LOG_TAG;
   private static final int kReadBufferLength;
   private boolean isConnected;
   private BufferedReader mReader;
   private Socket mSocket;
   private PrintWriter mWriter;
   private final int readTimeout;
   private final String serverIP;
   private final int serverPort;

   static {
      String var0 = NetworkTCPTextClient.class.toString();
      Intrinsics.checkNotNullExpressionValue(var0, "toString(...)");
      LOG_TAG = var0;
      kReadBufferLength = 512;
   }

   public NetworkTCPTextClient(String var1, int var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "serverIP");
      super();
      this.serverIP = var1;
      this.serverPort = var2;
      this.readTimeout = var3;
      this.isConnected = false;
   }

   public final boolean connect() {
      // $FF: Couldn't be decompiled
   }

   public final void disconnect() {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("Disconnecting from ");
      var1.append(this.serverIP);
      var1.append(':');
      var1.append(this.serverPort);
      var1.append('.');
      var2.i(var1.toString(), new Object[0]);
      this.mReader = null;
      this.mWriter = null;

      try {
         Socket var5 = this.mSocket;
         Intrinsics.checkNotNull(var5);
         var5.close();
      } catch (IOException var4) {
         var2 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("Error while closing socket. ");
         var3.append(var4);
         var2.e(var3.toString(), new Object[0]);
      }

      this.mSocket = null;
      this.isConnected = false;
   }

   public final int getReadTimeout() {
      return this.readTimeout;
   }

   public final String getServerIP() {
      return this.serverIP;
   }

   public final int getServerPort() {
      return this.serverPort;
   }

   public final boolean isConnected() {
      return this.isConnected;
   }

   public final String readLine() {
      Timber.Forest.d("Reading a line of text from the server.", new Object[0]);

      try {
         BufferedReader var1 = this.mReader;
         Intrinsics.checkNotNull(var1);
         String var3 = var1.readLine();
         return var3;
      } catch (IOException var2) {
         Timber.Forest.e((Throwable)var2);
         return null;
      }
   }

   public final String readMessage() {
      String var3 = "";

      label29: {
         int var1;
         char[] var5;
         try {
            var1 = kReadBufferLength;
            var5 = new char[var1];
         } catch (IOException var8) {
            boolean var10001 = false;
            break label29;
         }

         while(true) {
            int var2;
            String var12;
            try {
               BufferedReader var4 = this.mReader;
               Intrinsics.checkNotNull(var4);
               var2 = var4.read(var5, 0, var1);
               StringBuilder var11 = new StringBuilder();
               var11.append(var3);
               var3 = new String(var5, 0, var2);
               var11.append(var3);
               var12 = var11.toString();
            } catch (IOException var7) {
               boolean var14 = false;
               break;
            }

            var3 = var12;
            if (var2 != var1) {
               try {
                  Timber.Forest var13 = Timber.Forest;
                  StringBuilder var10 = new StringBuilder();
                  var10.append("Received message from server: ");
                  var10.append(var12);
                  var13.d(var10.toString(), new Object[0]);
                  return var12;
               } catch (IOException var6) {
                  boolean var15 = false;
                  break;
               }
            }
         }
      }

      Timber.Forest.e("Reading from the server failed.", new Object[0]);
      return null;
   }

   public final void setConnected(boolean var1) {
      this.isConnected = var1;
   }

   public final boolean writeLine(String var1) {
      Intrinsics.checkNotNullParameter(var1, "message");
      StringBuilder var2 = new StringBuilder();
      var2.append(var1);
      var2.append('\n');
      return this.writeMessage(var2.toString());
   }

   public final boolean writeMessage(String var1) {
      Intrinsics.checkNotNullParameter(var1, "message");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Sending a message to the server: \"");
      var2.append(var1);
      var2.append("\".");
      var3.d(var2.toString(), new Object[0]);
      PrintWriter var5 = this.mWriter;
      if (var5 != null) {
         Intrinsics.checkNotNull(var5);
         if (!var5.checkError()) {
            var5 = this.mWriter;
            Intrinsics.checkNotNull(var5);
            var5.println(var1);
            PrintWriter var4 = this.mWriter;
            Intrinsics.checkNotNull(var4);
            var4.flush();
            return true;
         }
      }

      Timber.Forest.e("Sending of the message failed due to the write stream's state.", new Object[0]);
      return false;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/NetworkTCPTextClient$Companion;", "", "<init>", "()V", "LOG_TAG", "", "kReadBufferLength", "", "adddevice_otherRelease"},
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
}
