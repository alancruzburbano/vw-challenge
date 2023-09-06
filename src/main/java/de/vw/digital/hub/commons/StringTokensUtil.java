package de.vw.digital.hub.commons;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTokensUtil {

  public static List<String> readTokens(String input, String separator) {
    return Stream.of(input.split(separator, -1)).collect(Collectors.toList());
  }
}
