package gradle_clojure.plugin.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.gradle.api.Action;
import org.gradle.api.file.FileCollection;
import org.gradle.process.JavaForkOptions;

public class ClojureExecSpec {
  private FileCollection classpath;
  private String namespace;
  private String function;
  private Object[] args = new Object[0];
  private List<Action<JavaForkOptions>> configureFork = new ArrayList<>();

  public FileCollection getClasspath() {
    return classpath;
  }

  public void setClasspath(FileCollection classpath) {
    this.classpath = classpath;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public Object[] getArgs() {
    return args;
  }

  public void setArgs(Object... args) {
    if (args == null) {
      this.args = new Object[0];
    } else {
      this.args = args;
    }
  }

  public void args(Object... args) {
    this.args = Stream.concat(Arrays.stream(this.args), Arrays.stream(args))
        .toArray(size -> new Object[size]);
  }

  public List<Action<JavaForkOptions>> getConfigureFork() {
    return configureFork;
  }

  public void forkOptions(Action<JavaForkOptions> configureFork) {
    this.configureFork.add(configureFork);
  }
}
