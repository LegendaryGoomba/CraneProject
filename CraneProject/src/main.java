import ch.aplu.xboxcontroller.XboxController;

import java.io.IOException;

import javax.comm.*;


public class main {

  public static void main(String[] args) {
    
    xboxControllerListener xcl = new xboxControllerListener();
    XboxController xc = new XboxController();
    xc.addXboxControllerListener(xcl);
    System.out.println(xc.isConnected());
    
    SerialPortHandler sph = new SerialPortHandler();
    try {
      sph.connect("COM3");
      System.out.println("Connected to: " + sph.getPortName());
    } catch (IOException e) {
      System.out.println("Connect to "+ sph.getPortName() + "failed");
      System.out.println("System Shutting Down");
      System.exit(0);
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
