package com.usp.gitavijnana.server.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.usp.gitavijnana.shared.model.TransitionInfo;

public class TransitionController extends Controller {

    @Override
    public Navigation run() throws Exception {
//        for (int i = 13; i < 73 ; i++) {
//            TransitionInfo info = new TransitionInfo();
//            info.setIndex(i);
//            Datastore.put(info); 
//        }
        return forward("transition.jsp");
    }
}
