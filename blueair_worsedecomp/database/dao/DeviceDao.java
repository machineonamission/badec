package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import com.blueair.database.entity.DeviceEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0003\b\u0001\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019Jn\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010 2\b\u0010&\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010 H§@¢\u0006\u0002\u0010(J \u0010)\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J \u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J*\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u00100J \u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u0010\u0019J \u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J\u001e\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u00105\u001a\u000206H§@¢\u0006\u0002\u00107J \u00108\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010:\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J\u001e\u0010@\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010B\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J>\u0010D\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u0011H§@¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010M\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010O\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010Q\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010R\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010S\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010T\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010U\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010V\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010W\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010X\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010Y\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010Z\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010[\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\\\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010]\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010^\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010_J\u001e\u0010`\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010c\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010e\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010g\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010h\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010j\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010k\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010l\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010m\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010n\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<JH\u0010p\u001a\u00020q2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010s2\b\u0010u\u001a\u0004\u0018\u00010\u00162\b\u0010v\u001a\u0004\u0018\u00010\u00112\b\u0010w\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010xJ \u0010y\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010z\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010_J*\u0010{\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010|\u001a\u0004\u0018\u00010\u00162\b\u0010}\u001a\u0004\u0018\u00010\u001eH§@¢\u0006\u0002\u0010~J\u001f\u0010\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J*\u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u001eH§@¢\u0006\u0003\u0010\u0001J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J*\u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u001eH§@¢\u0006\u0003\u0010\u0001J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010 \u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¢\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010£\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¤\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¥\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¦\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J!\u0010¨\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010©\u0001\u001a\u00020sH§@¢\u0006\u0003\u0010ª\u0001J!\u0010«\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020sH§@¢\u0006\u0003\u0010ª\u0001J \u0010­\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¯\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010°\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010±\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010²\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010³\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010´\u0001\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J \u0010µ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¶\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010·\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¸\u0001\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\"\u0010¹\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u0010\u0019J\u001b\u0010»\u0001\u001a\u00020\u00162\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0003\u0010¼\u0001J \u0010½\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¾\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¿\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010À\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Á\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Â\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ã\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ä\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Å\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Æ\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Ç\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010È\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010É\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ê\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Ë\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ì\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Í\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Î\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ï\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ð\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ñ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ò\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Ó\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ô\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Õ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ö\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010×\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ø\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ù\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ú\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Û\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ü\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ý\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Þ\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ß\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010à\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010á\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010â\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ã\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ä\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010å\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010æ\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J\"\u0010ç\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\t\u0010è\u0001\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010_J \u0010é\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ê\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ë\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ì\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010í\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010î\u0001\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J \u0010ï\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ð\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ñ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ò\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010ó\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ô\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010õ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ö\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J\u0011\u0010÷\u0001\u001a\u00020q2\u0006\u0010\u0012\u001a\u00020\u0004H'J\u0011\u0010ø\u0001\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004H'J\u0011\u0010ù\u0001\u001a\u00020q2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0012\u0010ú\u0001\u001a\u00020q2\u0007\u0010û\u0001\u001a\u000206H'J\t\u0010ú\u0001\u001a\u00020qH'R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006ü\u0001À\u0006\u0003"}, d2 = {"Lcom/blueair/database/dao/DeviceDao;", "", "devices", "", "Lcom/blueair/database/entity/DeviceEntity;", "getDevices", "()Ljava/util/List;", "liveDevices", "Landroidx/lifecycle/LiveData;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "flowDevices", "Lkotlinx/coroutines/flow/Flow;", "getFlowDevices", "()Lkotlinx/coroutines/flow/Flow;", "liveDevice", "id", "", "device", "getFlowDevice", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateName", "", "deviceId", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTimezone", "timezone", "updateLatestSensorDataPoint", "timeInSeconds", "", "pm1", "", "pm10", "pm25", "voc", "hcho", "tmp", "hum", "fan", "(Ljava/lang/String;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastSelectedSensorType", "lastSelectedSensorType", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFanSpeed", "fanSpeed", "updateFanSpeedAndAutoMode", "autoModeText", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAutoMode", "updateBrightness", "brightness", "updateChildLock", "isChildLockOn", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLinkedDeviceUid", "linkedDeviceUid", "updateConnectivityStatus", "connectivityStatus", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProgress", "updateFilterLife", "filterLife", "updateSku", "sku", "updateCompatibility", "compatibility", "updateSensorRange", "pm1Ranges", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWifiFirmware", "wifiFirmware", "updateMcuFirmware", "mcuFirmware", "updateHardware", "hardware", "updateStandByMode", "isStandByOn", "updateEcoMode", "isEcoModeOn", "updateHinsMode", "isHinsModeOn", "updateHinsNightMode", "isHinsNightModeOn", "updateG4NightMode", "isG4NightModeOn", "updateGermShieldMode", "isGermShieldOn", "updateGermShieldNightMode", "isGermShieldNightModeOn", "(Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSerialNumber", "serialNumber", "updateFilterTrigger", "filterTrigger", "updateG4NightModeFilterTrigger", "g4NightModeFilterTrigger", "updateSafetySwitch", "isSafetySwitchOn", "updateMacAddress", "macAddress", "updateModelName", "modelName", "updateFilterType", "filterType", "updateDeviceType", "deviceType", "updateWelcomeHome", "", "lat", "", "lng", "radius", "textValue", "enabled", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDisinfection", "disinfection", "updateDisinfectLeftTime", "disinfectLeftTime", "disinfectLeftTimeUpdateTime", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWickdryEnabled", "wickdryEnabled", "updateWickdryOn", "wickdryOn", "updateWickdryLeftTime", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "(Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWickUsage", "wickUsage", "updateWaterShortage", "waterShortage", "updateAutoRh", "autoRh", "updateTimerStatus", "timerStatus", "updateTimerDuration", "timerDuration", "updateTimerLeftTime", "timerLeftTime", "timerLeftTimeUpdateTime", "updateTemperatureUnit", "temperatureUnit", "updateOscillationState", "oscillationState", "updateOscillationAngle", "oscillationAngle", "updateOscillationDirection", "oscillationDirection", "updateOscillationFanSpeed", "oscillationFanSpeed", "updateMainMode", "mainMode", "updateApSubMode", "apSubMode", "updateApFanSpeed", "apFanSpeed", "updateHeatSubMode", "heatSubMode", "updateHeatFanSpeed", "heatFanSpeed", "updateHeatAutoTmp", "heatAutoTmp", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHeatEcoTmp", "heatEcoTmp", "updateCoolSubMode", "coolSubMode", "updateCoolFanSpeed", "coolFanSpeed", "updateCoolAutoTag", "coolAutoTag", "updateCoolAutoPresets", "coolAutoPresets", "updateCoolEcoTag", "coolEcoTag", "updateCoolEcoPresets", "coolEcoPresets", "updateLocationId", "locationId", "deleteLocationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMode", "mode", "updateHumMode", "humMode", "updateWaterLevel", "waterLevel", "updateDehSubMode", "dehSubMode", "updateWaterTankFailure", "waterTankFailure", "updateSmartSubMode", "smartSubMode", "updateDetectCat", "detectCat", "updateBodyMounted", "bodyMounted", "updateCleanAirEta", "cleanAirEta", "updatePanelDisplayMode", "panelDisplayMode", "updateHoverEnabled", "hoverEnabled", "updateAirRefreshEnabled", "airRefreshEnabled", "updateAirRefreshStatus", "airRefreshStatus", "updateAirRefreshDuration", "airRefreshDuration", "updateAirRefreshTimeStamp", "airRefreshTimeStamp", "updateAirRefreshStartTimeStamp", "airRefreshStartTimeStamp", "updateAirRefreshEndTimeStamp", "airRefreshEndTimeStamp", "updateRoomType", "roomType", "updateNightLampBrightness", "nightLampBrightness", "updateWickdryDuration", "wickdryDuration", "updateWickdryDone", "wickdryDone", "updateYwrmEnabled", "ywrmEnabled", "updateYwrmUsage", "ywrmUsage", "updateNightLampSteplessBrightness", "nightLampSteplessBrightness", "updateAlarms", "alarms", "updateHumSubMode", "humSubMode", "updateUse24Hour", "use24Hour", "updatWaterInfill", "waterInfill", "updateSensorMode", "sensorMode", "insert", "update", "delete", "deleteAll", "isAblDevice", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDao.kt */
public interface DeviceDao {
    void delete(String str);

    void deleteAll();

    void deleteAll(boolean z);

    Object deleteLocationId(String str, Continuation<? super Integer> continuation);

    DeviceEntity device(String str);

    Object getDevices(Continuation<? super List<DeviceEntity>> continuation);

    List<DeviceEntity> getDevices();

    Flow<DeviceEntity> getFlowDevice(String str);

    Flow<List<DeviceEntity>> getFlowDevices();

    LiveData<List<DeviceEntity>> getLiveDevices();

    void insert(DeviceEntity deviceEntity);

    LiveData<DeviceEntity> liveDevice(String str);

    Object updatWaterInfill(String str, boolean z, Continuation<? super Integer> continuation);

    int update(DeviceEntity deviceEntity);

    Object updateAirRefreshDuration(String str, int i, Continuation<? super Integer> continuation);

    Object updateAirRefreshEnabled(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateAirRefreshEndTimeStamp(String str, int i, Continuation<? super Integer> continuation);

    Object updateAirRefreshStartTimeStamp(String str, int i, Continuation<? super Integer> continuation);

    Object updateAirRefreshStatus(String str, int i, Continuation<? super Integer> continuation);

    Object updateAirRefreshTimeStamp(String str, int i, Continuation<? super Integer> continuation);

    Object updateAlarms(String str, String str2, Continuation<? super Integer> continuation);

    Object updateApFanSpeed(String str, int i, Continuation<? super Integer> continuation);

    Object updateApSubMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateAutoMode(String str, String str2, Continuation<? super Integer> continuation);

    Object updateAutoRh(String str, int i, Continuation<? super Integer> continuation);

    Object updateBodyMounted(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateBrightness(String str, Integer num, Continuation<? super Integer> continuation);

    Object updateChildLock(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateCleanAirEta(String str, int i, Continuation<? super Integer> continuation);

    Object updateCompatibility(String str, String str2, Continuation<? super Integer> continuation);

    Object updateConnectivityStatus(String str, int i, Continuation<? super Integer> continuation);

    Object updateCoolAutoPresets(String str, String str2, Continuation<? super Integer> continuation);

    Object updateCoolAutoTag(String str, int i, Continuation<? super Integer> continuation);

    Object updateCoolEcoPresets(String str, String str2, Continuation<? super Integer> continuation);

    Object updateCoolEcoTag(String str, int i, Continuation<? super Integer> continuation);

    Object updateCoolFanSpeed(String str, int i, Continuation<? super Integer> continuation);

    Object updateCoolSubMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateDehSubMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateDetectCat(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateDeviceType(String str, int i, Continuation<? super Integer> continuation);

    Object updateDisinfectLeftTime(String str, Integer num, Long l, Continuation<? super Integer> continuation);

    Object updateDisinfection(String str, Boolean bool, Continuation<? super Integer> continuation);

    Object updateEcoMode(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateFanSpeed(String str, Integer num, Continuation<? super Integer> continuation);

    Object updateFanSpeedAndAutoMode(String str, Integer num, String str2, Continuation<? super Integer> continuation);

    Object updateFilterLife(String str, Integer num, Continuation<? super Integer> continuation);

    Object updateFilterTrigger(String str, String str2, Continuation<? super Integer> continuation);

    Object updateFilterType(String str, String str2, Continuation<? super Integer> continuation);

    Object updateG4NightMode(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateG4NightModeFilterTrigger(String str, String str2, Continuation<? super Integer> continuation);

    Object updateGermShieldMode(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateGermShieldNightMode(String str, Boolean bool, Continuation<? super Integer> continuation);

    Object updateHardware(String str, String str2, Continuation<? super Integer> continuation);

    Object updateHeatAutoTmp(String str, double d, Continuation<? super Integer> continuation);

    Object updateHeatEcoTmp(String str, double d, Continuation<? super Integer> continuation);

    Object updateHeatFanSpeed(String str, int i, Continuation<? super Integer> continuation);

    Object updateHeatSubMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateHinsMode(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateHinsNightMode(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateHoverEnabled(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateHumMode(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateHumSubMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateLastSelectedSensorType(String str, Integer num, Continuation<? super Integer> continuation);

    Object updateLatestSensorDataPoint(String str, long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Continuation<? super Integer> continuation);

    Object updateLinkedDeviceUid(String str, String str2, Continuation<? super Integer> continuation);

    Object updateLocationId(String str, String str2, Continuation<? super Integer> continuation);

    Object updateMacAddress(String str, String str2, Continuation<? super Integer> continuation);

    Object updateMainMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateMcuFirmware(String str, String str2, Continuation<? super Integer> continuation);

    Object updateMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateModelName(String str, String str2, Continuation<? super Integer> continuation);

    Object updateName(String str, String str2, Continuation<? super Integer> continuation);

    Object updateNightLampBrightness(String str, int i, Continuation<? super Integer> continuation);

    Object updateNightLampSteplessBrightness(String str, int i, Continuation<? super Integer> continuation);

    Object updateOscillationAngle(String str, int i, Continuation<? super Integer> continuation);

    Object updateOscillationDirection(String str, int i, Continuation<? super Integer> continuation);

    Object updateOscillationFanSpeed(String str, int i, Continuation<? super Integer> continuation);

    Object updateOscillationState(String str, int i, Continuation<? super Integer> continuation);

    Object updatePanelDisplayMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateProgress(String str, int i, Continuation<? super Integer> continuation);

    Object updateRoomType(String str, int i, Continuation<? super Integer> continuation);

    Object updateSafetySwitch(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateSensorMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateSensorRange(String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super Integer> continuation);

    Object updateSerialNumber(String str, String str2, Continuation<? super Integer> continuation);

    Object updateSku(String str, String str2, Continuation<? super Integer> continuation);

    Object updateSmartSubMode(String str, int i, Continuation<? super Integer> continuation);

    Object updateStandByMode(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateTemperatureUnit(String str, int i, Continuation<? super Integer> continuation);

    Object updateTimerDuration(String str, int i, Continuation<? super Integer> continuation);

    Object updateTimerLeftTime(String str, int i, long j, Continuation<? super Integer> continuation);

    Object updateTimerStatus(String str, int i, Continuation<? super Integer> continuation);

    Object updateTimezone(String str, String str2, Continuation<? super Integer> continuation);

    Object updateUse24Hour(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateWaterLevel(String str, int i, Continuation<? super Integer> continuation);

    Object updateWaterShortage(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateWaterTankFailure(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateWelcomeHome(String str, Double d, Double d2, Integer num, String str2, Boolean bool, Continuation<? super Unit> continuation);

    Object updateWickUsage(String str, int i, Continuation<? super Integer> continuation);

    Object updateWickdryDone(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateWickdryDuration(String str, int i, Continuation<? super Integer> continuation);

    Object updateWickdryEnabled(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateWickdryLeftTime(String str, int i, long j, Continuation<? super Integer> continuation);

    Object updateWickdryOn(String str, boolean z, Continuation<? super Integer> continuation);

    Object updateWifiFirmware(String str, String str2, Continuation<? super Integer> continuation);

    Object updateYwrmEnabled(String str, Boolean bool, Continuation<? super Integer> continuation);

    Object updateYwrmUsage(String str, int i, Continuation<? super Integer> continuation);
}
