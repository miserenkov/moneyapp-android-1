package com.cactusteam.money.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.cactusteam.money.data.dao.Account;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACCOUNT".
*/
public class AccountDao extends AbstractDao<Account, Long> {

    public static final String TABLENAME = "ACCOUNT";

    /**
     * Properties of entity Account.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Deleted = new Property(2, boolean.class, "deleted", false, "DELETED");
        public final static Property CurrencyCode = new Property(3, String.class, "currencyCode", false, "CURRENCY_CODE");
        public final static Property Color = new Property(4, String.class, "color", false, "COLOR");
        public final static Property Type = new Property(5, int.class, "type", false, "TYPE");
        public final static Property SkipInBalance = new Property(6, boolean.class, "skipInBalance", false, "SKIP_IN_BALANCE");
        public final static Property CustomOrder = new Property(7, int.class, "customOrder", false, "CUSTOM_ORDER");
        public final static Property GlobalId = new Property(8, Long.class, "globalId", false, "GLOBAL_ID");
        public final static Property Synced = new Property(9, Boolean.class, "synced", false, "SYNCED");
    };


    public AccountDao(DaoConfig config) {
        super(config);
    }
    
    public AccountDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACCOUNT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"DELETED\" INTEGER NOT NULL ," + // 2: deleted
                "\"CURRENCY_CODE\" TEXT NOT NULL ," + // 3: currencyCode
                "\"COLOR\" TEXT NOT NULL ," + // 4: color
                "\"TYPE\" INTEGER NOT NULL ," + // 5: type
                "\"SKIP_IN_BALANCE\" INTEGER NOT NULL ," + // 6: skipInBalance
                "\"CUSTOM_ORDER\" INTEGER NOT NULL ," + // 7: customOrder
                "\"GLOBAL_ID\" INTEGER," + // 8: globalId
                "\"SYNCED\" INTEGER);"); // 9: synced
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACCOUNT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Account entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getDeleted() ? 1L: 0L);
        stmt.bindString(4, entity.getCurrencyCode());
        stmt.bindString(5, entity.getColor());
        stmt.bindLong(6, entity.getType());
        stmt.bindLong(7, entity.getSkipInBalance() ? 1L: 0L);
        stmt.bindLong(8, entity.getCustomOrder());
 
        Long globalId = entity.getGlobalId();
        if (globalId != null) {
            stmt.bindLong(9, globalId);
        }
 
        Boolean synced = entity.getSynced();
        if (synced != null) {
            stmt.bindLong(10, synced ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Account readEntity(Cursor cursor, int offset) {
        Account entity = new Account( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getShort(offset + 2) != 0, // deleted
            cursor.getString(offset + 3), // currencyCode
            cursor.getString(offset + 4), // color
            cursor.getInt(offset + 5), // type
            cursor.getShort(offset + 6) != 0, // skipInBalance
            cursor.getInt(offset + 7), // customOrder
            cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8), // globalId
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0 // synced
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Account entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setDeleted(cursor.getShort(offset + 2) != 0);
        entity.setCurrencyCode(cursor.getString(offset + 3));
        entity.setColor(cursor.getString(offset + 4));
        entity.setType(cursor.getInt(offset + 5));
        entity.setSkipInBalance(cursor.getShort(offset + 6) != 0);
        entity.setCustomOrder(cursor.getInt(offset + 7));
        entity.setGlobalId(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
        entity.setSynced(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Account entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Account entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
