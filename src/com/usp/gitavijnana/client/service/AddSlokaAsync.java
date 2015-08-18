package com.usp.gitavijnana.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.usp.gitavijnana.shared.model.Sloka;

public interface AddSlokaAsync {

    void addSloka(Sloka sloka, AsyncCallback<Void> callback);

}
