package com.usp.gitavijnana.shared.model;

import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.slim3.datastore.Datastore;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.usp.gitavijnana.server.meta.SlokaMeta;

@Api(name = "slokaendpoint", namespace = @ApiNamespace(ownerDomain = "usp.com", ownerName = "usp.com", packagePath = "gitavijnana.shared.model"))
public class SlokaEndpoint {

    /**
     * This method gets the entity having primary key id. It uses HTTP GET method.
     *
     * @param id the primary key of the java bean.
     * @return The entity with primary key id.
     */
    @ApiMethod(name = "getSloka")
    public Sloka getSloka(@Named("chapter") int chapter, @Named("sloka") int slokaNum) {

        Sloka sloka = new Sloka();
        SlokaMeta meta = SlokaMeta.get();
        Sloka result = Datastore.query(meta)
                .filter(meta.chapter.equal(chapter),
                    meta.slokaNum.equal(slokaNum))
                    .asSingle();
        if (result != null) {
            return result;
        }

        return sloka;
    }

    /**
     * This inserts a new entity into App Engine datastore. If the entity already
     * exists in the datastore, an exception is thrown.
     * It uses HTTP POST method.
     *
     * @param sloka the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(name = "insertSloka")
    public Sloka insertSloka(Sloka sloka) {
        EntityManager mgr = getEntityManager();
        try {
            if (containsSloka(sloka)) {
                throw new EntityExistsException("Object already exists");
            }
            mgr.persist(sloka);
        } finally {
            mgr.close();
        }
        return sloka;
    }

    /**
     * This method is used for updating an existing entity. If the entity does not
     * exist in the datastore, an exception is thrown.
     * It uses HTTP PUT method.
     *
     * @param sloka the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(name = "updateSloka")
    public Sloka updateSloka(Sloka sloka) {
        EntityManager mgr = getEntityManager();
        try {
            if (!containsSloka(sloka)) {
                throw new EntityNotFoundException("Object does not exist");
            }
            mgr.persist(sloka);
        } finally {
            mgr.close();
        }
        return sloka;
    }

    /**
     * This method removes the entity with primary key id.
     * It uses HTTP DELETE method.
     *
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(name = "removeSloka")
    public void removeSloka(@Named("id") Long id) {
        EntityManager mgr = getEntityManager();
        try {
            Sloka sloka = mgr.find(Sloka.class, id);
            mgr.remove(sloka);
        } finally {
            mgr.close();
        }
    }

    private boolean containsSloka(Sloka sloka) {
        EntityManager mgr = getEntityManager();
        boolean contains = true;
        try {
            Sloka item = mgr.find(Sloka.class, sloka.getKey());
            if (item == null) {
                contains = false;
            }
        } finally {
            mgr.close();
        }
        return contains;
    }

    private static EntityManager getEntityManager() {
        return EMF.get().createEntityManager();
    }

}
