package com.dev.sa.fintnessrunnersuite;

import fitnesse.junit.FitNesseSuite;
import fitnesse.junit.FitNesseSuite.OutputDir;
import fitnesse.junit.FitNesseSuite.FitnesseDir;
import fitnesse.junit.FitNesseSuite.Name;
import org.junit.runner.RunWith;
/**
 * Created by Anie on 7/3/2016.
 */
@RunWith(FitNesseSuite.class)
@Name("UnitTesting.DaoUnitTestSuite")
@FitnesseDir(value="src/test/fitnesses",fitNesseRoot ="")
@OutputDir("target/fitoutput")
public class FitnessRunnerDoaTest {
}
