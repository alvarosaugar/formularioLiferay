package com.liferay62.servicio.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay62.servicio.model.Registro;

import java.util.List;

/**
 * The persistence utility for the registro service. This utility wraps {@link RegistroPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroPersistence
 * @see RegistroPersistenceImpl
 * @generated
 */
public class RegistroUtil {
    private static RegistroPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Registro registro) {
        getPersistence().clearCache(registro);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Registro> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Registro> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Registro> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Registro update(Registro registro) throws SystemException {
        return getPersistence().update(registro);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Registro update(Registro registro,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(registro, serviceContext);
    }

    /**
    * Returns all the registros where email = &#63;.
    *
    * @param email the email
    * @return the matching registros
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay62.servicio.model.Registro> findByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email);
    }

    /**
    * Returns a range of all the registros where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay62.servicio.model.impl.RegistroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of registros
    * @param end the upper bound of the range of registros (not inclusive)
    * @return the range of matching registros
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay62.servicio.model.Registro> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email, start, end);
    }

    /**
    * Returns an ordered range of all the registros where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay62.servicio.model.impl.RegistroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of registros
    * @param end the upper bound of the range of registros (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching registros
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay62.servicio.model.Registro> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email, start, end, orderByComparator);
    }

    /**
    * Returns the first registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching registro
    * @throws com.liferay62.servicio.NoSuchRegistroException if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro findByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException {
        return getPersistence().findByEmail_First(email, orderByComparator);
    }

    /**
    * Returns the first registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching registro, or <code>null</code> if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro fetchByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail_First(email, orderByComparator);
    }

    /**
    * Returns the last registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching registro
    * @throws com.liferay62.servicio.NoSuchRegistroException if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro findByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException {
        return getPersistence().findByEmail_Last(email, orderByComparator);
    }

    /**
    * Returns the last registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching registro, or <code>null</code> if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro fetchByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail_Last(email, orderByComparator);
    }

    /**
    * Returns the registros before and after the current registro in the ordered set where email = &#63;.
    *
    * @param registroId the primary key of the current registro
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next registro
    * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro[] findByEmail_PrevAndNext(
        long registroId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException {
        return getPersistence()
                   .findByEmail_PrevAndNext(registroId, email, orderByComparator);
    }

    /**
    * Removes all the registros where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEmail(email);
    }

    /**
    * Returns the number of registros where email = &#63;.
    *
    * @param email the email
    * @return the number of matching registros
    * @throws SystemException if a system exception occurred
    */
    public static int countByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEmail(email);
    }

    /**
    * Caches the registro in the entity cache if it is enabled.
    *
    * @param registro the registro
    */
    public static void cacheResult(
        com.liferay62.servicio.model.Registro registro) {
        getPersistence().cacheResult(registro);
    }

    /**
    * Caches the registros in the entity cache if it is enabled.
    *
    * @param registros the registros
    */
    public static void cacheResult(
        java.util.List<com.liferay62.servicio.model.Registro> registros) {
        getPersistence().cacheResult(registros);
    }

    /**
    * Creates a new registro with the primary key. Does not add the registro to the database.
    *
    * @param registroId the primary key for the new registro
    * @return the new registro
    */
    public static com.liferay62.servicio.model.Registro create(long registroId) {
        return getPersistence().create(registroId);
    }

    /**
    * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param registroId the primary key of the registro
    * @return the registro that was removed
    * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro remove(long registroId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException {
        return getPersistence().remove(registroId);
    }

    public static com.liferay62.servicio.model.Registro updateImpl(
        com.liferay62.servicio.model.Registro registro)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(registro);
    }

    /**
    * Returns the registro with the primary key or throws a {@link com.liferay62.servicio.NoSuchRegistroException} if it could not be found.
    *
    * @param registroId the primary key of the registro
    * @return the registro
    * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro findByPrimaryKey(
        long registroId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException {
        return getPersistence().findByPrimaryKey(registroId);
    }

    /**
    * Returns the registro with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param registroId the primary key of the registro
    * @return the registro, or <code>null</code> if a registro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay62.servicio.model.Registro fetchByPrimaryKey(
        long registroId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(registroId);
    }

    /**
    * Returns all the registros.
    *
    * @return the registros
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay62.servicio.model.Registro> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the registros.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay62.servicio.model.impl.RegistroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of registros
    * @param end the upper bound of the range of registros (not inclusive)
    * @return the range of registros
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay62.servicio.model.Registro> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the registros.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay62.servicio.model.impl.RegistroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of registros
    * @param end the upper bound of the range of registros (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of registros
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay62.servicio.model.Registro> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the registros from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of registros.
    *
    * @return the number of registros
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RegistroPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RegistroPersistence) PortletBeanLocatorUtil.locate(com.liferay62.servicio.service.ClpSerializer.getServletContextName(),
                    RegistroPersistence.class.getName());

            ReferenceRegistry.registerReference(RegistroUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RegistroPersistence persistence) {
    }
}
