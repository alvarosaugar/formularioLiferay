package com.liferay62.servicio.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay62.servicio.model.Registro;
import com.liferay62.servicio.service.RegistroLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class RegistroActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RegistroActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RegistroLocalServiceUtil.getService());
        setClass(Registro.class);

        setClassLoader(com.liferay62.servicio.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("registroId");
    }
}
