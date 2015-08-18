package com.usp.gitavijnana.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.usp.gitavijnana.shared.model.Sloka;

@RemoteServiceRelativePath("service.s3gwt")
public interface AddSloka extends RemoteService {
    void addSloka(Sloka sloka);
}
