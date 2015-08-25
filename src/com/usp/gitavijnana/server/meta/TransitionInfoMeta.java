package com.usp.gitavijnana.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-08-25 13:58:16")
/** */
public final class TransitionInfoMeta extends org.slim3.datastore.ModelMeta<com.usp.gitavijnana.shared.model.TransitionInfo> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer> chapter = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer>(this, "chapter", "chapter", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer> end = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer>(this, "end", "end", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer> index = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer>(this, "index", "index", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer> start = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Integer>(this, "start", "start", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.TransitionInfo, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TransitionInfoMeta slim3_singleton = new TransitionInfoMeta();

    /**
     * @return the singleton
     */
    public static TransitionInfoMeta get() {
       return slim3_singleton;
    }

    /** */
    public TransitionInfoMeta() {
        super("TransitionInfo", com.usp.gitavijnana.shared.model.TransitionInfo.class);
    }

    @Override
    public com.usp.gitavijnana.shared.model.TransitionInfo entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.usp.gitavijnana.shared.model.TransitionInfo model = new com.usp.gitavijnana.shared.model.TransitionInfo();
        model.setChapter(longToPrimitiveInt((java.lang.Long) entity.getProperty("chapter")));
        model.setEnd(longToPrimitiveInt((java.lang.Long) entity.getProperty("end")));
        model.setIndex(longToPrimitiveInt((java.lang.Long) entity.getProperty("index")));
        model.setKey(entity.getKey());
        model.setStart(longToPrimitiveInt((java.lang.Long) entity.getProperty("start")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.usp.gitavijnana.shared.model.TransitionInfo m = (com.usp.gitavijnana.shared.model.TransitionInfo) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("chapter", m.getChapter());
        entity.setProperty("end", m.getEnd());
        entity.setProperty("index", m.getIndex());
        entity.setProperty("start", m.getStart());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.usp.gitavijnana.shared.model.TransitionInfo m = (com.usp.gitavijnana.shared.model.TransitionInfo) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.usp.gitavijnana.shared.model.TransitionInfo m = (com.usp.gitavijnana.shared.model.TransitionInfo) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.usp.gitavijnana.shared.model.TransitionInfo m = (com.usp.gitavijnana.shared.model.TransitionInfo) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.usp.gitavijnana.shared.model.TransitionInfo m = (com.usp.gitavijnana.shared.model.TransitionInfo) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.usp.gitavijnana.shared.model.TransitionInfo m = (com.usp.gitavijnana.shared.model.TransitionInfo) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("chapter");
        encoder0.encode(writer, m.getChapter());
        writer.setNextPropertyName("end");
        encoder0.encode(writer, m.getEnd());
        writer.setNextPropertyName("index");
        encoder0.encode(writer, m.getIndex());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("start");
        encoder0.encode(writer, m.getStart());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.usp.gitavijnana.shared.model.TransitionInfo jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.usp.gitavijnana.shared.model.TransitionInfo m = new com.usp.gitavijnana.shared.model.TransitionInfo();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("chapter");
        m.setChapter(decoder0.decode(reader, m.getChapter()));
        reader = rootReader.newObjectReader("end");
        m.setEnd(decoder0.decode(reader, m.getEnd()));
        reader = rootReader.newObjectReader("index");
        m.setIndex(decoder0.decode(reader, m.getIndex()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("start");
        m.setStart(decoder0.decode(reader, m.getStart()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}