package ggikko.me.gtemplateapp.util.network;

import rx.functions.Func1;

public enum ConnectivityStatus {
  UNKNOWN("unknown"),
  WIFI_CONNECTED("connected to WiFi network"),
  MOBILE_CONNECTED("connected to mobile network"),
  OFFLINE("offline");

  public final String description;

  ConnectivityStatus(final String description) {
    this.description = description;
  }

  /**
   * Creates a function, which checks
   * if single connectivity status or many statuses
   * are equal to current status. It can be used inside filter(...)
   * method from RxJava
   *
   * @param statuses many connectivity statuses or single status
   * @return Func1<ConnectivityStatus, Boolean> from RxJava
   */
  public static Func1<ConnectivityStatus, Boolean> isEqualTo(final ConnectivityStatus... statuses) {
    return new Func1<ConnectivityStatus, Boolean>() {
      @Override
      public Boolean call(ConnectivityStatus connectivityStatus) {
        boolean statuesAreEqual = false;

        for (ConnectivityStatus singleStatus : statuses) {
          statuesAreEqual = singleStatus == connectivityStatus;
        }

        return statuesAreEqual;
      }
    };
  }

  /**
   * Creates a function, which checks
   * if single connectivity status or many statuses
   * are not equal to current status. It can be used inside filter(...)
   * method from RxJava
   *
   * @param statuses many connectivity statuses or single status
   * @return Func1<ConnectivityStatus, Boolean> from RxJava
   */
  public static Func1<ConnectivityStatus, Boolean> isNotEqualTo(
      final ConnectivityStatus... statuses) {
    return new Func1<ConnectivityStatus, Boolean>() {
      @Override
      public Boolean call(ConnectivityStatus connectivityStatus) {
        boolean statuesAreNotEqual = false;

        for (ConnectivityStatus singleStatus : statuses) {
          statuesAreNotEqual = singleStatus != connectivityStatus;
        }

        return statuesAreNotEqual;
      }
    };
  }

  @Override
  public String toString() {
    return "ConnectivityStatus{" + "description='" + description + '\'' + '}';
  }
}
