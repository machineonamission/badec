package com.blueair.api.client;

import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.ActuatorWrapper;
import com.blueair.api.restapi.AutoModeTrigger;
import com.blueair.api.restapi.BlueCloudRestApi;
import com.blueair.api.restapi.G4NightModeTrigger;
import com.blueair.api.restapi.ModeDependency;
import com.blueair.api.restapi.NameConfiguration;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.api.restapi.UpdateWrapper;
import com.blueair.auth.AuthService;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.WelcomeHomeLocation;
import com.foobot.liblabclient.domain.outdoor.CityStation;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0013\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 Ò\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u00152\u00020\u00162\u00020\u00172\u00020\u00182\u00020\u00192\u00020\u001a2\u00020\u001b2\u00020\u001c2\u00020\u001d2\u00020\u001e2\u00020\u001f2\u00020 2\u00020!2\u00020\"2\u00020#2\u00020$:\u0002Ò\u0001B+\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0004\b-\u0010.J$\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020NH@¢\u0006\u0002\u0010OJ$\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020*2\u0006\u0010P\u001a\u00020QH@¢\u0006\u0002\u0010RJ$\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020*2\u0006\u0010S\u001a\u00020TH@¢\u0006\u0002\u0010UJ\"\u0010V\u001a\b\u0012\u0004\u0012\u00020K0J2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XH@¢\u0006\u0002\u0010ZJ\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0JH@¢\u0006\u0002\u0010]J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010_\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010b\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010d\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010f\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010i\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010k\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010q\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010s\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010u\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010w\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u0014\u0010y\u001a\b\u0012\u0004\u0012\u00020K0JH@¢\u0006\u0002\u0010]J\u001c\u0010z\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001c\u0010{\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J'\u0010\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0001\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020NH@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J0\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0001\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020N2\u0006\u0010_\u001a\u00020NH@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J'\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020QH@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010m\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010m\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J+\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0001\u001a\u00020N2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H@¢\u0006\u0003\u0010\u0001J+\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0001\u001a\u00020N2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u0015\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020K0JH@¢\u0006\u0002\u0010]J\u001d\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001d\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001d\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u001d\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ(\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010©\u0001\u001a\u00020N2\u0007\u0010ª\u0001\u001a\u00020NH@¢\u0006\u0003\u0010\u0001J+\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010¬\u0001\u001a\u00020N2\n\u0010­\u0001\u001a\u0005\u0018\u00010®\u0001H@¢\u0006\u0003\u0010¯\u0001J\u0015\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020K0JH@¢\u0006\u0002\u0010]J'\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020N2\u0007\u0010²\u0001\u001a\u00020QH@¢\u0006\u0003\u0010\u0001J\u001d\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020QH@¢\u0006\u0002\u0010gJ\u001d\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020NH@¢\u0006\u0002\u0010`J\u0016\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u00010JH@¢\u0006\u0002\u0010]J'\u0010·\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¶\u00010X0J2\b\u0010¸\u0001\u001a\u00030¹\u0001H@¢\u0006\u0003\u0010º\u0001J\u0015\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020T0JH@¢\u0006\u0002\u0010]J\u001f\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020T0J2\u0007\u0010½\u0001\u001a\u00020TH@¢\u0006\u0003\u0010¾\u0001J\u001f\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00020T0J2\u0007\u0010½\u0001\u001a\u00020*H@¢\u0006\u0003\u0010À\u0001J!\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010J2\b\u0010Ã\u0001\u001a\u00030Ä\u0001H@¢\u0006\u0003\u0010Å\u0001J\u001a\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020*H@¢\u0006\u0003\u0010À\u0001J\"\u0010É\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0J2\b\u0010Ã\u0001\u001a\u00030Ä\u0001H@¢\u0006\u0003\u0010Å\u0001J\u001c\u0010Ê\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ä\u00010X0JH@¢\u0006\u0002\u0010]J!\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u00030Ç\u00010J2\b\u0010Ì\u0001\u001a\u00030Í\u0001H@¢\u0006\u0003\u0010Î\u0001J\u0016\u0010Ï\u0001\u001a\t\u0012\u0005\u0012\u00030Ç\u00010JH@¢\u0006\u0002\u0010]J\b\u0010Ð\u0001\u001a\u00030¹\u0001J\n\u0010Ñ\u0001\u001a\u00030Ç\u0001H\u0016R\u0014\u0010%\u001a\u00020&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010+\u001a\u0004\u0018\u00010,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8VX\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020B8VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020F8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006Ó\u0001"}, d2 = {"Lcom/blueair/api/client/BlueCloudClient;", "Lcom/blueair/api/client/BlueCloudNetworkClient;", "Lcom/blueair/api/client/CanProvisionCloud;", "Lcom/blueair/api/client/CanSetFan;", "Lcom/blueair/api/client/CanSetChildLock;", "Lcom/blueair/api/client/CanSetBrightness;", "Lcom/blueair/api/client/CanGetSensorData;", "Lcom/blueair/api/client/CanSetStandBy;", "Lcom/blueair/api/client/CanSetG4NightMode;", "Lcom/blueair/api/client/CanSetGermShieldMode;", "Lcom/blueair/api/client/CanSetAutoModeDependency;", "Lcom/blueair/api/client/CanSetDeviceName;", "Lcom/blueair/api/client/CanManageSchedule;", "Lcom/blueair/api/client/CanManageWelcomeHome;", "Lcom/blueair/api/client/CanSetDisinfection;", "Lcom/blueair/api/client/CanSetEcoMode;", "Lcom/blueair/api/client/CanSetHinsMode;", "Lcom/blueair/api/client/CanSetWick;", "Lcom/blueair/api/client/CanSetAutoRh;", "Lcom/blueair/api/client/CanSetTimer;", "Lcom/blueair/api/client/CanSetTemperatureUnit;", "Lcom/blueair/api/client/CanSetOscillation;", "Lcom/blueair/api/client/CanSetMainMode;", "Lcom/blueair/api/client/CanSetMode;", "Lcom/blueair/api/client/CanSetHumMode;", "Lcom/blueair/api/client/CanSetDehSubMode;", "Lcom/blueair/api/client/CanSetSmartSubMode;", "Lcom/blueair/api/client/CanSetTare;", "Lcom/blueair/api/client/CanSetPanelDisplayMode;", "Lcom/blueair/api/client/CanSetHoverEnabled;", "Lcom/blueair/api/client/CanSetAirRefresh;", "Lcom/blueair/api/client/CanSetNightLamp;", "Lcom/blueair/api/client/CanSetYellowWaterRemove;", "Lcom/blueair/api/client/CanSetAlarm;", "Lcom/blueair/api/client/CanSetHumSubMode;", "Lcom/blueair/api/client/CanSetHourFormat;", "Lcom/blueair/api/client/CanSetSensorMode;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "deviceUuid", "", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Ljava/lang/String;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "setAuthService", "(Lcom/blueair/auth/AuthService;)V", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "deviceRestApi", "Lcom/blueair/api/restapi/BlueCloudRestApi;", "getDeviceRestApi", "()Lcom/blueair/api/restapi/BlueCloudRestApi;", "setActuator", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "n", "v", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vb", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vj", "", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setActuators", "actuators", "", "Lcom/blueair/api/restapi/ActuatorWrapper;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomVerifyText", "Lcom/blueair/api/client/RandomVerifyText;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFanSpeed", "fanSpeed", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "setChildLock", "isLocked", "setDisinfection", "disinfection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBrightness", "brightness", "setStandBy", "isStandBy", "setEcoMode", "value", "setHinsMode", "isHinsModeOn", "setHinsNightMode", "isHinsNightModeOn", "setG4NightMode", "isG4NightMode", "setGermShieldMode", "isGermShieldMode", "setGermShieldNightMode", "isGermShieldNightModeOn", "setWickDryEnabled", "cancelWickDryMode", "setWickDryOn", "setWickDryDurationAndOn", "setAutoRh", "setTimerStatus", "setTimerDuration", "setTimerDurationAndStatus", "duration", "status", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTemperatureUnit", "setOscillationState", "setOscillationParams", "angle", "direction", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainMode", "setApSubMode", "overwriteMainMode", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApFanSpeed", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolAutoPresets", "tag", "presets", "", "(I[DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoolEcoPresets", "setMode", "setHumMode", "setDehSubMode", "setSmartSubMode", "setTare", "setPanelDisplayMode", "setHoverEnabled", "setAirRefreshStatus", "setAirRefreshEnabled", "setNightLampBrightness", "setNightLampSteplessBrightness", "setYwrmEnabled", "playAlarm", "sound", "volume", "setAlarm", "index", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "(ILcom/blueair/core/model/DeviceAlarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAlarm", "setHumSubMode", "cancelWickDry", "setUse24Hour", "setSensorMode", "getLatestSensorPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getMonthSensorPoints", "fromTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetAutoModeDependency", "setAutoModeDependency", "nuValue", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSchedule", "Lokhttp3/ResponseBody;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedule", "", "scheduleId", "updateSchedule", "getSchedules", "createUpdateWelcomeHome", "location", "Lcom/blueair/core/model/WelcomeHomeLocation;", "(Lcom/blueair/core/model/WelcomeHomeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWelcomeHome", "getUnixTime", "clear", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudClient.kt */
public final class BlueCloudClient implements BlueCloudNetworkClient, CanProvisionCloud, CanSetFan, CanSetChildLock, CanSetBrightness, CanGetSensorData, CanSetStandBy, CanSetG4NightMode, CanSetGermShieldMode, CanSetAutoModeDependency, CanSetDeviceName, CanManageSchedule, CanManageWelcomeHome, CanSetDisinfection, CanSetEcoMode, CanSetHinsMode, CanSetWick, CanSetAutoRh, CanSetTimer, CanSetTemperatureUnit, CanSetOscillation, CanSetMainMode, CanSetMode, CanSetHumMode, CanSetDehSubMode, CanSetSmartSubMode, CanSetTare, CanSetPanelDisplayMode, CanSetHoverEnabled, CanSetAirRefresh, CanSetNightLamp, CanSetYellowWaterRemove, CanSetAlarm, CanSetHumSubMode, CanSetHourFormat, CanSetSensorMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private AuthService authService;
    private String deviceUuid;
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public void clear() {
    }

    public BlueCloudClient(Resources resources2, AuthService authService2, String str, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        Intrinsics.checkNotNullParameter(str, "deviceUuid");
        this.resources = resources2;
        this.authService = authService2;
        this.deviceUuid = str;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new BlueCloudClient$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlueCloudClient(Resources resources2, AuthService authService2, String str, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources2, authService2, str, (i & 8) != 0 ? null : interceptor);
    }

    public <T> Object awaitAllCalls(List<BaseNetworkClient.CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
        return BaseNetworkClient.CC.$default$awaitAllCalls(this, list, continuation);
    }

    public <T> Object awaitCall(Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
        return BaseNetworkClient.CC.$default$awaitCall(this, deferred, continuation);
    }

    public OkHttpClient buildBasicAuthClient(Interceptor interceptor) {
        return CloudNetworkClient.CC.$default$buildBasicAuthClient(this, interceptor);
    }

    public OkHttpClient buildHttpClient(boolean z, Interceptor interceptor) {
        return CloudNetworkClient.CC.$default$buildHttpClient(this, z, interceptor);
    }

    public OkHttpClient buildHttpClientWithFakeUserSupport(boolean z, Interceptor interceptor) {
        return CloudNetworkClient.CC.$default$buildHttpClientWithFakeUserSupport(this, z, interceptor);
    }

    public <Input, Output> Object doSuspendedApiCall(Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation) {
        return BaseNetworkClient.CC.$default$doSuspendedApiCall(this, function2, input, continuation);
    }

    public <Input1, Input2, Output> Object doSuspendedApiCall(Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation) {
        return BaseNetworkClient.CC.$default$doSuspendedApiCall(this, function3, input1, input2, continuation);
    }

    public Retrofit retroFitFactory(String str) {
        return BaseNetworkClient.CC.$default$retroFitFactory(this, str);
    }

    public Resources getResources() {
        return this.resources;
    }

    public AuthService getAuthService() {
        return this.authService;
    }

    public void setAuthService(AuthService authService2) {
        Intrinsics.checkNotNullParameter(authService2, "<set-?>");
        this.authService = authService2;
    }

    public String getDeviceUuid() {
        return this.deviceUuid;
    }

    public void setDeviceUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceUuid = str;
    }

    public Interceptor getMockInterceptor() {
        return this.mockInterceptor;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¨\u0006\t"}, d2 = {"Lcom/blueair/api/client/BlueCloudClient$Companion;", "", "<init>", "()V", "responseBodyToSimpleResponse", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "result", "Lokhttp3/ResponseBody;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueCloudClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ApiResult<SimpleResponse> responseBodyToSimpleResponse(ApiResult<ResponseBody> apiResult) {
            String str;
            Intrinsics.checkNotNullParameter(apiResult, "result");
            ApiResult.Companion companion = ApiResult.Companion;
            ResponseBody orNull = apiResult.getOrNull();
            if (orNull == null || (str = orNull.string()) == null) {
                Throwable exceptionOrNull = apiResult.exceptionOrNull();
                str = exceptionOrNull != null ? exceptionOrNull.getMessage() : null;
            }
            return companion.fromResult(apiResult, new SimpleResponse((Integer) null, str));
        }
    }

    public OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$0(BlueCloudClient blueCloudClient) {
        return blueCloudClient.buildHttpClient(false, blueCloudClient.getMockInterceptor());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(getAuthService().getBlueHomeHost());
    }

    public BlueCloudRestApi getDeviceRestApi() {
        Object create = getRetrofit().create(BlueCloudRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (BlueCloudRestApi) create;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setActuator(java.lang.String r12, int r13, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.blueair.api.client.BlueCloudClient$setActuator$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.blueair.api.client.BlueCloudClient$setActuator$1 r0 = (com.blueair.api.client.BlueCloudClient$setActuator$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$setActuator$1 r0 = new com.blueair.api.client.BlueCloudClient$setActuator$1
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r12 = r0.I$0
            java.lang.Object r12 = r0.L$1
            com.blueair.api.client.BlueCloudClient$Companion r12 = (com.blueair.api.client.BlueCloudClient.Companion) r12
            java.lang.Object r13 = r0.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x006b
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r14)
            com.blueair.api.client.BlueCloudClient$Companion r14 = Companion
            com.blueair.api.restapi.BlueCloudRestApi r4 = r11.getDeviceRestApi()
            java.lang.String r5 = r11.getDeviceUuid()
            com.blueair.api.restapi.ActuatorWrapper r6 = new com.blueair.api.restapi.ActuatorWrapper
            r6.<init>((java.lang.String) r12, (int) r13)
            r8 = 4
            r9 = 0
            r7 = 0
            kotlinx.coroutines.Deferred r2 = com.blueair.api.restapi.BlueCloudRestApi.CC.setActuator$default(r4, r5, r6, r7, r8, r9)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$0 = r12
            r0.L$1 = r14
            r0.I$0 = r13
            r0.label = r3
            java.lang.Object r12 = r11.awaitCall(r2, r0)
            if (r12 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x006b:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            io.flatcircle.coroutinehelper.ApiResult r12 = r12.responseBodyToSimpleResponse(r14)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.setActuator(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setActuator(java.lang.String r12, boolean r13, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.blueair.api.client.BlueCloudClient$setActuator$2
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.blueair.api.client.BlueCloudClient$setActuator$2 r0 = (com.blueair.api.client.BlueCloudClient$setActuator$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$setActuator$2 r0 = new com.blueair.api.client.BlueCloudClient$setActuator$2
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            boolean r12 = r0.Z$0
            java.lang.Object r12 = r0.L$1
            com.blueair.api.client.BlueCloudClient$Companion r12 = (com.blueair.api.client.BlueCloudClient.Companion) r12
            java.lang.Object r13 = r0.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x006b
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r14)
            com.blueair.api.client.BlueCloudClient$Companion r14 = Companion
            com.blueair.api.restapi.BlueCloudRestApi r4 = r11.getDeviceRestApi()
            java.lang.String r5 = r11.getDeviceUuid()
            com.blueair.api.restapi.ActuatorWrapper r6 = new com.blueair.api.restapi.ActuatorWrapper
            r6.<init>((java.lang.String) r12, (boolean) r13)
            r8 = 4
            r9 = 0
            r7 = 0
            kotlinx.coroutines.Deferred r2 = com.blueair.api.restapi.BlueCloudRestApi.CC.setActuator$default(r4, r5, r6, r7, r8, r9)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$0 = r12
            r0.L$1 = r14
            r0.Z$0 = r13
            r0.label = r3
            java.lang.Object r12 = r11.awaitCall(r2, r0)
            if (r12 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x006b:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            io.flatcircle.coroutinehelper.ApiResult r12 = r12.responseBodyToSimpleResponse(r14)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.setActuator(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setActuator(java.lang.String r12, java.lang.Object r13, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.blueair.api.client.BlueCloudClient$setActuator$3
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.blueair.api.client.BlueCloudClient$setActuator$3 r0 = (com.blueair.api.client.BlueCloudClient$setActuator$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$setActuator$3 r0 = new com.blueair.api.client.BlueCloudClient$setActuator$3
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r12 = r0.L$2
            com.blueair.api.client.BlueCloudClient$Companion r12 = (com.blueair.api.client.BlueCloudClient.Companion) r12
            java.lang.Object r13 = r0.L$1
            java.lang.Object r13 = r0.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x006f
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r14)
            com.blueair.api.client.BlueCloudClient$Companion r14 = Companion
            com.blueair.api.restapi.BlueCloudRestApi r4 = r11.getDeviceRestApi()
            java.lang.String r5 = r11.getDeviceUuid()
            com.blueair.api.restapi.ActuatorWrapper r6 = new com.blueair.api.restapi.ActuatorWrapper
            r6.<init>((java.lang.String) r12, (java.lang.Object) r13)
            r8 = 4
            r9 = 0
            r7 = 0
            kotlinx.coroutines.Deferred r2 = com.blueair.api.restapi.BlueCloudRestApi.CC.setActuator$default(r4, r5, r6, r7, r8, r9)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$0 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$1 = r12
            r0.L$2 = r14
            r0.label = r3
            java.lang.Object r12 = r11.awaitCall(r2, r0)
            if (r12 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x006f:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            io.flatcircle.coroutinehelper.ApiResult r12 = r12.responseBodyToSimpleResponse(r14)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.setActuator(java.lang.String, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setActuators(java.util.List<com.blueair.api.restapi.ActuatorWrapper> r7, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.blueair.api.client.BlueCloudClient$setActuators$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.api.client.BlueCloudClient$setActuators$1 r0 = (com.blueair.api.client.BlueCloudClient$setActuators$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$setActuators$1 r0 = new com.blueair.api.client.BlueCloudClient$setActuators$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r7 = r0.L$1
            com.blueair.api.client.BlueCloudClient$Companion r7 = (com.blueair.api.client.BlueCloudClient.Companion) r7
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005f
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.api.client.BlueCloudClient$Companion r8 = Companion
            com.blueair.api.restapi.BlueCloudRestApi r2 = r6.getDeviceRestApi()
            java.lang.String r4 = r6.getDeviceUuid()
            kotlinx.coroutines.Deferred r2 = r2.setActuators(r4, r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r6.awaitCall(r2, r0)
            if (r7 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x005f:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            io.flatcircle.coroutinehelper.ApiResult r7 = r7.responseBodyToSimpleResponse(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.setActuators(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getRandomVerifyText(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.client.RandomVerifyText>> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.blueair.api.client.BlueCloudClient$getRandomVerifyText$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.blueair.api.client.BlueCloudClient$getRandomVerifyText$1 r0 = (com.blueair.api.client.BlueCloudClient$getRandomVerifyText$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$getRandomVerifyText$1 r0 = new com.blueair.api.client.BlueCloudClient$getRandomVerifyText$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r1 = r0.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.L$2
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.L$1
            byte[] r3 = (byte[]) r3
            java.lang.Object r0 = r0.L$0
            java.security.SecureRandom r0 = (java.security.SecureRandom) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0099
        L_0x003a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r12)
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.String r2 = "getting randomised verification for a provisioning device"
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r12.v(r2, r5)
            java.security.SecureRandom r12 = new java.security.SecureRandom
            r12.<init>()
            r2 = 64
            byte[] r2 = new byte[r2]
            r12.nextBytes(r2)
            java.lang.String r4 = android.util.Base64.encodeToString(r2, r4)
            com.blueair.api.utils.RandomString r5 = new com.blueair.api.utils.RandomString
            r9 = 6
            r10 = 0
            r6 = 128(0x80, float:1.794E-43)
            r7 = 0
            r8 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            java.lang.String r5 = r5.nextString()
            com.blueair.api.restapi.BlueCloudRestApi r6 = r11.getDeviceRestApi()
            com.blueair.api.restapi.BlueCloudRestApi$VerificationWrapper r7 = new com.blueair.api.restapi.BlueCloudRestApi$VerificationWrapper
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r7.<init>(r4, r5)
            kotlinx.coroutines.Deferred r6 = r6.sendSecureVerification(r7)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$0 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r12
            r0.L$2 = r4
            r0.L$3 = r5
            r0.label = r3
            java.lang.Object r12 = r11.awaitCall(r6, r0)
            if (r12 != r1) goto L_0x0097
            return r1
        L_0x0097:
            r2 = r4
            r1 = r5
        L_0x0099:
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            com.blueair.api.client.RandomVerifyText r3 = new com.blueair.api.client.RandomVerifyText
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r3.<init>(r2, r1)
            io.flatcircle.coroutinehelper.ApiResult r12 = r0.fromResult(r12, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.getRandomVerifyText(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object setFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("fanspeed", i, continuation);
    }

    public Object setAutoMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        return setActuator("automode", z, continuation);
    }

    public Object setChildLock(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        return setActuator("childlock", z, continuation);
    }

    public Object setDisinfection(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("disinfection", z, continuation);
    }

    public Object setBrightness(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("brightness", i, continuation);
    }

    public Object setStandBy(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        return setActuator("standby", z, continuation);
    }

    public Object setEcoMode(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("eco", z, continuation);
    }

    public Object setHinsMode(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("hins", z, continuation);
    }

    public Object setHinsNightMode(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("nmhins", z, continuation);
    }

    public Object setG4NightMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        return setActuator("nightmode", z, continuation);
    }

    public Object setGermShieldMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        return setActuator("germshield", z, continuation);
    }

    public Object setGermShieldNightMode(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("gsnm", z, continuation);
    }

    public Object setWickDryEnabled(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("wickdrye", z, continuation);
    }

    public Object cancelWickDryMode(Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("wickdrys", false, continuation);
    }

    public Object setWickDryOn(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("wickdrys", z, continuation);
    }

    public Object setWickDryDurationAndOn(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper("wickdrydur", i), new ActuatorWrapper("wickdrys", true)), continuation);
    }

    public Object setAutoRh(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("autorh", i, continuation);
    }

    public Object setTimerStatus(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("timstate", i, continuation);
    }

    public Object setTimerDuration(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("timdur", i, continuation);
    }

    public Object setTimerDurationAndStatus(int i, int i2, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper("timdur", i), new ActuatorWrapper("timstate", i2)), continuation);
    }

    public Object setTemperatureUnit(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("tu", i, continuation);
    }

    public Object setOscillationState(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("oscstate", i, continuation);
    }

    public Object setOscillationParams(int i, int i2, int i3, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper("osc", i), new ActuatorWrapper("oscdir", i2), new ActuatorWrapper("oscfs", i3)), continuation);
    }

    public Object setMainMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("mainmode", i, continuation);
    }

    public Object setApSubMode(int i, boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        if (!z) {
            return setActuator("apsubmode", i, continuation);
        }
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper("mainmode", MainMode.AirPurify.getValue()), new ActuatorWrapper("apsubmode", i)), continuation);
    }

    public Object setApFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("fsp0", i, continuation);
    }

    public Object setHeatSubMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("heatsubmode", i, continuation);
    }

    public Object setHeatFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("heatfs", i, continuation);
    }

    public Object setHeatAutoTmp(double d, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("heattemp", DeviceData.Companion.toServerValue(d), continuation);
    }

    public Object setHeatEcoTmp(double d, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("ecoheattemp", DeviceData.Companion.toServerValue(d), continuation);
    }

    public Object setCoolSubMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("coolsubmode", i, continuation);
    }

    public Object setCoolFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("coolfs", i, continuation);
    }

    public Object setCoolAutoPresets(int i, double[] dArr, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        if (dArr == null || dArr.length < 3) {
            return setActuator("coolautotag", i, continuation);
        }
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper("coolautotag", i), new ActuatorWrapper("coolautofs1", DeviceData.Companion.toServerValue(dArr[0])), new ActuatorWrapper("coolautofs2", DeviceData.Companion.toServerValue(dArr[1])), new ActuatorWrapper("coolautofs3", DeviceData.Companion.toServerValue(dArr[2]))), continuation);
    }

    public Object setCoolEcoPresets(int i, double[] dArr, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        if (dArr == null || dArr.length < 2) {
            return setActuator("coolecotag", i, continuation);
        }
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper("coolecotag", i), new ActuatorWrapper("coolecofs1", DeviceData.Companion.toServerValue(dArr[0])), new ActuatorWrapper("coolecofs2", DeviceData.Companion.toServerValue(dArr[1]))), continuation);
    }

    public Object setMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("mode", i, continuation);
    }

    public Object setHumMode(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("hummode", z, continuation);
    }

    public Object setDehSubMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("dehsubmode", i, continuation);
    }

    public Object setSmartSubMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("smartsubmode", i, continuation);
    }

    public Object setTare(Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("nw", 1, continuation);
    }

    public Object setPanelDisplayMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("displaymode", i, continuation);
    }

    public Object setHoverEnabled(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("hover", z, continuation);
    }

    public Object setAirRefreshStatus(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("arstate", i, continuation);
    }

    public Object setAirRefreshEnabled(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("airrefresh", z, continuation);
    }

    public Object setNightLampBrightness(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("nlbrightness", i, continuation);
    }

    public Object setNightLampSteplessBrightness(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("nlstepless", i, continuation);
    }

    public Object setYwrmEnabled(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return awaitCall(getDeviceRestApi().update(new UpdateWrapper(getDeviceUuid(), (Object) null, MapsKt.mapOf(TuplesKt.to("ywrme", Boxing.boxBoolean(z))), 2, (DefaultConstructorMarker) null)), continuation);
    }

    public Object playAlarm(int i, int i2, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper((String) NotificationCompat.CATEGORY_ALARM, i), new ActuatorWrapper("alarmvol", i2)), continuation);
    }

    public Object setAlarm(int i, DeviceAlarm deviceAlarm, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        String str = NotificationCompat.CATEGORY_ALARM + i;
        Object obj = deviceAlarm;
        if (deviceAlarm == null) {
            obj = MapsKt.emptyMap();
        }
        return setActuator(str, obj, continuation);
    }

    public Object stopAlarm(Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("alarmstop", 1, continuation);
    }

    public Object setHumSubMode(int i, boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        if (!z) {
            return setActuator("humsubmode", i, continuation);
        }
        return setActuators(CollectionsKt.listOf(new ActuatorWrapper("wickdrys", false), new ActuatorWrapper("humsubmode", i)), continuation);
    }

    public Object setUse24Hour(boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("hourformat", z, continuation);
    }

    public Object setSensorMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return setActuator("sensormode", i, continuation);
    }

    public Object getLatestSensorPoint(Continuation<? super ApiResult<IndoorDatapoint>> continuation) {
        return ApiResult.Companion.fail(new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getMonthSensorPoints(long r11, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.IndoorDatapoint>>> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.blueair.api.client.BlueCloudClient$getMonthSensorPoints$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.api.client.BlueCloudClient$getMonthSensorPoints$1 r0 = (com.blueair.api.client.BlueCloudClient$getMonthSensorPoints$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$getMonthSensorPoints$1 r0 = new com.blueair.api.client.BlueCloudClient$getMonthSensorPoints$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            long r11 = r0.J$2
            long r11 = r0.J$1
            long r11 = r0.J$0
            java.lang.Object r11 = r0.L$1
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Object r11 = r0.L$0
            java.util.List r11 = (java.util.List) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x009e
        L_0x0038:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r13)
            long r4 = r10.getUnixTime()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r6 = r11 / r6
            com.blueair.api.utils.BlueCloudSensor$Companion r13 = com.blueair.api.utils.BlueCloudSensor.Companion
            java.util.List r13 = r13.getSensorNames()
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            java.lang.String r8 = "did"
            java.lang.String r9 = r10.getDeviceUuid()
            r2.put(r8, r9)
            java.lang.String r8 = "from"
            java.lang.String r9 = java.lang.String.valueOf(r6)
            r2.put(r8, r9)
            java.lang.String r8 = "to"
            java.lang.String r9 = java.lang.String.valueOf(r4)
            r2.put(r8, r9)
            com.blueair.api.restapi.BlueCloudRestApi r8 = r10.getDeviceRestApi()
            com.blueair.auth.AuthService r9 = r10.getAuthService()
            java.lang.String r9 = r9.getUserIdForBlueCloud()
            kotlinx.coroutines.Deferred r8 = r8.getMonthDatapoints(r9, r2, r13)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$0 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r13
            r0.J$0 = r11
            r0.J$1 = r4
            r0.J$2 = r6
            r0.label = r3
            java.lang.Object r13 = r10.awaitCall(r8, r0)
            if (r13 != r1) goto L_0x009e
            return r1
        L_0x009e:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            boolean r11 = r13.isFailure()
            r12 = 0
            if (r11 == 0) goto L_0x00ae
            io.flatcircle.coroutinehelper.ApiResult$Companion r11 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r11 = r11.fromResult(r13, r12)
            return r11
        L_0x00ae:
            java.lang.Object r11 = r13.getOrNull()
            java.util.List r11 = (java.util.List) r11
            if (r11 == 0) goto L_0x00c2
            java.lang.Object r11 = kotlin.collections.CollectionsKt.firstOrNull(r11)
            com.blueair.api.restapi.BlueDataWrapper r11 = (com.blueair.api.restapi.BlueDataWrapper) r11
            if (r11 == 0) goto L_0x00c2
            java.util.List r12 = r11.convertToSimpleIndoorDataPoints()
        L_0x00c2:
            if (r12 != 0) goto L_0x00d3
            io.flatcircle.coroutinehelper.Failure r11 = new io.flatcircle.coroutinehelper.Failure
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "The datapoints were not parsed correctly"
            r12.<init>(r13)
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            r11.<init>(r12)
            return r11
        L_0x00d3:
            io.flatcircle.coroutinehelper.ApiResult$Companion r11 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r11 = r11.fromResult(r13, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.getMonthSensorPoints(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object resetAutoModeDependency(Continuation<? super ApiResult<Object>> continuation) {
        return setAutoModeDependency(CityStation.PM25, continuation);
    }

    public Object setAutoModeDependency(Object obj, Continuation<? super ApiResult<Object>> continuation) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Pair<*, *>");
        Pair pair = (Pair) obj;
        Timber.Forest forest = Timber.Forest;
        forest.d("setAutoModeDependency: nuPair = " + pair, new Object[0]);
        Object first = pair.getFirst();
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.String");
        AutoModeTrigger autoModeTrigger = new AutoModeTrigger((String) first, (String) null, 2, (DefaultConstructorMarker) null);
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.String");
        return awaitCall(getDeviceRestApi().update(new UpdateWrapper(getDeviceUuid(), new ModeDependency(autoModeTrigger, new G4NightModeTrigger((String) second, (String) null, 2, (DefaultConstructorMarker) null)), (Object) null, 4, (DefaultConstructorMarker) null)), continuation);
    }

    public Object setDeviceName(String str, Continuation<? super ApiResult<Object>> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("setDeviceName: nuValue = " + str, new Object[0]);
        return awaitCall(getDeviceRestApi().update(new UpdateWrapper(getDeviceUuid(), (Object) null, new NameConfiguration(str), 2, (DefaultConstructorMarker) null)), continuation);
    }

    public Object createSchedule(DeviceSchedule deviceSchedule, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getDeviceRestApi().createSchedule(getAuthService().getUserIdForBlueCloud(), deviceSchedule.toBlueDeviceSchedule()), continuation);
    }

    public Object deleteSchedule(String str, Continuation<? super Unit> continuation) {
        getDeviceRestApi().deleteSchedule(getAuthService().getUserIdForBlueCloud(), getDeviceUuid(), str);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateSchedule(com.blueair.core.model.DeviceSchedule r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.blueair.api.client.BlueCloudClient$updateSchedule$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.api.client.BlueCloudClient$updateSchedule$1 r0 = (com.blueair.api.client.BlueCloudClient$updateSchedule$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$updateSchedule$1 r0 = new com.blueair.api.client.BlueCloudClient$updateSchedule$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r6 = r0.L$1
            com.blueair.core.model.BlueDeviceSchedule r6 = (com.blueair.core.model.BlueDeviceSchedule) r6
            java.lang.Object r6 = r0.L$0
            com.blueair.core.model.DeviceSchedule r6 = (com.blueair.core.model.DeviceSchedule) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0066
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.core.model.BlueDeviceSchedule r7 = r6.toBlueDeviceSchedule()
            com.blueair.api.restapi.BlueCloudRestApi r2 = r5.getDeviceRestApi()
            com.blueair.auth.AuthService r4 = r5.getAuthService()
            java.lang.String r4 = r4.getUserIdForBlueCloud()
            kotlinx.coroutines.Deferred r2 = r2.updateSchedule(r4, r7)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.awaitCall(r2, r0)
            if (r7 != r1) goto L_0x0066
            return r1
        L_0x0066:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            java.lang.String r6 = "null cannot be cast to non-null type io.flatcircle.coroutinehelper.ApiResult<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.updateSchedule(com.blueair.core.model.DeviceSchedule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getSchedules(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.DeviceSchedule>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.BlueCloudClient$getSchedules$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.BlueCloudClient$getSchedules$1 r0 = (com.blueair.api.client.BlueCloudClient$getSchedules$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.BlueCloudClient$getSchedules$1 r0 = new com.blueair.api.client.BlueCloudClient$getSchedules$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0052
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.api.restapi.BlueCloudRestApi r6 = r5.getDeviceRestApi()
            com.blueair.auth.AuthService r2 = r5.getAuthService()
            java.lang.String r2 = r2.getUserIdForBlueCloud()
            java.lang.String r4 = r5.getDeviceUuid()
            kotlinx.coroutines.Deferred r6 = r6.getSchedule(r2, r4)
            r0.label = r3
            java.lang.Object r6 = r5.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0052
            return r1
        L_0x0052:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            java.lang.Object r0 = r6.getOrNull()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0088
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x006f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0085
            java.lang.Object r2 = r0.next()
            com.blueair.core.model.BlueDeviceSchedule r2 = (com.blueair.core.model.BlueDeviceSchedule) r2
            com.blueair.core.model.DeviceSchedule$Companion r3 = com.blueair.core.model.DeviceSchedule.Companion
            com.blueair.core.model.DeviceSchedule r2 = r3.fromBlueDeviceSchedule(r2)
            r1.add(r2)
            goto L_0x006f
        L_0x0085:
            java.util.List r1 = (java.util.List) r1
            goto L_0x0089
        L_0x0088:
            r1 = 0
        L_0x0089:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "getSchedules : schedules = "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.d(r2, r3)
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r6 = r0.fromResult(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BlueCloudClient.getSchedules(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object createUpdateWelcomeHome(WelcomeHomeLocation welcomeHomeLocation, Continuation<? super ApiResult<Unit>> continuation) {
        return awaitCall(getDeviceRestApi().createUpdateWelcomeHome(getDeviceUuid(), WelcomeHomeLocation.Companion.toBlueWelcomeHomeLocation(welcomeHomeLocation)), continuation);
    }

    public Object deleteWelcomeHome(Continuation<? super ApiResult<Unit>> continuation) {
        return awaitCall(getDeviceRestApi().deleteWelcomeHome(getDeviceUuid()), continuation);
    }

    public final long getUnixTime() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        Date time = Calendar.getInstance(TimeZone.getDefault()).getTime();
        return (time.getTime() + ((long) timeZone.getOffset(time.getTime()))) / 1000;
    }
}
