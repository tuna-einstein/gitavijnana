package com.usp.gitavijnana.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-08-17 08:39:09")
/** */
public final class SlokaMeta extends org.slim3.datastore.ModelMeta<com.usp.gitavijnana.shared.model.Sloka> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka> audioLink = new org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka>(this, "audioLink", "audioLink");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, java.lang.Integer> chapter = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, java.lang.Integer>(this, "chapter", "chapter", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka> english = new org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka>(this, "english", "english");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka> englishTranslation = new org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka>(this, "englishTranslation", "englishTranslation");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka> sanskrit = new org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka>(this, "sanskrit", "sanskrit");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka> sanskritToEnglish = new org.slim3.datastore.StringAttributeMeta<com.usp.gitavijnana.shared.model.Sloka>(this, "sanskritToEnglish", "sanskritToEnglish");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, java.lang.Integer> slokaNum = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, java.lang.Integer>(this, "slokaNum", "slokaNum", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.usp.gitavijnana.shared.model.Sloka, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final SlokaMeta slim3_singleton = new SlokaMeta();

    /**
     * @return the singleton
     */
    public static SlokaMeta get() {
       return slim3_singleton;
    }

    /** */
    public SlokaMeta() {
        super("Sloka", com.usp.gitavijnana.shared.model.Sloka.class);
    }

    @Override
    public com.usp.gitavijnana.shared.model.Sloka entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.usp.gitavijnana.shared.model.Sloka model = new com.usp.gitavijnana.shared.model.Sloka();
        model.setAudioLink((java.lang.String) entity.getProperty("audioLink"));
        model.setChapter(longToPrimitiveInt((java.lang.Long) entity.getProperty("chapter")));
        model.setEnglish((java.lang.String) entity.getProperty("english"));
        model.setEnglishTranslation((java.lang.String) entity.getProperty("englishTranslation"));
        model.setKey(entity.getKey());
        model.setSanskrit((java.lang.String) entity.getProperty("sanskrit"));
        model.setSanskritToEnglish((java.lang.String) entity.getProperty("sanskritToEnglish"));
        model.setSlokaNum(longToPrimitiveInt((java.lang.Long) entity.getProperty("slokaNum")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.usp.gitavijnana.shared.model.Sloka m = (com.usp.gitavijnana.shared.model.Sloka) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("audioLink", m.getAudioLink());
        entity.setProperty("chapter", m.getChapter());
        entity.setProperty("english", m.getEnglish());
        entity.setProperty("englishTranslation", m.getEnglishTranslation());
        entity.setProperty("sanskrit", m.getSanskrit());
        entity.setProperty("sanskritToEnglish", m.getSanskritToEnglish());
        entity.setProperty("slokaNum", m.getSlokaNum());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.usp.gitavijnana.shared.model.Sloka m = (com.usp.gitavijnana.shared.model.Sloka) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.usp.gitavijnana.shared.model.Sloka m = (com.usp.gitavijnana.shared.model.Sloka) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.usp.gitavijnana.shared.model.Sloka m = (com.usp.gitavijnana.shared.model.Sloka) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.usp.gitavijnana.shared.model.Sloka m = (com.usp.gitavijnana.shared.model.Sloka) model;
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
        com.usp.gitavijnana.shared.model.Sloka m = (com.usp.gitavijnana.shared.model.Sloka) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAudioLink() != null){
            writer.setNextPropertyName("audioLink");
            encoder0.encode(writer, m.getAudioLink());
        }
        writer.setNextPropertyName("chapter");
        encoder0.encode(writer, m.getChapter());
        if(m.getEnglish() != null){
            writer.setNextPropertyName("english");
            encoder0.encode(writer, m.getEnglish());
        }
        if(m.getEnglishTranslation() != null){
            writer.setNextPropertyName("englishTranslation");
            encoder0.encode(writer, m.getEnglishTranslation());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getSanskrit() != null){
            writer.setNextPropertyName("sanskrit");
            encoder0.encode(writer, m.getSanskrit());
        }
        if(m.getSanskritToEnglish() != null){
            writer.setNextPropertyName("sanskritToEnglish");
            encoder0.encode(writer, m.getSanskritToEnglish());
        }
        writer.setNextPropertyName("slokaNum");
        encoder0.encode(writer, m.getSlokaNum());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.usp.gitavijnana.shared.model.Sloka jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.usp.gitavijnana.shared.model.Sloka m = new com.usp.gitavijnana.shared.model.Sloka();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("audioLink");
        m.setAudioLink(decoder0.decode(reader, m.getAudioLink()));
        reader = rootReader.newObjectReader("chapter");
        m.setChapter(decoder0.decode(reader, m.getChapter()));
        reader = rootReader.newObjectReader("english");
        m.setEnglish(decoder0.decode(reader, m.getEnglish()));
        reader = rootReader.newObjectReader("englishTranslation");
        m.setEnglishTranslation(decoder0.decode(reader, m.getEnglishTranslation()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("sanskrit");
        m.setSanskrit(decoder0.decode(reader, m.getSanskrit()));
        reader = rootReader.newObjectReader("sanskritToEnglish");
        m.setSanskritToEnglish(decoder0.decode(reader, m.getSanskritToEnglish()));
        reader = rootReader.newObjectReader("slokaNum");
        m.setSlokaNum(decoder0.decode(reader, m.getSlokaNum()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}