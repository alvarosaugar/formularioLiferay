package com.liferay62.servicio.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistroService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistroService
 * @generated
 */
public class RegistroServiceWrapper implements RegistroService,
    ServiceWrapper<RegistroService> {
    private RegistroService _registroService;

    public RegistroServiceWrapper(RegistroService registroService) {
        _registroService = registroService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _registroService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _registroService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _registroService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public RegistroService getWrappedRegistroService() {
        return _registroService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedRegistroService(RegistroService registroService) {
        _registroService = registroService;
    }

    @Override
    public RegistroService getWrappedService() {
        return _registroService;
    }

    @Override
    public void setWrappedService(RegistroService registroService) {
        _registroService = registroService;
    }
}
