package com.usp.gitavijnana.server.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.usp.gitavijnana.shared.model.TransitionInfo;

public class TransitionController extends Controller {

    @Override
    public Navigation run() throws Exception {
        TransitionInfo info = new TransitionInfo();
        Datastore.put(info);
        return forward("transition.jsp");
    }
}
