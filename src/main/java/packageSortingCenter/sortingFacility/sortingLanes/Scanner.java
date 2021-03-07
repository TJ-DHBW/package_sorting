package packageSortingCenter.sortingFacility.sortingLanes;

import base.Configuration;
import container.Package;
import packageSortingCenter.sortingFacility.SearchAlgorithm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Scanner {
    private static ISearchAlgorithm searchAlgorithm;
    private final char[] forbiddenObject = "exp!os:ve".toCharArray();

    public Scanner() {
        changeSearchAlgorithm(SearchAlgorithm.RK);
    }

    public static void shutdownScanner() {
        searchAlgorithm = null;
    }

    public static void changeSearchAlgorithm(SearchAlgorithm algorithm) {
        String projectName = algorithm.toProjectName();
        String className = algorithm.toMainClassName();
        if (projectName == null || className == null)
            throw new UnsupportedOperationException("Changing to the algorithm " + algorithm + " is not supported.");

        searchAlgorithm = loadSearchAlgorithmComponent(projectName, className);
    }

    private static ISearchAlgorithm loadSearchAlgorithmComponent(String projectName, String className) {
        String fileSeparator = Configuration.instance.fileSeparator;
        String pathToJar = Configuration.instance.componentsFolder + fileSeparator
                + projectName + fileSeparator
                + Configuration.instance.libraryPath + fileSeparator
                + "searchAlgorithm.jar";
        ISearchAlgorithm componentPort = null;

        try {
            URL[] urls = {new File(pathToJar).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Scanner.class.getClassLoader());
            Class searchAlgorithmClass = Class.forName(className, true, urlClassLoader);
            Object searchAlgorithmInstance = searchAlgorithmClass.getMethod("getInstance").invoke(null);
            componentPort = (ISearchAlgorithm) searchAlgorithmClass.getDeclaredField("port").get(searchAlgorithmInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

    public boolean scan(Package packageToScan) {
        for (char[][] length : packageToScan.getContent()) {
            for (char[] width : length) {
                if (searchAlgorithm.search(width, forbiddenObject) != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
