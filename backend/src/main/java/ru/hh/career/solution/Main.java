package ru.hh.career.solution;

import ru.hh.career.solution.config.ProdConfig;
import ru.hh.nab.starter.NabApplication;

public class Main {

    public static void main(String[] args) {
        NabApplication
                .builder()
                .configureJersey()
                .bindToRoot()
                .build()
                .run(ProdConfig.class);
    }
}
