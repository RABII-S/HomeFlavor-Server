package com.supcom.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;


@ApplicationPath("/api")
public class JaxRsActivator extends Application {
    public JaxRsActivator() throws IOException {
        super();
        FireStoreInitializer.connect();
    }

}