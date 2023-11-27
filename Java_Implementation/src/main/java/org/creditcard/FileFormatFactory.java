package org.creditcard;

import java.util.Objects;

public class FileFormatFactory {
    public FileFormat selectFileFormat(String ipfilename, String opfilename){

        FileFormat fileFormat = null;

        String[] strarr  = ipfilename.split("\\.");

        int ind = strarr.length;
        String extension = strarr[ind-1];
        if(extension.equals("csv")){
            fileFormat=  new CSVFileFormat(ipfilename, opfilename);
        }
        else if(extension.equals("json")){
            fileFormat=  new JSONFileFormat(ipfilename, opfilename);
        }
        else if(extension.equals("xml")){
            fileFormat = new XMLFileFormat(ipfilename, opfilename);
        }

        return fileFormat;

    }
}
