package com.usp.gitavijnana.server.service;

import org.slim3.datastore.Datastore;

import com.usp.gitavijnana.client.service.AddSloka;
import com.usp.gitavijnana.server.meta.SlokaMeta;
import com.usp.gitavijnana.shared.model.Sloka;

public class AddSlokaImpl implements AddSloka {

    public void addSloka(Sloka sloka) {
        SlokaMeta meta = SlokaMeta.get();
        Sloka result = Datastore.query(meta)
        .filter(meta.chapter.equal(sloka.getChapter()),
            meta.slokaNum.equal(sloka.getSlokaNum()))
            .asSingle();
        if (result == null) {
            Datastore.put(sloka);
        } 
    }
}
