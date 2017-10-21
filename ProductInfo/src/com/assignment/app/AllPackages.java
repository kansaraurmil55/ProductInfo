package com.assignment.app;

import org.glassfish.jersey.server.ResourceConfig;

public class AllPackages extends ResourceConfig {
    public AllPackages() {
        // Define the package which contains the service classes.
        packages("com.assignment.services");
    }
}