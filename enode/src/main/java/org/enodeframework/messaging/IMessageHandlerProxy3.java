package org.enodeframework.messaging;

import org.enodeframework.infrastructure.IObjectProxy;
import org.enodeframework.infrastructure.MethodInvocation;

import java.util.concurrent.CompletableFuture;

public interface IMessageHandlerProxy3 extends IObjectProxy, MethodInvocation {
    CompletableFuture<Void> handleAsync(IMessage message1, IMessage message2, IMessage message3);
}
