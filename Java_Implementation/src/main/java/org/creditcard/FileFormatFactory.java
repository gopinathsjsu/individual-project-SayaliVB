package org.creditcard;

import java.util.Objects;

public class FileFormatFactory {
    public FileFormat selectFileFormat(String ipfilename, String opfilename){

        FileFormat fileFormat = null;

        String[] strarr  = ipfilename.split("\\.");

        int ind = strarr.length;
        String ipextension = strarr[ind-1];

        strarr  = opfilename.split("\\.");
        ind = strarr.length;
        String opextension = strarr[ind-1];


        if(ipextension.equals("csv") && opextension.equals("csv")){
            fileFormat=  new CSVFileFormat(ipfilename, opfilename);
        }
        else if(ipextension.equals("json") && opextension.equals("json")){
            fileFormat=  new JSONFileFormat(ipfilename, opfilename);
        }
        else if(ipextension.equals("xml") && opextension.equals("xml")){
            fileFormat = new XMLFileFormat(ipfilename, opfilename);
        }

        return fileFormat;

    }
}
