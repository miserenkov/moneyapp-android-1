package com.cactusteam.money.data.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.cactusteam.money.data.dao.PatternTag;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PATTERN_TAG".
*/
public class PatternTagDao extends AbstractDao<PatternTag, Long> {

    public static final String TABLENAME = "PATTERN_TAG";

    /**
     * Properties of entity PatternTag.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PatternId = new Property(1, long.class, "patternId", false, "PATTERN_ID");
        public final static Property TagId = new Property(2, long.class, "tagId", false, "TAG_ID");
    };

    private DaoSession daoSession;

    private Query<PatternTag> transactionPattern_TagsQuery;

    public PatternTagDao(DaoConfig config) {
        super(config);
    }
    
    public PatternTagDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PATTERN_TAG\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"PATTERN_ID\" INTEGER NOT NULL ," + // 1: patternId
                "\"TAG_ID\" INTEGER NOT NULL );"); // 2: tagId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PATTERN_TAG\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PatternTag entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getPatternId());
        stmt.bindLong(3, entity.getTagId());
    }

    @Override
    protected void attachEntity(PatternTag entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public PatternTag readEntity(Cursor cursor, int offset) {
        PatternTag entity = new PatternTag( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // patternId
            cursor.getLong(offset + 2) // tagId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PatternTag entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPatternId(cursor.getLong(offset + 1));
        entity.setTagId(cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PatternTag entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PatternTag entity) {
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
    
    /** Internal query to resolve the "tags" to-many relationship of TransactionPattern. */
    public List<PatternTag> _queryTransactionPattern_Tags(long patternId) {
        synchronized (this) {
            if (transactionPattern_TagsQuery == null) {
                QueryBuilder<PatternTag> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.PatternId.eq(null));
                transactionPattern_TagsQuery = queryBuilder.build();
            }
        }
        Query<PatternTag> query = transactionPattern_TagsQuery.forCurrentThread();
        query.setParameter(0, patternId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getTagDao().getAllColumns());
            builder.append(" FROM PATTERN_TAG T");
            builder.append(" LEFT JOIN TAG T0 ON T.\"TAG_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PatternTag loadCurrentDeep(Cursor cursor, boolean lock) {
        PatternTag entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Tag tag = loadCurrentOther(daoSession.getTagDao(), cursor, offset);
         if(tag != null) {
            entity.setTag(tag);
        }

        return entity;    
    }

    public PatternTag loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<PatternTag> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PatternTag> list = new ArrayList<PatternTag>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<PatternTag> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PatternTag> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
