package com.liferay62.servicio.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay62.servicio.model.Registro;

/**
 * The persistence interface for the registro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroPersistenceImpl
 * @see RegistroUtil
 * @generated
 */
public interface RegistroPersistence extends BasePersistence<Registro> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RegistroUtil} to access the registro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the registros where email = &#63;.
    *
    * @param email the email
    * @return the matching registros
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay62.servicio.model.Registro> findByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay62.servicio.model.Registro> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay62.servicio.model.Registro> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching registro
    * @throws com.liferay62.servicio.NoSuchRegistroException if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay62.servicio.model.Registro findByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException;

    /**
    * Returns the first registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching registro, or <code>null</code> if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay62.servicio.model.Registro fetchByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching registro
    * @throws com.liferay62.servicio.NoSuchRegistroException if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay62.servicio.model.Registro findByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException;

    /**
    * Returns the last registro in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching registro, or <code>null</code> if a matching registro could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay62.servicio.model.Registro fetchByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay62.servicio.model.Registro[] findByEmail_PrevAndNext(
        long registroId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException;

    /**
    * Removes all the registros where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public void removeByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of registros where email = &#63;.
    *
    * @param email the email
    * @return the number of matching registros
    * @throws SystemException if a system exception occurred
    */
    public int countByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the registro in the entity cache if it is enabled.
    *
    * @param registro the registro
    */
    public void cacheResult(com.liferay62.servicio.model.Registro registro);

    /**
    * Caches the registros in the entity cache if it is enabled.
    *
    * @param registros the registros
    */
    public void cacheResult(
        java.util.List<com.liferay62.servicio.model.Registro> registros);

    /**
    * Creates a new registro with the primary key. Does not add the registro to the database.
    *
    * @param registroId the primary key for the new registro
    * @return the new registro
    */
    public com.liferay62.servicio.model.Registro create(long registroId);

    /**
    * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param registroId the primary key of the registro
    * @return the registro that was removed
    * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay62.servicio.model.Registro remove(long registroId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException;

    public com.liferay62.servicio.model.Registro updateImpl(
        com.liferay62.servicio.model.Registro registro)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the registro with the primary key or throws a {@link com.liferay62.servicio.NoSuchRegistroException} if it could not be found.
    *
    * @param registroId the primary key of the registro
    * @return the registro
    * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay62.servicio.model.Registro findByPrimaryKey(
        long registroId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay62.servicio.NoSuchRegistroException;

    /**
    * Returns the registro with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param registroId the primary key of the registro
    * @return the registro, or <code>null</code> if a registro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay62.servicio.model.Registro fetchByPrimaryKey(
        long registroId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the registros.
    *
    * @return the registros
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay62.servicio.model.Registro> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay62.servicio.model.Registro> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay62.servicio.model.Registro> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the registros from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of registros.
    *
    * @return the number of registros
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
