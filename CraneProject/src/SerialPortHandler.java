import java.util.*;
import java.io.*;
import gnu.io.*;

public class SerialPortHandler {
  private static SerialPort serialPort;
  private static OutputStream outputStream;
  private InputStream inputStream;
  private String portName;
  private CommPortIdentifier portId;
  
  public void connect () throws IOException {
//    this.portName = pn;
    Enumeration ports = CommPortIdentifier.getPortIdentifiers();
    CommPortIdentifier portIdentifier = null;
    
    while (ports.hasMoreElements()) {
      portIdentifier = (CommPortIdentifier) ports.nextElement();
      System.out.println("PORT: " + portIdentifier.getName());
      System.out.println("Current Owner: " + portIdentifier.getCurrentOwner());
      
      portName = portIdentifier.getName();
      if (!portIdentifier.isCurrentlyOwned()){
        try {
          //obtain a CommPortIdentifier object to the port of the specified name
          portId = CommPortIdentifier.getPortIdentifier(portIdentifier.getName());
          //open and begin owning the port
          serialPort = (SerialPort) portId.open(this.getClass().getName(), 2000);
          //set port parameters
          this.setSerialParameters();
          //open the streams, if they wont open, close the port before throwing an exception
          outputStream = serialPort.getOutputStream();
          inputStream = serialPort.getInputStream();
          
          break;
        } catch (NoSuchPortException e) {
          throw new IOException(e.getMessage());
        } catch (PortInUseException e) {
          throw new IOException(e.getMessage());
        } catch (IOException e) {
          serialPort.close();
          throw e;
        }
      }
      
    }
//    try {
//      //obtain a CommPortIdentifier object to the port of the specified name
//      CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portName);
//      //open and begin owning the port
//      serialPort = (SerialPort) portId.open(this.getClass().getName(), 2000);
//      //set port parameters
//      this.setSerialParameters();
//      //open the streams, if they wont open, close the port before throwing an exception
//      outputStream = serialPort.getOutputStream();
//      inputStream = serialPort.getInputStream();
//    } catch (NoSuchPortException e) {
//      throw new IOException(e.getMessage());
//    } catch (PortInUseException e) {
//      throw new IOException(e.getMessage());
//    } catch (IOException e) {
//      serialPort.close();
//      throw e;
//    }
  }
  public InputStream getSerialInputStream() {
    return inputStream;
  }
  
  public OutputStream getSerialOutputStream() {
    return outputStream;
  }
  
  public String getPortName() {
    return portName;
  }
  
  public void setSerialParameters() throws IOException {    
    try {
      serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
      serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
    } catch (UnsupportedCommOperationException e) {
      throw new IOException("Unsupported serial port Parameter");
    }

  }
  
  //close the port and exit the program.
  public static void closePort() {
    System.out.println("Closing port!");
    System.out.println("Exiting Program");
    serialPort.close();
    System.exit(0);
  }
  
  //write a character to the serial port
  public static void write(char x) {
    try {
      outputStream.write(x);
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  //write an integer to the serial port
  public static void write(int i) {
    try {
      outputStream.write(i);
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  //write a byte array to the serial port using byte[0] as an identifier and any other bytes as values
  public static void write(byte[] b) {
    try {
      outputStream.write(b);
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
