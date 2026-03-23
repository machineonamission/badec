package com.blueair.adddevice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0003J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003J\b\u0010 \u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/blueair/adddevice/NetworkTCPTextClient;", "", "serverIP", "", "serverPort", "", "readTimeout", "<init>", "(Ljava/lang/String;II)V", "getServerIP", "()Ljava/lang/String;", "getServerPort", "()I", "getReadTimeout", "isConnected", "", "()Z", "setConnected", "(Z)V", "mSocket", "Ljava/net/Socket;", "mWriter", "Ljava/io/PrintWriter;", "mReader", "Ljava/io/BufferedReader;", "connect", "disconnect", "", "writeMessage", "message", "writeLine", "readMessage", "readLine", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkTCPTextClient.kt */
public final class NetworkTCPTextClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG;
    private static final int kReadBufferLength = 512;
    private boolean isConnected = false;
    private BufferedReader mReader;
    private Socket mSocket;
    private PrintWriter mWriter;
    private final int readTimeout;
    private final String serverIP;
    private final int serverPort;

    public NetworkTCPTextClient(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "serverIP");
        this.serverIP = str;
        this.serverPort = i;
        this.readTimeout = i2;
    }

    public final String getServerIP() {
        return this.serverIP;
    }

    public final int getServerPort() {
        return this.serverPort;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final void setConnected(boolean z) {
        this.isConnected = z;
    }

    public final boolean connect() {
        if (this.isConnected) {
            disconnect();
        }
        Timber.Forest forest = Timber.Forest;
        forest.i("Connecting to " + this.serverIP + ':' + this.serverPort + " with a read time out of " + this.readTimeout + " milliseconds.", new Object[0]);
        try {
            try {
                Socket socket = new Socket(InetAddress.getByName(this.serverIP), this.serverPort);
                this.mSocket = socket;
                this.isConnected = true;
                try {
                    Intrinsics.checkNotNull(socket);
                    socket.setSoTimeout(this.readTimeout);
                } catch (IOException e) {
                    Timber.Forest forest2 = Timber.Forest;
                    forest2.e("Failed to set the read timeout for the socket. " + e, new Object[0]);
                }
                Socket socket2 = this.mSocket;
                Intrinsics.checkNotNull(socket2);
                this.mReader = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                Socket socket3 = this.mSocket;
                Intrinsics.checkNotNull(socket3);
                this.mWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket3.getOutputStream())), true);
            } catch (IOException e2) {
                Timber.Forest forest3 = Timber.Forest;
                forest3.e("Failed to connect to the socket. " + e2, new Object[0]);
            }
        } catch (UnknownHostException e3) {
            Timber.Forest forest4 = Timber.Forest;
            forest4.e("Failed to configure the address. " + e3, new Object[0]);
        }
        return this.isConnected;
    }

    public final void disconnect() {
        Timber.Forest forest = Timber.Forest;
        forest.i("Disconnecting from " + this.serverIP + ':' + this.serverPort + '.', new Object[0]);
        this.mReader = null;
        this.mWriter = null;
        try {
            Socket socket = this.mSocket;
            Intrinsics.checkNotNull(socket);
            socket.close();
        } catch (IOException e) {
            Timber.Forest forest2 = Timber.Forest;
            forest2.e("Error while closing socket. " + e, new Object[0]);
        }
        this.mSocket = null;
        this.isConnected = false;
    }

    public final boolean writeMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Timber.Forest forest = Timber.Forest;
        forest.d("Sending a message to the server: \"" + str + "\".", new Object[0]);
        PrintWriter printWriter = this.mWriter;
        if (printWriter != null) {
            Intrinsics.checkNotNull(printWriter);
            if (!printWriter.checkError()) {
                PrintWriter printWriter2 = this.mWriter;
                Intrinsics.checkNotNull(printWriter2);
                printWriter2.println(str);
                PrintWriter printWriter3 = this.mWriter;
                Intrinsics.checkNotNull(printWriter3);
                printWriter3.flush();
                return true;
            }
        }
        Timber.Forest.e("Sending of the message failed due to the write stream's state.", new Object[0]);
        return false;
    }

    public final boolean writeLine(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return writeMessage(str + 10);
    }

    public final String readMessage() {
        int read;
        String str = "";
        try {
            int i = kReadBufferLength;
            char[] cArr = new char[i];
            do {
                BufferedReader bufferedReader = this.mReader;
                Intrinsics.checkNotNull(bufferedReader);
                read = bufferedReader.read(cArr, 0, i);
                str = str + new String(cArr, 0, read);
            } while (read == i);
            Timber.Forest.d("Received message from server: " + str, new Object[0]);
            return str;
        } catch (IOException unused) {
            Timber.Forest.e("Reading from the server failed.", new Object[0]);
            return null;
        }
    }

    public final String readLine() {
        Timber.Forest.d("Reading a line of text from the server.", new Object[0]);
        try {
            BufferedReader bufferedReader = this.mReader;
            Intrinsics.checkNotNull(bufferedReader);
            return bufferedReader.readLine();
        } catch (IOException e) {
            Timber.Forest.e(e);
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/NetworkTCPTextClient$Companion;", "", "<init>", "()V", "LOG_TAG", "", "kReadBufferLength", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkTCPTextClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String cls = NetworkTCPTextClient.class.toString();
        Intrinsics.checkNotNullExpressionValue(cls, "toString(...)");
        LOG_TAG = cls;
    }
}
