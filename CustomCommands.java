package custom;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CustomCommands {

    public interface AddressCmdOrBuilder extends MessageLiteOrBuilder {
    }

    public interface AddressRespOrBuilder extends MessageLiteOrBuilder {
        String getMacAddress();

        ByteString getMacAddressBytes();
    }

    public interface CommandWrapperOrBuilder extends MessageLiteOrBuilder {
        AddressCmd getAddressCmd();

        AddressResp getAddressResp();

        ConfigCmd getConfigCmd();

        ConfigResp getConfigResp();

        EventCmd getEventCmd();

        EventResp getEventResp();

        FactoryCmd getFactoryCmd();

        FactoryResp getFactoryResp();

        FilterReadCmd getFilterReadCmd();

        FilterReadResp getFilterReadResp();

        FilterSetCmd getFilterSetCmd();

        FilterSetResp getFilterSetResp();

        CommandWrapper.PayloadCase getPayloadCase();

        StartCmd getStartCmd();

        StartResp getStartResp();

        StopCmd getStopCmd();

        StopResp getStopResp();

        boolean hasAddressCmd();

        boolean hasAddressResp();

        boolean hasConfigCmd();

        boolean hasConfigResp();

        boolean hasEventCmd();

        boolean hasEventResp();

        boolean hasFactoryCmd();

        boolean hasFactoryResp();

        boolean hasFilterReadCmd();

        boolean hasFilterReadResp();

        boolean hasFilterSetCmd();

        boolean hasFilterSetResp();

        boolean hasStartCmd();

        boolean hasStartResp();

        boolean hasStopCmd();

        boolean hasStopResp();
    }

    public interface ConfigCmdOrBuilder extends MessageLiteOrBuilder {
        String getApiUrl();

        ByteString getApiUrlBytes();

        String getAuthUrl();

        ByteString getAuthUrlBytes();

        String getBrokerUrl();

        ByteString getBrokerUrlBytes();

        ConfigCmd.PayloadCase getPayloadCase();

        String getRandomText();

        ByteString getRandomTextBytes();

        String getRegion();

        ByteString getRegionBytes();

        String getSecureRandom();

        ByteString getSecureRandomBytes();

        boolean hasApiUrl();

        boolean hasAuthUrl();

        boolean hasBrokerUrl();

        boolean hasRandomText();

        boolean hasRegion();

        boolean hasSecureRandom();
    }

    public interface ConfigRespOrBuilder extends MessageLiteOrBuilder {
        Status getStatus();

        int getStatusValue();
    }

    public interface EventCmdOrBuilder extends MessageLiteOrBuilder {
        EventCommands getCmd();

        int getCmdValue();
    }

    public interface EventRespOrBuilder extends MessageLiteOrBuilder {
        String getJson();

        ByteString getJsonBytes();

        int getNumberOfEvents();
    }

    public interface FactoryCmdOrBuilder extends MessageLiteOrBuilder {
        String getPwd();

        ByteString getPwdBytes();

        String getSsid();

        ByteString getSsidBytes();

        String getToken();

        ByteString getTokenBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    public interface FactoryRespOrBuilder extends MessageLiteOrBuilder {
        Status getStatus();

        int getStatusValue();
    }

    public interface FilterReadCmdOrBuilder extends MessageLiteOrBuilder {
        String getType();

        ByteString getTypeBytes();
    }

    public interface FilterReadRespOrBuilder extends MessageLiteOrBuilder {
        int getFilter();
    }

    public interface FilterSetCmdOrBuilder extends MessageLiteOrBuilder {
        String getFilter();

        ByteString getFilterBytes();
    }

    public interface FilterSetRespOrBuilder extends MessageLiteOrBuilder {
        Status getStatus();

        int getStatusValue();
    }

    public interface StartCmdOrBuilder extends MessageLiteOrBuilder {
    }

    public interface StartRespOrBuilder extends MessageLiteOrBuilder {
        Status getStatus();

        int getStatusValue();
    }

    public interface StopCmdOrBuilder extends MessageLiteOrBuilder {
    }

    public interface StopRespOrBuilder extends MessageLiteOrBuilder {
        Status getStatus();

        int getStatusValue();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private CustomCommands() {
    }

    public enum Status implements Internal.EnumLite {
        Success(0),
        Fail(1),
        UNRECOGNIZED(-1);
        
        public static final int Fail_VALUE = 1;
        public static final int Success_VALUE = 0;
        private static final Internal.EnumLiteMap<Status> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<Status>() {
                public Status findValueByNumber(int i) {
                    return Status.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Status valueOf(int i) {
            return forNumber(i);
        }

        public static Status forNumber(int i) {
            if (i == 0) {
                return Success;
            }
            if (i != 1) {
                return null;
            }
            return Fail;
        }

        public static Internal.EnumLiteMap<Status> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return StatusVerifier.INSTANCE;
        }

        private static final class StatusVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private StatusVerifier() {
            }

            static {
                INSTANCE = new StatusVerifier();
            }

            public boolean isInRange(int i) {
                return Status.forNumber(i) != null;
            }
        }

        private Status(int i) {
            this.value = i;
        }
    }

    public enum EventCommands implements Internal.EnumLite {
        EventGet(0),
        EventClearAll(1),
        UNRECOGNIZED(-1);
        
        public static final int EventClearAll_VALUE = 1;
        public static final int EventGet_VALUE = 0;
        private static final Internal.EnumLiteMap<EventCommands> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<EventCommands>() {
                public EventCommands findValueByNumber(int i) {
                    return EventCommands.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static EventCommands valueOf(int i) {
            return forNumber(i);
        }

        public static EventCommands forNumber(int i) {
            if (i == 0) {
                return EventGet;
            }
            if (i != 1) {
                return null;
            }
            return EventClearAll;
        }

        public static Internal.EnumLiteMap<EventCommands> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return EventCommandsVerifier.INSTANCE;
        }

        private static final class EventCommandsVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private EventCommandsVerifier() {
            }

            static {
                INSTANCE = new EventCommandsVerifier();
            }

            public boolean isInRange(int i) {
                return EventCommands.forNumber(i) != null;
            }
        }

        private EventCommands(int i) {
            this.value = i;
        }
    }

    public static final class StartCmd extends GeneratedMessageLite<StartCmd, Builder> implements StartCmdOrBuilder {
        /* access modifiers changed from: private */
        public static final StartCmd DEFAULT_INSTANCE;
        private static volatile Parser<StartCmd> PARSER;

        private StartCmd() {
        }

        public static StartCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StartCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StartCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StartCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StartCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StartCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StartCmd parseFrom(InputStream inputStream) throws IOException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StartCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StartCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StartCmd startCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(startCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StartCmd, Builder> implements StartCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(StartCmd.DEFAULT_INSTANCE);
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new StartCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", (Object[]) null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StartCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (StartCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            StartCmd startCmd = new StartCmd();
            DEFAULT_INSTANCE = startCmd;
            GeneratedMessageLite.registerDefaultInstance(StartCmd.class, startCmd);
        }

        public static StartCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StartCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: custom.CustomCommands$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: custom.CustomCommands.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class StartResp extends GeneratedMessageLite<StartResp, Builder> implements StartRespOrBuilder {
        /* access modifiers changed from: private */
        public static final StartResp DEFAULT_INSTANCE;
        private static volatile Parser<StartResp> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 1;
        private int status_;

        private StartResp() {
        }

        public int getStatusValue() {
            return this.status_;
        }

        public Status getStatus() {
            Status forNumber = Status.forNumber(this.status_);
            return forNumber == null ? Status.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setStatusValue(int i) {
            this.status_ = i;
        }

        /* access modifiers changed from: private */
        public void setStatus(Status status) {
            this.status_ = status.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        public static StartResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StartResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StartResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StartResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StartResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StartResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StartResp parseFrom(InputStream inputStream) throws IOException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StartResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StartResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StartResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StartResp startResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(startResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StartResp, Builder> implements StartRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(StartResp.DEFAULT_INSTANCE);
            }

            public int getStatusValue() {
                return ((StartResp) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int i) {
                copyOnWrite();
                ((StartResp) this.instance).setStatusValue(i);
                return this;
            }

            public Status getStatus() {
                return ((StartResp) this.instance).getStatus();
            }

            public Builder setStatus(Status status) {
                copyOnWrite();
                ((StartResp) this.instance).setStatus(status);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((StartResp) this.instance).clearStatus();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new StartResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StartResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (StartResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            StartResp startResp = new StartResp();
            DEFAULT_INSTANCE = startResp;
            GeneratedMessageLite.registerDefaultInstance(StartResp.class, startResp);
        }

        public static StartResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StartResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ConfigCmd extends GeneratedMessageLite<ConfigCmd, Builder> implements ConfigCmdOrBuilder {
        public static final int API_URL_FIELD_NUMBER = 1;
        public static final int AUTH_URL_FIELD_NUMBER = 2;
        public static final int BROKER_URL_FIELD_NUMBER = 3;
        /* access modifiers changed from: private */
        public static final ConfigCmd DEFAULT_INSTANCE;
        private static volatile Parser<ConfigCmd> PARSER = null;
        public static final int RANDOM_TEXT_FIELD_NUMBER = 5;
        public static final int REGION_FIELD_NUMBER = 4;
        public static final int SECURE_RANDOM_FIELD_NUMBER = 6;
        private int payloadCase_ = 0;
        private Object payload_;

        private ConfigCmd() {
        }

        public enum PayloadCase {
            API_URL(1),
            AUTH_URL(2),
            BROKER_URL(3),
            REGION(4),
            RANDOM_TEXT(5),
            SECURE_RANDOM(6),
            PAYLOAD_NOT_SET(0);
            
            private final int value;

            private PayloadCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static PayloadCase valueOf(int i) {
                return forNumber(i);
            }

            public static PayloadCase forNumber(int i) {
                switch (i) {
                    case 0:
                        return PAYLOAD_NOT_SET;
                    case 1:
                        return API_URL;
                    case 2:
                        return AUTH_URL;
                    case 3:
                        return BROKER_URL;
                    case 4:
                        return REGION;
                    case 5:
                        return RANDOM_TEXT;
                    case 6:
                        return SECURE_RANDOM;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        public PayloadCase getPayloadCase() {
            return PayloadCase.forNumber(this.payloadCase_);
        }

        /* access modifiers changed from: private */
        public void clearPayload() {
            this.payloadCase_ = 0;
            this.payload_ = null;
        }

        public boolean hasApiUrl() {
            return this.payloadCase_ == 1;
        }

        public String getApiUrl() {
            if (this.payloadCase_ == 1) {
                return (String) this.payload_;
            }
            return "";
        }

        public ByteString getApiUrlBytes() {
            String str;
            if (this.payloadCase_ == 1) {
                str = (String) this.payload_;
            } else {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }

        /* access modifiers changed from: private */
        public void setApiUrl(String str) {
            str.getClass();
            this.payloadCase_ = 1;
            this.payload_ = str;
        }

        /* access modifiers changed from: private */
        public void clearApiUrl() {
            if (this.payloadCase_ == 1) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void setApiUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.payload_ = byteString.toStringUtf8();
            this.payloadCase_ = 1;
        }

        public boolean hasAuthUrl() {
            return this.payloadCase_ == 2;
        }

        public String getAuthUrl() {
            if (this.payloadCase_ == 2) {
                return (String) this.payload_;
            }
            return "";
        }

        public ByteString getAuthUrlBytes() {
            String str;
            if (this.payloadCase_ == 2) {
                str = (String) this.payload_;
            } else {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }

        /* access modifiers changed from: private */
        public void setAuthUrl(String str) {
            str.getClass();
            this.payloadCase_ = 2;
            this.payload_ = str;
        }

        /* access modifiers changed from: private */
        public void clearAuthUrl() {
            if (this.payloadCase_ == 2) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void setAuthUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.payload_ = byteString.toStringUtf8();
            this.payloadCase_ = 2;
        }

        public boolean hasBrokerUrl() {
            return this.payloadCase_ == 3;
        }

        public String getBrokerUrl() {
            if (this.payloadCase_ == 3) {
                return (String) this.payload_;
            }
            return "";
        }

        public ByteString getBrokerUrlBytes() {
            String str;
            if (this.payloadCase_ == 3) {
                str = (String) this.payload_;
            } else {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }

        /* access modifiers changed from: private */
        public void setBrokerUrl(String str) {
            str.getClass();
            this.payloadCase_ = 3;
            this.payload_ = str;
        }

        /* access modifiers changed from: private */
        public void clearBrokerUrl() {
            if (this.payloadCase_ == 3) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void setBrokerUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.payload_ = byteString.toStringUtf8();
            this.payloadCase_ = 3;
        }

        public boolean hasRegion() {
            return this.payloadCase_ == 4;
        }

        public String getRegion() {
            if (this.payloadCase_ == 4) {
                return (String) this.payload_;
            }
            return "";
        }

        public ByteString getRegionBytes() {
            String str;
            if (this.payloadCase_ == 4) {
                str = (String) this.payload_;
            } else {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }

        /* access modifiers changed from: private */
        public void setRegion(String str) {
            str.getClass();
            this.payloadCase_ = 4;
            this.payload_ = str;
        }

        /* access modifiers changed from: private */
        public void clearRegion() {
            if (this.payloadCase_ == 4) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void setRegionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.payload_ = byteString.toStringUtf8();
            this.payloadCase_ = 4;
        }

        public boolean hasRandomText() {
            return this.payloadCase_ == 5;
        }

        public String getRandomText() {
            if (this.payloadCase_ == 5) {
                return (String) this.payload_;
            }
            return "";
        }

        public ByteString getRandomTextBytes() {
            String str;
            if (this.payloadCase_ == 5) {
                str = (String) this.payload_;
            } else {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }

        /* access modifiers changed from: private */
        public void setRandomText(String str) {
            str.getClass();
            this.payloadCase_ = 5;
            this.payload_ = str;
        }

        /* access modifiers changed from: private */
        public void clearRandomText() {
            if (this.payloadCase_ == 5) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void setRandomTextBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.payload_ = byteString.toStringUtf8();
            this.payloadCase_ = 5;
        }

        public boolean hasSecureRandom() {
            return this.payloadCase_ == 6;
        }

        public String getSecureRandom() {
            if (this.payloadCase_ == 6) {
                return (String) this.payload_;
            }
            return "";
        }

        public ByteString getSecureRandomBytes() {
            String str;
            if (this.payloadCase_ == 6) {
                str = (String) this.payload_;
            } else {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }

        /* access modifiers changed from: private */
        public void setSecureRandom(String str) {
            str.getClass();
            this.payloadCase_ = 6;
            this.payload_ = str;
        }

        /* access modifiers changed from: private */
        public void clearSecureRandom() {
            if (this.payloadCase_ == 6) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void setSecureRandomBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.payload_ = byteString.toStringUtf8();
            this.payloadCase_ = 6;
        }

        public static ConfigCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConfigCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConfigCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConfigCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConfigCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConfigCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConfigCmd parseFrom(InputStream inputStream) throws IOException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConfigCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConfigCmd configCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(configCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigCmd, Builder> implements ConfigCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(ConfigCmd.DEFAULT_INSTANCE);
            }

            public PayloadCase getPayloadCase() {
                return ((ConfigCmd) this.instance).getPayloadCase();
            }

            public Builder clearPayload() {
                copyOnWrite();
                ((ConfigCmd) this.instance).clearPayload();
                return this;
            }

            public boolean hasApiUrl() {
                return ((ConfigCmd) this.instance).hasApiUrl();
            }

            public String getApiUrl() {
                return ((ConfigCmd) this.instance).getApiUrl();
            }

            public ByteString getApiUrlBytes() {
                return ((ConfigCmd) this.instance).getApiUrlBytes();
            }

            public Builder setApiUrl(String str) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setApiUrl(str);
                return this;
            }

            public Builder clearApiUrl() {
                copyOnWrite();
                ((ConfigCmd) this.instance).clearApiUrl();
                return this;
            }

            public Builder setApiUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setApiUrlBytes(byteString);
                return this;
            }

            public boolean hasAuthUrl() {
                return ((ConfigCmd) this.instance).hasAuthUrl();
            }

            public String getAuthUrl() {
                return ((ConfigCmd) this.instance).getAuthUrl();
            }

            public ByteString getAuthUrlBytes() {
                return ((ConfigCmd) this.instance).getAuthUrlBytes();
            }

            public Builder setAuthUrl(String str) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setAuthUrl(str);
                return this;
            }

            public Builder clearAuthUrl() {
                copyOnWrite();
                ((ConfigCmd) this.instance).clearAuthUrl();
                return this;
            }

            public Builder setAuthUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setAuthUrlBytes(byteString);
                return this;
            }

            public boolean hasBrokerUrl() {
                return ((ConfigCmd) this.instance).hasBrokerUrl();
            }

            public String getBrokerUrl() {
                return ((ConfigCmd) this.instance).getBrokerUrl();
            }

            public ByteString getBrokerUrlBytes() {
                return ((ConfigCmd) this.instance).getBrokerUrlBytes();
            }

            public Builder setBrokerUrl(String str) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setBrokerUrl(str);
                return this;
            }

            public Builder clearBrokerUrl() {
                copyOnWrite();
                ((ConfigCmd) this.instance).clearBrokerUrl();
                return this;
            }

            public Builder setBrokerUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setBrokerUrlBytes(byteString);
                return this;
            }

            public boolean hasRegion() {
                return ((ConfigCmd) this.instance).hasRegion();
            }

            public String getRegion() {
                return ((ConfigCmd) this.instance).getRegion();
            }

            public ByteString getRegionBytes() {
                return ((ConfigCmd) this.instance).getRegionBytes();
            }

            public Builder setRegion(String str) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setRegion(str);
                return this;
            }

            public Builder clearRegion() {
                copyOnWrite();
                ((ConfigCmd) this.instance).clearRegion();
                return this;
            }

            public Builder setRegionBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setRegionBytes(byteString);
                return this;
            }

            public boolean hasRandomText() {
                return ((ConfigCmd) this.instance).hasRandomText();
            }

            public String getRandomText() {
                return ((ConfigCmd) this.instance).getRandomText();
            }

            public ByteString getRandomTextBytes() {
                return ((ConfigCmd) this.instance).getRandomTextBytes();
            }

            public Builder setRandomText(String str) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setRandomText(str);
                return this;
            }

            public Builder clearRandomText() {
                copyOnWrite();
                ((ConfigCmd) this.instance).clearRandomText();
                return this;
            }

            public Builder setRandomTextBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setRandomTextBytes(byteString);
                return this;
            }

            public boolean hasSecureRandom() {
                return ((ConfigCmd) this.instance).hasSecureRandom();
            }

            public String getSecureRandom() {
                return ((ConfigCmd) this.instance).getSecureRandom();
            }

            public ByteString getSecureRandomBytes() {
                return ((ConfigCmd) this.instance).getSecureRandomBytes();
            }

            public Builder setSecureRandom(String str) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setSecureRandom(str);
                return this;
            }

            public Builder clearSecureRandom() {
                copyOnWrite();
                ((ConfigCmd) this.instance).clearSecureRandom();
                return this;
            }

            public Builder setSecureRandomBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigCmd) this.instance).setSecureRandomBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConfigCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȼ\u0000\u0002Ȼ\u0000\u0003Ȼ\u0000\u0004Ȼ\u0000\u0005Ȼ\u0000\u0006Ȼ\u0000", new Object[]{"payload_", "payloadCase_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConfigCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ConfigCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ConfigCmd configCmd = new ConfigCmd();
            DEFAULT_INSTANCE = configCmd;
            GeneratedMessageLite.registerDefaultInstance(ConfigCmd.class, configCmd);
        }

        public static ConfigCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConfigCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ConfigResp extends GeneratedMessageLite<ConfigResp, Builder> implements ConfigRespOrBuilder {
        /* access modifiers changed from: private */
        public static final ConfigResp DEFAULT_INSTANCE;
        private static volatile Parser<ConfigResp> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 1;
        private int status_;

        private ConfigResp() {
        }

        public int getStatusValue() {
            return this.status_;
        }

        public Status getStatus() {
            Status forNumber = Status.forNumber(this.status_);
            return forNumber == null ? Status.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setStatusValue(int i) {
            this.status_ = i;
        }

        /* access modifiers changed from: private */
        public void setStatus(Status status) {
            this.status_ = status.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        public static ConfigResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConfigResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConfigResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConfigResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConfigResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConfigResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConfigResp parseFrom(InputStream inputStream) throws IOException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConfigResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConfigResp configResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(configResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigResp, Builder> implements ConfigRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(ConfigResp.DEFAULT_INSTANCE);
            }

            public int getStatusValue() {
                return ((ConfigResp) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int i) {
                copyOnWrite();
                ((ConfigResp) this.instance).setStatusValue(i);
                return this;
            }

            public Status getStatus() {
                return ((ConfigResp) this.instance).getStatus();
            }

            public Builder setStatus(Status status) {
                copyOnWrite();
                ((ConfigResp) this.instance).setStatus(status);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((ConfigResp) this.instance).clearStatus();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConfigResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConfigResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ConfigResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ConfigResp configResp = new ConfigResp();
            DEFAULT_INSTANCE = configResp;
            GeneratedMessageLite.registerDefaultInstance(ConfigResp.class, configResp);
        }

        public static ConfigResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConfigResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EventCmd extends GeneratedMessageLite<EventCmd, Builder> implements EventCmdOrBuilder {
        public static final int CMD_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final EventCmd DEFAULT_INSTANCE;
        private static volatile Parser<EventCmd> PARSER;
        private int cmd_;

        private EventCmd() {
        }

        public int getCmdValue() {
            return this.cmd_;
        }

        public EventCommands getCmd() {
            EventCommands forNumber = EventCommands.forNumber(this.cmd_);
            return forNumber == null ? EventCommands.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setCmdValue(int i) {
            this.cmd_ = i;
        }

        /* access modifiers changed from: private */
        public void setCmd(EventCommands eventCommands) {
            this.cmd_ = eventCommands.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearCmd() {
            this.cmd_ = 0;
        }

        public static EventCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EventCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EventCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EventCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EventCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EventCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EventCmd parseFrom(InputStream inputStream) throws IOException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EventCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EventCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(EventCmd eventCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(eventCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EventCmd, Builder> implements EventCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(EventCmd.DEFAULT_INSTANCE);
            }

            public int getCmdValue() {
                return ((EventCmd) this.instance).getCmdValue();
            }

            public Builder setCmdValue(int i) {
                copyOnWrite();
                ((EventCmd) this.instance).setCmdValue(i);
                return this;
            }

            public EventCommands getCmd() {
                return ((EventCmd) this.instance).getCmd();
            }

            public Builder setCmd(EventCommands eventCommands) {
                copyOnWrite();
                ((EventCmd) this.instance).setCmd(eventCommands);
                return this;
            }

            public Builder clearCmd() {
                copyOnWrite();
                ((EventCmd) this.instance).clearCmd();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new EventCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"cmd_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EventCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (EventCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            EventCmd eventCmd = new EventCmd();
            DEFAULT_INSTANCE = eventCmd;
            GeneratedMessageLite.registerDefaultInstance(EventCmd.class, eventCmd);
        }

        public static EventCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EventCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EventResp extends GeneratedMessageLite<EventResp, Builder> implements EventRespOrBuilder {
        /* access modifiers changed from: private */
        public static final EventResp DEFAULT_INSTANCE;
        public static final int JSON_FIELD_NUMBER = 1;
        public static final int NUMBER_OF_EVENTS_FIELD_NUMBER = 2;
        private static volatile Parser<EventResp> PARSER;
        private String json_ = "";
        private int numberOfEvents_;

        private EventResp() {
        }

        public String getJson() {
            return this.json_;
        }

        public ByteString getJsonBytes() {
            return ByteString.copyFromUtf8(this.json_);
        }

        /* access modifiers changed from: private */
        public void setJson(String str) {
            str.getClass();
            this.json_ = str;
        }

        /* access modifiers changed from: private */
        public void clearJson() {
            this.json_ = getDefaultInstance().getJson();
        }

        /* access modifiers changed from: private */
        public void setJsonBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.json_ = byteString.toStringUtf8();
        }

        public int getNumberOfEvents() {
            return this.numberOfEvents_;
        }

        /* access modifiers changed from: private */
        public void setNumberOfEvents(int i) {
            this.numberOfEvents_ = i;
        }

        /* access modifiers changed from: private */
        public void clearNumberOfEvents() {
            this.numberOfEvents_ = 0;
        }

        public static EventResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EventResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EventResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EventResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EventResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EventResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EventResp parseFrom(InputStream inputStream) throws IOException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EventResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EventResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(EventResp eventResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(eventResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EventResp, Builder> implements EventRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(EventResp.DEFAULT_INSTANCE);
            }

            public String getJson() {
                return ((EventResp) this.instance).getJson();
            }

            public ByteString getJsonBytes() {
                return ((EventResp) this.instance).getJsonBytes();
            }

            public Builder setJson(String str) {
                copyOnWrite();
                ((EventResp) this.instance).setJson(str);
                return this;
            }

            public Builder clearJson() {
                copyOnWrite();
                ((EventResp) this.instance).clearJson();
                return this;
            }

            public Builder setJsonBytes(ByteString byteString) {
                copyOnWrite();
                ((EventResp) this.instance).setJsonBytes(byteString);
                return this;
            }

            public int getNumberOfEvents() {
                return ((EventResp) this.instance).getNumberOfEvents();
            }

            public Builder setNumberOfEvents(int i) {
                copyOnWrite();
                ((EventResp) this.instance).setNumberOfEvents(i);
                return this;
            }

            public Builder clearNumberOfEvents() {
                copyOnWrite();
                ((EventResp) this.instance).clearNumberOfEvents();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new EventResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"json_", "numberOfEvents_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EventResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (EventResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            EventResp eventResp = new EventResp();
            DEFAULT_INSTANCE = eventResp;
            GeneratedMessageLite.registerDefaultInstance(EventResp.class, eventResp);
        }

        public static EventResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EventResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AddressCmd extends GeneratedMessageLite<AddressCmd, Builder> implements AddressCmdOrBuilder {
        /* access modifiers changed from: private */
        public static final AddressCmd DEFAULT_INSTANCE;
        private static volatile Parser<AddressCmd> PARSER;

        private AddressCmd() {
        }

        public static AddressCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AddressCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AddressCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AddressCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AddressCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AddressCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AddressCmd parseFrom(InputStream inputStream) throws IOException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AddressCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AddressCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AddressCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AddressCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddressCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AddressCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AddressCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddressCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AddressCmd addressCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(addressCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AddressCmd, Builder> implements AddressCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(AddressCmd.DEFAULT_INSTANCE);
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AddressCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", (Object[]) null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AddressCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (AddressCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AddressCmd addressCmd = new AddressCmd();
            DEFAULT_INSTANCE = addressCmd;
            GeneratedMessageLite.registerDefaultInstance(AddressCmd.class, addressCmd);
        }

        public static AddressCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AddressCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AddressResp extends GeneratedMessageLite<AddressResp, Builder> implements AddressRespOrBuilder {
        /* access modifiers changed from: private */
        public static final AddressResp DEFAULT_INSTANCE;
        public static final int MAC_ADDRESS_FIELD_NUMBER = 1;
        private static volatile Parser<AddressResp> PARSER;
        private String macAddress_ = "";

        private AddressResp() {
        }

        public String getMacAddress() {
            return this.macAddress_;
        }

        public ByteString getMacAddressBytes() {
            return ByteString.copyFromUtf8(this.macAddress_);
        }

        /* access modifiers changed from: private */
        public void setMacAddress(String str) {
            str.getClass();
            this.macAddress_ = str;
        }

        /* access modifiers changed from: private */
        public void clearMacAddress() {
            this.macAddress_ = getDefaultInstance().getMacAddress();
        }

        /* access modifiers changed from: private */
        public void setMacAddressBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.macAddress_ = byteString.toStringUtf8();
        }

        public static AddressResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AddressResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AddressResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AddressResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AddressResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AddressResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AddressResp parseFrom(InputStream inputStream) throws IOException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AddressResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AddressResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AddressResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AddressResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddressResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AddressResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AddressResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddressResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AddressResp addressResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(addressResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AddressResp, Builder> implements AddressRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(AddressResp.DEFAULT_INSTANCE);
            }

            public String getMacAddress() {
                return ((AddressResp) this.instance).getMacAddress();
            }

            public ByteString getMacAddressBytes() {
                return ((AddressResp) this.instance).getMacAddressBytes();
            }

            public Builder setMacAddress(String str) {
                copyOnWrite();
                ((AddressResp) this.instance).setMacAddress(str);
                return this;
            }

            public Builder clearMacAddress() {
                copyOnWrite();
                ((AddressResp) this.instance).clearMacAddress();
                return this;
            }

            public Builder setMacAddressBytes(ByteString byteString) {
                copyOnWrite();
                ((AddressResp) this.instance).setMacAddressBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AddressResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"macAddress_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AddressResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (AddressResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AddressResp addressResp = new AddressResp();
            DEFAULT_INSTANCE = addressResp;
            GeneratedMessageLite.registerDefaultInstance(AddressResp.class, addressResp);
        }

        public static AddressResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AddressResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StopCmd extends GeneratedMessageLite<StopCmd, Builder> implements StopCmdOrBuilder {
        /* access modifiers changed from: private */
        public static final StopCmd DEFAULT_INSTANCE;
        private static volatile Parser<StopCmd> PARSER;

        private StopCmd() {
        }

        public static StopCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StopCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StopCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StopCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StopCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StopCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StopCmd parseFrom(InputStream inputStream) throws IOException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StopCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StopCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StopCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StopCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StopCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StopCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StopCmd stopCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(stopCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StopCmd, Builder> implements StopCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(StopCmd.DEFAULT_INSTANCE);
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new StopCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", (Object[]) null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StopCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (StopCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            StopCmd stopCmd = new StopCmd();
            DEFAULT_INSTANCE = stopCmd;
            GeneratedMessageLite.registerDefaultInstance(StopCmd.class, stopCmd);
        }

        public static StopCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StopCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StopResp extends GeneratedMessageLite<StopResp, Builder> implements StopRespOrBuilder {
        /* access modifiers changed from: private */
        public static final StopResp DEFAULT_INSTANCE;
        private static volatile Parser<StopResp> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 1;
        private int status_;

        private StopResp() {
        }

        public int getStatusValue() {
            return this.status_;
        }

        public Status getStatus() {
            Status forNumber = Status.forNumber(this.status_);
            return forNumber == null ? Status.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setStatusValue(int i) {
            this.status_ = i;
        }

        /* access modifiers changed from: private */
        public void setStatus(Status status) {
            this.status_ = status.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        public static StopResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StopResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StopResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StopResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StopResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StopResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StopResp parseFrom(InputStream inputStream) throws IOException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StopResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StopResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StopResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StopResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StopResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StopResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StopResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StopResp stopResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(stopResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StopResp, Builder> implements StopRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(StopResp.DEFAULT_INSTANCE);
            }

            public int getStatusValue() {
                return ((StopResp) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int i) {
                copyOnWrite();
                ((StopResp) this.instance).setStatusValue(i);
                return this;
            }

            public Status getStatus() {
                return ((StopResp) this.instance).getStatus();
            }

            public Builder setStatus(Status status) {
                copyOnWrite();
                ((StopResp) this.instance).setStatus(status);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((StopResp) this.instance).clearStatus();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new StopResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StopResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (StopResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            StopResp stopResp = new StopResp();
            DEFAULT_INSTANCE = stopResp;
            GeneratedMessageLite.registerDefaultInstance(StopResp.class, stopResp);
        }

        public static StopResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StopResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FactoryCmd extends GeneratedMessageLite<FactoryCmd, Builder> implements FactoryCmdOrBuilder {
        /* access modifiers changed from: private */
        public static final FactoryCmd DEFAULT_INSTANCE;
        private static volatile Parser<FactoryCmd> PARSER = null;
        public static final int PWD_FIELD_NUMBER = 3;
        public static final int SSID_FIELD_NUMBER = 2;
        public static final int TOKEN_FIELD_NUMBER = 4;
        public static final int URL_FIELD_NUMBER = 1;
        private String pwd_ = "";
        private String ssid_ = "";
        private String token_ = "";
        private String url_ = "";

        private FactoryCmd() {
        }

        public String getUrl() {
            return this.url_;
        }

        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        /* access modifiers changed from: private */
        public void setUrl(String str) {
            str.getClass();
            this.url_ = str;
        }

        /* access modifiers changed from: private */
        public void clearUrl() {
            this.url_ = getDefaultInstance().getUrl();
        }

        /* access modifiers changed from: private */
        public void setUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.url_ = byteString.toStringUtf8();
        }

        public String getSsid() {
            return this.ssid_;
        }

        public ByteString getSsidBytes() {
            return ByteString.copyFromUtf8(this.ssid_);
        }

        /* access modifiers changed from: private */
        public void setSsid(String str) {
            str.getClass();
            this.ssid_ = str;
        }

        /* access modifiers changed from: private */
        public void clearSsid() {
            this.ssid_ = getDefaultInstance().getSsid();
        }

        /* access modifiers changed from: private */
        public void setSsidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.ssid_ = byteString.toStringUtf8();
        }

        public String getPwd() {
            return this.pwd_;
        }

        public ByteString getPwdBytes() {
            return ByteString.copyFromUtf8(this.pwd_);
        }

        /* access modifiers changed from: private */
        public void setPwd(String str) {
            str.getClass();
            this.pwd_ = str;
        }

        /* access modifiers changed from: private */
        public void clearPwd() {
            this.pwd_ = getDefaultInstance().getPwd();
        }

        /* access modifiers changed from: private */
        public void setPwdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.pwd_ = byteString.toStringUtf8();
        }

        public String getToken() {
            return this.token_;
        }

        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        /* access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.token_ = str;
        }

        /* access modifiers changed from: private */
        public void clearToken() {
            this.token_ = getDefaultInstance().getToken();
        }

        /* access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.token_ = byteString.toStringUtf8();
        }

        public static FactoryCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FactoryCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FactoryCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FactoryCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FactoryCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FactoryCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FactoryCmd parseFrom(InputStream inputStream) throws IOException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FactoryCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FactoryCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FactoryCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FactoryCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FactoryCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FactoryCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FactoryCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FactoryCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FactoryCmd factoryCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(factoryCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FactoryCmd, Builder> implements FactoryCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(FactoryCmd.DEFAULT_INSTANCE);
            }

            public String getUrl() {
                return ((FactoryCmd) this.instance).getUrl();
            }

            public ByteString getUrlBytes() {
                return ((FactoryCmd) this.instance).getUrlBytes();
            }

            public Builder setUrl(String str) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setUrl(str);
                return this;
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((FactoryCmd) this.instance).clearUrl();
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setUrlBytes(byteString);
                return this;
            }

            public String getSsid() {
                return ((FactoryCmd) this.instance).getSsid();
            }

            public ByteString getSsidBytes() {
                return ((FactoryCmd) this.instance).getSsidBytes();
            }

            public Builder setSsid(String str) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setSsid(str);
                return this;
            }

            public Builder clearSsid() {
                copyOnWrite();
                ((FactoryCmd) this.instance).clearSsid();
                return this;
            }

            public Builder setSsidBytes(ByteString byteString) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setSsidBytes(byteString);
                return this;
            }

            public String getPwd() {
                return ((FactoryCmd) this.instance).getPwd();
            }

            public ByteString getPwdBytes() {
                return ((FactoryCmd) this.instance).getPwdBytes();
            }

            public Builder setPwd(String str) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setPwd(str);
                return this;
            }

            public Builder clearPwd() {
                copyOnWrite();
                ((FactoryCmd) this.instance).clearPwd();
                return this;
            }

            public Builder setPwdBytes(ByteString byteString) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setPwdBytes(byteString);
                return this;
            }

            public String getToken() {
                return ((FactoryCmd) this.instance).getToken();
            }

            public ByteString getTokenBytes() {
                return ((FactoryCmd) this.instance).getTokenBytes();
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setToken(str);
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((FactoryCmd) this.instance).clearToken();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((FactoryCmd) this.instance).setTokenBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FactoryCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"url_", "ssid_", "pwd_", "token_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FactoryCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (FactoryCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            FactoryCmd factoryCmd = new FactoryCmd();
            DEFAULT_INSTANCE = factoryCmd;
            GeneratedMessageLite.registerDefaultInstance(FactoryCmd.class, factoryCmd);
        }

        public static FactoryCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FactoryCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FactoryResp extends GeneratedMessageLite<FactoryResp, Builder> implements FactoryRespOrBuilder {
        /* access modifiers changed from: private */
        public static final FactoryResp DEFAULT_INSTANCE;
        private static volatile Parser<FactoryResp> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 1;
        private int status_;

        private FactoryResp() {
        }

        public int getStatusValue() {
            return this.status_;
        }

        public Status getStatus() {
            Status forNumber = Status.forNumber(this.status_);
            return forNumber == null ? Status.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setStatusValue(int i) {
            this.status_ = i;
        }

        /* access modifiers changed from: private */
        public void setStatus(Status status) {
            this.status_ = status.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        public static FactoryResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FactoryResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FactoryResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FactoryResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FactoryResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FactoryResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FactoryResp parseFrom(InputStream inputStream) throws IOException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FactoryResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FactoryResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FactoryResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FactoryResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FactoryResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FactoryResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FactoryResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FactoryResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FactoryResp factoryResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(factoryResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FactoryResp, Builder> implements FactoryRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(FactoryResp.DEFAULT_INSTANCE);
            }

            public int getStatusValue() {
                return ((FactoryResp) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int i) {
                copyOnWrite();
                ((FactoryResp) this.instance).setStatusValue(i);
                return this;
            }

            public Status getStatus() {
                return ((FactoryResp) this.instance).getStatus();
            }

            public Builder setStatus(Status status) {
                copyOnWrite();
                ((FactoryResp) this.instance).setStatus(status);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((FactoryResp) this.instance).clearStatus();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FactoryResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FactoryResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (FactoryResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            FactoryResp factoryResp = new FactoryResp();
            DEFAULT_INSTANCE = factoryResp;
            GeneratedMessageLite.registerDefaultInstance(FactoryResp.class, factoryResp);
        }

        public static FactoryResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FactoryResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FilterReadCmd extends GeneratedMessageLite<FilterReadCmd, Builder> implements FilterReadCmdOrBuilder {
        /* access modifiers changed from: private */
        public static final FilterReadCmd DEFAULT_INSTANCE;
        private static volatile Parser<FilterReadCmd> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        private String type_ = "";

        private FilterReadCmd() {
        }

        public String getType() {
            return this.type_;
        }

        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        /* access modifiers changed from: private */
        public void setType(String str) {
            str.getClass();
            this.type_ = str;
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.type_ = getDefaultInstance().getType();
        }

        /* access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.type_ = byteString.toStringUtf8();
        }

        public static FilterReadCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FilterReadCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FilterReadCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FilterReadCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FilterReadCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FilterReadCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FilterReadCmd parseFrom(InputStream inputStream) throws IOException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterReadCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterReadCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FilterReadCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterReadCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterReadCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterReadCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FilterReadCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterReadCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FilterReadCmd filterReadCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(filterReadCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FilterReadCmd, Builder> implements FilterReadCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(FilterReadCmd.DEFAULT_INSTANCE);
            }

            public String getType() {
                return ((FilterReadCmd) this.instance).getType();
            }

            public ByteString getTypeBytes() {
                return ((FilterReadCmd) this.instance).getTypeBytes();
            }

            public Builder setType(String str) {
                copyOnWrite();
                ((FilterReadCmd) this.instance).setType(str);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((FilterReadCmd) this.instance).clearType();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((FilterReadCmd) this.instance).setTypeBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FilterReadCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"type_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FilterReadCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (FilterReadCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            FilterReadCmd filterReadCmd = new FilterReadCmd();
            DEFAULT_INSTANCE = filterReadCmd;
            GeneratedMessageLite.registerDefaultInstance(FilterReadCmd.class, filterReadCmd);
        }

        public static FilterReadCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FilterReadCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FilterReadResp extends GeneratedMessageLite<FilterReadResp, Builder> implements FilterReadRespOrBuilder {
        /* access modifiers changed from: private */
        public static final FilterReadResp DEFAULT_INSTANCE;
        public static final int FILTER_FIELD_NUMBER = 1;
        private static volatile Parser<FilterReadResp> PARSER;
        private int filter_;

        private FilterReadResp() {
        }

        public int getFilter() {
            return this.filter_;
        }

        /* access modifiers changed from: private */
        public void setFilter(int i) {
            this.filter_ = i;
        }

        /* access modifiers changed from: private */
        public void clearFilter() {
            this.filter_ = 0;
        }

        public static FilterReadResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FilterReadResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FilterReadResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FilterReadResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FilterReadResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FilterReadResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FilterReadResp parseFrom(InputStream inputStream) throws IOException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterReadResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterReadResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FilterReadResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterReadResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterReadResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterReadResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FilterReadResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterReadResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FilterReadResp filterReadResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(filterReadResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FilterReadResp, Builder> implements FilterReadRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(FilterReadResp.DEFAULT_INSTANCE);
            }

            public int getFilter() {
                return ((FilterReadResp) this.instance).getFilter();
            }

            public Builder setFilter(int i) {
                copyOnWrite();
                ((FilterReadResp) this.instance).setFilter(i);
                return this;
            }

            public Builder clearFilter() {
                copyOnWrite();
                ((FilterReadResp) this.instance).clearFilter();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FilterReadResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"filter_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FilterReadResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (FilterReadResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            FilterReadResp filterReadResp = new FilterReadResp();
            DEFAULT_INSTANCE = filterReadResp;
            GeneratedMessageLite.registerDefaultInstance(FilterReadResp.class, filterReadResp);
        }

        public static FilterReadResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FilterReadResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FilterSetCmd extends GeneratedMessageLite<FilterSetCmd, Builder> implements FilterSetCmdOrBuilder {
        /* access modifiers changed from: private */
        public static final FilterSetCmd DEFAULT_INSTANCE;
        public static final int FILTER_FIELD_NUMBER = 1;
        private static volatile Parser<FilterSetCmd> PARSER;
        private String filter_ = "";

        private FilterSetCmd() {
        }

        public String getFilter() {
            return this.filter_;
        }

        public ByteString getFilterBytes() {
            return ByteString.copyFromUtf8(this.filter_);
        }

        /* access modifiers changed from: private */
        public void setFilter(String str) {
            str.getClass();
            this.filter_ = str;
        }

        /* access modifiers changed from: private */
        public void clearFilter() {
            this.filter_ = getDefaultInstance().getFilter();
        }

        /* access modifiers changed from: private */
        public void setFilterBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.filter_ = byteString.toStringUtf8();
        }

        public static FilterSetCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FilterSetCmd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FilterSetCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FilterSetCmd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FilterSetCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FilterSetCmd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FilterSetCmd parseFrom(InputStream inputStream) throws IOException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterSetCmd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterSetCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FilterSetCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterSetCmd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterSetCmd) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterSetCmd parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FilterSetCmd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterSetCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FilterSetCmd filterSetCmd) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(filterSetCmd);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FilterSetCmd, Builder> implements FilterSetCmdOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(FilterSetCmd.DEFAULT_INSTANCE);
            }

            public String getFilter() {
                return ((FilterSetCmd) this.instance).getFilter();
            }

            public ByteString getFilterBytes() {
                return ((FilterSetCmd) this.instance).getFilterBytes();
            }

            public Builder setFilter(String str) {
                copyOnWrite();
                ((FilterSetCmd) this.instance).setFilter(str);
                return this;
            }

            public Builder clearFilter() {
                copyOnWrite();
                ((FilterSetCmd) this.instance).clearFilter();
                return this;
            }

            public Builder setFilterBytes(ByteString byteString) {
                copyOnWrite();
                ((FilterSetCmd) this.instance).setFilterBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FilterSetCmd();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"filter_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FilterSetCmd> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (FilterSetCmd.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            FilterSetCmd filterSetCmd = new FilterSetCmd();
            DEFAULT_INSTANCE = filterSetCmd;
            GeneratedMessageLite.registerDefaultInstance(FilterSetCmd.class, filterSetCmd);
        }

        public static FilterSetCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FilterSetCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FilterSetResp extends GeneratedMessageLite<FilterSetResp, Builder> implements FilterSetRespOrBuilder {
        /* access modifiers changed from: private */
        public static final FilterSetResp DEFAULT_INSTANCE;
        private static volatile Parser<FilterSetResp> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 1;
        private int status_;

        private FilterSetResp() {
        }

        public int getStatusValue() {
            return this.status_;
        }

        public Status getStatus() {
            Status forNumber = Status.forNumber(this.status_);
            return forNumber == null ? Status.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setStatusValue(int i) {
            this.status_ = i;
        }

        /* access modifiers changed from: private */
        public void setStatus(Status status) {
            this.status_ = status.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        public static FilterSetResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FilterSetResp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FilterSetResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FilterSetResp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FilterSetResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FilterSetResp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FilterSetResp parseFrom(InputStream inputStream) throws IOException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterSetResp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterSetResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FilterSetResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterSetResp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterSetResp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterSetResp parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FilterSetResp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterSetResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FilterSetResp filterSetResp) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(filterSetResp);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FilterSetResp, Builder> implements FilterSetRespOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(FilterSetResp.DEFAULT_INSTANCE);
            }

            public int getStatusValue() {
                return ((FilterSetResp) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int i) {
                copyOnWrite();
                ((FilterSetResp) this.instance).setStatusValue(i);
                return this;
            }

            public Status getStatus() {
                return ((FilterSetResp) this.instance).getStatus();
            }

            public Builder setStatus(Status status) {
                copyOnWrite();
                ((FilterSetResp) this.instance).setStatus(status);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((FilterSetResp) this.instance).clearStatus();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FilterSetResp();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FilterSetResp> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (FilterSetResp.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            FilterSetResp filterSetResp = new FilterSetResp();
            DEFAULT_INSTANCE = filterSetResp;
            GeneratedMessageLite.registerDefaultInstance(FilterSetResp.class, filterSetResp);
        }

        public static FilterSetResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FilterSetResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class CommandWrapper extends GeneratedMessageLite<CommandWrapper, Builder> implements CommandWrapperOrBuilder {
        public static final int ADDRESS_CMD_FIELD_NUMBER = 7;
        public static final int ADDRESS_RESP_FIELD_NUMBER = 8;
        public static final int CONFIG_CMD_FIELD_NUMBER = 3;
        public static final int CONFIG_RESP_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */
        public static final CommandWrapper DEFAULT_INSTANCE;
        public static final int EVENT_CMD_FIELD_NUMBER = 5;
        public static final int EVENT_RESP_FIELD_NUMBER = 6;
        public static final int FACTORY_CMD_FIELD_NUMBER = 11;
        public static final int FACTORY_RESP_FIELD_NUMBER = 12;
        public static final int FILTER_READ_CMD_FIELD_NUMBER = 13;
        public static final int FILTER_READ_RESP_FIELD_NUMBER = 14;
        public static final int FILTER_SET_CMD_FIELD_NUMBER = 15;
        public static final int FILTER_SET_RESP_FIELD_NUMBER = 16;
        private static volatile Parser<CommandWrapper> PARSER = null;
        public static final int START_CMD_FIELD_NUMBER = 1;
        public static final int START_RESP_FIELD_NUMBER = 2;
        public static final int STOP_CMD_FIELD_NUMBER = 9;
        public static final int STOP_RESP_FIELD_NUMBER = 10;
        private int payloadCase_ = 0;
        private Object payload_;

        private CommandWrapper() {
        }

        public enum PayloadCase {
            START_CMD(1),
            START_RESP(2),
            CONFIG_CMD(3),
            CONFIG_RESP(4),
            EVENT_CMD(5),
            EVENT_RESP(6),
            ADDRESS_CMD(7),
            ADDRESS_RESP(8),
            STOP_CMD(9),
            STOP_RESP(10),
            FACTORY_CMD(11),
            FACTORY_RESP(12),
            FILTER_READ_CMD(13),
            FILTER_READ_RESP(14),
            FILTER_SET_CMD(15),
            FILTER_SET_RESP(16),
            PAYLOAD_NOT_SET(0);
            
            private final int value;

            private PayloadCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static PayloadCase valueOf(int i) {
                return forNumber(i);
            }

            public static PayloadCase forNumber(int i) {
                switch (i) {
                    case 0:
                        return PAYLOAD_NOT_SET;
                    case 1:
                        return START_CMD;
                    case 2:
                        return START_RESP;
                    case 3:
                        return CONFIG_CMD;
                    case 4:
                        return CONFIG_RESP;
                    case 5:
                        return EVENT_CMD;
                    case 6:
                        return EVENT_RESP;
                    case 7:
                        return ADDRESS_CMD;
                    case 8:
                        return ADDRESS_RESP;
                    case 9:
                        return STOP_CMD;
                    case 10:
                        return STOP_RESP;
                    case 11:
                        return FACTORY_CMD;
                    case 12:
                        return FACTORY_RESP;
                    case 13:
                        return FILTER_READ_CMD;
                    case 14:
                        return FILTER_READ_RESP;
                    case 15:
                        return FILTER_SET_CMD;
                    case 16:
                        return FILTER_SET_RESP;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        public PayloadCase getPayloadCase() {
            return PayloadCase.forNumber(this.payloadCase_);
        }

        /* access modifiers changed from: private */
        public void clearPayload() {
            this.payloadCase_ = 0;
            this.payload_ = null;
        }

        public boolean hasStartCmd() {
            return this.payloadCase_ == 1;
        }

        public StartCmd getStartCmd() {
            if (this.payloadCase_ == 1) {
                return (StartCmd) this.payload_;
            }
            return StartCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setStartCmd(StartCmd startCmd) {
            startCmd.getClass();
            this.payload_ = startCmd;
            this.payloadCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void mergeStartCmd(StartCmd startCmd) {
            startCmd.getClass();
            if (this.payloadCase_ != 1 || this.payload_ == StartCmd.getDefaultInstance()) {
                this.payload_ = startCmd;
            } else {
                this.payload_ = ((StartCmd.Builder) StartCmd.newBuilder((StartCmd) this.payload_).mergeFrom(startCmd)).buildPartial();
            }
            this.payloadCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void clearStartCmd() {
            if (this.payloadCase_ == 1) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasStartResp() {
            return this.payloadCase_ == 2;
        }

        public StartResp getStartResp() {
            if (this.payloadCase_ == 2) {
                return (StartResp) this.payload_;
            }
            return StartResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setStartResp(StartResp startResp) {
            startResp.getClass();
            this.payload_ = startResp;
            this.payloadCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void mergeStartResp(StartResp startResp) {
            startResp.getClass();
            if (this.payloadCase_ != 2 || this.payload_ == StartResp.getDefaultInstance()) {
                this.payload_ = startResp;
            } else {
                this.payload_ = ((StartResp.Builder) StartResp.newBuilder((StartResp) this.payload_).mergeFrom(startResp)).buildPartial();
            }
            this.payloadCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void clearStartResp() {
            if (this.payloadCase_ == 2) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasConfigCmd() {
            return this.payloadCase_ == 3;
        }

        public ConfigCmd getConfigCmd() {
            if (this.payloadCase_ == 3) {
                return (ConfigCmd) this.payload_;
            }
            return ConfigCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setConfigCmd(ConfigCmd configCmd) {
            configCmd.getClass();
            this.payload_ = configCmd;
            this.payloadCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void mergeConfigCmd(ConfigCmd configCmd) {
            configCmd.getClass();
            if (this.payloadCase_ != 3 || this.payload_ == ConfigCmd.getDefaultInstance()) {
                this.payload_ = configCmd;
            } else {
                this.payload_ = ((ConfigCmd.Builder) ConfigCmd.newBuilder((ConfigCmd) this.payload_).mergeFrom(configCmd)).buildPartial();
            }
            this.payloadCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void clearConfigCmd() {
            if (this.payloadCase_ == 3) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasConfigResp() {
            return this.payloadCase_ == 4;
        }

        public ConfigResp getConfigResp() {
            if (this.payloadCase_ == 4) {
                return (ConfigResp) this.payload_;
            }
            return ConfigResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setConfigResp(ConfigResp configResp) {
            configResp.getClass();
            this.payload_ = configResp;
            this.payloadCase_ = 4;
        }

        /* access modifiers changed from: private */
        public void mergeConfigResp(ConfigResp configResp) {
            configResp.getClass();
            if (this.payloadCase_ != 4 || this.payload_ == ConfigResp.getDefaultInstance()) {
                this.payload_ = configResp;
            } else {
                this.payload_ = ((ConfigResp.Builder) ConfigResp.newBuilder((ConfigResp) this.payload_).mergeFrom(configResp)).buildPartial();
            }
            this.payloadCase_ = 4;
        }

        /* access modifiers changed from: private */
        public void clearConfigResp() {
            if (this.payloadCase_ == 4) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasEventCmd() {
            return this.payloadCase_ == 5;
        }

        public EventCmd getEventCmd() {
            if (this.payloadCase_ == 5) {
                return (EventCmd) this.payload_;
            }
            return EventCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setEventCmd(EventCmd eventCmd) {
            eventCmd.getClass();
            this.payload_ = eventCmd;
            this.payloadCase_ = 5;
        }

        /* access modifiers changed from: private */
        public void mergeEventCmd(EventCmd eventCmd) {
            eventCmd.getClass();
            if (this.payloadCase_ != 5 || this.payload_ == EventCmd.getDefaultInstance()) {
                this.payload_ = eventCmd;
            } else {
                this.payload_ = ((EventCmd.Builder) EventCmd.newBuilder((EventCmd) this.payload_).mergeFrom(eventCmd)).buildPartial();
            }
            this.payloadCase_ = 5;
        }

        /* access modifiers changed from: private */
        public void clearEventCmd() {
            if (this.payloadCase_ == 5) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasEventResp() {
            return this.payloadCase_ == 6;
        }

        public EventResp getEventResp() {
            if (this.payloadCase_ == 6) {
                return (EventResp) this.payload_;
            }
            return EventResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setEventResp(EventResp eventResp) {
            eventResp.getClass();
            this.payload_ = eventResp;
            this.payloadCase_ = 6;
        }

        /* access modifiers changed from: private */
        public void mergeEventResp(EventResp eventResp) {
            eventResp.getClass();
            if (this.payloadCase_ != 6 || this.payload_ == EventResp.getDefaultInstance()) {
                this.payload_ = eventResp;
            } else {
                this.payload_ = ((EventResp.Builder) EventResp.newBuilder((EventResp) this.payload_).mergeFrom(eventResp)).buildPartial();
            }
            this.payloadCase_ = 6;
        }

        /* access modifiers changed from: private */
        public void clearEventResp() {
            if (this.payloadCase_ == 6) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasAddressCmd() {
            return this.payloadCase_ == 7;
        }

        public AddressCmd getAddressCmd() {
            if (this.payloadCase_ == 7) {
                return (AddressCmd) this.payload_;
            }
            return AddressCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setAddressCmd(AddressCmd addressCmd) {
            addressCmd.getClass();
            this.payload_ = addressCmd;
            this.payloadCase_ = 7;
        }

        /* access modifiers changed from: private */
        public void mergeAddressCmd(AddressCmd addressCmd) {
            addressCmd.getClass();
            if (this.payloadCase_ != 7 || this.payload_ == AddressCmd.getDefaultInstance()) {
                this.payload_ = addressCmd;
            } else {
                this.payload_ = ((AddressCmd.Builder) AddressCmd.newBuilder((AddressCmd) this.payload_).mergeFrom(addressCmd)).buildPartial();
            }
            this.payloadCase_ = 7;
        }

        /* access modifiers changed from: private */
        public void clearAddressCmd() {
            if (this.payloadCase_ == 7) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasAddressResp() {
            return this.payloadCase_ == 8;
        }

        public AddressResp getAddressResp() {
            if (this.payloadCase_ == 8) {
                return (AddressResp) this.payload_;
            }
            return AddressResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setAddressResp(AddressResp addressResp) {
            addressResp.getClass();
            this.payload_ = addressResp;
            this.payloadCase_ = 8;
        }

        /* access modifiers changed from: private */
        public void mergeAddressResp(AddressResp addressResp) {
            addressResp.getClass();
            if (this.payloadCase_ != 8 || this.payload_ == AddressResp.getDefaultInstance()) {
                this.payload_ = addressResp;
            } else {
                this.payload_ = ((AddressResp.Builder) AddressResp.newBuilder((AddressResp) this.payload_).mergeFrom(addressResp)).buildPartial();
            }
            this.payloadCase_ = 8;
        }

        /* access modifiers changed from: private */
        public void clearAddressResp() {
            if (this.payloadCase_ == 8) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasStopCmd() {
            return this.payloadCase_ == 9;
        }

        public StopCmd getStopCmd() {
            if (this.payloadCase_ == 9) {
                return (StopCmd) this.payload_;
            }
            return StopCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setStopCmd(StopCmd stopCmd) {
            stopCmd.getClass();
            this.payload_ = stopCmd;
            this.payloadCase_ = 9;
        }

        /* access modifiers changed from: private */
        public void mergeStopCmd(StopCmd stopCmd) {
            stopCmd.getClass();
            if (this.payloadCase_ != 9 || this.payload_ == StopCmd.getDefaultInstance()) {
                this.payload_ = stopCmd;
            } else {
                this.payload_ = ((StopCmd.Builder) StopCmd.newBuilder((StopCmd) this.payload_).mergeFrom(stopCmd)).buildPartial();
            }
            this.payloadCase_ = 9;
        }

        /* access modifiers changed from: private */
        public void clearStopCmd() {
            if (this.payloadCase_ == 9) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasStopResp() {
            return this.payloadCase_ == 10;
        }

        public StopResp getStopResp() {
            if (this.payloadCase_ == 10) {
                return (StopResp) this.payload_;
            }
            return StopResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setStopResp(StopResp stopResp) {
            stopResp.getClass();
            this.payload_ = stopResp;
            this.payloadCase_ = 10;
        }

        /* access modifiers changed from: private */
        public void mergeStopResp(StopResp stopResp) {
            stopResp.getClass();
            if (this.payloadCase_ != 10 || this.payload_ == StopResp.getDefaultInstance()) {
                this.payload_ = stopResp;
            } else {
                this.payload_ = ((StopResp.Builder) StopResp.newBuilder((StopResp) this.payload_).mergeFrom(stopResp)).buildPartial();
            }
            this.payloadCase_ = 10;
        }

        /* access modifiers changed from: private */
        public void clearStopResp() {
            if (this.payloadCase_ == 10) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasFactoryCmd() {
            return this.payloadCase_ == 11;
        }

        public FactoryCmd getFactoryCmd() {
            if (this.payloadCase_ == 11) {
                return (FactoryCmd) this.payload_;
            }
            return FactoryCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setFactoryCmd(FactoryCmd factoryCmd) {
            factoryCmd.getClass();
            this.payload_ = factoryCmd;
            this.payloadCase_ = 11;
        }

        /* access modifiers changed from: private */
        public void mergeFactoryCmd(FactoryCmd factoryCmd) {
            factoryCmd.getClass();
            if (this.payloadCase_ != 11 || this.payload_ == FactoryCmd.getDefaultInstance()) {
                this.payload_ = factoryCmd;
            } else {
                this.payload_ = ((FactoryCmd.Builder) FactoryCmd.newBuilder((FactoryCmd) this.payload_).mergeFrom(factoryCmd)).buildPartial();
            }
            this.payloadCase_ = 11;
        }

        /* access modifiers changed from: private */
        public void clearFactoryCmd() {
            if (this.payloadCase_ == 11) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasFactoryResp() {
            return this.payloadCase_ == 12;
        }

        public FactoryResp getFactoryResp() {
            if (this.payloadCase_ == 12) {
                return (FactoryResp) this.payload_;
            }
            return FactoryResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setFactoryResp(FactoryResp factoryResp) {
            factoryResp.getClass();
            this.payload_ = factoryResp;
            this.payloadCase_ = 12;
        }

        /* access modifiers changed from: private */
        public void mergeFactoryResp(FactoryResp factoryResp) {
            factoryResp.getClass();
            if (this.payloadCase_ != 12 || this.payload_ == FactoryResp.getDefaultInstance()) {
                this.payload_ = factoryResp;
            } else {
                this.payload_ = ((FactoryResp.Builder) FactoryResp.newBuilder((FactoryResp) this.payload_).mergeFrom(factoryResp)).buildPartial();
            }
            this.payloadCase_ = 12;
        }

        /* access modifiers changed from: private */
        public void clearFactoryResp() {
            if (this.payloadCase_ == 12) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasFilterReadCmd() {
            return this.payloadCase_ == 13;
        }

        public FilterReadCmd getFilterReadCmd() {
            if (this.payloadCase_ == 13) {
                return (FilterReadCmd) this.payload_;
            }
            return FilterReadCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setFilterReadCmd(FilterReadCmd filterReadCmd) {
            filterReadCmd.getClass();
            this.payload_ = filterReadCmd;
            this.payloadCase_ = 13;
        }

        /* access modifiers changed from: private */
        public void mergeFilterReadCmd(FilterReadCmd filterReadCmd) {
            filterReadCmd.getClass();
            if (this.payloadCase_ != 13 || this.payload_ == FilterReadCmd.getDefaultInstance()) {
                this.payload_ = filterReadCmd;
            } else {
                this.payload_ = ((FilterReadCmd.Builder) FilterReadCmd.newBuilder((FilterReadCmd) this.payload_).mergeFrom(filterReadCmd)).buildPartial();
            }
            this.payloadCase_ = 13;
        }

        /* access modifiers changed from: private */
        public void clearFilterReadCmd() {
            if (this.payloadCase_ == 13) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasFilterReadResp() {
            return this.payloadCase_ == 14;
        }

        public FilterReadResp getFilterReadResp() {
            if (this.payloadCase_ == 14) {
                return (FilterReadResp) this.payload_;
            }
            return FilterReadResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setFilterReadResp(FilterReadResp filterReadResp) {
            filterReadResp.getClass();
            this.payload_ = filterReadResp;
            this.payloadCase_ = 14;
        }

        /* access modifiers changed from: private */
        public void mergeFilterReadResp(FilterReadResp filterReadResp) {
            filterReadResp.getClass();
            if (this.payloadCase_ != 14 || this.payload_ == FilterReadResp.getDefaultInstance()) {
                this.payload_ = filterReadResp;
            } else {
                this.payload_ = ((FilterReadResp.Builder) FilterReadResp.newBuilder((FilterReadResp) this.payload_).mergeFrom(filterReadResp)).buildPartial();
            }
            this.payloadCase_ = 14;
        }

        /* access modifiers changed from: private */
        public void clearFilterReadResp() {
            if (this.payloadCase_ == 14) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasFilterSetCmd() {
            return this.payloadCase_ == 15;
        }

        public FilterSetCmd getFilterSetCmd() {
            if (this.payloadCase_ == 15) {
                return (FilterSetCmd) this.payload_;
            }
            return FilterSetCmd.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setFilterSetCmd(FilterSetCmd filterSetCmd) {
            filterSetCmd.getClass();
            this.payload_ = filterSetCmd;
            this.payloadCase_ = 15;
        }

        /* access modifiers changed from: private */
        public void mergeFilterSetCmd(FilterSetCmd filterSetCmd) {
            filterSetCmd.getClass();
            if (this.payloadCase_ != 15 || this.payload_ == FilterSetCmd.getDefaultInstance()) {
                this.payload_ = filterSetCmd;
            } else {
                this.payload_ = ((FilterSetCmd.Builder) FilterSetCmd.newBuilder((FilterSetCmd) this.payload_).mergeFrom(filterSetCmd)).buildPartial();
            }
            this.payloadCase_ = 15;
        }

        /* access modifiers changed from: private */
        public void clearFilterSetCmd() {
            if (this.payloadCase_ == 15) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public boolean hasFilterSetResp() {
            return this.payloadCase_ == 16;
        }

        public FilterSetResp getFilterSetResp() {
            if (this.payloadCase_ == 16) {
                return (FilterSetResp) this.payload_;
            }
            return FilterSetResp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setFilterSetResp(FilterSetResp filterSetResp) {
            filterSetResp.getClass();
            this.payload_ = filterSetResp;
            this.payloadCase_ = 16;
        }

        /* access modifiers changed from: private */
        public void mergeFilterSetResp(FilterSetResp filterSetResp) {
            filterSetResp.getClass();
            if (this.payloadCase_ != 16 || this.payload_ == FilterSetResp.getDefaultInstance()) {
                this.payload_ = filterSetResp;
            } else {
                this.payload_ = ((FilterSetResp.Builder) FilterSetResp.newBuilder((FilterSetResp) this.payload_).mergeFrom(filterSetResp)).buildPartial();
            }
            this.payloadCase_ = 16;
        }

        /* access modifiers changed from: private */
        public void clearFilterSetResp() {
            if (this.payloadCase_ == 16) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        public static CommandWrapper parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CommandWrapper parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CommandWrapper parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CommandWrapper parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CommandWrapper parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CommandWrapper parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CommandWrapper parseFrom(InputStream inputStream) throws IOException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CommandWrapper parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CommandWrapper parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CommandWrapper) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CommandWrapper parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommandWrapper) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CommandWrapper parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CommandWrapper parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommandWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CommandWrapper commandWrapper) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(commandWrapper);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CommandWrapper, Builder> implements CommandWrapperOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(CommandWrapper.DEFAULT_INSTANCE);
            }

            public PayloadCase getPayloadCase() {
                return ((CommandWrapper) this.instance).getPayloadCase();
            }

            public Builder clearPayload() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearPayload();
                return this;
            }

            public boolean hasStartCmd() {
                return ((CommandWrapper) this.instance).hasStartCmd();
            }

            public StartCmd getStartCmd() {
                return ((CommandWrapper) this.instance).getStartCmd();
            }

            public Builder setStartCmd(StartCmd startCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStartCmd(startCmd);
                return this;
            }

            public Builder setStartCmd(StartCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStartCmd((StartCmd) builder.build());
                return this;
            }

            public Builder mergeStartCmd(StartCmd startCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeStartCmd(startCmd);
                return this;
            }

            public Builder clearStartCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearStartCmd();
                return this;
            }

            public boolean hasStartResp() {
                return ((CommandWrapper) this.instance).hasStartResp();
            }

            public StartResp getStartResp() {
                return ((CommandWrapper) this.instance).getStartResp();
            }

            public Builder setStartResp(StartResp startResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStartResp(startResp);
                return this;
            }

            public Builder setStartResp(StartResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStartResp((StartResp) builder.build());
                return this;
            }

            public Builder mergeStartResp(StartResp startResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeStartResp(startResp);
                return this;
            }

            public Builder clearStartResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearStartResp();
                return this;
            }

            public boolean hasConfigCmd() {
                return ((CommandWrapper) this.instance).hasConfigCmd();
            }

            public ConfigCmd getConfigCmd() {
                return ((CommandWrapper) this.instance).getConfigCmd();
            }

            public Builder setConfigCmd(ConfigCmd configCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setConfigCmd(configCmd);
                return this;
            }

            public Builder setConfigCmd(ConfigCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setConfigCmd((ConfigCmd) builder.build());
                return this;
            }

            public Builder mergeConfigCmd(ConfigCmd configCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeConfigCmd(configCmd);
                return this;
            }

            public Builder clearConfigCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearConfigCmd();
                return this;
            }

            public boolean hasConfigResp() {
                return ((CommandWrapper) this.instance).hasConfigResp();
            }

            public ConfigResp getConfigResp() {
                return ((CommandWrapper) this.instance).getConfigResp();
            }

            public Builder setConfigResp(ConfigResp configResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setConfigResp(configResp);
                return this;
            }

            public Builder setConfigResp(ConfigResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setConfigResp((ConfigResp) builder.build());
                return this;
            }

            public Builder mergeConfigResp(ConfigResp configResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeConfigResp(configResp);
                return this;
            }

            public Builder clearConfigResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearConfigResp();
                return this;
            }

            public boolean hasEventCmd() {
                return ((CommandWrapper) this.instance).hasEventCmd();
            }

            public EventCmd getEventCmd() {
                return ((CommandWrapper) this.instance).getEventCmd();
            }

            public Builder setEventCmd(EventCmd eventCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setEventCmd(eventCmd);
                return this;
            }

            public Builder setEventCmd(EventCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setEventCmd((EventCmd) builder.build());
                return this;
            }

            public Builder mergeEventCmd(EventCmd eventCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeEventCmd(eventCmd);
                return this;
            }

            public Builder clearEventCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearEventCmd();
                return this;
            }

            public boolean hasEventResp() {
                return ((CommandWrapper) this.instance).hasEventResp();
            }

            public EventResp getEventResp() {
                return ((CommandWrapper) this.instance).getEventResp();
            }

            public Builder setEventResp(EventResp eventResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setEventResp(eventResp);
                return this;
            }

            public Builder setEventResp(EventResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setEventResp((EventResp) builder.build());
                return this;
            }

            public Builder mergeEventResp(EventResp eventResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeEventResp(eventResp);
                return this;
            }

            public Builder clearEventResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearEventResp();
                return this;
            }

            public boolean hasAddressCmd() {
                return ((CommandWrapper) this.instance).hasAddressCmd();
            }

            public AddressCmd getAddressCmd() {
                return ((CommandWrapper) this.instance).getAddressCmd();
            }

            public Builder setAddressCmd(AddressCmd addressCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setAddressCmd(addressCmd);
                return this;
            }

            public Builder setAddressCmd(AddressCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setAddressCmd((AddressCmd) builder.build());
                return this;
            }

            public Builder mergeAddressCmd(AddressCmd addressCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeAddressCmd(addressCmd);
                return this;
            }

            public Builder clearAddressCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearAddressCmd();
                return this;
            }

            public boolean hasAddressResp() {
                return ((CommandWrapper) this.instance).hasAddressResp();
            }

            public AddressResp getAddressResp() {
                return ((CommandWrapper) this.instance).getAddressResp();
            }

            public Builder setAddressResp(AddressResp addressResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setAddressResp(addressResp);
                return this;
            }

            public Builder setAddressResp(AddressResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setAddressResp((AddressResp) builder.build());
                return this;
            }

            public Builder mergeAddressResp(AddressResp addressResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeAddressResp(addressResp);
                return this;
            }

            public Builder clearAddressResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearAddressResp();
                return this;
            }

            public boolean hasStopCmd() {
                return ((CommandWrapper) this.instance).hasStopCmd();
            }

            public StopCmd getStopCmd() {
                return ((CommandWrapper) this.instance).getStopCmd();
            }

            public Builder setStopCmd(StopCmd stopCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStopCmd(stopCmd);
                return this;
            }

            public Builder setStopCmd(StopCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStopCmd((StopCmd) builder.build());
                return this;
            }

            public Builder mergeStopCmd(StopCmd stopCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeStopCmd(stopCmd);
                return this;
            }

            public Builder clearStopCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearStopCmd();
                return this;
            }

            public boolean hasStopResp() {
                return ((CommandWrapper) this.instance).hasStopResp();
            }

            public StopResp getStopResp() {
                return ((CommandWrapper) this.instance).getStopResp();
            }

            public Builder setStopResp(StopResp stopResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStopResp(stopResp);
                return this;
            }

            public Builder setStopResp(StopResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setStopResp((StopResp) builder.build());
                return this;
            }

            public Builder mergeStopResp(StopResp stopResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeStopResp(stopResp);
                return this;
            }

            public Builder clearStopResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearStopResp();
                return this;
            }

            public boolean hasFactoryCmd() {
                return ((CommandWrapper) this.instance).hasFactoryCmd();
            }

            public FactoryCmd getFactoryCmd() {
                return ((CommandWrapper) this.instance).getFactoryCmd();
            }

            public Builder setFactoryCmd(FactoryCmd factoryCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFactoryCmd(factoryCmd);
                return this;
            }

            public Builder setFactoryCmd(FactoryCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFactoryCmd((FactoryCmd) builder.build());
                return this;
            }

            public Builder mergeFactoryCmd(FactoryCmd factoryCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeFactoryCmd(factoryCmd);
                return this;
            }

            public Builder clearFactoryCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearFactoryCmd();
                return this;
            }

            public boolean hasFactoryResp() {
                return ((CommandWrapper) this.instance).hasFactoryResp();
            }

            public FactoryResp getFactoryResp() {
                return ((CommandWrapper) this.instance).getFactoryResp();
            }

            public Builder setFactoryResp(FactoryResp factoryResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFactoryResp(factoryResp);
                return this;
            }

            public Builder setFactoryResp(FactoryResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFactoryResp((FactoryResp) builder.build());
                return this;
            }

            public Builder mergeFactoryResp(FactoryResp factoryResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeFactoryResp(factoryResp);
                return this;
            }

            public Builder clearFactoryResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearFactoryResp();
                return this;
            }

            public boolean hasFilterReadCmd() {
                return ((CommandWrapper) this.instance).hasFilterReadCmd();
            }

            public FilterReadCmd getFilterReadCmd() {
                return ((CommandWrapper) this.instance).getFilterReadCmd();
            }

            public Builder setFilterReadCmd(FilterReadCmd filterReadCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterReadCmd(filterReadCmd);
                return this;
            }

            public Builder setFilterReadCmd(FilterReadCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterReadCmd((FilterReadCmd) builder.build());
                return this;
            }

            public Builder mergeFilterReadCmd(FilterReadCmd filterReadCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeFilterReadCmd(filterReadCmd);
                return this;
            }

            public Builder clearFilterReadCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearFilterReadCmd();
                return this;
            }

            public boolean hasFilterReadResp() {
                return ((CommandWrapper) this.instance).hasFilterReadResp();
            }

            public FilterReadResp getFilterReadResp() {
                return ((CommandWrapper) this.instance).getFilterReadResp();
            }

            public Builder setFilterReadResp(FilterReadResp filterReadResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterReadResp(filterReadResp);
                return this;
            }

            public Builder setFilterReadResp(FilterReadResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterReadResp((FilterReadResp) builder.build());
                return this;
            }

            public Builder mergeFilterReadResp(FilterReadResp filterReadResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeFilterReadResp(filterReadResp);
                return this;
            }

            public Builder clearFilterReadResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearFilterReadResp();
                return this;
            }

            public boolean hasFilterSetCmd() {
                return ((CommandWrapper) this.instance).hasFilterSetCmd();
            }

            public FilterSetCmd getFilterSetCmd() {
                return ((CommandWrapper) this.instance).getFilterSetCmd();
            }

            public Builder setFilterSetCmd(FilterSetCmd filterSetCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterSetCmd(filterSetCmd);
                return this;
            }

            public Builder setFilterSetCmd(FilterSetCmd.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterSetCmd((FilterSetCmd) builder.build());
                return this;
            }

            public Builder mergeFilterSetCmd(FilterSetCmd filterSetCmd) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeFilterSetCmd(filterSetCmd);
                return this;
            }

            public Builder clearFilterSetCmd() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearFilterSetCmd();
                return this;
            }

            public boolean hasFilterSetResp() {
                return ((CommandWrapper) this.instance).hasFilterSetResp();
            }

            public FilterSetResp getFilterSetResp() {
                return ((CommandWrapper) this.instance).getFilterSetResp();
            }

            public Builder setFilterSetResp(FilterSetResp filterSetResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterSetResp(filterSetResp);
                return this;
            }

            public Builder setFilterSetResp(FilterSetResp.Builder builder) {
                copyOnWrite();
                ((CommandWrapper) this.instance).setFilterSetResp((FilterSetResp) builder.build());
                return this;
            }

            public Builder mergeFilterSetResp(FilterSetResp filterSetResp) {
                copyOnWrite();
                ((CommandWrapper) this.instance).mergeFilterSetResp(filterSetResp);
                return this;
            }

            public Builder clearFilterSetResp() {
                copyOnWrite();
                ((CommandWrapper) this.instance).clearFilterSetResp();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CommandWrapper();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0001\u0000\u0001\u0010\u0010\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000", new Object[]{"payload_", "payloadCase_", StartCmd.class, StartResp.class, ConfigCmd.class, ConfigResp.class, EventCmd.class, EventResp.class, AddressCmd.class, AddressResp.class, StopCmd.class, StopResp.class, FactoryCmd.class, FactoryResp.class, FilterReadCmd.class, FilterReadResp.class, FilterSetCmd.class, FilterSetResp.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CommandWrapper> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (CommandWrapper.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            CommandWrapper commandWrapper = new CommandWrapper();
            DEFAULT_INSTANCE = commandWrapper;
            GeneratedMessageLite.registerDefaultInstance(CommandWrapper.class, commandWrapper);
        }

        public static CommandWrapper getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CommandWrapper> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
