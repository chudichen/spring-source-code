package com.chu.context;

import com.chu.beans.factory.HierarchicalBeanFactory;
import com.chu.beans.factory.ListableBeanFactory;
import com.chu.core.io.ResourceLoader;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
