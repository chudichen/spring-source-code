package com.chudichen.spring.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chudichen
 * @date 2021-07-20
 */
public class CglibEnhancerDemo {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestBeanA.class);
		enhancer.setCallback(new MyInterceptor());
		TestBeanA testBeanA = (TestBeanA) enhancer.create();
		String testStr = testBeanA.getTestStr();
		System.out.println(testStr);
	}

	private static class MyInterceptor implements MethodInterceptor {
		@Override
		public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
			System.out.println("Before invoke method is: " + method);
			Object result = methodProxy.invokeSuper(o, objects);
			System.out.println("After invoke method is: " + method + " result is: " + result);
			return result;
		}
	}
}
