package com.liferay62.servicio.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay62.servicio.model.Registro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Registro in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Registro
 * @generated
 */
public class RegistroCacheModel implements CacheModel<Registro>, Externalizable {
    public long registroId;
    public String nombre;
    public String apellido;
    public String email;
    public long nacimiento;
    public long alta;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{registroId=");
        sb.append(registroId);
        sb.append(", nombre=");
        sb.append(nombre);
        sb.append(", apellido=");
        sb.append(apellido);
        sb.append(", email=");
        sb.append(email);
        sb.append(", nacimiento=");
        sb.append(nacimiento);
        sb.append(", alta=");
        sb.append(alta);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Registro toEntityModel() {
        RegistroImpl registroImpl = new RegistroImpl();

        registroImpl.setRegistroId(registroId);

        if (nombre == null) {
            registroImpl.setNombre(StringPool.BLANK);
        } else {
            registroImpl.setNombre(nombre);
        }

        if (apellido == null) {
            registroImpl.setApellido(StringPool.BLANK);
        } else {
            registroImpl.setApellido(apellido);
        }

        if (email == null) {
            registroImpl.setEmail(StringPool.BLANK);
        } else {
            registroImpl.setEmail(email);
        }

        if (nacimiento == Long.MIN_VALUE) {
            registroImpl.setNacimiento(null);
        } else {
            registroImpl.setNacimiento(new Date(nacimiento));
        }

        if (alta == Long.MIN_VALUE) {
            registroImpl.setAlta(null);
        } else {
            registroImpl.setAlta(new Date(alta));
        }

        registroImpl.resetOriginalValues();

        return registroImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        registroId = objectInput.readLong();
        nombre = objectInput.readUTF();
        apellido = objectInput.readUTF();
        email = objectInput.readUTF();
        nacimiento = objectInput.readLong();
        alta = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(registroId);

        if (nombre == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(nombre);
        }

        if (apellido == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(apellido);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        objectOutput.writeLong(nacimiento);
        objectOutput.writeLong(alta);
    }
}
