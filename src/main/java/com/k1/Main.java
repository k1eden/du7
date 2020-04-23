package com.k1;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        DuMethods duProject = new DuMethods();
        duProject.parser(args);
        duProject.size();
        duProject.output();
    }
}
