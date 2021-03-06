package org.enodeframework.tests.TestClasses;

import org.enodeframework.ENodeAutoConfiguration;
import org.enodeframework.commanding.ICommandService;
import org.enodeframework.domain.IDomainException;
import org.enodeframework.domain.IMemoryCache;
import org.enodeframework.eventing.DomainEventStreamMessage;
import org.enodeframework.eventing.IEventStore;
import org.enodeframework.eventing.IProcessingEventProcessor;
import org.enodeframework.eventing.IPublishedVersionStore;
import org.enodeframework.messaging.IApplicationMessage;
import org.enodeframework.messaging.IMessagePublisher;
import org.enodeframework.tests.EnodeExtensionConfig;
import org.enodeframework.tests.KafkaEventConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ENodeAutoConfiguration.class, KafkaEventConfig.class, EnodeExtensionConfig.class})
public abstract class AbstractTest {
    @Autowired
    protected ICommandService commandService;
    @Autowired
    protected IMemoryCache memoryCache;
    @Autowired
    protected IEventStore eventStore;
    @Autowired
    protected IPublishedVersionStore publishedVersionStore;
    @Autowired
    protected IMessagePublisher<DomainEventStreamMessage> domainEventPublisher;
    @Autowired
    protected IMessagePublisher<IApplicationMessage> applicationMessagePublisher;
    @Autowired
    protected IMessagePublisher<IDomainException> publishableExceptionPublisher;
    @Autowired
    protected IProcessingEventProcessor processor;
}
