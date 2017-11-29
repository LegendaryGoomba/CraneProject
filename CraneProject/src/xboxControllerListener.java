import ch.aplu.*;
import ch.aplu.jaw.*;
import ch.aplu.xboxcontroller.*;
import javax.comm.*;



public class xboxControllerListener implements XboxControllerListener {
  static boolean resourceRelease = false;

  @Override
  public void back(boolean arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void buttonA(boolean arg0) {
    SerialPortHandler.write(new byte[]{'a', 0});
  }

  @Override
  public void buttonB(boolean arg0) {
    SerialPortHandler.write(new byte[]{'b', 0});
  }

  @Override
  public void buttonX(boolean arg0) {
    SerialPortHandler.write(new byte[]{'x', 0});
  }

  @Override
  public void buttonY(boolean arg0) {
    SerialPortHandler.write(new byte[]{'y', 0});
  }

  @Override
  //true when pressed, false when released
  //up is 0 increases to 7 clockwise.
  public void dpad(int arg0, boolean arg1) {
    //arg1 is true when the button is pushed, false when released. This if statement
    //is there to make sure that the servo moves only when holding down the button
    if (arg1) {
      switch(arg0) {
      case 0:
        SerialPortHandler.write(new byte[] {'d', 'u'});
        System.out.println("UP");
        break;
      case 2:
        SerialPortHandler.write(new byte[] {'d', 'r'});
        System.out.println("RIGHT");
        break;
      case 4:
        SerialPortHandler.write(new byte[] {'d', 'd'});
        System.out.println("DOWN");
        break;
      case 6: 
        SerialPortHandler.write(new byte[] {'d', 'l'});
        System.out.println("LEFT");
        break;
      default:
        System.out.println("Not u, l, d or r");
      }
    } else {
      //if arg1 is false, it will stop the servo, hence the 's'
      SerialPortHandler.write(new byte[] {'d','s'});
    }
    
  }

  @Override
  public void isConnected(boolean arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void leftShoulder(boolean arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void leftThumb(boolean arg0) {
    // TODO Auto-generated method stub
    
  }

  //uses 0-359 degrees
  @Override
  public void leftThumbDirection(double arg0) {
    
//    //use j for left thumbstick
//    System.out.println("Left thumbstick direction in degrees: " + (int)arg0);
//    
//    if (arg0 > 225 && arg0 < 315) { //stick is pointing left
//      SerialPortHandler.write(new byte[] {'j', 'l'});
//    } else if (arg0 > 45 && arg0 < 135) { //stick is pointing right
//      SerialPortHandler.write(new byte[] {'j', 'r'}); 
//    }
  }

  @Override
  public void leftThumbMagnitude(double arg0) {
    //use j for left thumbstick
//    System.out.println("Magnitude: " + arg0);
  
  }

  @Override
  public void leftTrigger(double arg0) {
    int i = (int) (arg0 * 255);
    byte b = (byte) i;
    SerialPortHandler.write(new byte[] {'l', b});
  }

  @Override
  public void rightShoulder(boolean arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void rightThumb(boolean arg0) {
    // TODO Auto-generated method stub
    
  }

  //uses 0-359 degrees
  @Override
  public void rightThumbDirection(double arg0) {
//    //use k for right thumbstick
//    System.out.println("Right thumbstick direction in degrees: " + (int)arg0);
//    int direction = (int)arg0;
//    System.out.println("Left thumbstick direction in degrees: " + (int)arg0);
//    if (arg0 > 315 || arg0 < 45) { //stick is pointing up
//      SerialPortHandler.write(new byte[] {'k', (byte)direction});
//    } else if (arg0 > 135 && arg0 < 225) { //stick is pointing down
//      SerialPortHandler.write(new byte[] {'k', (byte)direction});
//    }
  }

  @Override
  public void rightThumbMagnitude(double arg0) {
    //use k for right thumbstick
//    System.out.println("Magnitude: " + arg0);
  }

  @Override
  public void rightTrigger(double arg0) {
    int i = (int) (arg0 * 127);
    byte b = (byte) i;
    SerialPortHandler.write(new byte[] {'r', b});
  }

  @Override
  public void start(boolean arg0) {
    // TODO Auto-generated method stub
  }
}
