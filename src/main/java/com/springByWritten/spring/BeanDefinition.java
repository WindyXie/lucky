package com.springByWritten.spring;

@SuppressWarnings("all")
public class BeanDefinition {
    private String scope;
    private Class beanClass;

    public String getScope() {
        return scope;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
