package Util;

import java.io.PrintWriter;

public interface CSVPrintable {

    String getName();
    int getID();
    void csvPrintln(PrintWriter out);
    //class PrintWriter out = new PrintWriter("output + /greeting.text");,,,,,,, out.flush();,,,,,,,, out.close();


}
