import ch.aplu.xboxcontroller.XboxController;
import java.io.IOException;
import javax.comm.*;

public class main {

  /*
   * must disable all other COM ports on Windows PC before running or else it might not work.
   * must extract appropriate dlls to java path, or add them to the java path environment variable.
   */
  public static void main(String[] args) {
//    PATH = C:\C:\Windows\XboxController"
//    contains: rxtxSerial.dll, win32comm.dll, xboxcontroller.dll, xboxcontroller64.dll
    System.loadLibrary("xboxcontroller64");
    xboxControllerListener xcl = new xboxControllerListener();
    XboxController xc = new XboxController();
    xc.addXboxControllerListener(xcl);
    System.out.println("Controller connected: " + xc.isConnected());
    
    SerialPortHandler sph = new SerialPortHandler();
    try {
      sph.connect();
      System.out.println("Connected to: " + sph.getPortName());
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Connect to "+ sph.getPortName() + " failed");
    }
    
    
//    while (xc.isConnected()) {
//      if (xcl.resourceRelease) {
//        xc.vibrate(65535, 65535, 100);
//        System.out.println("stopping");
//        xc.release();
//      }
//    }
  }
}
