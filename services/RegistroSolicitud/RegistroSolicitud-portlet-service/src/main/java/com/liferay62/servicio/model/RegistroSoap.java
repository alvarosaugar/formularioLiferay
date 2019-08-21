package com.liferay62.servicio.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay62.servicio.service.http.RegistroServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay62.servicio.service.http.RegistroServiceSoap
 * @generated
 */
public class RegistroSoap implements Serializable {
    private long _registroId;
    private String _nombre;
    private String _apellido;
    private String _email;
    private Date _nacimiento;
    private Date _alta;

    public RegistroSoap() {
    }

    public static RegistroSoap toSoapModel(Registro model) {
        RegistroSoap soapModel = new RegistroSoap();

        soapModel.setRegistroId(model.getRegistroId());
        soapModel.setNombre(model.getNombre());
        soapModel.setApellido(model.getApellido());
        soapModel.setEmail(model.getEmail());
        soapModel.setNacimiento(model.getNacimiento());
        soapModel.setAlta(model.getAlta());

        return soapModel;
    }

    public static RegistroSoap[] toSoapModels(Registro[] models) {
        RegistroSoap[] soapModels = new RegistroSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RegistroSoap[][] toSoapModels(Registro[][] models) {
        RegistroSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RegistroSoap[models.length][models[0].length];
        } else {
            soapModels = new RegistroSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RegistroSoap[] toSoapModels(List<Registro> models) {
        List<RegistroSoap> soapModels = new ArrayList<RegistroSoap>(models.size());

        for (Registro model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RegistroSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _registroId;
    }

    public void setPrimaryKey(long pk) {
        setRegistroId(pk);
    }

    public long getRegistroId() {
        return _registroId;
    }

    public void setRegistroId(long registroId) {
        _registroId = registroId;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        _nombre = nombre;
    }

    public String getApellido() {
        return _apellido;
    }

    public void setApellido(String apellido) {
        _apellido = apellido;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public Date getNacimiento() {
        return _nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        _nacimiento = nacimiento;
    }

    public Date getAlta() {
        return _alta;
    }

    public void setAlta(Date alta) {
        _alta = alta;
    }
}
