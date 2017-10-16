public class Homework6Grader
{
  public Homework6Grader() {}
  
  public static void main(String[] paramArrayOfString)
  {
    try {
      java.io.File localFile1 = new java.io.File("graph_builder_test.txt");
      if (!localFile1.exists()) {
        System.out.println("Cannot run tests: graph_builder_test.txt needs to be in project root directory or directory where you ran Java.");
        System.exit(1);
      }
    }
    catch (Exception localException1) {
      System.out.println("An unexpected error occurred while trying to read graph_builder_test.txt: " + localException1);
      System.out.println("Please check that graph_builder_test.txt is in the project root directory or directory where you ran Java.");
      System.exit(1);
    }
    try {
      java.io.File localFile2 = new java.io.File("is_hamiltonian_path_test.txt");
      if (!localFile2.exists()) {
        System.out.println("Cannot run tests: is_hamiltonian_path_test.txt needs to be in project root directory or directory where you ran Java.");
        System.exit(1);
      }
    }
    catch (Exception localException2) {
      System.out.println("An unexpected error occurred while trying to read is_hamiltonian_path_test.txt: " + localException2);
      System.out.println("Please check that is_hamiltonian_path_test.txt is in the project root directory or directory where you ran Java.");
      System.exit(1);
    }
    
    org.junit.runner.Result localResult = org.junit.runner.JUnitCore.runClasses(new Class[] { MinDistanceTest.class, NodesWithinDistanceTest.class, IsHamiltonianPathTest.class });
    
    int i = localResult.getFailureCount();
    int j = localResult.getRunCount() - i;
    
    if (j == 1) {
      System.out.println("1 test passed.");
    } else {
      System.out.println(j + " tests passed.");
    }
    if (i == 1)
      System.out.println("1 test failed."); else {
      System.out.println(i + " tests failed.");
    }
    if (i == 0) {
      System.out.println("Great job!");
    }
    else {
      int k = (int)(j / (i + j) * 100.0D);
      int m = 1;
      for (org.junit.runner.notification.Failure localFailure : localResult.getFailures()) { Throwable localThrowable;
        if (localFailure.getMessage() == null) {
          localThrowable = localFailure.getException();
          System.out.println("#" + m + ". A test threw " + localThrowable + " at " + localThrowable.getStackTrace()[0]);

        }
        else
        {
          localThrowable = localFailure.getException();
          if ((localThrowable instanceof AssertionError)) {
            System.out.println("#" + m + ". " + localFailure.getMessage());
          }
          else {
            System.out.println("#" + m + ". " + localFailure.getException() + " occurs at " + localFailure.getException().getStackTrace()[0]);
          }
        }
        m++;
      }
      System.out.println("Your score for this assignment would be " + k + "%\n");
    }
  }
}
