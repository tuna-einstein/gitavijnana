package com.usp.gitavijnana.server.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class TempController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("sloka.jsp");
    }
}
