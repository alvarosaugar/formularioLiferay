package com.liferay62.servicio.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay62.servicio.NoSuchRegistroException;
import com.liferay62.servicio.model.Registro;
import com.liferay62.servicio.model.impl.RegistroImpl;
import com.liferay62.servicio.model.impl.RegistroModelImpl;
import com.liferay62.servicio.service.persistence.RegistroPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the registro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroPersistence
 * @see RegistroUtil
 * @generated
 */
public class RegistroPersistenceImpl extends BasePersistenceImpl<Registro>
    implements RegistroPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RegistroUtil} to access the registro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RegistroImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroModelImpl.FINDER_CACHE_ENABLED, RegistroImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroModelImpl.FINDER_CACHE_ENABLED, RegistroImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroModelImpl.FINDER_CACHE_ENABLED, RegistroImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroModelImpl.FINDER_CACHE_ENABLED, RegistroImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
            new String[] { String.class.getName() },
            RegistroModelImpl.EMAIL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "registro.email IS NULL";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "registro.email = ?";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(registro.email IS NULL OR registro.email = '')";
    private static final String _SQL_SELECT_REGISTRO = "SELECT registro FROM Registro registro";
    private static final String _SQL_SELECT_REGISTRO_WHERE = "SELECT registro FROM Registro registro WHERE ";
    private static final String _SQL_COUNT_REGISTRO = "SELECT COUNT(registro) FROM Registro registro";
    private static final String _SQL_COUNT_REGISTRO_WHERE = "SELECT COUNT(registro) FROM Registro registro WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "registro.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Registro exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Registro exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RegistroPersistenceImpl.class);
    private static Registro _nullRegistro = new RegistroImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Registro> toCacheModel() {
                return _nullRegistroCacheModel;
            }
        };

    private static CacheModel<Registro> _nullRegistroCacheModel = new CacheModel<Registro>() {
            @Override
            public Registro toEntityModel() {
                return _nullRegistro;
            }
        };

    public RegistroPersistenceImpl() {
        setModelClass(Registro.class);
    }

    /**
     * Returns all the registros where email = &#63;.
     *
     * @param email the email
     * @return the matching registros
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Registro> findByEmail(String email) throws SystemException {
        return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Registro> findByEmail(String email, int start, int end)
        throws SystemException {
        return findByEmail(email, start, end, null);
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
    @Override
    public List<Registro> findByEmail(String email, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email, start, end, orderByComparator };
        }

        List<Registro> list = (List<Registro>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Registro registro : list) {
                if (!Validator.equals(email, registro.getEmail())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_REGISTRO_WHERE);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
            } else {
                bindEmail = true;

                query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RegistroModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEmail) {
                    qPos.add(email);
                }

                if (!pagination) {
                    list = (List<Registro>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Registro>(list);
                } else {
                    list = (List<Registro>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Registro findByEmail_First(String email,
        OrderByComparator orderByComparator)
        throws NoSuchRegistroException, SystemException {
        Registro registro = fetchByEmail_First(email, orderByComparator);

        if (registro != null) {
            return registro;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegistroException(msg.toString());
    }

    /**
     * Returns the first registro in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching registro, or <code>null</code> if a matching registro could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro fetchByEmail_First(String email,
        OrderByComparator orderByComparator) throws SystemException {
        List<Registro> list = findByEmail(email, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Registro findByEmail_Last(String email,
        OrderByComparator orderByComparator)
        throws NoSuchRegistroException, SystemException {
        Registro registro = fetchByEmail_Last(email, orderByComparator);

        if (registro != null) {
            return registro;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegistroException(msg.toString());
    }

    /**
     * Returns the last registro in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching registro, or <code>null</code> if a matching registro could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro fetchByEmail_Last(String email,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEmail(email);

        if (count == 0) {
            return null;
        }

        List<Registro> list = findByEmail(email, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Registro[] findByEmail_PrevAndNext(long registroId, String email,
        OrderByComparator orderByComparator)
        throws NoSuchRegistroException, SystemException {
        Registro registro = findByPrimaryKey(registroId);

        Session session = null;

        try {
            session = openSession();

            Registro[] array = new RegistroImpl[3];

            array[0] = getByEmail_PrevAndNext(session, registro, email,
                    orderByComparator, true);

            array[1] = registro;

            array[2] = getByEmail_PrevAndNext(session, registro, email,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Registro getByEmail_PrevAndNext(Session session,
        Registro registro, String email, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REGISTRO_WHERE);

        boolean bindEmail = false;

        if (email == null) {
            query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
        } else if (email.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
        } else {
            bindEmail = true;

            query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RegistroModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEmail) {
            qPos.add(email);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(registro);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Registro> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the registros where email = &#63; from the database.
     *
     * @param email the email
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEmail(String email) throws SystemException {
        for (Registro registro : findByEmail(email, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(registro);
        }
    }

    /**
     * Returns the number of registros where email = &#63;.
     *
     * @param email the email
     * @return the number of matching registros
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEmail(String email) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

        Object[] finderArgs = new Object[] { email };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_REGISTRO_WHERE);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
            } else {
                bindEmail = true;

                query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEmail) {
                    qPos.add(email);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the registro in the entity cache if it is enabled.
     *
     * @param registro the registro
     */
    @Override
    public void cacheResult(Registro registro) {
        EntityCacheUtil.putResult(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroImpl.class, registro.getPrimaryKey(), registro);

        registro.resetOriginalValues();
    }

    /**
     * Caches the registros in the entity cache if it is enabled.
     *
     * @param registros the registros
     */
    @Override
    public void cacheResult(List<Registro> registros) {
        for (Registro registro : registros) {
            if (EntityCacheUtil.getResult(
                        RegistroModelImpl.ENTITY_CACHE_ENABLED,
                        RegistroImpl.class, registro.getPrimaryKey()) == null) {
                cacheResult(registro);
            } else {
                registro.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all registros.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RegistroImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RegistroImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the registro.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Registro registro) {
        EntityCacheUtil.removeResult(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroImpl.class, registro.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Registro> registros) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Registro registro : registros) {
            EntityCacheUtil.removeResult(RegistroModelImpl.ENTITY_CACHE_ENABLED,
                RegistroImpl.class, registro.getPrimaryKey());
        }
    }

    /**
     * Creates a new registro with the primary key. Does not add the registro to the database.
     *
     * @param registroId the primary key for the new registro
     * @return the new registro
     */
    @Override
    public Registro create(long registroId) {
        Registro registro = new RegistroImpl();

        registro.setNew(true);
        registro.setPrimaryKey(registroId);

        return registro;
    }

    /**
     * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param registroId the primary key of the registro
     * @return the registro that was removed
     * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro remove(long registroId)
        throws NoSuchRegistroException, SystemException {
        return remove((Serializable) registroId);
    }

    /**
     * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the registro
     * @return the registro that was removed
     * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro remove(Serializable primaryKey)
        throws NoSuchRegistroException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Registro registro = (Registro) session.get(RegistroImpl.class,
                    primaryKey);

            if (registro == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRegistroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(registro);
        } catch (NoSuchRegistroException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Registro removeImpl(Registro registro) throws SystemException {
        registro = toUnwrappedModel(registro);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(registro)) {
                registro = (Registro) session.get(RegistroImpl.class,
                        registro.getPrimaryKeyObj());
            }

            if (registro != null) {
                session.delete(registro);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (registro != null) {
            clearCache(registro);
        }

        return registro;
    }

    @Override
    public Registro updateImpl(com.liferay62.servicio.model.Registro registro)
        throws SystemException {
        registro = toUnwrappedModel(registro);

        boolean isNew = registro.isNew();

        RegistroModelImpl registroModelImpl = (RegistroModelImpl) registro;

        Session session = null;

        try {
            session = openSession();

            if (registro.isNew()) {
                session.save(registro);

                registro.setNew(false);
            } else {
                session.merge(registro);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RegistroModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((registroModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        registroModelImpl.getOriginalEmail()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);

                args = new Object[] { registroModelImpl.getEmail() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);
            }
        }

        EntityCacheUtil.putResult(RegistroModelImpl.ENTITY_CACHE_ENABLED,
            RegistroImpl.class, registro.getPrimaryKey(), registro);

        return registro;
    }

    protected Registro toUnwrappedModel(Registro registro) {
        if (registro instanceof RegistroImpl) {
            return registro;
        }

        RegistroImpl registroImpl = new RegistroImpl();

        registroImpl.setNew(registro.isNew());
        registroImpl.setPrimaryKey(registro.getPrimaryKey());

        registroImpl.setRegistroId(registro.getRegistroId());
        registroImpl.setNombre(registro.getNombre());
        registroImpl.setApellido(registro.getApellido());
        registroImpl.setEmail(registro.getEmail());
        registroImpl.setNacimiento(registro.getNacimiento());
        registroImpl.setAlta(registro.getAlta());

        return registroImpl;
    }

    /**
     * Returns the registro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the registro
     * @return the registro
     * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRegistroException, SystemException {
        Registro registro = fetchByPrimaryKey(primaryKey);

        if (registro == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRegistroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return registro;
    }

    /**
     * Returns the registro with the primary key or throws a {@link com.liferay62.servicio.NoSuchRegistroException} if it could not be found.
     *
     * @param registroId the primary key of the registro
     * @return the registro
     * @throws com.liferay62.servicio.NoSuchRegistroException if a registro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro findByPrimaryKey(long registroId)
        throws NoSuchRegistroException, SystemException {
        return findByPrimaryKey((Serializable) registroId);
    }

    /**
     * Returns the registro with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the registro
     * @return the registro, or <code>null</code> if a registro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Registro registro = (Registro) EntityCacheUtil.getResult(RegistroModelImpl.ENTITY_CACHE_ENABLED,
                RegistroImpl.class, primaryKey);

        if (registro == _nullRegistro) {
            return null;
        }

        if (registro == null) {
            Session session = null;

            try {
                session = openSession();

                registro = (Registro) session.get(RegistroImpl.class, primaryKey);

                if (registro != null) {
                    cacheResult(registro);
                } else {
                    EntityCacheUtil.putResult(RegistroModelImpl.ENTITY_CACHE_ENABLED,
                        RegistroImpl.class, primaryKey, _nullRegistro);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RegistroModelImpl.ENTITY_CACHE_ENABLED,
                    RegistroImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return registro;
    }

    /**
     * Returns the registro with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param registroId the primary key of the registro
     * @return the registro, or <code>null</code> if a registro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Registro fetchByPrimaryKey(long registroId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) registroId);
    }

    /**
     * Returns all the registros.
     *
     * @return the registros
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Registro> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Registro> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Registro> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Registro> list = (List<Registro>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REGISTRO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REGISTRO;

                if (pagination) {
                    sql = sql.concat(RegistroModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Registro>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Registro>(list);
                } else {
                    list = (List<Registro>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the registros from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Registro registro : findAll()) {
            remove(registro);
        }
    }

    /**
     * Returns the number of registros.
     *
     * @return the number of registros
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_REGISTRO);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the registro persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay62.servicio.model.Registro")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Registro>> listenersList = new ArrayList<ModelListener<Registro>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Registro>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RegistroImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
