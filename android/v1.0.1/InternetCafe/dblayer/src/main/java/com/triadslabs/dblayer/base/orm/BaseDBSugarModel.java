package com.triadslabs.dblayer.base.orm;

import com.triadslabs.dblayer.base.IDBBaseModel;
import com.orm.SugarRecord;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by muzammilpeer on 1/23/15.
 */
public class BaseDBSugarModel  extends SugarRecord implements IDBBaseModel {

    public BaseDBSugarModel()
    {

    }

    @Override
    public void delete() {
        super.delete();
    }

    @Override
    public void save() {
        super.save();
    }

    @Override
    public List<Field> getTableFields() {
        return super.getTableFields();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getSqlName() {
        return super.getSqlName();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }
}
